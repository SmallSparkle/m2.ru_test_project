package steps;

import com.codeborne.selenide.CollectionCondition;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import tests.TestBase;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class SamoletBaseSteps extends TestBase {

  @Step("Открываем главную страницу")
  public void openMainPage() {
    open("");
  }

  @Step("Переходим на страницу застройщика \"Самолет\"")
  public void goToSamoletDeveloperPage() {
    $("[data-test='header-partner-button']").click();
  }

  @Step("Проверяем что открыта страница застройщика \"Самолет\"")
  public void checkDeveloperPage() {
    $("h2").shouldBe(visible).shouldHave(text("Новостройки от Группы «Самолет» в Москве и области"));
  }

  @Step("Проверяем что на страница застройщика \"Самолет\" размещены объекты")
  public void checkSamoletDevelopersOffers(int minimalCountOffers) {
    //кол-во объкетов на стр. можно брать из базы или из требований
    $$(".SamoletSerp__item")
            .shouldHave(CollectionCondition.sizeGreaterThanOrEqual(minimalCountOffers));
  }

}
