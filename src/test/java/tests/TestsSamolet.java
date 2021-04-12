package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import steps.BaseStepsSamolet;

import static utils.RandomUtils.getRandomResidentialComplex;

//тесты flaky из за долгой загрузки страницы - видимо api застройщика тормозит
//оставлены для отображения в Allure

@Feature("Сатмолёт")
class TestsSamolet extends TestBase {
  private final BaseStepsSamolet step = new BaseStepsSamolet();


  @Test
  void goToSamoletPage() {
    step.openBaseURL();
    step.goToSamoletPage();
    step.checkPage();
    step.checkOffers();
  }

  @Test
  void openComplexPage() {
    String complex = getRandomResidentialComplex();
    step.openSamoletPage();
    step.selectObject(complex);
    step.goToComplexPage();
    step.checkComplexPage(extractComplexName(complex));


  }

  private String extractComplexName(String complex)  {
    if(!complex.contains("«")) {
      return complex;
    }
      String[] s = complex.split("«");

    return s[1].split("»").toString();
  }

}
