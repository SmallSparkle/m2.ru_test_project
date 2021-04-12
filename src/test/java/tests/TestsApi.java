package tests;

import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@Feature("API")
public class TestsApi extends TestBase {

  @Test
  @Tag("api")
  @DisplayName("Получить список квартир")
  void searchApartmentApi() {
    given()
            .when()
            .post("/moskva/nedvizhimost/kupit-kvartiru/3-komnaty/?priceMax=10000000")
            .then()
            .log().body()
            .statusCode(200)
            .extract().body()
            .toString().contains("Купить квартиру в Москве");
  }
}
