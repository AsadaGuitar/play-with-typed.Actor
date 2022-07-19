package controllers.components

import com.google.inject.AbstractModule
import play.api.libs.concurrent.AkkaGuiceSupport


/**
 * application.conf
 *   play.modules.enabled += "controllers.components.AppModule"
 */
class AppModule extends AbstractModule with AkkaGuiceSupport {

  override def configure(): Unit = {
    bindTypedActor(HelloWorld.behavior, "hello-world")
    bind(classOf[TypedConfigurations]).asEagerSingleton()
  }
}
