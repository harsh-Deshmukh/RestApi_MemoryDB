/*
package com.uxpsystems.assignment.controller;

import com.uxpsystems.assignment.config.AppRootConfig;
import com.uxpsystems.assignment.service.UserService;
import io.restassured.RestAssured;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(classes = AppRootConfig.class)
public class UserControllerTest {

    private static RestAssured restAssured;
    @Autowired
    UserService userService;
    @InjectMocks
    UserController userController;


    @BeforeClass
    public static void init() {
        restAssured.baseURI = "http://localhost";
        restAssured.port = 9090;
        restAssured.basic("harshal", "{noop}harshal1");
        restAssured.rootPath = "/assignement";

    }

    @Test
    public void noResorceFound() {
        restAssured.when().get("/test").then().statusCode(404);
    }

    @Test
    public void getSuccessRequest() {
        restAssured.given()
                .auth().basic("harshal", "harshal1")
                .when().get(restAssured.rootPath + "/user")
                .then().statusCode(200);
    }
}
*/
