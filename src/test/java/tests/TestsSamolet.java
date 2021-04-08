package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static utils.RandomUtils.getRandomResidentialComplex;


class TestsSamolet extends TestBase {

  @Test
  void goToSamolet() {
    open("");
    $("#Header_ButtonSamolet-link").click();

    $("h2").shouldHave(text("Новостройки от Группы «Самолет» в Москве и области"));
    Assertions.assertEquals(12, $$(".SamoletSerp__item").size());
  }

  @Test
  void openComplexPage() {
    String complex = getRandomResidentialComplex();
    open("/samolet");
    $(".SamoletSerp").shouldBe(visible, Duration.ofSeconds(40));
    $$("a").findBy(text(complex)).click();
    switchTo().window(1);

    String[] s = complex.split("«");
    String[] openedComplex = s[1].split("»");
    $("h1").$("span", 1).shouldHave(text(openedComplex[0]));
  }

}
