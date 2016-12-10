package com.androidsuit.sarmail

import akka.actor.{ActorSystem, Props}
import scala.concurrent.Await
import scala.concurrent.duration._
import scala.concurrent.ExecutionContext.Implicits.global

object Main {
  val system = ActorSystem("sarmail")
  val secretary = system.actorOf(Props[Secretary], "Secretary")

  def main(args: Array[String]) {
    system.scheduler.scheduleOnce(5.seconds) {
      system.shutdown()
    }
  }
}
