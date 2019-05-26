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
    private final Logger logger = LogManager.getRootLogger();
    private ArrayList<String> windowHandles;
    private String tabMinutemail;
    private String tabGoogle;

    public TenMinutesEmailHomePage(WebDriver driver) {
        super(driver);
    }

    @FindBy (xpath = "//input[@id = 'fe_text']")
    private  WebElement tenMinutesEmailInput;

    @FindBy(xpath = "//a[text() = 'Google Cloud Platform Price Estimate']")
    private WebElement googlEmailLink;

    @Override
    public TenMinutesEmailHomePage open() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public void openInNewTab() {
        ((JavascriptExecutor) driver).executeScript("window.open('https://10minutemail.net/')");
        logger.info("https://10minutemail.net opened");
//        windowHandles = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(windowHandles.get(1));
    }

    public void moveToParentPage() {
        tabGoogle = windowHandles.get(0);
        driver.switchTo().window(tabGoogle);
        logger.info("Switched to first tab");
    }


    public String getTenMinutesEmail(){
        String email = new WebDriverWait(driver,10).until(ExpectedConditions.visibilityOf(tenMinutesEmailInput))
                .getAttribute("value");
        logger.info("Email generated: " + email);
        return email;
    }

    public TenMinutesReadEmailPage clickLetterInList() {
        scrollToElement(googlEmailLink);
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS*6).until(ExpectedConditions.visibilityOf(googlEmailLink))
                .click();
        logger.info("TenMinutesReadEmailPage opened");
        return new TenMinutesReadEmailPage(driver);
    }

    public void  createNewTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
    }

    public void  switchToSecondTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
        tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void  switchToFirstTab() {

        driver.switchTo().window(tabs.get(0));
    }
}
