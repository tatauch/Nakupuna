package Model;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CalculatorPage extends BasePage{

    @FindBy(id = "selectBuild")
    private WebElement buildDropdownMenu;

    @FindBy (xpath = "//select[@id='selectBuild']/option[9]")
    private WebElement buildEight;

    @FindBy(id = "number1Field")
    private WebElement number1FieldInput;

    @FindBy(id = "number2Field")
    private WebElement number2FieldInput;

    @FindBy(id = "selectOperationDropdown")
    private WebElement operationDropdownMenu;

    @FindBy(xpath = "//select[@id='selectOperationDropdown']/option[1]")
    private WebElement addOperation;

    @FindBy(xpath = "//select[@id='selectOperationDropdown']/option[2]")
    private WebElement subtractOperation;

    @FindBy(xpath = "//select[@id='selectOperationDropdown']/option[3]")
    private WebElement multiplyOperation;

    @FindBy(xpath = "//select[@id='selectOperationDropdown']/option[4]")
    private WebElement divideOperation;

    @FindBy(xpath = "//select[@id='selectOperationDropdown']/option[5]")
    private WebElement concatenateOperation;

    @FindBy(id = "calculateButton")
    private WebElement calculateButton;

    @FindBy(id = "numberAnswerField")
    private WebElement answerField;

    @FindBy(id = "integerSelect")
    private WebElement checkboxIntegersOnly;

    @FindBy(id = "clearButton")
    private WebElement clearButton;

    @FindBy(id = "errorMsgField")
    private WebElement errorMessage;

    public CalculatorPage(WebDriver driver) {
        super(driver);
    }
    public CalculatorPage clickBuildDropDownMenu(){
        buildDropdownMenu.click();

        return this;
    }

    public CalculatorPage clickBuildEight(){
        buildEight.click();

        return this;
    }

    public CalculatorPage setNumber1Field(String num){
        number1FieldInput.clear();
        number1FieldInput.sendKeys(num);

        return this;
    }

    public CalculatorPage setNumber2Field(String num){
        number2FieldInput.clear();
        number2FieldInput.sendKeys(num);

        return this;
    }

    public CalculatorPage clickAddOperation(){
        operationDropdownMenu.click();
        addOperation.click();

        return this;
    }

    public CalculatorPage clickSubtractOperation(){
        operationDropdownMenu.click();
        subtractOperation.click();

        return this;
    }

    public CalculatorPage clickMultiplyOperation(){
        operationDropdownMenu.click();
        multiplyOperation.click();

        return this;
    }

    public CalculatorPage clickDivideOperation(){
        operationDropdownMenu.click();
        divideOperation.click();

        return this;
    }

    public CalculatorPage clickConcatenateOperation(){
        operationDropdownMenu.click();
        concatenateOperation.click();

        return this;
    }

    public CalculatorPage clickCalculateButton(){
        calculateButton.click();

        return this;
    }

    public String getNumberAnswerField(){
        return answerField.getAttribute("value");
    }

    public boolean isCheckedCheckboxIntegersOnly() {
        return Boolean.parseBoolean(checkboxIntegersOnly.getAttribute("checked"));
    }

    public CalculatorPage clickCheckboxIntegersOnly() {
        checkboxIntegersOnly.click();

        return this;
    }

    public CalculatorPage clickClearButton() {
        clearButton.click();

        return this;
    }

    public String getErrorMsgText() {
       return errorMessage.getText();
    }

}
