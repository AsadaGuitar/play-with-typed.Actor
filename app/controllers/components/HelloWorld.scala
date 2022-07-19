package controllers.components

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.{ActorRef, Behavior}


object HelloWorld {

  sealed trait Command {
    def replyTo: ActorRef[_]
  }
  final case class SayHello(name: String)(val replyTo: ActorRef[String]) extends Command
  final case class Echo(string: String)(val replyTo: ActorRef[String]) extends Command

  def behavior: Behavior[HelloWorld.Command] =
    Behaviors.receiveMessage {
      case cmd@SayHello(name) =>
        cmd.replyTo ! s"Hello, $name"
        Behaviors.same
      case cmd@Echo(string) =>
        cmd.replyTo ! string
        Behaviors.same
    }
}
