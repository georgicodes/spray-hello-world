import com.typesafe.sbt.SbtNativePackager.Universal

packageArchetype.java_application

name := "Image Service"

organization  := "com.hello"

version       := "0.1"

scalaVersion  := "2.10.3"

scalacOptions := Seq("-unchecked", "-deprecation", "-encoding", "utf8")

mappings in Universal += {
  file("src/main/resources/application.conf") -> "conf/application.conf"
}

resolvers ++= Seq(
  "spray repo" at "http://repo.spray.io/",
  "sonatype repo" at "https://oss.sonatype.org/content/repositories/snapshots/"
)

libraryDependencies ++= {
  val akkaV = "2.1.4"
  val sprayV = "1.1.0"
  Seq(
    "io.spray"            %   "spray-can"     % sprayV,
    "io.spray"            %   "spray-routing" % sprayV,
    "io.spray"            %   "spray-testkit" % sprayV,
    "io.spray"            %%   "spray-json" % "1.2.5",
    "com.typesafe.akka"   %%  "akka-actor"    % akkaV,
    "com.typesafe.akka"   %%  "akka-testkit"  % akkaV,
    "org.specs2"          %%  "specs2"        % "2.2.3" % "test",
    "org.mockito"         %   "mockito-all"   % "1.9.5"
  )
}

seq(Revolver.settings: _*)
