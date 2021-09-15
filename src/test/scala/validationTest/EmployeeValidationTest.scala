package validationTest


import companyModels.Employee
import org.scalatest.funsuite.AnyFunSuite
import validation.EmployeeValidation


class EmployeeValidationTest extends AnyFunSuite{

  val employeeOneJohn: Employee = Employee("John", "Kamran", 12,45000, "Software Developer", "Knoldus", "john123@gmail.com" )
  val employeeTwoSmith: Employee = Employee("Smith", "Adam", 36,43000, "Software Consultant", "Wipro", "smith12@gmail.com" )
  val employeeThreeAlex: Employee = Employee("Alex", "Carry", 23,55000, "Sr. Software Trainee", "HCL", "alex56@gmail.com" )
  val employeeFourRobbert: Employee = Employee("Robbert", "Hood", 21,35000, "Software Designer", "Accenture", "robbert012?@gmail.com" )


  test("Checking if Employee- employeeOneJohn working in Knoldus(company present in Database) is a valid Employee"){
    val expectOutcome = true
    val finalResult = (new EmployeeValidation).employeeIsValid(employeeOneJohn)
    assert(expectOutcome == finalResult)
  }


  test("Checking if Employee- employeeTwoSmith working in Wiper(company present in Database) is a valid Employee"){

    val expectOutcome = false
    val result = (new EmployeeValidation).employeeIsValid(employeeTwoSmith)
    assert(expectOutcome == result)
  }


  test("Checking if Employee- employeeThreeAlex working in company HCL(company not present in Database) is thus an invalid Employee"){

    val expectResult = false
    val outcome = (new EmployeeValidation).employeeIsValid(employeeThreeAlex)
    assert(expectResult == outcome)
  }

  test("Checking if Employee- employeeFourRobbert working in Accenture(company present in Database) having invalid Email ID is thus an invalid Employee"){
    val expectResult = false
    val conclusion = (new EmployeeValidation).employeeIsValid(employeeFourRobbert)
    assert(expectResult == conclusion)
  }

}
