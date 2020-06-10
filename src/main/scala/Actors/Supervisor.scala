package Actors

import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}

object SupervisorActor {

  def apply(): Behavior[Nothing] = {
    println("Supervisor actor setup")
    Behaviors.setup[Nothing](context => new SupervisorActor(context))
  }
}

class SupervisorActor(context: ActorContext[Nothing]) extends AbstractBehavior[Nothing](context) {
  context.log.info("{} created", context.system.name)

  override def onMessage(msg: Nothing): Behavior[Nothing] = {
    context.log.info("On Message");
    Behaviors.unhandled
  }
}
