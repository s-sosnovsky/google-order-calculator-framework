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
    public void sendTotalEstimateEmailNotification() {

        totalEstimateFromGoogleCalculator = calculatorPage.getTotalCostText();
        tenMinutesEmailHomePage = new TenMinutesEmailHomePage(driver);
        calculatorPage
                .clickEmailEstimateButton();
        tenMinutesEmailHomePage.openInNewTab();
        tenMinutesEmail= tenMinutesEmailHomePage.getTenMinutesEmail();
        tenMinutesEmailHomePage.moveToParentPage();
        calculatorPage
                .setTenMinutesEmail(tenMinutesEmail)
                .clickSendEmailAddressButton();
        readEmailPage = tenMinutesEmailHomePage.clickLetterInList();
        totalEstimateFromLetter = readEmailPage.getTotalEstimateFromLetter();

        assertThat(totalEstimateFromGoogleCalculator, containsString(totalEstimateFromLetter));

    }
}
