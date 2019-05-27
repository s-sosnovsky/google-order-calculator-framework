package com.epam.ta.model;

public class Order {

    private  String cloudEngine;
    private  Integer numberOfInstances;
    private  String operationSystemType;
    private  String vmClassType;
    private  String instanceType;
    private  String localSsdType;
    private  Integer numberOfGpu;
    private  String gpuType;
    private  String datacenterLocation;
    private  String commitmentTerm;
    private  String totalEstimatePrice;

    public Order(){}

    public Order( String cloudEngine, String numberOfInstances, String operationSystemType, String vmClassType,
                  String instanceType, String numberOfGpu, String gpuType, String localSsdType,
                  String datacenterLocation, String commitmentTerm, String totalEstimatePrice) {
        this.cloudEngine = cloudEngine;
        this.numberOfInstances = Integer.parseInt(numberOfInstances);
        this.operationSystemType = operationSystemType;
        this.vmClassType = vmClassType;
        this.instanceType = instanceType;
        this.localSsdType = localSsdType;
        this.numberOfGpu = Integer.parseInt(numberOfGpu);;
        this.gpuType = gpuType;
        this.datacenterLocation = datacenterLocation;
        this.commitmentTerm = commitmentTerm;
        this.totalEstimatePrice = totalEstimatePrice;
    }

    public String getCloudEngine() {
        return cloudEngine;
    }

    public String getNumberOfInstances() {
        return String.valueOf(numberOfInstances);
    }

    public String getOperationSystemType() {
        return operationSystemType;
    }

    public String getVmClassType() {
        return vmClassType;
    }

    public String getInstanceType() {
        return instanceType;
    }

    public String getLocalSsdType() {
        return localSsdType;
    }

    public String  getNumberOfGpu() {
        return String.valueOf(numberOfGpu);
    }

    public String getGpuType() {
        return gpuType;
    }

    public String getDatacenterLocation() {
        return datacenterLocation;
    }

    public String getCommitmentTerm() {
        return commitmentTerm;
    }

    public String getTotalEstimatePrice() {
        return totalEstimatePrice;
    }

    public void setCloudEngine(String cloudEngine) {
        this.cloudEngine = cloudEngine;
    }

    public void setNumberOfInstances(String numberOfInstances) {
        this.numberOfInstances = Integer.parseInt(numberOfInstances);
    }

    public void setOperationSystemType(String operationSystemType) {
        this.operationSystemType = operationSystemType;
    }

    public void setVmClassType(String vmClassType) {
        this.vmClassType = vmClassType;
    }

    public void setInstanceType(String instanceType) {
        this.instanceType = instanceType;
    }

    public void setLocalSsdType(String localSsdType) {
        this.localSsdType = localSsdType;
    }

    public void setNumberOfGpu(String numberOfGpu) {
        this.numberOfGpu = Integer.parseInt(numberOfGpu);
    }

    public void setGpuType(String gpuType) {
        this.gpuType = gpuType;
    }

    public void setDatacenterLocation(String datacenterLocation) {
        this.datacenterLocation = datacenterLocation;
    }

    public void setCommitmentTerm(String commitmentTerm) {
        this.commitmentTerm = commitmentTerm;
    }

    public void setTotalEstimatePrice(String totalEstimatePrice) {
        this.totalEstimatePrice = totalEstimatePrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order)) return false;
        Order order = (Order) o;
        if (!cloudEngine.equals(order.cloudEngine)) return false;
        if (!numberOfInstances.equals(order.numberOfInstances)) return false;
        if (!operationSystemType.equals(order.operationSystemType)) return false;
        if (!vmClassType.equals(order.vmClassType)) return false;
        if (!instanceType.equals(order.instanceType)) return false;
        if (!localSsdType.equals(order.localSsdType)) return false;
        if (!numberOfGpu.equals(order.numberOfGpu)) return false;
        if (!gpuType.equals(order.gpuType)) return false;
        if (!datacenterLocation.equals(order.datacenterLocation)) return false;
        if (!commitmentTerm.equals(order.commitmentTerm)) return false;
        return totalEstimatePrice.equals(order.totalEstimatePrice);
    }

    @Override
    public int hashCode() {
        int result = cloudEngine.hashCode();
        result = 31 * result + numberOfInstances.hashCode();
        result = 31 * result + operationSystemType.hashCode();
        result = 31 * result + vmClassType.hashCode();
        result = 31 * result + instanceType.hashCode();
        result = 31 * result + localSsdType.hashCode();
        result = 31 * result + numberOfGpu.hashCode();
        result = 31 * result + gpuType.hashCode();
        result = 31 * result + datacenterLocation.hashCode();
        result = 31 * result + commitmentTerm.hashCode();
        result = 31 * result + totalEstimatePrice.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Order{" +
                "cloudEngine='" + cloudEngine + '\'' +
                ", numberOfInstances='" + numberOfInstances + '\'' +
                ", operationSystemType='" + operationSystemType + '\'' +
                ", vmClassType='" + vmClassType + '\'' +
                ", instanceType='" + instanceType + '\'' +
                ", localSsdType='" + localSsdType + '\'' +
                ", numberOfGpu='" + numberOfGpu + '\'' +
                ", gpuType='" + gpuType + '\'' +
                ", datacenterLocation='" + datacenterLocation + '\'' +
                ", commitmentTerm='" + commitmentTerm + '\'' +
                ", totalEstimatePrice='" + totalEstimatePrice + '\'' +
                '}';
    }
}
