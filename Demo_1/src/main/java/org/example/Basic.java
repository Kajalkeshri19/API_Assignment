package org.example;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItems;


public class Basic {
    @Test
    public void Demo() {
        Response res=RestAssured.get("https://reqres.in/api/users?page=2");
        System.out.println(res.getStatusCode());
        System.out.println(res.getBody());
        System.out.println(res.getContentType());


    }

    @Test
    public void statusCode() {
        given()
                .when()
                .get("https://reqres.in/api/users")
                .then()
                .statusCode(200);
        System.out.println("The satus code is 200");
    }

    @Test
    public void get()
    {
        given().get("https://reqres.in/api/users?page=2").
                then().statusCode(200)
                .body("data.id[1]",equalTo(8))
                .body("data.first_name",hasItems("George","Michael"))
                .log().all();
        System.out.println("Status code is 200");
    }


    @Test
    public void post()
    {
        Map<String,Object> map=new HashMap<String,Object>();
        map.put("name","Kajal");
        map.put("job","Intern");

//        JSONObject request=new JSONObject( map);
//        System.out.println(request);

        JSONObject request=new JSONObject();
        request.put("name","Sweta");
        //System.out.println(request);
        System.out.println(request.toJSONString());

    }



}
