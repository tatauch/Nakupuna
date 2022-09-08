
import Base.BaseTest;
import Model.CalculatorPage;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MultiplyOperatorTest extends BaseTest {

    @DataProvider(name = "DataPositiveNumbers")
    public Object[][] dataPositiveNumbers() {
        return new Object[][]{
                {"1", "9", "9"},
                {"10", "99", "990"},
                {"100", "999", "99900"},
                {"1000", "9999999999", "9999999999000"}
        };
    }

    @Test(dataProvider = "DataPositiveNumbers")
    public void testTC354MultiplyPositiveNumbers(String num1, String num2, String expectedResult) {
        String multiplySmoke = new CalculatorPage(getDriver())
                .clickBuildDropDownMenu()
                .clickBuildEight()
                .setNumber1Field(num1)
                .setNumber2Field(num2)
                .clickMultiplyOperation()
                .clickCalculateButton()
                .getNumberAnswerField();

        Assert.assertEquals(multiplySmoke, expectedResult);
    }
}
