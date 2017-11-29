import Printer.PrintCurrency
import akka.actor.{Actor, ActorLogging, ActorRef, Props}

object EuroConverter {
  def props(printerActor: ActorRef): Props = Props(new EuroConverter(printerActor))
  case class euro2bitcoin(euro: BigDecimal)
  case class euro2dollar(euro: BigDecimal)
}

class EuroConverter(printerActor: ActorRef) extends Actor with ActorLogging {

  def receive = {
    case EuroConverter.euro2bitcoin(euro : BigDecimal)  => printerActor ! PrintCurrency(euro/BigDecimal("5551"))
    case EuroConverter.euro2dollar(euro : BigDecimal)  => printerActor ! PrintCurrency(euro*BigDecimal("1.18"))
  }

}