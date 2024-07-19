package com.saurabhAPIAuto.tests.crud;

import com.saurabhAPIAuto.base.BaseTest;
import io.qameta.allure.Description;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;

public class smaple extends BaseTest {

    @Test(groups= {"Smoke"})
    @Owner("Saurabh")
    @Description("TC1_Verify that user is able to create a booking successfully")
    @Severity(SeverityLevel.NORMAL)
    public void testCreateBooking() {
        // Code
    }
}

