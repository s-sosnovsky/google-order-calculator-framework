package com.epam.ta.test;

import com.epam.ta.page.googlecloud.CalculatorPage;
import com.epam.ta.page.tenminutesemail.TenMinutesEmailHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.ta.model.Order;
import com.epam.ta.service.OrderCreator;


public class EmailWithEstimatePriceTest extends CommonConditions {

    @Test
    public void sendTotalEstimateEmailNotification() throws InterruptedException {
        order = OrderCreator.createComputeEngineOrder();
        TenMinutesEmailHomePage tenMinutesEmailHomePage = new TenMinutesEmailHomePage(driver);
        tenMinutesEmailHomePage.open();
        String tenMinutesEmail = tenMinutesEmailHomePage.getTenMinutesEmail();
        tenMinutesEmailHomePage.switchToSecondTab();
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage
                .open()
                .createSimpleOrder(order);
        String totalEstimateFromGoogleCalculator = calculatorPage.getTotalCostText();
        calculatorPage.clickEmailEstimateButton()
                .setTenMinutesEmail(tenMinutesEmail)
                .clickSendEmailAddressButton();
        calculatorPage.switchToFirstTab();
        TenMinutesReadEmailPage readEmailPage = tenMinutesEmailHomePage.clickLetterInList();
        String totalEstimateFromLetter = readEmailPage.getTotalEstimateFromLetter();

        Assert.assertTrue(totalEstimateFromGoogleCalculator.contains(totalEstimateFromLetter),
                "Total estimate values in the letter and in the googlecloud calculator do not match");
    }
}
