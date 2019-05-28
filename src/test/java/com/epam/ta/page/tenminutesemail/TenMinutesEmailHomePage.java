package com.epam.ta.page.tenminutesemail;

import com.epam.ta.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class TenMinutesEmailHomePage extends AbstractPage {

    private final static String PAGE_URL = "https://10minutemail.net/";


    @FindBy (xpath = "//input[@id = 'fe_text']")
    private  WebElement tenMinutesEmailInput;

    @FindBy(xpath = "//a[text() = 'Google Cloud Platform Price Estimate']")
    private WebElement googlEmailLink;

    public TenMinutesEmailHomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public TenMinutesEmailHomePage open() {
        driver.navigate().to(PAGE_URL);
        logger.info("Ten minutes email page opened: " + PAGE_URL);
        return this;
    }

    public String getTenMinutesEmail(){
        String email = new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(tenMinutesEmailInput))
                .getAttribute("value");
        logger.info("Email generated: " + email);
        return email;
    }

    public TenMinutesReadEmailPage clickLetterInList() {
        new WebDriverWait(driver, WAIT_LETTER_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(googlEmailLink))
                .click();
        logger.info("TenMinutesReadEmailPage opened");
        return new TenMinutesReadEmailPage(driver);
    }
}
