package tests;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestCreateNewOffer extends TestBase {

  @Test
  void createOfferInHomePageNoLoginUser() {
    open("");
    $("[data-test='create-offer']").click();

    $("[data-test='login-tab']").shouldHave(text("Вход"));
    $("[name='phone']").shouldBe(exist);
    $("[data-test='phone-submit-button']").shouldBe(visible);
  }
}
