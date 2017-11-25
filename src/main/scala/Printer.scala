import akka.actor.{Actor, ActorLogging, Props}

object Printer {
  def props: Props = Props[Printer]
  final case class Print(message: String)
}

class Printer extends Actor with ActorLogging {

  def receive = {
    case _ => println("TODO")
  }
}
