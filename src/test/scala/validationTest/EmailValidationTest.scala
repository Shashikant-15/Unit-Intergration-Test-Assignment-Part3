package validationTest

import org.scalatest.funsuite.AnyFunSuite
import validation.EmailValidation



class EmailValidationTest extends AnyFunSuite {

  val emailValidator_object = new EmailValidation
  test("Checking with a valid Email Id") {

    val expectedOutcome = true
    val output = emailValidator_object.emailIdIsValid("shashikanttanti603@gmail.com")
    assert(expectedOutcome == output)
  }

  test("Checking if it returns false on passing an invalid Email Id without '@'") {

    val expectedData = false
    val outcome = emailValidator_object.emailIdIsValid("shashikanttanti603gmail.com")
    assert(expectedData == outcome)
  }

  test("Checking if it returns false on passing an invalid Email Id with special characters in domain name") {

    val expectedValue = false
    val outcome = emailValidator_object.emailIdIsValid("shashikanttanti603@$$gmail.com")
    assert(expectedValue == outcome)
  }

  test("Checking if it returns false on passing an invalid Email Id with special characters in recipient's Name") {

    val expectedOutput = false
    val output = emailValidator_object.emailIdIsValid("shashikant@$tanti603@gmail.com")
    assert(expectedOutput == output)
  }

  test("Checking if it returns false on passing an invalid Email Id with invalid Top Level Domain") {

    val expectedResult = false
    val result = emailValidator_object.emailIdIsValid("shashikanttanti603@gmail.calm")
    assert(expectedResult == result)
  }
}