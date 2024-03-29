name := "CalcGUI"

version := "0.1"

// Version of Scala used by the project
scalaVersion := "2.13.1"

scalacOptions ++= Seq("-unchecked", "-deprecation", "-Xcheckinit", "-encoding", "utf8")

// Add dependency on ScalaFX library
libraryDependencies += "org.scalafx" %% "scalafx" % "12.0.2-R18"

// Add OS specific JavaFX dependencies
val javafxModules = Seq("base", "controls", "fxml", "graphics", "media", "swing", "web")
val osName = System.getProperty("os.name") match {
  case n if n.startsWith("Linux") => "linux"
  case n if n.startsWith("Mac") => "mac"
  case n if n.startsWith("Windows") => "win"
  case _ => throw new Exception("Unknown platform!")
}
libraryDependencies ++= javafxModules.map(m => "org.openjfx" % s"javafx-$m" % "12.0.2" classifier osName)
libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "2.1.1"
libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "1.2.0"


fork := true