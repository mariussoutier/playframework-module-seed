package com.mariussoutier.play.module

import com.mariussoutier.play.module.actor.ErrorActor
import play.api.inject.Binding
import play.api.libs.concurrent.Akka
import play.api.{Configuration, Environment}

/**
  * Beware: The Play documentation recommends to put the Module class in the root package. This will be however lead
  * to strange dependency injection errors. So you should always put your module in a custom package and call
  * it to something project-specific.
  *
  * The Play app that will use your module must then explicitly enable the module instead of relying on the broken
  * auto-discovery:
  * play.modules {
  *   enabled += com.mariussoutier.play.module.SeedModule
  * }
  *
  * More info on modules: https://www.playframework.com/documentation/2.5.x/ScalaPlayModules
  */
class SeedModule extends play.api.inject.Module {
  // Bind dependency-injected instanced, in this case an Akka actor.
  override def bindings(environment: Environment, configuration: Configuration): Seq[Binding[_]] = Seq(
    Akka.bindingOf[ErrorActor]("error-actor", _ => ErrorActor.props)
  )
}
