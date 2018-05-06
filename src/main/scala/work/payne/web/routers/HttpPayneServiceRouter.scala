package work.payne.web.routers

import akka.actor.ActorSystem
import akka.http.scaladsl.model._
import akka.http.scaladsl.server.Directives._
import akka.http.scaladsl.server.Route

import scala.concurrent.ExecutionContext

class HttpPayneServiceRouter(implicit sys: ActorSystem, ec: ExecutionContext) {

  def route(): Route = {


    get {
      pathEndOrSingleSlash {
        getFromResource("www/index.html")
      }~
      path("index" ){
        getFromResource("www/index.html")
      } ~
      getFromDirectory("www")
    }

  }

  def getSimpleResponse: HttpResponse = {
    HttpResponse(
      status = StatusCodes.OK,
      entity = HttpEntity(
        ContentTypes.`text/html(UTF-8)`,
        "<html><head></head><body><p>I respond for all gets</p></body></html>"
      )
    )
  }

}
