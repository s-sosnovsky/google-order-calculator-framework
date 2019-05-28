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
    protected CalculatorPage calculatorPage;
    protected TenMinutesEmailHomePage tenMinutesEmailHomePage;
    protected TenMinutesReadEmailPage readEmailPage;

    @BeforeClass
    public void setUpDriver(){
        driver = DriverManager.getDriver();
        order = OrderCreator.createComputeEngineOrder();
        GoogleCloudHomePage googleCloudHomePage= new GoogleCloudHomePage(driver);
        googleCloudHomePage.open();
        AllProductsPage allProductsPage = googleCloudHomePage.clickExploreNewProductsButton();
        SeePricingPage seePricingPage = allProductsPage.clickSeePricingButton();
        calculatorPage = seePricingPage.clickCalculatorsButton();
        //calculatorPage = new CalculatorPage(driver);
        //calculatorPage.open();
        calculatorPage.createSimpleOrder(order);
    }

    @AfterClass(alwaysRun = true)
    public void tearDrop()
    {
        DriverManager.closeDriver();
    }
}
