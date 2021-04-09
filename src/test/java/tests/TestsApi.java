package tests;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

public class TestsApi extends TestBase {

  @Test
  @Tag("api")
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
