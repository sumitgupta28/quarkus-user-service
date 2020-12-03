package com.quakus.demo.controller;

import com.quakus.demo.rs.model.User;
import io.quarkus.test.junit.QuarkusTest;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import javax.ws.rs.core.MediaType;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.jupiter.api.Assertions.*;



@QuarkusTest
class UserResourceTest {

    public static String payload = "{\n" +
            "  \"firstName\": \"Test\",\n" +
            "  \"lastName\": \"Test\",\n" +
            "  \"emailAddress\": \"someTest@mail.com\"\n" +
            "}";

    @Test
    void createUser() {
        given().contentType(MediaType.APPLICATION_JSON)
                .body(payload)
                .post("/user/add")
                .then().log().ifValidationFails(LogDetail.ALL).statusCode(200);
    }

    @Test
    void getUser() {
       String userName= getUserName(new User("Test","Test","Test@Testmail.com"));
        String url="/user/get/"+userName;
        given().get(url)
                .then().log().ifValidationFails(LogDetail.ALL).statusCode(200);

    }

    private String getUserName(User user)
    {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();
        return firstName.substring(0, 3) + lastName.substring(0, 3) + firstName.hashCode();
    }

    @Test
    void getUsers() {
    }

    @Test
    void deleteUser() {
    }

    @Test
    void updateUser() {
    }
}