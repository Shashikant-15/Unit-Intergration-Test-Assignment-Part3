package validation

import database.CompanyDB
import companyModels.Employee

class EmployeeValidation {

  def employeeIsValid(employee: Employee): Boolean = {

    val database_object = new CompanyDB
    val companyName = database_object.getCompanyByName(employee.companyName)
    val emailValidator_object = new EmailValidation
    val emailValidator = emailValidator_object.emailIdIsValid(employee.emailId)
    if(emailValidator && companyName.isDefined)
      return true
    false
  }
}
