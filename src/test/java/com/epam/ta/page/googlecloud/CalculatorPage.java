package com.epam.ta.page.googlecloud;

import com.epam.ta.page.AbstractPage;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.epam.ta.model.Order;
import com.epam.ta.service.OrderCreator;

import java.util.List;

public class CalculatorPage extends AbstractPage {

    private final static String PAGE_URL="https://cloud.google.com/products/calculator/";
    private final Logger logger = LogManager.getRootLogger();

    @FindBy(id = "idIframe")
    private WebElement orderFormIframe;

    @FindBy(xpath = "//input[@id='input_51']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//md-select[@id='select_63']")
    private WebElement operationSystemTypeDropDown;

    @FindBy(xpath = "//div[@id='select_container_64']/md-select-menu/md-content/md-option")
    private List<WebElement> operationSystemOptionsList;

    @FindBy (xpath = "//md-select[@id='select_67']")
    private WebElement vmClassDropDown;

    @FindBy(xpath = "//div[@id='select_container_68']/md-select-menu/md-content/md-option")
    private List<WebElement> vmClassOptionsList;

    @FindBy(xpath = "//div[@ng-class='{estimated: listingCtrl.CartData[tab.estimatedLabel]}']")
    private List<WebElement> sectionsEnginesList;

    @FindBy (xpath ="//md-select[@id='select_74']")
    private WebElement instanceTypeDropDown;

    @FindBy(xpath = "//md-optgroup[@label='standard']/md-option")
    private List<WebElement> instanceTypeOptionsList;

    @FindBy(xpath = "//md-checkbox[contains(@ng-model,'addGPUs')]")
    private WebElement addGpuCheckbox;

    @FindBy(xpath = "//md-select[@id='select_335']")
    private WebElement numberOfGpuDropDown;

    @FindBy(xpath = "//div[@id='select_container_336']/md-select-menu/md-content/md-option")
    private List<WebElement> numberOfGpuOptionsList;

    @FindBy(xpath = "//md-select[@id='select_337']")
    private WebElement gpuTypeDropDown;

    @FindBy(xpath = "//div[@id='select_container_338']/md-select-menu/md-content/md-option")
    private List<WebElement> gpuTypeOptionsList;

    @FindBy(xpath = "//md-select[@id='select_76']")
    private WebElement localSsdTypeDropDown;

    @FindBy(xpath = "//div[@id='select_container_77']/md-select-menu/md-content/md-option")
    private List<WebElement> localSsdOptionsList;

    @FindBy(xpath = "//md-select[@id='select_78']")
    private WebElement datacenterLocationDropDown;

    @FindBy(xpath = "//div[@id='select_container_79']/md-select-menu/md-content/md-option")
    private List<WebElement> datacenterLocationOptionsList;

    @FindBy(xpath = "//md-select[@id='select_83']")
    private WebElement committmentUsageDropDown;

    @FindBy(xpath = "//div[@id='select_container_84']/md-select-menu/md-content/md-option")
    private List<WebElement> commitmentUsageOptionsList;

    @FindBy(xpath = "//button[@aria-label='Add to Estimate'][1]")
    private WebElement addToEstimateButton;

    @FindBy (xpath = "//div[contains(text(),'VM class')]")
    private WebElement vmClassText;

    @FindBy (xpath ="//div[contains(text(),'Instance type:')]")
    private WebElement instanceTypeText;

    @FindBy (xpath = "//div[contains(text(),'Total available local SSD space')]")
    private WebElement localSsdCapacityText;

    @FindBy (xpath = "//div[contains(text(),'Commitment term:')]")
    private WebElement commitmentTermText;

    @FindBy (xpath = "//div[contains(text(), 'Region:')]")
    private WebElement fatacenterLocationText;

    @FindBy (xpath = "//b[contains(text(),'Total Estimated Cost')]")
    private WebElement totalEstimateValue;

    @FindBy (xpath = "//button[@id = 'email_quote']")
    private WebElement emailEstimateButton;

    @FindBy (xpath = "//form[@name = 'emailForm']/descendant::input[@type ='email']")
    WebElement emailValueField;

    @FindBy (xpath = "//button[@aria-label='Send Email']")
    WebElement sendEmailButton;
    
