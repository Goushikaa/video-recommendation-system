import Actors.SupervisorActor
import Actors.SupervisorActor.{CreateUsers, SupervisorActorCommand}
import akka.actor.typed.ActorSystem

object SimulatorApplication {

  def main(args: Array[String]): Unit = {
    println("main method")
    val actorSystem: ActorSystem[SupervisorActorCommand] = ActorSystem[SupervisorActorCommand](SupervisorActor(), "test-supervisor-actor")
    actorSystem.tell(CreateUsers(10))
  }

}
