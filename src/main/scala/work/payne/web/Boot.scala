package work.payne.web


import java.util.logging.Logger

import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import akka.stream.scaladsl._
import com.sun.javafx.util.Logging
import com.typesafe.config.{Config, ConfigFactory}
import work.payne.web.routers.HttpPayneWebRouter

import scala.concurrent.Future


object Boot extends App {

  implicit val system = ActorSystem("Payne-Web")
  implicit val materializer = ActorMaterializer()
  implicit val executionContext = system.dispatcher


  val conf = ConfigFactory.load
  val server = WebServerConfig(conf.getConfig("web-server"))


  val router = new HttpPayneWebRouter()


  val bindingFuture = Http().bindAndHandle(
    router.route(),
    interface = server.interface,
    port = server.port)

}

case class WebServerConfig(interface: String, port: Int)

object WebServerConfig {
  def apply(config: Config): WebServerConfig = {
    WebServerConfig(
      config.getString("interface"),
      config.getInt("port")
    )
  }
}