    @Override
    public CalculatorPage open() {
        driver.navigate().to(PAGE_URL);
        return this;
    }

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    public CalculatorPage switchToOrderIFrame() {
        (new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS)).until(ExpectedConditions.visibilityOf(orderFormIframe));
        driver.switchTo().frame(orderFormIframe);
        return this;
    }

    public CalculatorPage setOrderCloudEngine(String engineName) {
        for (WebElement engine : sectionsEnginesList) {
            if (engine.getText().equals(engineName.toUpperCase())) {
                engine.click();
                break;
            }
        }
        return this;
    }

    public CalculatorPage setNumberOfInstances(String number){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(numberOfInstances)).click();
        numberOfInstances.sendKeys(number);
        return this;
    }

    public CalculatorPage setOperationSystem(String operationSystemValue){
        dropDownWaitForElementAndChooseOptionText(operationSystemTypeDropDown, operationSystemOptionsList, operationSystemValue);
        return this;
    }

    public CalculatorPage setVmClass(String vmClassValue){
        dropDownWaitForElementAndChooseOptionText(vmClassDropDown, vmClassOptionsList, vmClassValue);
        return this;
    }

     public CalculatorPage setInstanceType(String instanceTypeValue) throws InterruptedException {
        scrollToElement(instanceTypeDropDown);
        dropDownWaitForElementAndChooseOptionText(instanceTypeDropDown, instanceTypeOptionsList, instanceTypeValue);
        return this;
    }

    public CalculatorPage selectAddGpuCheckbox() throws InterruptedException {
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(addGpuCheckbox)).click();
        return this;
    }

    public CalculatorPage setNumberOfGpu(String numberOfGpuValue){
        dropDownWaitForElementAndChooseOptionText(numberOfGpuDropDown, numberOfGpuOptionsList, numberOfGpuValue);
        return this;
    }

    public CalculatorPage selectGpuType(String gpuTypeValue){
        dropDownWaitForElementAndChooseOptionText(gpuTypeDropDown, gpuTypeOptionsList, gpuTypeValue);
        return this;
    }

    public CalculatorPage setLocalSsdType(String ssdValue)  {
        scrollToElement(localSsdTypeDropDown);
        dropDownWaitForElementAndChooseOptionText(localSsdTypeDropDown, localSsdOptionsList, ssdValue);
        return this;
    }

    public CalculatorPage setDatacenterLocation(String locationValue) {
        dropDownWaitForElementAndChooseOptionText(datacenterLocationDropDown, datacenterLocationOptionsList, locationValue);
        return this;
    }

    public CalculatorPage setCommitmentTerm(String committedUsageValue){
        dropDownWaitForElementAndChooseOptionText(committmentUsageDropDown, commitmentUsageOptionsList,committedUsageValue);
        return this;
    }

    public CalculatorPage clickAddToEstimateButton() throws InterruptedException {

        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(addToEstimateButton));
        addToEstimateButton.click();
        logger.info("Order sent for estimation price");
        return this;
    }

    public CalculatorPage clickEmailEstimateButton()  {
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(emailEstimateButton))
                .click();

        logger.info("Opened email estimation pop-up");
        return this;
    }

    private void dropDownWaitForElementAndChooseOptionText(WebElement dropDown, List<WebElement> dropDownOptions, String text){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(dropDown)).click();
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOfAllElements(dropDownOptions));
        for (WebElement option : dropDownOptions) {
            if (option.getText().contains(text)) {
                option.click();
                 break;
            }
        }
    }

    public String getVMClassText(){
        return vmClassText.getText();
    }

    public String getInstanceTypeText(){
        return new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(instanceTypeText))
                .getText();
    }

    public String getLocalSsdCapacityText(){
        return new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(localSsdCapacityText))
                .getText();
    }

    public String getCommitmentTermText(){
        return new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(commitmentTermText))
                .getText();
    }

    public String getDatacenterLocationText(){
        return new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(fatacenterLocationText))
                .getText();
    }

    public String getTotalCostText(){
        return new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(totalEstimateValue))
                .getText();
    }

  public CalculatorPage setTenMinutesEmail(String email) throws InterruptedException {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.elementToBeClickable(emailValueField));
        emailValueField.sendKeys(email);
        logger.info("Set 10 minutes email: " + email);
        return this;
    }

    public void clickSendEmailAddressButton() throws InterruptedException {
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS*2).until(ExpectedConditions.elementToBeClickable(sendEmailButton));
        sendEmailButton.click();
        logger.info("Email with estimated price sent");
    }
    public void createSimpleOrder(Order order) throws InterruptedException {

                switchToOrderIFrame();
                setOrderCloudEngine(order.getCloudEngine());
                setNumberOfInstances(order.getNumberOfInstances());
                setOperationSystem(order.getOperationSystemType());
                setVmClass(order.getVmClassType());
                setInstanceType(order.getInstanceType());
                selectAddGpuCheckbox();
                setNumberOfGpu(order.getNumberOfGpu());
                selectGpuType(order.getGpuType());
                setLocalSsdType(order.getLocalSsdType());
                setDatacenterLocation(order.getDatacenterLocation());
                setCommitmentTerm(order.getCommitmentTerm());
                clickAddToEstimateButton();
        logger.info("Simple order created and sent for estimation");
    }
}

