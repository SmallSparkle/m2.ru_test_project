package tests.steps;

import allure.JiraIssue;
import allure.JiraIssues;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("Оффер")
class TestsOffer extends TestBase {

  @Test
  @Story("Создать новый Offer")
  @Tag("web")
  @JiraIssues({@JiraIssue("QC3-25")})
  @DisplayName("Создание нового Offer неавторизованным пользователем")
  void createOfferInHomePageNoLoginUser() {
    step("Открываем главную страницу", () -> {
      open("");
    });
    step("Нажимаем на \"Новое объявление\" в навбаре", () -> {
      $("[href='/offer-placement/create']").$("span").click();
    });
    step("Проверяем что открытая страница содержит блок авторизации", () -> {
      $("[data-test='login-tab']").shouldHave(text("Вход"));
      $("[name='phone']").shouldBe(visible);
      $("[data-test='phone-submit-button']").shouldBe(visible);
    });
  }

  @Test
  @Story("Показать телефон")
  @Tag("web")
  @JiraIssues({@JiraIssue("QC3-25")})
  @DisplayName("Показать телефон продавца")
  void showPhone() {
    step("Открываем страницу поисковой выдачи", () -> {
      open("/moskva/nedvizhimost/kupit-kvartiru/3-komnaty/?priceMax=10000000");
    });
    step("Нажимаем на кнопку \"Показать телефон\" в карточке объекта", () -> {
      $("[data-test='offers']").$("[data-test='phone-button']").click();
    });
    step("Проверяем что на кнопке не отображается текст \"Показать телефон\"", () -> {
      $("[data-test='offers']").$("[data-test='phone-button']")
              .$("span").shouldNotHave(text("Показать телефон"));//$("li", 0)
    });
  }

}
