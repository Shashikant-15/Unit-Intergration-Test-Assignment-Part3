package validationTest

import companyModels.Company
import org.scalatest.funsuite.AnyFunSuite
import validation.CompanyValidation


class CompanyValidationTest extends AnyFunSuite {

  val companyOne = new Company("Tata Consultancy Service", "tcs23@gmail.com", "Noida")
  val companyTwo = new Company("Knoldus", "knoldus23@gmail.com", "Noida")
  val companyThree = new Company("Deloitte", "deloitte23gmail.com", "Delhi")


  test("Check if companyOne is not present in database and is thus a valid entry") {
    val expectedResult = true
    val result = (new CompanyValidation).companyIsValid(companyOne)
    assert(expectedResult == result)
  }

  test("Check if companyTwo is an invalid entry as the company already exists in the database") {
    val expectedResult = false
    val result = (new CompanyValidation).companyIsValid(companyTwo)
    assert(expectedResult == result)
  }

  test("Check if companyThree is not present in database but having invalid email ID without '@'is thus an invalid entry") {
    val expectedResult = false
    val result = (new CompanyValidation).companyIsValid(companyThree)
    assert(expectedResult == result)
  }

}
