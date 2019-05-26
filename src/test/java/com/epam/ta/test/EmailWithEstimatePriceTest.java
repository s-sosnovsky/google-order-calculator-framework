package com.epam.ta.test;

import com.epam.ta.page.googlecloud.CalculatorPage;
import com.epam.ta.page.tenminutesemail.TenMinutesEmailHomePage;
import com.epam.ta.service.OrderCreator;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class EmailWithEstimatePriceTest extends CommonConditions {

    private String totalEstimateFromGoogleCalculator;
    private String totalEstimateFromLetter;
    private String tenMinutesEmail;

    @Test()
    public void sendTotalEstimateEmailNotification() {

        totalEstimateFromGoogleCalculator = calculatorPage.getTotalCostText();

        String parentHandle = driver.getWindowHandle();
        tenMinutesEmailHomePage = new TenMinutesEmailHomePage(driver);
        //tenMinutesEmailHomePage.createNewTab();
        tenMinutesEmailHomePage.switchToSecondTab();
        tenMinutesEmailHomePage.open();
        tenMinutesEmail= tenMinutesEmailHomePage.getTenMinutesEmail();
        String emailHandle = driver.getWindowHandle();

        driver.switchTo().window(parentHandle);
        calculatorPage
                .clickEmailEstimateButton();
        calculatorPage
                .setTenMinutesEmail(tenMinutesEmail)
                .clickSendEmailAddressButton();
        driver.switchTo().window(emailHandle);
        readEmailPage = tenMinutesEmailHomePage.clickLetterInList();
        totalEstimateFromLetter = readEmailPage.getTotalEstimateFromLetter();

        assertThat(totalEstimateFromGoogleCalculator, containsString(totalEstimateFromLetter));

    }
}
