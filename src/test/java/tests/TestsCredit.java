package tests;

import org.junit.jupiter.api.Test;
import steps.BaseStepsCredit;

class TestsCredit extends TestBase {
  private final BaseStepsCredit step = new BaseStepsCredit();

  @Test
  void goToCreditPaige() {
    step.openBaseURL();
    step.goTeCreditPaige();
    step.checkPromoBlock();
    step.checkCalculatorBlock();

  }


}
