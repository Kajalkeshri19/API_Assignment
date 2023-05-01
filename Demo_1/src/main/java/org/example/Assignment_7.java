package org.example;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;

public class Assignment_7 {

    @Test
    public void byStatusCode()
    {
         given().
                 when().
                 get("https://reqres.in/api/users?page=2")
                 .then()
                 .statusCode(200)
                 .log().all();
    }

    @Test
    public void byResponseBody()
    {
        given().
                when().
                get("https://reqres.in/api/users?page=2")
                .then()
                .body("data.id[0]",equalTo(7))
                .body("data.first_name",hasItems("Lindsay","George"))
                .log().all();
    }

    @Test
    public void byResponseHeader()
    {
        given().
                when().
                get("https://reqres.in/api/users?page=2")
                .then()
                .header("Content-Type", equalTo("application/json; charset=utf-8"))
                .header("Transfer-Encoding",equalTo("chunked"))
                .log().all();
    }

    @Test
    public void byCustomAssertion()
    {
        given().
                when().
                get("https://reqres.in/api/users?page=2")
                .then()
                .assertThat()
                .body("total_pages",equalTo(2))
                .log().all();
    }
}
