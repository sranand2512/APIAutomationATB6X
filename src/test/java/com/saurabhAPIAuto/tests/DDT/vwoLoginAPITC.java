package com.saurabhAPIAuto.tests.DDT;

import com.saurabhAPIAuto.utils.UtilsExcel;
import com.google.gson.Gson;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

public class vwoLoginAPITC {

    RequestSpecification r2;
    ValidatableResponse vr2;
    Integer id;
    Response res2 ;

    @Test(dataProvider = "getData",dataProviderClass = UtilsExcel.class )
    public void testvwoLogin(String email, String password){
        System.out.println("Login API Testing");
        System.out.println(email);
        System.out.println(password);

//        @Test(dataProvider = "getData",dataProviderClass = UtilsExcel.class)
//        public void testVWOLogin(String email,String password){
//            System.out.println(" -- Login API Testing");
//            System.out.println(email);
//            System.out.println(password);


        //Payload

        vwoLoginPoJo vwoLoginPoJo = new vwoLoginPoJo();
        vwoLoginPoJo.setUsername(email);
        vwoLoginPoJo.setPassword(password);
        vwoLoginPoJo.setRecaptchaResponseField("");
        vwoLoginPoJo.setRemember(false);

        Gson gson = new Gson();
        String payload = gson.toJson(vwoLoginPoJo);


        // Rest Assured code

        r2 = RestAssured.given();
        r2.baseUri("https://app.vwo.com");
        r2.basePath("/login");
        r2.contentType(ContentType.JSON);
        r2.body(payload).log().all();

        res2 = r2.when().post();
        vr2 = res2.then().log().all();

        String resString = res2.asString();
        System.out.println(resString);
        vr2.body("id", Matchers.notNullValue());


        // AssertJ



    }
}
