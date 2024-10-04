package ch.heigvd.amt.resource;

import io.quarkus.test.TestTransaction;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.containsString;

@QuarkusTest
public class ProbeResourceTest {

    @Test
    void testIndex() {
        given()
                .when().get("/")
                .then()
                .statusCode(200)
                .body(containsString("Welcome to Uptime"));
    }

    @Test
    @TestTransaction
    void testRegister() {
        given()
                .formParam("url", "https://www.example.com")
                .when().post("/probes")
                .then()
                .statusCode(200)
                .body(containsString("https://www.example.com"));
    }


}
