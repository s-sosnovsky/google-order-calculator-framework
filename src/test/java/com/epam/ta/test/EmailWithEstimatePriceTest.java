package com.epam.ta.test;

import com.epam.ta.page.googlecloud.CalculatorPage;
import com.epam.ta.page.tenminutesemail.TenMinutesEmailHomePage;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class EmailWithEstimatePriceTest extends CommonConditions {

    private String totalEstimateFromGoogleCalculator;
    private String totalEstimateFromLetter;
    private String tenMinutesEmail;

    @Test()
    public void sendTotalEstimateEmailNotification() throws InterruptedException {
        calculatorPage.clickEmailEstimateButton();
        //calculatorPage.createNewTab();
        calculatorPage.switchToSecondTab();
        tenMinutesEmailHomePage = new TenMinutesEmailHomePage(driver);
        tenMinutesEmailHomePage.open();
        tenMinutesEmail= tenMinutesEmailHomePage.getTenMinutesEmail();
        tenMinutesEmailHomePage.switchToFirstTab();
        Thread.sleep(5000);
        totalEstimateFromGoogleCalculator = calculatorPage.getTotalCostText();
        calculatorPage
                .setTenMinutesEmail(tenMinutesEmail)
                .clickSendEmailAddressButton();
        calculatorPage.switchToSecondTab();
        readEmailPage = tenMinutesEmailHomePage.clickLetterInList();
        totalEstimateFromLetter = readEmailPage.getTotalEstimateFromLetter();

        assertThat(totalEstimateFromGoogleCalculator, containsString(totalEstimateFromLetter));

    }
}
