package com.saurabhAPIAuto.tests.extendDemo;

import com.saurabhAPIAuto.base.BaseTest;
import com.saurabhAPIAuto.endpoints.APIConstants;
import com.saurabhAPIAuto.pojos.Booking;
import com.saurabhAPIAuto.pojos.BookingResponse;
import com.saurabhAPIAuto.utils.PropertyReader;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.restassured.RestAssured;
import org.hamcrest.Matchers;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import static org.assertj.core.api.Assertions.assertThat;


public class TCIntegrationFlow1extent extends BaseTest {
    //Create a token, booking
    //Get booking
    //Update booking
    //Delete the booking

    @Test(groups = "integration",priority = 1)
    @Owner("Saurabh")
    @Description("INTC01 - Step 1. Verify that Booking can be created ")
    public void testCreateBooking(ITestContext iTestContext) {
        iTestContext.setAttribute("token",getToken());
        Assert.assertTrue(true);

        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString()).post();

        validatableResponse = response.then().log().all();

        //Validatable Assertion
        validatableResponse.statusCode(200);
        validatableResponse.body("bookingid", Matchers.notNullValue());
        validatableResponse.body("booking.firstname", Matchers.equalTo("Saurabh"));

        //DeSerialization
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        //AssertJ
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Saurabh");

        //TestNG Assertions
        assertActions.verifyStatusCode(response);

        //Set the booking iD
        iTestContext.setAttribute("bookingid", bookingResponse.getBookingid());


    }



    @Test(groups = "integration", priority = 2)
    @Owner("Saurabh")
    @Description("INTC01 - Step 2. Verify that Booking Id ")
    public void testVerifyBookingId(ITestContext iTestContext) {

        System.out.println("Token -"+ iTestContext.getAttribute("token"));
        Assert.assertTrue(true);
        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");

        String basePath_new =  APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+bookingid;
        System.out.println(basePath_new);

        requestSpecification.basePath(basePath_new);
        response = RestAssured
                .given(requestSpecification)
                .when().get();

        validatableResponse = response.then().log().all();

        //Validatable Assertion
         validatableResponse.statusCode(200);
         Booking booking = payloadManager.getResponseFromJSON(response.asString());

         assertThat(booking.getFirstname()).isNotNull().isNotBlank();
         assertThat(booking.getFirstname()).isEqualTo("Saurabh");
         assertThat(booking.getFirstname()).isEqualTo(PropertyReader.readKey("booking.firstname"));


    }


    @Test(groups = "integration", priority = 3)
    @Owner("Saurabh")
    @Description("INTC01 - Step 3. Verify that Booking can be updated ")
    public void testUpdateBookingId(ITestContext iTestContext) {
        System.out.println("Token -"+ iTestContext.getAttribute("token"));
        String token = (String) iTestContext.getAttribute("token");
        Assert.assertTrue(true);


        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String basePath_new =  APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+bookingid;
        System.out.println(basePath_new);

        requestSpecification.basePath(basePath_new);
        response = RestAssured
                .given(requestSpecification).cookie("token",token)
                .when().body(payloadManager.createPayloadBookingAsString_up()).put();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);
        Booking booking = payloadManager.getResponseFromJSON(response.asString());

        assertThat(booking.getFirstname()).isNotNull().isNotBlank();
        assertThat(booking.getFirstname()).isEqualTo("Mahatma");




    }

    @Test(groups = "integration", priority = 4)
    @Owner("Saurabh")
    @Description("INTC01 - Step 4. Verify that Booking can be deleted ")
    public void testDeleteBookingId(ITestContext iTestContext) {
        System.out.println("Token -"+ iTestContext.getAttribute("token"));
        Assert.assertTrue(true);

        String token = (String) iTestContext.getAttribute("token");

        Integer bookingid = (Integer) iTestContext.getAttribute("bookingid");
        String basePath_new =  APIConstants.CREATE_UPDATE_BOOKING_URL+"/"+bookingid;
        System.out.println(basePath_new);

        requestSpecification.basePath(basePath_new);
        response = RestAssured
                .given(requestSpecification).cookie("token",token)
                .when().delete();

        validatableResponse = response.then().log().all();

        validatableResponse.statusCode(200);



    }


}
