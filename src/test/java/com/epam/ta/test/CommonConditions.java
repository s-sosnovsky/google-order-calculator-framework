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

    private final Logger logger = LogManager.getRootLogger();
    protected WebDriver driver;
    protected CalculatorPage calculatorPage;
    protected AllProductsPage allProductsPage;
    protected GoogleCloudHomePage googleCloudHomePage;
    protected SeePricingPage seePricingPage;
    protected TenMinutesEmailHomePage tenMinutesEmailHomePage;
    protected TenMinutesReadEmailPage readEmailPage;
    protected Order order = OrderCreator.withCredentialsFromProperty();

    public CalculatorPage createSimpleOrder(CalculatorPage calculatorPage) throws InterruptedException {
        order = OrderCreator.withCredentialsFromProperty();
        calculatorPage
                .switchToOrderIFrame()
                .setOrderCloudEngine(order.getCloudEngine())
                .setNumberOfInstances(order.getNumberOfInstances())
                .setOperationSystem(order.getOperationSystemType())
                .setVmClass(order.getVmClassType())
                .setInstanceType(order.getInstanceType())
                .selectAddGpuCheckbox()
                .setNumberOfGpu(order.getNumberOfGpu())
                .selectGpuType(order.getGpuType())
                .setLocalSsdType(order.getLocalSsdType())
                .setDatacenterLocation(order.getDatacenterLocation())
                .setCommitmentTerm(order.getCommitmentTerm())
                .clickAddToEstimateButton();
                logger.info("Simple order created");
        return calculatorPage;
    }

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
