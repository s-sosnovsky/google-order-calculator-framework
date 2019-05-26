package com.epam.ta.test;


import com.epam.ta.page.googlecloud.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CreateNewInstanceOrderTest extends CommonConditions{

    @Test
    public void estimateSimpleInstanceOrderPricePerMonth()  {


        assertThat(calculatorPage.getVMClassText(), containsString(order.getVmClassType().toLowerCase()));

        assertThat(calculatorPage.getInstanceTypeText(), containsString(order.getInstanceType()));

        assertThat(calculatorPage.getLocalSsdCapacityText(), containsString(order.getLocalSsdType()));

        assertThat(calculatorPage.getCommitmentTermText(), containsString(order.getCommitmentTerm()));

        assertThat(calculatorPage.getDatacenterLocationText(), containsString(order.getDatacenterLocation()));

        assertThat(calculatorPage.getTotalCostText(), containsString(order.getTotalEstimatePrice()));

}
}