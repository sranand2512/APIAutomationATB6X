package com.saurabhAPIAuto.tests.integration;

import com.saurabhAPIAuto.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;

public class sample extends BaseTest {
    //Create a token, booking
    //Get booking
    //Update booking
    //Delete the booking

    @Test(groups = "integration",priority = 1)
    @Owner("Saurabh")
    @Description("INTC01 - Step 1. Verify that Booking can be created ")
    public void testCreateBooking() {
        Assert.assertTrue(true);


    }



    @Test(groups = "integration", priority = 2)
    @Owner("Saurabh")
    @Description("INTC02 - Step 2. Verify that Booking Id ")
    public void testVerifyBookingId() {
        Assert.assertTrue(true);


    }


    @Test(groups = "integration", priority = 3)
    @Owner("Saurabh")
    @Description("INTC03 - Step 3. Verify that Booking can be updated ")
    public void testUpdateBookingId() {
        Assert.assertTrue(true);


    }

    @Test(groups = "integration", priority = 4)
    @Owner("Saurabh")
    @Description("INTC04 - Step 4. Verify that Booking can be deleted ")
    public void testDeleteBookingId() {
        Assert.assertTrue(true);


    }


}
