package com.epam.ta.page.googlecloud;

import com.epam.ta.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AllProductsPage extends AbstractPage {

    private final static String PAGE_URL = "https://cloud.google.com/products/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy (xpath = "//div[@class='cloud-button__set']/a[2]")
    private WebElement seePricingButton;

    @Override
    public AllProductsPage open() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public AllProductsPage(WebDriver driver){
        super(driver);
    }

    public SeePricingPage clickSeePricingButton(){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.
                visibilityOf(seePricingButton)).click();
        logger.info("Trying to open see pricing page");
        return new SeePricingPage(driver);
    }
}
