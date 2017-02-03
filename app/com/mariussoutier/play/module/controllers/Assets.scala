package com.mariussoutier.play.module.controllers

import javax.inject.{Inject, Singleton}

import controllers.AssetsBuilder
import play.api.http.HttpErrorHandler

/**
  * Module-specific assets controller to serve the module's assets and WebJars.
  *
  * Without this we get
  * [RuntimeException: java.lang.NoSuchMethodError: controllers.ReverseAssets.versioned(Ljava/lang/String;)Lplay/api/mvc/Call;]
  * when using Assets.
  */
@Singleton
class Assets @Inject() (errorHandler: HttpErrorHandler) extends AssetsBuilder(errorHandler)
