package com.epam.ta.page.googlecloud;

import com.epam.ta.model.Order;
import com.epam.ta.page.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class CalculatorPage extends AbstractPage {

    private final static String PAGE_URL="https://cloud.google.com/products/calculator/";

    @FindBy(id = "idIframe")
    private WebElement orderFormIframe;

    @FindBy(xpath = "//div[@ng-class='{estimated: listingCtrl.CartData[tab.estimatedLabel]}']")
    private List<WebElement> sectionsEnginesList;

    @FindBy(xpath = "//input[@id='input_52']")
    private WebElement numberOfInstances;

    @FindBy(xpath = "//md-select[@id='select_64']")
    private WebElement operationSystemTypeDropDown;

    @FindBy(xpath = "//div[@id='select_container_65']/md-select-menu/md-content/md-option")
    private List<WebElement> operationSystemOptionsList;

    @FindBy (xpath = "//md-select[@id='select_68']")
    private WebElement vmClassDropDown;

    @FindBy(xpath = "//div[@id='select_container_69']/md-select-menu/md-content/md-option")
    private List<WebElement> vmClassOptionsList;

    @FindBy (xpath ="//md-select[@id='select_75']")
    private WebElement instanceTypeDropDown;

    @FindBy(xpath = "//md-optgroup[@label='standard']/md-option")
    private List<WebElement> instanceTypeOptionsList;

    @FindBy(xpath = "//md-checkbox[contains(@ng-model,'addGPUs')]")
    private WebElement addGpuCheckbox;

    @FindBy(xpath = "//md-select[@id='select_336']")
    private WebElement numberOfGpuDropDown;

    @FindBy(xpath = "//div[@id='select_container_337']/md-select-menu/md-content/md-option")
    private List<WebElement> numberOfGpuOptionsList;

    @FindBy(xpath = "//md-select[@id='select_338']")
    private WebElement gpuTypeDropDown;

    @FindBy(xpath = "//div[@id='select_container_339']/md-select-menu/md-content/md-option")
    private List<WebElement> gpuTypeOptionsList;

    @FindBy(xpath = "//md-select[@id='select_77']")
    private WebElement localSsdTypeDropDown;

    @FindBy(xpath = "//div[@id='select_container_78']/md-select-menu/md-content/md-option")
    private List<WebElement> localSsdOptionsList;

    @FindBy(xpath = "//md-select[@id='select_79']")
    private WebElement datacenterLocationDropDown;

    @FindBy(xpath = "//div[@id='select_container_80']/md-select-menu/md-content/md-option")
    private List<WebElement> datacenterLocationOptionsList;

    @FindBy(xpath = "//md-select[@id='select_84']")
    private WebElement committmentUsageDropDown;

    @FindBy(xpath = "//div[@id='select_container_85']/md-select-menu/md-content/md-option")
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
    private WebElement datacenterLocationText;

    @FindBy (xpath = "//b[contains(text(),'Total Estimated Cost')]")
    private WebElement totalEstimateValue;

    @FindBy (xpath = "//button[@id = 'email_quote']")
    private WebElement emailEstimateButton;

    @FindBy (xpath = "//form[@name = 'emailForm']/descendant::input[@type ='email']")
    private WebElement emailValueField;

    @FindBy (xpath = "//button[@aria-label='Send Email']")
    private WebElement sendEmailButton;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public CalculatorPage open() {
        logger.info("Calculators page opened: " + PAGE_URL);
        driver.navigate().to(PAGE_URL);
        return this;
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

     public CalculatorPage setInstanceType(String instanceTypeValue){
        dropDownWaitForElementAndChooseOptionText(instanceTypeDropDown, instanceTypeOptionsList, instanceTypeValue);
        return this;
    }

    public CalculatorPage selectAddGpuCheckbox(){
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

    public CalculatorPage clickAddToEstimateButton(){
        new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(addToEstimateButton));
        addToEstimateButton.click();
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
                highlightElement(option);
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
        return new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(datacenterLocationText))
                .getText();
    }

    public String getTotalCostText(){
        return new WebDriverWait(driver,WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(totalEstimateValue))
                .getText();
    }

    public CalculatorPage setTenMinutesEmail(String email){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(emailValueField));
        emailValueField.clear();
        emailValueField.click();
        emailValueField.sendKeys(email);
        logger.info("Set 10 minutes email: " + email);
        return this;
    }

    public CalculatorPage clickSendEmailAddressButton(){
        new WebDriverWait(driver, WAIT_TIMEOUT_SECONDS).until(ExpectedConditions.visibilityOf(sendEmailButton));
        sendEmailButton.click();
        logger.info("Email with estimated price sent");
        return this;
    }

    public void createSimpleOrder(Order order)  {
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
        logger.info("Simple order " + order.toString() + " created and sent for estimation");
    }
}

