package requestForCheck


import validation.CompanyValidation
import companyModels.Company


class CompanyOperation(companyValidator: CompanyValidation) {

  def createCompany(company: Company): Option[String] = {
    if (companyValidator.companyIsValid(company)) Option(company.name)
    else None
  }
}