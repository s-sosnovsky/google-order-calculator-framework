package com.epam.ta.test;


import com.epam.ta.page.googlecloud.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

public class CreateNewInstanceOrderTests extends CommonConditions{

    @Test
    public void checkDataCenterLocationConformity()  {
        assertThat(calculatorPage.getDatacenterLocationText(), containsString(order.getDatacenterLocation()));
        
}
    @Test
    public void checkInstanceTypeConformity(){
        assertThat(calculatorPage.getInstanceTypeText(), containsString(order.getInstanceType()));
    }
    
    @Test
    public void checkVMClassConformity(){
        assertThat(calculatorPage.getVMClassText(), containsString(order.getVmClassType().toLowerCase()));
    }

    @Test
    public void checkLocalSSDConformity(){
        assertThat(calculatorPage.getLocalSsdCapacityText(), containsString(order.getLocalSsdType()));
    }

    @Test
    public void checkCommitmentTermConformity(){
        assertThat(calculatorPage.getCommitmentTermText(), containsString(order.getCommitmentTerm()));
    }
    
    @Test
    public void checkTotalEstimationConformity(){
        assertThat(calculatorPage.getTotalCostText(), containsString(order.getTotalEstimatePrice()));
    }


}