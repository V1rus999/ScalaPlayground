package main.scala.design_patterns.cake

import scala.concurrent.Future

trait EmployeeServiceComponent {

  val employeeService: EmployeeService

  trait EmployeeService {
    def POST(employee: Employee): Future[Unit]
    def GET(id: Int): Future[Employee]
  }
}
