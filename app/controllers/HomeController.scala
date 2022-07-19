package controllers

import akka.actor.typed.ActorRef
import akka.actor.typed.scaladsl.AskPattern._
import controllers.components.{HelloWorld, TypedActorConfigurations}

import javax.inject._
import play.api.mvc._


@Singleton
final class HomeController @Inject()(cc: ControllerComponents, actorConf: TypedActorConfigurations, helloWorld: ActorRef[HelloWorld.Command])
  extends AbstractController(cc) {
  import actorConf._

  def index() = Action.async { implicit request: Request[AnyContent] =>
    helloWorld
      .ask(HelloWorld.SayHello("Martin Odersky"))
      .map { msg =>
        Ok(views.html.index(msg))
      }
  }
}
