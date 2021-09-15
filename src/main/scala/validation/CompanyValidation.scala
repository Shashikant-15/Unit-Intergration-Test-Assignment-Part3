package validation

import database.CompanyDB
import companyModels.Company

class CompanyValidation {

  def companyIsValid(company: Company): Boolean = {

    val database_object = new CompanyDB
    val companyExist = database_object.getCompanyByName(company.name)

    val emailValidator = new EmailValidation
    val checkEmail = emailValidator.emailIdIsValid(company.emailId)
    if (checkEmail && companyExist.isEmpty)

      return true
    false

  }
}

