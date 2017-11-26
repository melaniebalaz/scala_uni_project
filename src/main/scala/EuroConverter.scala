import akka.actor.{Actor, ActorLogging, ActorRef, Props}

object EuroConverter {
  def props(printerActor: ActorRef): Props = Props(new EuroConverter(printerActor))
  case class euro2bitcoin(euro: BigDecimal)
  case class euro2dollar(euro: BigDecimal)
}

class EuroConverter(printerActor: ActorRef) extends Actor with ActorLogging {

  def receive = {
    case _ => println("TODO")
    case EuroConverter.euro2bitcoin(euro : BigDecimal)  => printerActor ! (euro/5551)
    case EuroConverter.euro2dollar(euro : BigDecimal)  => printerActor ! (euro*1.18)
  }

}