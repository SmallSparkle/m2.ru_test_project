package steps;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class CreditBaseSteps {

  @Step("Открываем главную страницу")
  public void openBaseURL() {
    open("");
  }

  @Step("Выбираем в навбаре пункт \"Ипотека\"")
  public void goTeCreditPage() {
    $(byText("Ипотека")).parent().click();
  }

  @Step("Проверяем что на странице, в промо блоке отображается заголовок и кнопка \"Подать заявку\" ")
  public void checkPromoBlock() {
    $("h1").shouldHave(text("Одна заявка на ипотеку сразу во все банки"));
    $("[data-test='demandCreateButton']").shouldBe(visible);
  }

  @Step("Проверяем что на странице отображается блок калькулятора")
  public void checkCalculatorBlock() {
    $("h3").shouldHave(text("Калькулятор ипотеки"));
    $("h3").parent().$("form").shouldBe(visible);
  }

}
