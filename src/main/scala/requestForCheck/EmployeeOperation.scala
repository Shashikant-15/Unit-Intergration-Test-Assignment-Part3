package requestForCheck

import companyModels.Employee
import validation.EmployeeValidation

class EmployeeOperation(employeeValidator: EmployeeValidation) {

  def createEmployee(employee: Employee): Option[String] = {
    if (employeeValidator.employeeIsValid(employee)) Option(employee.emailId)
    else None
  }
}