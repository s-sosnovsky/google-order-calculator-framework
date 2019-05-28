package com.epam.ta.test;

import com.epam.ta.driver.DriverManager;
import com.epam.ta.model.Order;
import com.epam.ta.page.googlecloud.AllProductsPage;
import com.epam.ta.page.googlecloud.CalculatorPage;
import com.epam.ta.page.googlecloud.GoogleCloudHomePage;
import com.epam.ta.page.googlecloud.SeePricingPage;
import com.epam.ta.page.tenminutesemail.TenMinutesEmailHomePage;
import com.epam.ta.page.tenminutesemail.TenMinutesReadEmailPage;
import com.epam.ta.service.OrderCreator;
import com.epam.ta.util.TestListener;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class CommonConditions {

    protected WebDriver driver;
    protected Order order;
    protected TenMinutesEmailHomePage tenMinutesEmailHomePage;
    protected TenMinutesReadEmailPage readEmailPage;
    protected GoogleCloudHomePage googleCloudHomePage;
    protected AllProductsPage allProductsPage;
    protected SeePricingPage seePricingPage;
    protected CalculatorPage calculatorPage;


    @BeforeClass
    public void setUpDriver(){
        driver = DriverManager.getDriver();
        order = OrderCreator.createComputeEngineOrder();
        googleCloudHomePage= new GoogleCloudHomePage(driver);
        googleCloudHomePage.open();
        allProductsPage = googleCloudHomePage.clickExploreNewProductsButton();
        seePricingPage = allProductsPage.clickSeePricingButton();
        calculatorPage = seePricingPage.clickCalculatorsButton();
        calculatorPage.createSimpleOrder(order);
    }

    @AfterClass(alwaysRun = true)
    public void tearDrop()
    {
        DriverManager.closeDriver();
    }
}
