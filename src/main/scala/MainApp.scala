import akka.actor.{ActorRef, ActorSystem}

object MainApp extends App {

  val system: ActorSystem = ActorSystem("mainAkka")

  try {
    val printer: ActorRef = system.actorOf(Printer.props, "printerActor")
    val ec: ActorRef = system.actorOf(EuroConverter.props(printer), "euroConverter")

  } finally {
    system.terminate()
  }
}