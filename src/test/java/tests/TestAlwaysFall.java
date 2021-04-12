package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Feature("Fail test for demo")
class TestAlwaysFall extends TestBase{

  @Test
  @DisplayName("Падающий тест для отрисовки отчёта")
  void alwaysFallFeature() {
    open("/favorites");
    $("h1").shouldHave(text("Избранное"));
  }
}
