import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    @Test
    @DisplayName("정상 입력에 대해 예외 없이 결과 반환됨")
    public void testMainCalculation() {
        StringCalculator calculator = new StringCalculator();

        try {
            int result = calculator.calculate("//;\n1;2;3");
            assertEquals(6, result);
        } catch (CalculatorException.InvalidInputException e) {
            fail("예외가 발생하지 않아야 함");
        }
    }

    @Test
    @DisplayName("음수 입력 시 예외 발생 확인함")
    public void testMainCalculationWithException() {
        StringCalculator calculator = new StringCalculator();

        CalculatorException.InvalidInputException exception = assertThrows(
                CalculatorException.InvalidInputException.class,
                () -> calculator.calculate("-1,2,3")
        );
        assertEquals("음수 또는 0은 입력할 수 없습니다. 입력된 값: -1", exception.getMessage());
    }
}
