package com.epam.ta.page;

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
    public abstract AbstractPage open();

    protected AbstractPage(WebDriver driver){
        this.driver = driver;
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
        Actions actionMove = new Actions(driver);
        actionMove.moveToElement(element).build().perform();
    }

    public void  createNewTab() {
        ((JavascriptExecutor)driver).executeScript("window.open()");
    }

    public void  switchToSecondTab() {
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public void  switchToFirstTab() {
        ArrayList<String> tabs = new ArrayList(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(0));
    }
}
