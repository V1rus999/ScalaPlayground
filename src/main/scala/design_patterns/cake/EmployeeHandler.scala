package main.scala.design_patterns.cake


// To construct the EmployeeHandler you need to provide a EmployeeDbComponent and EmployeeServiceComponent implementation
class EmployeeHandler {
  this: EmployeeDbComponent with EmployeeServiceComponent =>

  def createEmployee(input: String): Employee = {
    val empl = Employee(input)

    // create employee via db
    employeeDb.createEmployee(empl)

    // POST employee to cloud
    employeeService.POST(empl)

    empl
  }

  def findEmployee(emp: Int): Employee = {
    employeeDb.getEmployee(emp)
  }

}
