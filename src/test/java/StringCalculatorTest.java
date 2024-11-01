import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StringCalculatorTest {

    private final StringCalculator calculator = new StringCalculator();

    @Test
    @DisplayName("빈 문자열 입력 시 0 반환함")
    public void testCalculateEmptyInput() {
        assertEquals(0, calculator.calculate(""));
    }

    @Test
    @DisplayName("숫자 하나만 입력 시 해당 숫자 반환함")
    public void testCalculateSingleNumber() {
        assertEquals(7, calculator.calculate("7"));
    }

    @Test
    @DisplayName("쉼표로 구분된 숫자들의 합 반환함")
    public void testCalculateCommaSeparatedNumbers() {
        assertEquals(6, calculator.calculate("1,2,3"));
    }

    @Test
    @DisplayName("콜론으로 구분된 숫자들의 합 반환함")
    public void testCalculateColonSeparatedNumbers() {
        assertEquals(15, calculator.calculate("5:5:5"));
    }

    @Test
    @DisplayName("커스텀 구분자로 구분된 숫자들의 합 반환함")
    public void testCalculateCustomDelimiter() {
        assertEquals(10, calculator.calculate("//;\n2;3;5"));
    }

    @Test
    @DisplayName("음수 포함 시 예외 발생 확인함")
    public void testCalculateWithNegativeNumber() {
        CalculatorException.InvalidInputException exception = assertThrows(
                CalculatorException.InvalidInputException.class,
                () -> calculator.calculate("-1,2,3")
        );
        assertEquals("음수 또는 0은 입력할 수 없습니다. 입력된 값: -1", exception.getMessage());
    }

    @Test
    @DisplayName("0 포함 시 예외 발생 확인함")
    public void testCalculateWithZero() {
        CalculatorException.InvalidInputException exception = assertThrows(
                CalculatorException.InvalidInputException.class,
                () -> calculator.calculate("0,1,2")
        );
        assertEquals("음수 또는 0은 입력할 수 없습니다. 입력된 값: 0", exception.getMessage());
    }
}
