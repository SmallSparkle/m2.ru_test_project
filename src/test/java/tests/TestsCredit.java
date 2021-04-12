package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.BaseStepsCredit;

@Feature("Ипотека")
class TestsCredit extends TestBase {
  private final BaseStepsCredit step = new BaseStepsCredit();

  @Test
  @Tag("web")
  @DisplayName("Переход на страницу \"Ипотека\"")
  void goToCreditPaige() {
    step.openBaseURL();
    step.goTeCreditPaige();
    step.checkPromoBlock();
    step.checkCalculatorBlock();

  }


}
