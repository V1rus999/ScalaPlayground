package main.scala.design_patterns.cake

/*
EmployeeDb component is an abstract component. We can have multiple implementations of this component.
For an instance we can have:
  Apache cassandra based EmployeeDb component
  MongoDB based EmployeeDb component
  Mocked EmployeeDb component for unit tests
 */
trait EmployeeDbComponent {

  val employeeDb: EmployeeDb

  trait EmployeeDb {
    def createEmployee(employee: Employee)
    def getEmployee(empId: Int): Employee
  }

}
