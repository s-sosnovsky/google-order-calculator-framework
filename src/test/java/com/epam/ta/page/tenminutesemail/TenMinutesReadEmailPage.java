package com.epam.ta.page.tenminutesemail;

import com.epam.ta.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class TenMinutesReadEmailPage extends AbstractPage {

    @FindBy(xpath = "//table[@class='quote']//td[4]")
    private WebElement infoInLetter;

    public TenMinutesReadEmailPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public AbstractPage open() {
        return null;
    }

    public String getTotalEstimateFromLetter(){
        String totalEsrimateFromLetter = new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS)
                .until(ExpectedConditions.visibilityOf(infoInLetter))
                .getText();
        logger.info("Letter received and opened with price: " + totalEsrimateFromLetter);
        return totalEsrimateFromLetter;
    }
}

