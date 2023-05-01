package org.example;

import io.restassured.http.Headers;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Assignment_9 {
    public void getEmployee()
    {
        List<Integer> employee = given()
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(200)
                .extract()
                .path("data.findAll { it.id >= 1 && it.id <= 10 }.id");
        System.out.println(employee);
    }


}
