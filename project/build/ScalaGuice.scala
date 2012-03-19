/*
 *  Copyright 2010-2011 Benjamin Lings
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
import sbt._
import java.io.File

class ScalaGuice(info: ProjectInfo) extends DefaultProject(info) {

  // Repositories

  // Dependencies
  val guice3 = "com.google.inject" % "guice" % "3.0"
  val guicemulti3 = "com.google.inject.extensions" % "guice-multibindings" % "3.0"
  val guava = "com.google.guava" % "guava" % "11.0.1"
  val TwoPointEight = """2\.8\.\d""".r
  val TwoPointNine = """2\.9\.[\d.-]+""".r

  val scalatest =
    buildScalaVersion match {
      case TwoPointEight() => "org.scalatest" % "scalatest" % "1.3"
      case TwoPointNine() => "org.scalatest" % "scalatest_2.9.0" % "1.4.1"
      case x => error("Unsupported Scala version " + x)
    }

  override def managedStyle = ManagedStyle.Maven
  lazy val publishTo = Resolver.file("file",  new File("repo"))
}
