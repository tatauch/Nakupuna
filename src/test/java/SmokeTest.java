import Base.BaseTest;
import Model.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest {

    @Test
    public void testTC1Add() {
        String addSmoke = new CalculatorPage(getDriver())
                .clickBuildDropDownMenu()
                .clickBuildEight()
                .setNumber1Field("1")
                .setNumber2Field("9")
                .clickAddOperation()
                .clickCalculateButton()
                .getNumberAnswerField();

        Assert.assertEquals(addSmoke, "10");
    }

    @Test
    public void testTC2Subtract() {
        String subtractSmoke = new CalculatorPage(getDriver())
                .clickBuildDropDownMenu()
                .clickBuildEight()
                .setNumber1Field("9")
                .setNumber2Field("1")
                .clickSubtractOperation()
                .clickCalculateButton()
                .getNumberAnswerField();

        Assert.assertEquals(subtractSmoke, "8");
    }

    @Test
    public void testTC3Multiply() {
        String multiplySmoke = new CalculatorPage(getDriver())
                .clickBuildDropDownMenu()
                .clickBuildEight()
                .setNumber1Field("2")
                .setNumber2Field("9")
                .clickMultiplyOperation()
                .clickCalculateButton()
                .getNumberAnswerField();

        Assert.assertEquals(multiplySmoke, "18");
    }

    @Test
    public void testTC4Divide() {
        String divideSmoke = new CalculatorPage(getDriver())
                .clickBuildDropDownMenu()
                .clickBuildEight()
                .setNumber1Field("10")
                .setNumber2Field("2")
                .clickDivideOperation()
                .clickCalculateButton()
                .getNumberAnswerField();

        Assert.assertEquals(divideSmoke, "5");
    }

    @Test
    public void testTC5Concatenate() {
        String concatenateSmoke = new CalculatorPage(getDriver())
                .clickBuildDropDownMenu()
                .clickBuildEight()
                .setNumber1Field("1")
                .setNumber2Field("9")
                .clickConcatenateOperation()
                .clickCalculateButton()
                .getNumberAnswerField();

        Assert.assertEquals(concatenateSmoke, "19");
    }

    @Test
    public void testTC6CheckboxIntegersOnly() {
        String integersOnlySmoke = new CalculatorPage(getDriver())
                .clickBuildDropDownMenu()
                .clickBuildEight()
                .setNumber1Field("9")
                .setNumber2Field("1.1")
                .clickSubtractOperation()
                .clickCheckboxIntegersOnly()
                .clickCalculateButton()
                .getNumberAnswerField();

        Assert.assertEquals(integersOnlySmoke, "7");
    }

    @Test (dependsOnMethods = "testTC1Add")
    public void testTC109ClearButton(){
        CalculatorPage clearButtonSmoke = new CalculatorPage(getDriver())
                .clickCheckboxIntegersOnly()
                .clickClearButton();

        Assert.assertEquals(clearButtonSmoke.getNumberAnswerField(), "");
        Assert.assertFalse(clearButtonSmoke.isCheckedCheckboxIntegersOnly());

    }
}
