package com.mariussoutier.play.module.component

import javax.inject.{Inject, Singleton}

import play.api.{Configuration, Environment}
import play.api.inject.ApplicationLifecycle

import scala.concurrent.Future

class DatabaseClient {
  def close(): Future[Unit] = ???
}

// A component that might be used by the application, in this example a database connection
trait DatabaseComponent {
  def environment: Environment
  def configuration: Configuration
  def applicationLifecycle: ApplicationLifecycle

  lazy val databaseClient: DatabaseClient = {
    val dbClient = new DatabaseClient
    applicationLifecycle.addStopHook(() => dbClient.close())
    dbClient
  }
}

@Singleton
class DatabaseComponentImpl @Inject()(val environment: Environment,
                                      val configuration: Configuration,
                                      val applicationLifecycle: ApplicationLifecycle) extends DatabaseComponent
