package com.epam.ta.test;

import com.epam.ta.page.googlecloud.CalculatorPage;
import com.epam.ta.page.tenminutesemail.TenMinutesEmailHomePage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class EmailWithEstimatePriceTest extends CommonConditions {

    @Test
    public void sendTotalEstimateEmailNotification() throws InterruptedException {

        TenMinutesEmailHomePage tenMinutesEmailHomePage = new TenMinutesEmailHomePage(driver);
        tenMinutesEmailHomePage.open();
        String tenMinutesEmail = tenMinutesEmailHomePage.getTenMinutesEmail();
        tenMinutesEmailHomePage.switchToSecondTab();
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.open();
        Order order = OrderCreator.withCredentialsFromProperty();
        calculatorPage
                .switchToOrderIFrame()
                .setOrderCloudEngine(order.getCloudEngine())
                .setNumberOfInstances(order.getNumberOfInstances())
                .setOperationSystem(order.getOperationSystemType())
                .setVmClass(order.getVmClassType())
                .setInstanceType(order.getInstanceType())
                .selectAddGpuCheckbox()
                .setNumberOfGpu(order.getNumberOfGpu())
                .selectGpuType(order.getGpuType())
                .setLocalSsdType(order.getLocalSsdType())
                .setDatacenterLocation(order.getDatacenterLocation())
                .setCommitmentTerm(order.getCommitmentTerm())
                .clickAddToEstimateButton();     

        String totalEstimateFromGoogleCalculator = calculatorPage.getTotalCostText();
        calculatorPage.clickEmailEstimateButton()
                .setTenMinutesEmail(tenMinutesEmail)
                .clickSendEmailAddressButton();
        calculatorPage.switchToFirstTab();
        readEmailPage = tenMinutesEmailHomePage.clickLetterInList();
        String totalEstimateFromLetter = readEmailPage.getTotalEstimateFromLetter();

        Assert.assertTrue(totalEstimateFromGoogleCalculator.contains(totalEstimateFromLetter),
                "Total estimate values in the letter and in the googlecloud calculator do not match");
    }
}
