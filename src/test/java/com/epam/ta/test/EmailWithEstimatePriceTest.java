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
        tenMinutesEmailHomePage = new TenMinutesEmailHomePage(driver);
        totalEstimateFromGoogleCalculator = calculatorPage.getTotalCostText();
        calculatorPage
                .clickEmailEstimateButton();
        String googleTab = driver.getWindowHandle();
        tenMinutesEmailHomePage.createNewTab();
        tenMinutesEmailHomePage.switchToSecondTab();
        tenMinutesEmailHomePage.open();
        tenMinutesEmail= tenMinutesEmailHomePage.getTenMinutesEmail();
        driver.switchTo().window(googleTab);
        calculatorPage
                .setTenMinutesEmail(tenMinutesEmail)
                .clickSendEmailAddressButton();
        readEmailPage = tenMinutesEmailHomePage.clickLetterInList();
        totalEstimateFromLetter = readEmailPage.getTotalEstimateFromLetter();

        assertThat(totalEstimateFromGoogleCalculator, containsString(totalEstimateFromLetter));

    }
}
