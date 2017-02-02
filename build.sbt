name := "play-module-example"

version := "1.0.0-SNAPSHOT"

scalaVersion := "2.11.8"

organization := "com.mariussoutier.play"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

// Required only to test this module during development
PlayKeys.devSettings += "play.http.router" -> "module.Routes"

libraryDependencies += "org.webjars" % "chartjs" % "2.4.0"
libraryDependencies += "org.webjars" % "bootstrap" % "3.3.7-1"
libraryDependencies += "org.webjars" % "numeral-js" % "1.5.3-1"
