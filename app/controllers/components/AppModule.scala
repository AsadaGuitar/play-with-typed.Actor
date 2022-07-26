package controllers.components

import com.google.inject.AbstractModule
import play.api.libs.concurrent.AkkaGuiceSupport

import javax.inject.Singleton


/**
 * application.conf
 *   play.modules.enabled += "controllers.components.AppModule"
 */
@Singleton
final class AppModule extends AbstractModule with AkkaGuiceSupport {

  override def configure(): Unit = {
    bindTypedActor(HelloWorld.behavior, "hello-world")
  }
}

