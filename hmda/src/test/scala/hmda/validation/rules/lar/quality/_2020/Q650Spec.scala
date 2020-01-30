package hmda.validation.rules.lar.quality._2020

import hmda.model.filing.lar.LarGenerators._
import hmda.model.filing.lar.LoanApplicationRegister
import hmda.validation.rules.EditCheck
import hmda.validation.rules.lar.LarEditCheckSpec

class Q650Spec extends LarEditCheckSpec {
  override def check: EditCheck[LoanApplicationRegister] = Q650

  property("Interest rate should note be greater than 0 but less than 0.5") {
    forAll(larGen) { lar =>
      lar.copy(loan = lar.loan.copy(interestRate = "8.5")).mustPass
      lar.copy(loan = lar.loan.copy(interestRate = "0.2")).mustFail
       lar.copy(loan = lar.loan.copy(interestRate = "-1.0")).mustFail
      lar.copy(loan = lar.loan.copy(interestRate = "0.4")).mustFail
      lar.copy(loan = lar.loan.copy(interestRate = "0.5")).mustPass
    }
  }
}
