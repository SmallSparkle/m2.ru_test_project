package tests.selenideOnly;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Feature("Неработающий тест для отображения в отчёте")
class TestFall extends TestBase {

  @Test
  @Tag("web")
  @DisplayName("Падающий тест для отрисовки отчёта")
  void alwaysFallFeature() {
    open("/favorites");
    $("h1").shouldHave(text("Избранное"));
  }
}
