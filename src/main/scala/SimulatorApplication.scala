import Actors.SupervisorActor
import akka.actor.typed.ActorSystem

object SimulatorApplication {

  def main(args: Array[String]): Unit = {
    println("main method")
    ActorSystem[Nothing](SupervisorActor(), "test-supervisor-actor");
  }

}
