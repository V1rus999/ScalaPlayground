package main.scala.design_patterns

import main.scala.design_patterns.bridge.{SaltedPasswordConverter, Sha256Hasher}
import main.scala.design_patterns.cake.{
  EmployeeHandler,
  FakeEmployeeServiceComponent,
  LogEmployeeDbComponent
}
import main.scala.design_patterns.facade.FacadeRunner
import main.scala.design_patterns.factory.DbUser

object DesignPatternApp extends App {
  println("Design Pattern App")

  DbUser.executeDbCalls()

  val password          = new SaltedPasswordConverter("superCoolSalt!@()") with Sha256Hasher
  val convertedPassword = password.convert("password123")
  println(convertedPassword)

  FacadeRunner.run()

  println("Cake Pattern")
  val emplHandler = new EmployeeHandler with LogEmployeeDbComponent
  with FakeEmployeeServiceComponent
  emplHandler.createEmployee("123")
  val empl = emplHandler.findEmployee(123)
  println(s"Got emply $empl")
}
