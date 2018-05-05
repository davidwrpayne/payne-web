package work.payne.web.routers

import akka.http.scaladsl.server.Route

import akka.http.scaladsl.server.Directives._

class HttpPayneServiceRouter extends HttpLog{

  def route(): Route = {


    getFromResourceDirectory("www")
  }
}
