package Actors

import Actors.WorkerActor.Command
import akka.actor.testkit.typed.scaladsl.ScalaTestWithActorTestKit
import org.scalatest.wordspec.AnyWordSpecLike

class WorkerActorSpec extends ScalaTestWithActorTestKit with AnyWordSpecLike {

  "WorkerActor" must {
    "create an user with display random number" in {
      val probe = createTestProbe[Command]()
      val workerActor = spawn(WorkerActor(), "testUser1")
      workerActor ! WorkerActor.Command("create")
    }
  }

}
