package main.scala.design_patterns.cake
import scala.concurrent.Future

trait FakeEmployeeServiceComponent extends EmployeeServiceComponent {

  val employeeService: EmployeeService = new FakeEmployeeServiceComponent()

  class FakeEmployeeServiceComponent extends EmployeeService {
    override def POST(employee: Employee): Future[Unit] = Future.successful()

    override def GET(id: Int): Future[Employee] = Future.successful(Employee("Some Employee"))
  }

}
