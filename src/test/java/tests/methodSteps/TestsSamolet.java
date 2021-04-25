package tests.methodSteps;

import allure.JiraIssue;
import allure.JiraIssues;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import steps.SamoletBaseSteps;
import tests.TestBase;

@Feature("Сатмолёт")
class TestsSamolet extends TestBase {
  private final SamoletBaseSteps step = new SamoletBaseSteps();

  @Test
  @Tag("web")
  @JiraIssues({@JiraIssue("QC3-25")})
  @DisplayName("Переход на страницу застройщика \"Самолёт\"")
  void goToSamoletDeveloperPage() {
    step.openMainPage();
    step.goToSamoletDeveloperPage();
    step.checkDeveloperPage();
    step.checkSamoletDevelopersOffers(6);
  }

}
