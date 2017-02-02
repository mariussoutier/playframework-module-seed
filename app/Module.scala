import com.mariussoutier.play.module.actor.ErrorActor
import play.api.inject.Binding
import play.api.libs.concurrent.Akka
import play.api.{Configuration, Environment}

class Module extends play.api.inject.Module {
  override def bindings(environment: Environment, configuration: Configuration): Seq[Binding[_]] = Seq(
    Akka.bindingOf[ErrorActor]("error-actor", _ => ErrorActor.props)
  )
}
