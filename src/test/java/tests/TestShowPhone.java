package tests;

import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;
import static io.qameta.allure.Allure.step;


class TestShowPhone extends TestBase {

  @Test
  @Feature("Offer")
  @Story("Показать телефон")
  @DisplayName("Показать телефон продавца")
  void showPhone() {
    step("Открываем страницу поисковой выдачи",
            () -> open("/moskva/nedvizhimost/kupit-kvartiru/3-komnaty/?priceMax=10000000"));
    step("Нажимаем на кнопку \"Показать телефон\"",
            () -> $("[data-test='offers']").$("li", 0).$("[data-test='phone-button']").click());
    step("Проверяем что на кнопке не отображается текст \"Показать телефон\"",
            () -> $("[data-test='offers']").$("li", 0).$("[data-test='phone-button']")
                    .$("span").shouldNotHave(text("Показать телефон")));


  }

}
