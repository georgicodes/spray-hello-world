package com.redballoon

import akka.actor.{ActorSystem, Props}
import akka.io.IO
import spray.can.Http
import com.typesafe.config.ConfigFactory

object Boot extends App {

  implicit val system = ActorSystem("on-spray-can")

  // create and start our service actor
  val service = system.actorOf(Props[ImageServiceActor], "image-service")

  val conf = ConfigFactory.load()

  val serverPort = conf.getInt("port")

  IO(Http) ! Http.Bind(service, interface = "0.0.0.0", port = serverPort)
}
