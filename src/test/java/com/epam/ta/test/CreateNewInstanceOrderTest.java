package com.epam.ta.test;


import com.epam.ta.page.googlecloud.CalculatorPage;
import com.epam.ta.page.googlecloud.GoogleCloudHomePage;
import com.epam.ta.service.OrderCreator;
import org.apache.commons.codec.language.Soundex;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.epam.ta.model.Order;
import com.epam.ta.service.OrderCreator;

public class CreateNewInstanceOrderTest extends CommonConditions{

    @Test(groups = {"g1"})
    public void estimateSimpleInstanceOrderPricePerMonth()  {
//        order = OrderCreator.createComputeEngineOrder();
//        CalculatorPage calculatorPage = new CalculatorPage(driver);
//        calculatorPage.open();
//        calculatorPage.createSimpleOrder(order);

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
