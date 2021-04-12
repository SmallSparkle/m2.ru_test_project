package tests;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("Оффер")
class TestCreateNewOffer extends TestBase {

  @Test
  @Feature("Offer")
  @Story("Создать новый Offer")
  @DisplayName("Создание нового Offer неавторизованным пользователем")
  void createOfferInHomePageNoLoginUser() {
    SelenideLogger.addListener("allure", new AllureSelenide());

    open("");
    $("[data-test='create-offer']").click();
    $("[data-test='login-tab']").shouldHave(text("Вход"));
    $("[name='phone']").shouldBe(exist);
    $("[data-test='phone-submit-button']").shouldBe(visible);
  }

  @Test
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
