package com.saurabhAPIAuto.base;

import com.saurabhAPIAuto.actions.AssertActions;
import com.saurabhAPIAuto.endpoints.APIConstants;
import com.saurabhAPIAuto.modules.PayloadManager;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

public class BaseTest {
    // Base Test Father -> Testcase - Son - Single Inheritance

    public RequestSpecification requestSpecification;
    public AssertActions assertActions;
    public PayloadManager payloadManager;
    public JsonPath jsonPath;
    public Response response;
    public ValidatableResponse validatableResponse;

    @BeforeTest
    public  void setUp(){
        System.out.println("Before Test");
        payloadManager = new PayloadManager();
        assertActions = new AssertActions();
        requestSpecification = new RequestSpecBuilder()
                .setBaseUri(APIConstants.BASE_URL)
                .addHeader("Content-Type", "application/json")
                .build().log().all();

//        requestSpecification = RestAssured
//                .given()
//                .baseUri(APIConstants.BASE_URL)
//                .contentType(ContentType.JSON)
//                .log().all();



    }

    public String getToken(){
        //url setup
        requestSpecification=
                RestAssured.given().baseUri(APIConstants.BASE_URL)
                        .basePath(APIConstants.AUTH_URL);
        //payload setup
        String payload = payloadManager.setAuthPayload();
        //getting the response
        response = requestSpecification
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post();


       //Extracting Token from via de serialization

        payloadManager = new PayloadManager();
        String token = payloadManager.getTokenFromJSON(response.asString());
        return token;

    }

}
