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


public class SeePricingPage extends AbstractPage {

    private final static String PAGE_URL = "https://cloud.google.com/pricing/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(xpath = "//a[@track-name='pricingNav/calculators']")
    private WebElement calculatorsButton;

    public SeePricingPage(WebDriver driver){
        super(driver);
    }

    @Override
    public AbstractPage open() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public CalculatorPage clickCaltulatorsButton(){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(calculatorsButton)).click();
        logger.info("Calculator page opened");
        return new CalculatorPage(driver);
    }
}
