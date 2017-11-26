import akka.actor.{Actor, ActorLogging, Props}

object Printer {
  def props: Props = Props[Printer]
  final case class Print(message: String)
  final case class PrintCurrency(currency: BigDecimal)
}

class Printer extends Actor with ActorLogging {

  def receive = {
    case _ => println("TODO")
    case Printer.Print => println(s"$​message")
    case Printer.PrintCurrency => println(s"$currency")
  }

  /**
  def print(term: Term) {
    term match {
      case Print(message) =>
        println(s"$​message")
      case PrintCurrency(message) =>
        println(s"$​message")
    }
  }
    **/
}
