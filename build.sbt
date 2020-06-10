name := "video-platform-simulator"

version := "0.1"

scalaVersion := "2.13.2"

libraryDependencies ++= Seq("com.typesafe.akka" %% "akka-actor-typed" % "2.6.5",
  "org.slf4j" % "slf4j-api" % "1.7.5",
  "org.slf4j" % "slf4j-simple" % "1.7.5")
