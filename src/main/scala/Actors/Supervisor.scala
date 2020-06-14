package Actors

import Actors.SupervisorActor._
import Actors.WorkerActor.Command
import akka.actor.typed
import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}

object SupervisorActor {

  def apply(): Behavior[SupervisorActorCommand] = {
    println("Supervisor actor setup")
    Behaviors.setup[SupervisorActorCommand](context => new SupervisorActor(context))
  }

  sealed trait SupervisorActorCommand

  case class CreateUsers(noOfUsers: Int) extends SupervisorActorCommand

}

class SupervisorActor(context: ActorContext[SupervisorActorCommand]) extends AbstractBehavior[SupervisorActorCommand](context) {
  context.log.info("{} created", context.system.name)

  override def onMessage(msg: SupervisorActorCommand): Behavior[SupervisorActorCommand] = {
    context.log.info("On Message");

    msg match {
      case CreateUsers(noOfUsers) => spawnWorkerActor(noOfUsers)
    }
    Behaviors.unhandled
  }


  def spawnWorkerActor(noOfUsers: Int) = {
    for (count <- 1 to noOfUsers) {
      val userActorRef: typed.ActorRef[Command] = context.spawn(WorkerActor(), s"User$count")
      userActorRef.tell(Command("create"))
    }
  }
}
