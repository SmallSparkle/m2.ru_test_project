package tests.methodSteps;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.CreditBaseSteps;
import tests.TestBase;

@Feature("Ипотека")
class TestsCredit extends TestBase {
  private final CreditBaseSteps step = new CreditBaseSteps();

  @Test
  @Tag("web")
  @DisplayName("Переход на страницу \"Ипотека\"")
  void goToCreditPage() {
    step.openBaseURL();
    step.goTeCreditPage();
    step.checkPromoBlock();
    step.checkCalculatorBlock();
  }

}
