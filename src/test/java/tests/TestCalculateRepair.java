package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class TestCalculateRepair extends TestBase {

  @Test
  @Disabled
  void calculateRepairInRepairPaige() {
    open("/remont/");
    $("[span='Калькулятор ремонта']").shouldBe();
    $("[type='submit']").scrollTo();
    $(byText("Новостройка")).parent().click();
    $("[data-test='square']").setValue("62");
    $("[data-test='roomCount']").$("[value='2']").click();
    $("[data-test='bathroomCount']").$x("//div/div[2]").click();
    $("[type='submit']").click();
    $(".wizard-module__title___2zPY").shouldHave(text("Выберите опции"));
    $("[name='warm-floor']").click();
    $(byText("Далее →")).click();
    $("[value='laminate']").click();
    $("[value='painted_ceiling']").click();
    $("[value='painted_wallpaper']").click();
    $(byText("Далее →")).click();
    $(byText("Оценка ремонтных работ")).shouldBe(visible);
    $(".final-module__finalForm___mj-4a").shouldHave(text("Запишитесь на онлайн-консультацию"));
    $(".final-module__finalFormWrapper___HiE7w").$("form").shouldBe(visible);
  }
}
