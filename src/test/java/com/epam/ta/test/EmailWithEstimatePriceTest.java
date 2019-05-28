package com.epam.ta.test;

import com.epam.ta.page.tenminutesemail.TenMinutesEmailHomePage;
import org.testng.annotations.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class EmailWithEstimatePriceTest extends CommonConditions {

    private String totalEstimateFromGoogleCalculator;
    private String totalEstimateFromLetter;
    private String tenMinutesEmail;

    @Test
    public void sendTotalEstimateEmailNotification() {
        totalEstimateFromGoogleCalculator = calculatorPage.getTotalCostText();
        tenMinutesEmailHomePage = new TenMinutesEmailHomePage(driver);
        tenMinutesEmailHomePage.createNewTab();
        tenMinutesEmailHomePage.switchToLastTab();
        tenMinutesEmailHomePage.open();
        tenMinutesEmail= tenMinutesEmailHomePage.getTenMinutesEmail();
        tenMinutesEmailHomePage.switchToFirstTab();
        calculatorPage.switchToOrderIFrame()
                .clickEmailEstimateButton()
                .setTenMinutesEmail(tenMinutesEmail)
                .clickSendEmailAddressButton();
        calculatorPage.switchToLastTab();
        readEmailPage = tenMinutesEmailHomePage.clickLetterInList();
        totalEstimateFromLetter = readEmailPage.getTotalEstimateFromLetter();
        assertThat(totalEstimateFromGoogleCalculator, containsString(totalEstimateFromLetter));
    }
}
