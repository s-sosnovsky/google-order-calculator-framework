package com.epam.ta.service;

import com.epam.ta.model.Order;

public class OrderCreator {

    public static final String TESTDATA_ORDER_ENGINE_TYPE = "testdata.order.engineType";
    public static final String TESTDATA_ORDER_NUMBER_OF_INSTANCES = "testdata.order.number";
    public static final String TESTDATA_ORDER_OPERATING_SYSTEM = "testdata.order.operatingSystem";
    public static final String TESTDATA_ORDER_VM_CLASS = "testdata.order.VMClass";
    public static final String TESTDATA_ORDER_INSTANCE_TYPE = "testdata.order.instanceType";
    public static final String TESTDATA_ORDER_NUMBER_OF_GPU = "testdata.order.numberOfGPUs";
    public static final String TESTDATA_ORDER_GPU_TYPE = "testdata.order.GPUType";
    public static final String TESTDATA_ORDER_LOCAL_SSD = "testdata.order.localSSD";
    public static final String TESTDATA_ORDER_LOCATION = "testdata.order.dataCenterLocation";
    public static final String TESTDATA_ORDER_COMMITTED_TERM = "testdata.order.committedUsage";
    public static final String TESTDATA_ORDER_TOTAL_ESTIMATED_PRICE = "testdata.order.totalEstimatedPrice";


    public static Order createComputeEngineOrder(){
        return new Order(
                TestDataReader.getTestData(TESTDATA_ORDER_ENGINE_TYPE),
                TestDataReader.getTestData(TESTDATA_ORDER_NUMBER_OF_INSTANCES),
                TestDataReader.getTestData(TESTDATA_ORDER_OPERATING_SYSTEM),
                TestDataReader.getTestData(TESTDATA_ORDER_VM_CLASS),
                TestDataReader.getTestData(TESTDATA_ORDER_INSTANCE_TYPE),
                TestDataReader.getTestData(TESTDATA_ORDER_NUMBER_OF_GPU),
                TestDataReader.getTestData(TESTDATA_ORDER_GPU_TYPE),
                TestDataReader.getTestData(TESTDATA_ORDER_LOCAL_SSD),
                TestDataReader.getTestData(TESTDATA_ORDER_LOCATION),
                TestDataReader.getTestData(TESTDATA_ORDER_COMMITTED_TERM),
                TestDataReader.getTestData(TESTDATA_ORDER_TOTAL_ESTIMATED_PRICE)
        );
    }
}
