import Dependencies._


lazy val commonSettings = Seq(
  version := "0.1-SNAPSHOT",
  organization := "work.payne",
  scalaVersion := "2.12.6",
)

lazy val payneWeb = (project in file(".")).
  settings(commonSettings : _*)
  .settings (
    name := "payne-web",
    libraryDependencies ++= Seq(
      scalaTest % Test,
      "com.typesafe" % "config" % "1.3.2",
      "com.typesafe.akka" %% "akka-http"   % "10.1.1",
      "com.typesafe.akka" %% "akka-stream" % "2.5.11", //TODO is this latest version?
    ),
    mainClass in (Compile,packageBin) := Some("work.payne.web.Boot"),
    assemblyJarName in assembly := "payne-web.jar"
  )
