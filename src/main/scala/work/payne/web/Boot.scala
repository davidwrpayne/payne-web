package work.payne.web


import akka.actor.ActorSystem
import akka.http.scaladsl.Http
import akka.stream.ActorMaterializer
import com.typesafe.config.{Config, ConfigFactory}
import work.payne.web.routers.HttpPayneServiceRouter

import scala.concurrent.ExecutionContextExecutor


object Boot extends App {

  implicit val system: ActorSystem = ActorSystem("Payne-Web")
  implicit val materializer: ActorMaterializer = ActorMaterializer()
  implicit val executionContext: ExecutionContextExecutor = system.dispatcher


  val conf = ConfigFactory.load
  val server = WebServerConfig(conf.getConfig("web-server"))


  val router = new HttpPayneServiceRouter()


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
