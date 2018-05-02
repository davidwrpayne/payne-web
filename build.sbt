import Dependencies._

lazy val payne_web = (project in file(".")).
  settings(
    inThisBuild(List(
      organization := "com.example",
      scalaVersion := "2.12.6",
      version := "0.1.0-SNAPSHOT"
    )),
    name := "payne-web",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      "com.typesafe" % "config" % "1.3.2",
      "com.typesafe.akka" %% "akka-http"   % "10.1.1",
      "com.typesafe.akka" %% "akka-stream" % "2.5.11", //TODO is this latest version?
    ),
    mainClass in (Compile,packageBin) := Some("work.payne.web.Boot")
  )
