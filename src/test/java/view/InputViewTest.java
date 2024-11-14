package view;

import core.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import utils.InputValidator;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mockStatic;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
@DisplayName("최종 우승자 여부 확인")
public class InputViewTest {

    @Test
    @DisplayName("유효한 자동차 이름 입력 테스트")
    void testGetCars_ValidNames() {
        // Given: 유효한 자동차 이름이 입력됨
        String validInput = "Car1, Car2, Car3\n";
        InputStream in = new ByteArrayInputStream(validInput.getBytes());
        System.setIn(in);

        // Mock InputValidator to validate names without errors
        try (MockedStatic<InputValidator> validatorMock = mockStatic(InputValidator.class)) {
            validatorMock.when(() -> InputValidator.validateCarNames(any(String[].class)))
                    .thenReturn(null);

            // When: getCars 메서드가 호출됨
            List<Car> cars = InputView.getCars();

            // Then: 유효한 이름으로 Car 객체가 생성되어야 함
            assertEquals(3, cars.size(), "자동차 이름 입력으로 3개의 Car 객체가 생성되어야 한다.");
            assertEquals("Car1", cars.get(0).getName(), "첫 번째 자동차 이름은 Car1 이어야 한다.");
            assertEquals("Car2", cars.get(1).getName(), "두 번째 자동차 이름은 Car2 이어야 한다.");
            assertEquals("Car3", cars.get(2).getName(), "세 번째 자동차 이름은 Car3 이어야 한다.");
        }
    }

    @Test
    @DisplayName("유효한 시도 횟수 입력 테스트")
    void testGetAttempts_ValidNumber() {
        // Given: 유효한 시도 횟수가 입력됨
        String validInput = "5\n";
        InputStream in = new ByteArrayInputStream(validInput.getBytes());
        System.setIn(in);

        // Mock InputValidator to validate attempt number without errors
        try (MockedStatic<InputValidator> validatorMock = mockStatic(InputValidator.class)) {
            validatorMock.when(() -> InputValidator.isValidAttempt(any(String.class)))
                    .thenReturn(true);

            // When: getAttempts 메서드가 호출됨
            int attempts = InputView.getAttempts();

            // Then: 유효한 시도 횟수가 반환되어야 함
            assertEquals(5, attempts, "유효한 시도 횟수 입력으로 5가 반환되어야 한다.");
        }
    }

    @Test
    @DisplayName("시도 횟수가 최대값을 초과했을 때 다시 입력 요청 테스트")
    void testGetAttempts_MaxExceeded() {
        // Given: 시도 횟수가 최대값을 초과함
        String inputExceedingMax = "15\n5\n";
        InputStream in = new ByteArrayInputStream(inputExceedingMax.getBytes());
        System.setIn(in);

        // Mock InputValidator to validate attempt number
        try (MockedStatic<InputValidator> validatorMock = mockStatic(InputValidator.class)) {
            validatorMock.when(() -> InputValidator.isValidAttempt(any(String.class)))
                    .thenReturn(true);

            // When: getAttempts 메서드가 호출됨
            int attempts = InputView.getAttempts();

            // Then: 유효한 시도 횟수가 반환되어야 함
            assertEquals(5, attempts, "최대값을 초과한 입력 후 유효한 시도 횟수 5가 반환되어야 한다.");
        }
    }
}
