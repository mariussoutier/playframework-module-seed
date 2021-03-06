package com.mariussoutier.play.module.actor

import akka.actor.{Actor, ActorLogging, Props}

/**
  * Example of an actor used by your module.
  * TODO Remove if you don't need actors. Otherwise bind them in the Module.
  */
class ErrorActor extends Actor with ActorLogging {

  import ErrorActor.Protocol._

  private var errorCount = 0L

  override def receive: Receive = {
    case ErrorRecorded(_) => errorCount += 1L
    case GetErrorCount => sender ! ErrorCount(errorCount)
  }

}

object ErrorActor {

  object Protocol {
    case class ErrorRecorded(code: Int)
    case object GetErrorCount

    case class ErrorCount(count: Long) extends AnyVal
  }

  def props: Props = Props(new ErrorActor)

}

