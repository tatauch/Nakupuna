import Base.BaseTest;
import Model.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class AddOperatorTest extends BaseTest {

    @DataProvider(name = "DataPositiveNumbers")
    public Object[][] dataPositiveNumbers() {
        return new Object[][]{
                {"1", "9", "10"},
                {"10", "99", "109"},
                {"100", "999", "1099"},
                {"1000", "9999999999", "10000000999"}
        };
    }

    @Test (dataProvider = "DataPositiveNumbers")
    public void testTC11AddPositiveNumbers(String num1, String num2, String expectedResult) {
        String addPositiveNumbers = new CalculatorPage(getDriver())
                .clickBuildDropDownMenu()
                .clickBuildEight()
                .setNumber1Field(num1)
                .setNumber2Field(num2)
                .clickAddOperation()
                .clickCalculateButton()
                .getNumberAnswerField();

        Assert.assertEquals(addPositiveNumbers, expectedResult);
    }

    @DataProvider(name = "ErrorMessageData")
    public Object[][] errorData() {
        return new Object[][]{
                {"!"}, {"@"}, {"#"}, {"$"}, {"%"}, {"^"}, {"&"}, {"*"},
                {":"}, {";"}, {"<"}, {">"}, {"?"}, {"/"}, {"\\"}
        };
    }

    @Test(dataProvider = "ErrorMessageData")
    public void testTC30AddSpecialCharacter(String character){
        String errorMessage = new CalculatorPage(getDriver())
                .clickBuildDropDownMenu()
                .clickBuildEight()
                .setNumber1Field(character)
                .setNumber2Field("5")
                .clickAddOperation()
                .clickCalculateButton()
                .getErrorMsgText();

        Assert.assertEquals(errorMessage, "Number 1 is not a number");

    }
}
