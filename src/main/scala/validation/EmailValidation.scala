package validation

class EmailValidation {

  def emailIdIsValid(emailId: String): Boolean = {

    if (domainName(emailId) && recipientName(emailId) && checkAtTheRate(emailId) && topLevelDomain(emailId))
      return true

    false

  }
  def domainName(emailId: String): Boolean = {
    if (!checkAtTheRate(emailId))

      return false

    var mailIndex = emailId.indexOf("@") + 1
    while (emailId.charAt(mailIndex) != '.') {
      if (!Character.isLetterOrDigit(emailId.charAt(mailIndex)))

        return false

      mailIndex = mailIndex + 1
    }
    true
  }

  def checkAtTheRate(emailId: String): Boolean = {
    for (i <- 0 until emailId.length)
      if (emailId.charAt(i) == '@')
        return true
    false
  }

  def recipientName(emailId: String): Boolean = {
    var evidence = 0
    while (emailId.charAt(evidence) != '@') {
      if (emailId.charAt(evidence) == '.')

        return true

      if (!Character.isLetterOrDigit(emailId.charAt(evidence)))

        return false
      evidence = evidence + 1
    }
    true
  }

  def topLevelDomain (emailId: String): Boolean = {
    if (! checkAtTheRate (emailId) )

      return false

    val sample = emailId.indexOf (".")
    val domainType: String = emailId.substring (sample)
    if (domainType.equals (".com") || domainType.equals (".net") || domainType.equals (".org") || domainType.equals (".co.in"))

      return true

    false

  }
}

