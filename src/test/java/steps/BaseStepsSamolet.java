package steps;

import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import tests.TestBase;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BaseStepsSamolet extends TestBase {

  @Step("Открываем главную страницу")
  public void openBaseURL() {
    open("");
  }

  @Step("Переходит на страницу застройщика \"Самолет\"")
  public void goToSamoletPage() {
    $("#Header_ButtonSamolet-link").click();
  }

  @Step("Проверяем что открыта страница застройщика \"Самолет\"")
  public void checkPage() {
    $("h2").shouldHave(text("Новостройки от Группы «Самолет» в Москве и области"));
  }

  @Step("Проверяем что на страница застройщика \"Самолет\" размещены объекты")
  public void checkOffers() {
    int minimalCountOffers = 6;
    //кол-во объкетов на стр. можно брать из базы или из требований
    Assertions.assertTrue($$(".SamoletSerp__item").size() >= minimalCountOffers);
  }

  @Step("Открываем страницу застройщика \"Самолет\"")
  public void openSamoletPage() {
    open("/samolet");
    $(".SamoletSerp").shouldBe(visible, Duration.ofSeconds(50));
  }

  @Step("Выбираем объект")
  public void selectObject(String complex) {
    $$("a").findBy(text(complex)).click();
  }

  @Step("Переходим на вкладку объекта")
  public void goToComplexPage() {
    switchTo().window(1);
  }

  @Step("Переходим на вкладку объекта")
  public void checkComplexPage(String s) {
    $("h1").$("span", 1).shouldHave(text(s));
  }


}
