package io.swagger;
/* 
 Created by Jaydip Patel
 */


import io.restassured.http.ContentType;
import io.restassured.response.ValidatableResponse;
import io.swagger.constants.EndPoints;
import io.swagger.model.PetPojo;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

public class UsersSteps {

    @Step("Creating User with name : {0}, Job: {1}")
    public ValidatableResponse createUser(String name,
                                          String job) {
        PetPojo petPojo = new PetPojo();
        petPojo.setName(name);
        petPojo.setJob(job);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(petPojo)
                .when()
                .post(EndPoints.POST_PET)
                .then();
    }

    @Step("Getting All Users from Page 2")
    public ValidatableResponse getAllUserFromPageTwo() {
               return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .queryParam("page",2)
                .when()
                .get(EndPoints.GET_PET_BY_ID)
                .then();
    }

    @Step("Getting the User information with ID: {0}")
    public void getUserByID(String userID) {
 SerenityRest.given().log().all()
                .when()
                .pathParam("userID", userID)
                .get(EndPoints.GET_PET_BY_ID)
                .then().log().all()
                .extract().path("");

    }
/*
    @Step("Login User with email : {0}, password: {1}")
    public HashMap<String, ?> loginUser(String email,
                                        String password) {
        PetPojo petPojo = new PetPojo();
        petPojo.setEmail(email);
        petPojo.setPassword(password);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .body(petPojo)
                .when()
                .post(EndPoints.USER_LOGIN)
                .then()
                .statusCode(200)
                .extract()
                .path("");
    }

    @Step("Update User with name : {0}, Job: {1}")
    public ValidatableResponse updateUserByPatch(String userID,
                                                 String name,
                                                 String job) {
        PetPojo petPojo = new PetPojo();
        petPojo.setName(name);
        petPojo.setJob(job);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("userID", userID)
                .body(petPojo)
                .when()
                .patch(EndPoints.UPDATE_USER_BY_ID)
                .then();
    }

    @Step("Update User with name : {0}, Job: {1}")
    public ValidatableResponse updateUserByPut(String userID,
                                               String name,
                                               String job) {
        PetPojo petPojo = new PetPojo();
        petPojo.setName(name);
        petPojo.setJob(job);
        return SerenityRest.given().log().all()
                .contentType(ContentType.JSON)
                .pathParam("userID", userID)
                .body(petPojo)
                .when()
                .put(EndPoints.UPDATE_USER_BY_ID)
                .then();
    }

    @Step("Deleting user with ID {0}")
    public ValidatableResponse deleteProduct(String userID) {
        return SerenityRest.given().log().all()
                .pathParam("userID", userID)
                .when()
                .delete(EndPoints.DELETE_USER_BY_ID)
                .then();
    }*/
}
