package com.androidsuit.sarmail

import akka.actor.{Actor, ActorLogging}
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global
import scala.xml.XML

class Secretary extends Actor with ActorLogging {

  val ticker = context.system.scheduler.schedule(
    100.millis, 100.millis, self, Tick)

  case object Tick

  def receive = {
    case Tick =>
      val xml = XML.load("https://hackaday.com/blog/feed/")
      println("Tick!")
  }
}
