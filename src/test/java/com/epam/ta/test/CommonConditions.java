package com.epam.ta.test;

import com.epam.ta.driver.DriverSingleton;
import com.epam.ta.model.Order;
import com.epam.ta.page.googlecloud.AllProductsPage;
import com.epam.ta.page.googlecloud.CalculatorPage;
import com.epam.ta.page.googlecloud.GoogleCloudHomePage;
import com.epam.ta.page.googlecloud.SeePricingPage;
import com.epam.ta.page.tenminutesemail.TenMinutesEmailHomePage;
import com.epam.ta.page.tenminutesemail.TenMinutesReadEmailPage;
import com.epam.ta.service.OrderCreator;
import com.epam.ta.util.TestListener;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    protected Order order;

    @BeforeMethod()
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
