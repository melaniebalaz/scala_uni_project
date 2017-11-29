import BitcoinConverter._
import EuroConverter._
import DollarConverter._
import akka.actor.{ActorRef, ActorSystem}

object MainApp extends App {

  val system: ActorSystem = ActorSystem("mainAkka")

  try {
    val printer: ActorRef = system.actorOf(Printer.props, "printerActor")
    val ec: ActorRef = system.actorOf(EuroConverter.props(printer), "euroConverter")
    val bc: ActorRef = system.actorOf(BitcoinConverter.props(printer), "bitConverter")
    val dc: ActorRef = system.actorOf(DollarConverter.props(printer), "dollarConverter")

    val bitcoin = BigDecimal("1")
    val dollar = BigDecimal("200")
    val euro = BigDecimal("300")

    bc ! bitcoin2dollar(bitcoin)
    bc ! bitcoin2euro(bitcoin)
    dc ! dollar2euro(dollar)
    dc ! dollar2bitcoin(dollar)
    ec ! euro2dollar(euro)
    ec ! euro2bitcoin(euro)

  } finally {
    system.terminate()
  }
}