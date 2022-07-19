package controllers.components

import akka.actor.typed.ActorSystem
import akka.actor.typed.scaladsl.adapter.ClassicActorSystemOps
import akka.actor.{ActorSystem => ClassicalSystem}
import akka.util.Timeout

import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.duration.DurationInt

@Singleton
final class TypedConfigurations @Inject()(classicalSystem: ClassicalSystem) {

  implicit val system: ActorSystem[_] = classicalSystem.toTyped
  implicit val ec: ExecutionContextExecutor = system.executionContext
  implicit val timeout: Timeout = 3.seconds
}
