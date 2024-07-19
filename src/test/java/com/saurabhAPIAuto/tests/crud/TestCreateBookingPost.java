package com.saurabhAPIAuto.tests.crud;

import com.saurabhAPIAuto.base.BaseTest;
import com.saurabhAPIAuto.endpoints.APIConstants;
import com.saurabhAPIAuto.pojos.BookingResponse;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.RestAssured;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.*;
public class TestCreateBookingPost extends BaseTest {

    @Test(groups= "Smoke")
    @Owner("Saurabh")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC1, Verify that the booking can created")
    public void testCreateBooking(){
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadManager.createPayloadBookingAsString()).post();

        validatableResponse = response.then().log().all();

        //Validatable Assertion
        validatableResponse.statusCode(200);
//        validatableResponse.body("bookingid", Matchers.notNullValue());
//        validatableResponse.body("booking.firstname", Matchers.equalTo("Saurabh"));

        //DeSerialization
        BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        //AssertJ
        assertThat(bookingResponse.getBookingid()).isNotNull();
        assertThat(bookingResponse.getBooking().getFirstname()).isNotNull().isNotBlank();
        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Saurabh");

        //TestNG Assertions
        assertActions.verifyStatusCode(response);



    }

    @Test(groups= "Smoke")
    @Owner("Saurabh")
    @Severity(SeverityLevel.NORMAL)
    @Description("TC2, Verify that the booking can not be created")
    public void testCreateBookingNegative(){
        requestSpecification.basePath(APIConstants.CREATE_UPDATE_BOOKING_URL);
        response = RestAssured
                .given(requestSpecification)
                .when().body(payloadManager.createInvalidPayloadBookingAsString()).post();

        validatableResponse = response.then().log().all();

        //Validatable Assertion
        validatableResponse.statusCode(500);
//        validatableResponse.body("bookingid", Matchers.notNullValue());
//        validatableResponse.body("booking.firstname", Matchers.equalTo("Saurabh"));

        //DeSerialization
       // BookingResponse bookingResponse = payloadManager.bookingResponseJava(response.asString());

        //AssertJ
//        assertThat(bookingResponse.getBookingid()).isNull();
//        assertThat(bookingResponse.getBooking().getFirstname()).isNull();
//        assertThat(bookingResponse.getBooking().getFirstname()).isEqualTo("Saurabh");

        //TestNG Assertions
        assertActions.verifyStatusCode1(response);



    }




}
