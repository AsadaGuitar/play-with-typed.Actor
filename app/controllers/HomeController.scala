package controllers

import akka.actor.typed.{ActorRef, ActorSystem}
import akka.actor.typed.scaladsl.AskPattern._
import akka.actor.typed.scaladsl.adapter.ClassicActorSystemOps
import akka.actor.{ActorSystem => ClassicSystem}
import akka.util.Timeout

import controllers.components.HelloWorld

import javax.inject._
import play.api.mvc._

import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.duration.DurationInt


@Singleton
final class HomeController @Inject()(cc: ControllerComponents, classicSystem: ClassicSystem, helloWorld: ActorRef[HelloWorld.Command])
  extends AbstractController(cc) {

  implicit val system: ActorSystem[_] = classicSystem.toTyped
  implicit val ec: ExecutionContextExecutor = system.executionContext
  implicit val timeout: Timeout = 3.seconds

  def index() = Action.async { implicit request: Request[AnyContent] =>
    helloWorld
      .ask(HelloWorld.SayHello("Martin Odersky"))
      .map { msg =>
        Ok(views.html.index(msg))
      }
  }
}
