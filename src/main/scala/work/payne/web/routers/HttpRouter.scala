package work.payne.web.routers

import akka.http.scaladsl.server.Route

import akka.http.scaladsl.server.Directives._

class HttpPayneWebRouter extends Router {
  override def route(): Route = {
    get {
      pathEndOrSingleSlash {
        ctx =>
          ctx.complete("Begginging of site")
      }
    }
  }
}


trait Router {
  def route(): Route
}