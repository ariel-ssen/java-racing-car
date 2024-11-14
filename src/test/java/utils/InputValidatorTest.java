package utils;

import message.Message;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

class InputValidatorTest {

    @Test
    @DisplayName("최종 우승자 여부 확인")
    void testValidateCarName() {
        // Given: 유효한 자동차 이름과 유효하지 않은 자동차 이름들
        String validName = "Car1";
        String invalidName = "Car@123";

        // When: validateCarName 메서드를 호출하여 각각의 이름을 검사
        String validResult = InputValidator.validateCarName(validName);
        String invalidResult = InputValidator.validateCarName(invalidName);

        // Then: 유효한 이름은 null을 반환하고, 너무 긴 이름은 에러 메시지를 반환하며, 유효하지 않은 이름은 에러 메시지를 반환
        assertNull(validResult, "유효한 자동차 이름은 null을 반환해야 한다.");
        assertEquals(Message.CAR_NAME_INVALID.getMessage(), invalidResult, "유효하지 않은 자동차 이름은 해당 에러 메시지를 반환해야 한다.");
    }


    @Test
    @DisplayName("여러 자동차 이름에 대한 유효성 검사")
    void testValidateCarNames() {
        // Given: 여러 자동차 이름 배열을 준비 (유효한 이름, 중복된 이름, 너무 긴 이름)
        String[] validNames = {"Car1", "Car2"};
        String[] duplicateNames = {"Car1", "Car1"};  // 중복된 이름

        // When: validateCarNames 메서드를 호출하여 각 이름 배열을 검사
        String validNamesResult = InputValidator.validateCarNames(validNames);
        String duplicateNamesResult = InputValidator.validateCarNames(duplicateNames);

        // Then: 유효한 이름 배열은 null을 반환하고, 중복된 이름 배열은 에러 메시지를 반환하며, 너무 긴 이름 배열은 에러 메시지를 반환
        assertNull(validNamesResult, "모든 자동차 이름이 유효하면 null을 반환해야 한다.");
        assertEquals(Message.CAR_NAME_DUPLICATE.getMessage(), duplicateNamesResult, "중복된 이름이 있으면 해당 에러 메시지를 반환해야 한다.");
    }

    @Test
    @DisplayName("시도 횟수 유효성 검사")
    void testIsValidAttempt() {
        // Given: 유효한 숫자 문자열 "5"와 유효하지 않은 문자열 "invalid"를 준비
        String validAttempt = "5";
        String invalidAttempt = "invalid";

        // When: isValidAttempt 메서드를 호출하여 각 입력 값의 유효성을 검사
        boolean validResult = InputValidator.isValidAttempt(validAttempt);
        boolean invalidResult = InputValidator.isValidAttempt(invalidAttempt);

        // Then: 유효한 숫자 문자열은 true를 반환하고, 유효하지 않은 문자열은 false를 반환해야 한다
        assertTrue(validResult, "유효한 숫자 문자열은 true를 반환해야 한다.");
        assertFalse(invalidResult, "유효하지 않은 문자열은 false를 반환해야 한다.");
    }
}
