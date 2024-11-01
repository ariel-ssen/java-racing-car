import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorExceptionTest {

    @Test
    @DisplayName("음수 값 입력 시 InvalidInputException 예외 메시지 확인함")
    public void testInvalidInputExceptionWithNegativeNumber() {
        CalculatorException.InvalidInputException exception =
                new CalculatorException.InvalidInputException(-3);
        assertEquals("음수 또는 0은 입력할 수 없습니다. 입력된 값: -3", exception.getMessage());
    }

    @Test
    @DisplayName("0 입력 시 InvalidInputException 예외 메시지 확인함")
    public void testInvalidInputExceptionWithZero() {
        CalculatorException.InvalidInputException exception =
                new CalculatorException.InvalidInputException(0);
        assertEquals("음수 또는 0은 입력할 수 없습니다. 입력된 값: 0", exception.getMessage());
    }
}
