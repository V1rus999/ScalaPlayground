package main.scala.design_patterns.cake

trait LogEmployeeDbComponent extends EmployeeDbComponent {

  override val employeeDb: EmployeeDb = new LogEmployeeDb

  class LogEmployeeDb extends EmployeeDb {

    override def createEmployee(employee: Employee): Unit = println("Created an employee")

    override def getEmployee(empId: Int): Employee = Employee("I am employeeeeeee")
  }
}
