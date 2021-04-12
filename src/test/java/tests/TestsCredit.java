package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Test;
import steps.BaseStepsCredit;

@Feature("Ипотека")
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
