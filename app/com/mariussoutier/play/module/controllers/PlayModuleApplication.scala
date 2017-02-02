package com.mariussoutier.play.module.controllers

import javax.inject.{Inject, Named, Singleton}

import akka.actor.ActorRef
import akka.util.Timeout
import com.mariussoutier.play.module.actor.ErrorActor.Protocol.{ErrorCount, GetErrorCount}
import play.api._
import play.api.mvc._

import scala.concurrent.ExecutionContext

@Singleton
class PlayModuleApplication @Inject()(configuration: Configuration,
                                      @Named("error-actor") errorActor: ActorRef)
                                     (implicit ec: ExecutionContext)
  extends Controller {

  import scala.concurrent.duration._
  implicit val timeout: Timeout = 5.seconds

  def index = Action.async { implicit request =>
    import akka.pattern.ask
    (errorActor ? GetErrorCount).mapTo[ErrorCount].map { errorCount =>
      Ok(com.mariussoutier.play.module.views.html.index(errorCount.count))
    }
  }
}
