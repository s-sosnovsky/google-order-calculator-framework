package com.epam.ta.test;

import com.epam.ta.page.googlecloud.CalculatorPage;
import com.epam.ta.page.tenminutesemail.TenMinutesEmailHomePage;
import com.epam.ta.page.tenminutesemail.TenMinutesReadEmailPage;
import org.testng.annotations.Test;
import com.epam.ta.service.OrderCreator;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;


public class EmailWithEstimatePriceTest extends CommonConditions {

    @Test()
    public void sendTotalEstimateEmailNotification() throws InterruptedException {
        calculatorPage.createNewTab();
        calculatorPage.switchToSecondTab();
        tenMinutesEmailHomePage = new TenMinutesEmailHomePage(driver);
        tenMinutesEmailHomePage.open();
        String tenMinutesEmail = tenMinutesEmailHomePage.getTenMinutesEmail();
        tenMinutesEmailHomePage.switchToFirstTab();
        String totalEstimateFromGoogleCalculator = calculatorPage.getTotalCostText();
        calculatorPage.clickEmailEstimateButton()
                .setTenMinutesEmail(tenMinutesEmail)
                .clickSendEmailAddressButton();
        calculatorPage.switchToSecondTab();
        readEmailPage = tenMinutesEmailHomePage.clickLetterInList();
        String totalEstimateFromLetter = readEmailPage.getTotalEstimateFromLetter();

        assertThat(totalEstimateFromGoogleCalculator, containsString(totalEstimateFromLetter));

    }
}
