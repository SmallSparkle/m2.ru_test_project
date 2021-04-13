package tests.steps;

import io.qameta.allure.AllureId;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;

@Feature("Поиск")
class TestsSearchTabsPanel extends TestBase {

  @Test
  @Tag("web")
  @DisplayName("Поиск на главной странице - покупка квартиры")
  void searchApartmentForBuy() {
    step("Открыть главную страницу", () -> {
      open("");
    });
    step("Задать параметры поиска квартиры", () -> {
      $("[data-test='room-select-trigger']").click();
      $("input[name='ROOM_2']").parent().parent().click();
      $("[data-test='price-popup-toggle']").click();
      $("[data-test='price-preset-to-8000000']").click();
      $("[data-test='region-select-trigger']").click();
      $("[data-test='region-select-list']").$(byText("Санкт-Петербург и область")).click();
    });
    step("Нажать кнопку \"Найти\"", () -> {
      $("[data-test='search-button']").click();
    });
    step("Убедиться что открыта страница с результатами поиска", () -> {
      $("h1").shouldHave(text("Купить квартиру в Санкт-Петербурге и"));
    });
    step("Убедиться что результаты поиска соответствуют заданным", () -> {
      $("[data-test='rooms-trigger']").$(".FilterSelectButton__text")
              .shouldHave(text("2 комнаты"));
      $("[data-test='price-trigger']").$("span").shouldHave(text("до 8 млн ₽"));
      $(".Breadcrumb").shouldHave(text("2-комнатную"));
    });
  }

  @Test
  @AllureId("2257")
  @Tag("web")
  @DisplayName("Поиск на главной странице - снять квартиру")
  void searchApartmentForRent() {
    step("Открыть главную страницу", () ->
            open(""));
    step("В меню поиска выбрать вкладку \"Снять\"", () ->
            $("[data-test='rent-tab']").click());
    step("Задать параметры поиска квартиры", () -> {
      $("[data-test='room-select-trigger']").click();
      $("input[name='ROOM_1']").parent().parent().click();
      $("[data-test='price-popup-toggle']").click();
      $("[data-test='price-preset-to-30000']").click();
      $("[data-test='region-select-trigger']").click();
      $("[data-test='region-select-list']").$(byText("Москва")).click();
    });
    step("Нажать кнопку \"Найти\"", () ->
            $("[data-test='search-button']").click());
    step("Убедиться что открыта страница с результатами поиска", () ->
            $("h1").shouldHave(text("Снять квартиру в Москве")));
    step("Убедиться что результаты поиска соответствуют заданным", () -> {
      $("[data-test='rooms-trigger']").$(".FilterSelectButton__text")
              .shouldHave(text("1 комната"));
      $("[data-test='price-trigger']").$("span").shouldHave(text("до 30 тыс ₽"));
    });
  }

}
