package tests;

import com.codeborne.selenide.Configuration;
import config.EnvironmentConfig;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.AttachmentsHelper.*;

public class TestBase {

  @BeforeAll
  static void setup() {
    final EnvironmentConfig config = ConfigFactory.create(EnvironmentConfig.class, System.getProperties());
    addListener("AllureSelenide", new AllureSelenide());
    Configuration.startMaximized = true;
    Configuration.baseUrl = "https://m2.ru";
    if (System.getProperty("remote_driver") != null) {
      DesiredCapabilities capabilities = new DesiredCapabilities();
      capabilities.setCapability("enableVNC", true);
      capabilities.setCapability("enableVideo", true);
      Configuration.browserCapabilities = capabilities;
      Configuration.remote = System.getProperty("remote_driver");
    }
    RestAssured.baseURI = "https://m2.ru";
  }

  @AfterEach
  public void afterEach() {
    attachScreenshot("Last screenshot");
    attachPageSource();
    attachAsText("Browser console logs", getConsoleLogs());
    if (System.getProperty("video_storage") != null) {
      attachVideo();
    }
    closeWebDriver();
  }
}

