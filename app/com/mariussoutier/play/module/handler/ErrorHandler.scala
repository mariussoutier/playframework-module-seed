package com.mariussoutier.play.module.handler

import javax.inject.{Inject, Named, Provider, Singleton}

import akka.actor.ActorRef
import com.mariussoutier.play.module.actor.ErrorActor
import play.api.http.DefaultHttpErrorHandler
import play.api.mvc.{RequestHeader, Result}
import play.api.routing.Router
import play.api.{Configuration, Environment, OptionalSourceMapper}

import scala.concurrent.Future

/**
  * Enable via:
  * play.http.errorHandler=com.mariussoutier.play.module.handler.ErrorHandler
  */
@Singleton
class ErrorHandler @Inject() (
                               env: Environment,
                               config: Configuration,
                               sourceMapper: OptionalSourceMapper,
                               router: Provider[Router],
                               @Named("error-actor") errorActor: ActorRef
                             ) extends DefaultHttpErrorHandler(env, config, sourceMapper, router) {
  override def onClientError(request: RequestHeader, statusCode: Int, message: String): Future[Result] = {
    statusCode match {
      case n if n >= 400 && n <= 499 =>
        errorActor ! ErrorActor.Protocol.ErrorRecorded(n)
      case n if n >= 500 && n <= 599 =>
        errorActor ! ErrorActor.Protocol.ErrorRecorded(n)
    }
    super.onClientError(request, statusCode, message)
  }
}
