import Printer._
import akka.actor.{Actor, ActorLogging, ActorRef, Props}

object DollarConverter {
  def props(printerActor: ActorRef): Props = Props(new DollarConverter(printerActor))
  case class dollar2bitcoin(dollar: BigDecimal)
  case class dollar2euro(dollar: BigDecimal)
}

class DollarConverter(printerActor: ActorRef) extends Actor with ActorLogging {

  def receive = {
    //case _ => println("TODO")
    case DollarConverter.dollar2bitcoin(dollar : BigDecimal)  => printerActor ! PrintCurrency(dollar/BigDecimal("6500"))
    case DollarConverter.dollar2euro(dollar : BigDecimal)  => printerActor ! PrintCurrency(dollar*BigDecimal("0.85"))
  }

}