package controllers.components

import com.google.inject.AbstractModule
import play.api.libs.concurrent.AkkaGuiceSupport


class AppModule extends AbstractModule with AkkaGuiceSupport {

  override def configure(): Unit = {
    bindTypedActor(HelloWorld.behavior, "hello-world")
    bind(classOf[TypedConfigurations]).asEagerSingleton()
  }
}
