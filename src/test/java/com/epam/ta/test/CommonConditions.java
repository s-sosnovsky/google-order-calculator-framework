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
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    protected Order order;
    protected CalculatorPage calculatorPage;
    protected TenMinutesEmailHomePage tenMinutesEmailHomePage;
    protected String tenMinutesEmail;

    @BeforeClass
    public void setUp()
    {
        driver = DriverSingleton.getDriver();
    }

    @BeforeMethod(groups = {"g1"})
    public void setCreateOrderTest()
    {
        order = OrderCreator.createComputeEngineOrder();
        calculatorPage = new CalculatorPage(driver);
        calculatorPage.open();
        calculatorPage.createSimpleOrder(order);
    }

    @BeforeMethod(groups = {"g2"})
    public void setEmailTest()
    {
        order = OrderCreator.createComputeEngineOrder();
        tenMinutesEmailHomePage = new TenMinutesEmailHomePage(driver);
        tenMinutesEmailHomePage.open();
        tenMinutesEmail = tenMinutesEmailHomePage.getTenMinutesEmail();
        tenMinutesEmailHomePage.switchToSecondTab();
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage
                .open()
                .createSimpleOrder(order);
    }

    @AfterClass(alwaysRun = true)
    public void stopBrowser()
    {
        DriverSingleton.closeDriver();
    }
}
