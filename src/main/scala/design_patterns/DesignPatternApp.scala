package main.scala.design_patterns

import main.scala.design_patterns.bridge.{SaltedPasswordConverter, Sha256Hasher}
import main.scala.design_patterns.factory.DbUser

object DesignPatternApp extends App {
  println("Design Pattern App")

  DbUser.executeDbCalls()

  val password = new SaltedPasswordConverter("superCoolSalt!@()") with Sha256Hasher
  val convertedPassword = password.convert("password123")
  println(convertedPassword)
}
