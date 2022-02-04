package org.acme;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

import java.util.UUID;

@QuarkusTest
public class GreetingResourceTest {

    @Test
    public void testHelloEndpoint() {
        given()
          .when().get("/hello")
          .then()
             .statusCode(200)
             .body(is("hello my message"));
    }
    @Test
    public void testGreetingEndpoint() {
        String uuid = UUID.randomUUID().toString();
        given()
          .pathParam("name", uuid)
          .when().get("/hello/greeting/{name}")
          .then()
            .statusCode(200)
            .body(is("Hello " + uuid));
    }

    @Test
    public void testNumOfGreeting(){
      given()
        .when().get("/hello/numGreetings")
          .then()
            .statusCode(200)
              .body(is("number of greetings is 1"));
    }

    @Test
    public void testListOfGreetings(){
      given()
      .when()
      .get("/hello/greetings/list")
      .then()
        .statusCode(200)
        .body(is("[hello, hola, chao]"));
    }

}