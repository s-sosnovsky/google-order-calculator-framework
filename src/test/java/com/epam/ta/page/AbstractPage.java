package com.epam.ta.page;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.*;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import static java.util.concurrent.TimeUnit.SECONDS;

public abstract class AbstractPage {

    protected WebDriver driver;
    protected final int WAIT_TIMEOUT_SECONDS = 10;
    protected final int WAIT_LETTER_TIMEOUT_SECONDS = 120;
    protected ArrayList<String> tabs;
    protected Logger logger;

    public abstract AbstractPage open();

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
        logger = LogManager.getRootLogger();
        PageFactory.initElements(driver, this);
        jQueryAJAXCompleted();
    }

    public ExpectedCondition<Boolean> jQueryAJAXCompleted(){
        return new ExpectedCondition<Boolean>() {
            public Boolean apply(@NullableDecl WebDriver driver) {
                return (Boolean) ((JavascriptExecutor) driver).executeScript("return (window.jQuery != null)" +
                        " && (jQuery.active == 0);");
            }
        };
    }

    protected void scrollToElement(WebElement element){
        new Actions(driver).moveToElement(element).build().perform();
    }

    public void  createNewTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
    }

    public void switchToLastTab() {
        tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(tabs.size()-1));
    }

    public void  switchToFirstTab() {
        tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }

    public void highlightElement(WebElement element){
        String bg = element.getCssValue("backgroundColor");
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + "yellow" + "'", element);
        js.executeScript("arguments[0].style.backgroundColor = '" + bg + "'", element);
    }

}
