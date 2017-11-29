import Printer.PrintCurrency
import akka.actor._

object BitcoinConverter {
  def props(printerActor: ActorRef): Props = Props(new BitcoinConverter(printerActor))
  case class bitcoin2euro(bitcoin: BigDecimal)
  case class bitcoin2dollar(bitcoin: BigDecimal)
}

class BitcoinConverter(printerActor: ActorRef) extends Actor with ActorLogging {

  def receive = {
    case _ => println("TODO")
    case BitcoinConverter.bitcoin2euro(bitcoin : BigDecimal)  => printerActor ! PrintCurrency(bitcoin*5551)
    case BitcoinConverter.bitcoin2dollar(bitcoin : BigDecimal)  => printerActor ! PrintCurrency(bitcoin*6500)
  }

}
