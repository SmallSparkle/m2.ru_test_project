package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Condition.*;


public class TestShowPhone extends TestBase {

  @Test
  void showPhone() {
    open("/moskva/nedvizhimost/kupit-kvartiru/3-komnaty/?priceMax=10000000");
    $("[data-test='offers']").$("li", 0).$("[data-test='phone-button']").click();

    $("[data-test='offers']").$("li", 0).$("[data-test='phone-button']")
            .$("span").shouldNotHave(text("Показать телефон"));
  }

}
