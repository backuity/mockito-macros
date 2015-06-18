name := "mockito-macros"

organization := "org.backuity"

scalaVersion := "2.11.6"

homepage := Some(url("https://github.com/backuity/mockito-macros"))

licenses := Seq("Apache 2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0.html"))

scalacOptions ++= Seq("-deprecation", "-unchecked")

libraryDependencies ++= Seq(
    "com.novocode"      %  "junit-interface" % "0.10"      % "test-internal",
    "com.chuusai"       %% "shapeless"       % "2.2.2",
    "org.scala-lang"    % "scala-reflect"    % scalaVersion.value,
    "org.mockito"       % "mockito-core"     % "1.10.8",
    "org.backuity"      %% "matchete"        % "1.11"      % "test",
    "junit"             %  "junit"           % "4.10"      % "test")

publishMavenStyle := true

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (version.value.trim.endsWith("SNAPSHOT"))
    Some("snapshots" at nexus + "content/repositories/snapshots")
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

// replace publish by publishSigned
//      publish := PgpKeys.publishSigned.value

pomIncludeRepository := { _ => false }

pomExtra :=
  <scm>
    <url>git@github.com:backuity/matchete.git</url>
    <connection>scm:git:git@github.com:backuity/matchete.git</connection>
  </scm>
  <developers>
    <developer>
      <id>backuitist</id>
      <name>Bruno Bieth</name>
      <url>https://github.com/backuitist</url>
    </developer>
  </developers>