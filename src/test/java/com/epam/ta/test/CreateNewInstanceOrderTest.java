package com.epam.ta.test;


import com.epam.ta.page.googlecloud.CalculatorPage;
import com.epam.ta.page.googlecloud.GoogleCloudHomePage;
import com.epam.ta.service.OrderCreator;
import org.apache.commons.codec.language.Soundex;
import org.testng.Assert;
import org.testng.annotations.Test;


public class CreateNewInstanceOrderTest extends CommonConditions{

    @Test
    public void estimateSimpleInstanceOrderPricePerMonth() throws InterruptedException {
        order = OrderCreator.withCredentialsFromProperty();
        CalculatorPage calculatorPage = new CalculatorPage(driver);
        calculatorPage.open();
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

        Assert.assertTrue(calculatorPage.getVMClassText().
                        contains(order.getVmClassType()
                                .toLowerCase()),
                "VM class values do not match");
        Assert.assertTrue(calculatorPage.getInstanceTypeText()
                        .contains(order.getInstanceType()),
                "Instance Type values do not match");
        Assert.assertTrue(
                calculatorPage.getLocalSsdCapacityText()
                        .contains(order.getLocalSsdType()),
                "Local SSD values do not match");
        Assert.assertTrue(
                calculatorPage.getCommitmentTermText()
                        .contains(order.getCommitmentTerm()),
                "Commitment Term values do not match");
        Assert.assertTrue(calculatorPage.getDatacenterLocationText()
                        .contains(order.getDatacenterLocation()),
                "Region values do not match");
        Assert.assertTrue(calculatorPage.
                        getTotalCostText().
                        contains(order.getTotalEstimatePrice()),
                "Total estimate values do not match");
}
}
