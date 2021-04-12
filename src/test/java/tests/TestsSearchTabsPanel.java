package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Feature("Поиск")
class TestsSearchTabsPanel extends TestBase {

  @Test
  @DisplayName("Поиск - покупка квартиры на главной странице")
  void searchApartmentForBuy() {
    open("");
    $("[data-test='room-select-trigger']").click();
    // проверить что мы на нужной вкладке меню ???
    $("input[name='ROOM_2']").parent().parent().click();
    $("[data-test='price-popup-toggle']").click();
    $("[data-test='price-preset-to-8000000']").click();
    $("[data-test='region-select-trigger']").click();
    $("[data-test='region-select-list']").$(byText("Санкт-Петербург и область")).click();
    $("[data-test='search-button']").click();
    $("h1").shouldHave(text("Купить квартиру в Санкт-Петербурге и"));
    $(".Breadcrumb").shouldHave(text("2-комнатную"));

  }
}
