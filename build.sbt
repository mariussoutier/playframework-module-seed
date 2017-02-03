// TODO Replace with your module's name
name := "play-module-seed"
// TODO Replace with your organization
organization in ThisBuild := "com.mariussoutier.play"

version := "1.0.0-SNAPSHOT"
scalaVersion in ThisBuild := "2.11.8"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)

// Required only to test this module during development
PlayKeys.devSettings += "play.http.router" -> "module.Routes"

// TODO Replace with your own dependencies
libraryDependencies ++= Seq(
  filters,
  // WebJars.org (i.e. client-side) dependencies
  "org.webjars" % "bootstrap" % "3.3.7-1"
)

// Scala Compiler Options
scalacOptions in ThisBuild ++= Seq(
  "-target:jvm-1.8",
  "-encoding", "UTF-8",
  "-deprecation", // warning and location for usages of deprecated APIs
  "-feature", // warning and location for usages of features that should be imported explicitly
  "-unchecked", // additional warnings where generated code depends on assumptions
  "-Xlint", // recommended additional warnings
  "-Xcheckinit", // runtime error when a val is not initialized due to trait hierarchies (instead of NPE somewhere else)
  "-Ywarn-adapted-args", // Warn if an argument list is modified to match the receiver
  //"-Yno-adapted-args", // Do not adapt an argument list (either by inserting () or creating a tuple) to match the receiver
  "-Ywarn-value-discard", // Warn when non-Unit expression results are unused
  "-Ywarn-inaccessible", // Warn about inaccessible types in method signatures
  "-Ywarn-dead-code", // Warn when dead code is identified
  "-Ywarn-unused", // Warn when local and private vals, vars, defs, and types are unused
  "-Ywarn-unused-import" //  Warn when imports are unused (don't want IntelliJ to do it automatically)
  //"-Ywarn-numeric-widen" // Warn when numerics are widened
)
