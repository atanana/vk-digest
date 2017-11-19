name := "vk-digest"

version := "1.1"

scalaVersion := "2.12.4"

resolvers += "lightshed-maven" at "http://dl.bintray.com/content/lightshed/maven"

libraryDependencies += "com.vk.api" % "sdk" % "0.5.6"
libraryDependencies += "io.spray" %% "spray-json" % "1.3.3"
libraryDependencies += "ch.lightshed" %% "courier" % "0.1.4"
libraryDependencies += "net.codingwell" %% "scala-guice" % "4.1.0"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.4" % Test
libraryDependencies += "org.scalamock" %% "scalamock-scalatest-support" % "3.6.0" % Test

lazy val root = (project in file(".")).enablePlugins(SbtTwirl)

assemblyMergeStrategy in assembly := {
  case PathList("META-INF", "MANIFEST.MF") => MergeStrategy.discard
  case PathList("META-INF", xs@_*) => MergeStrategy.filterDistinctLines
  case x =>
    val oldStrategy = (assemblyMergeStrategy in assembly).value
    oldStrategy(x)
}