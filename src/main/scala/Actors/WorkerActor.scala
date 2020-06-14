package Actors

import Actors.WorkerActor.Command
import akka.actor.typed.Behavior
import akka.actor.typed.scaladsl.{AbstractBehavior, ActorContext, Behaviors}

import scala.util.Random

object WorkerActor {
  def apply(): Behavior[Command] = {
    Behaviors.setup[Command](context => new WorkerActor(context))
  }

  case class Command(command: String)

}

class WorkerActor(context: ActorContext[Command]) extends AbstractBehavior[Command](context) {
  override def onMessage(msg: Command): Behavior[Command] = {
    msg.command match {
      case "create" =>
        println(s"Actor ${this.context.self.path} random Number ${Random.nextInt(10)}")
        Behaviors.unhandled
    }
  }
}
