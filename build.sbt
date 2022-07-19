ThisBuild / scalaVersion := "2.13.8"

ThisBuild / version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """play_with_akka""",
    libraryDependencies ++= Seq(
      guice,
      "com.typesafe.akka"       %%  "akka-actor-typed"    %  "2.6.19",
//      "com.google.inject"        %  "guice"               %  "4.2.2",
      "org.scalatestplus.play"  %%  "scalatestplus-play"  %  "5.1.0"  % Test
    )
  )