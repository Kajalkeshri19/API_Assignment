package org.example;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;


public class Assignment_6 {
    @Test

    public void getEmployee()
    {
        List<Integer> employee = given()
                .when()
                .get("https://reqres.in/api/unknown")
                .then()
                .statusCode(200)
                .extract()
                .path("data.findAll { it.id >= 1 && it.id <= 10 }.id");
        System.out.println(employee);

        List<Integer> employee1 = given()
                .when()
                .get("https://reqres.in/api/users?page=2")
                .then()
                .statusCode(200)
                .extract()
                .path("data.findAll { it.id >= 1 && it.id <= 10 }.id");
        System.out.println(employee1);

    }
}
