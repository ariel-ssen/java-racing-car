package core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

class CarConstraintsTest {

    @Test
    @DisplayName("최종 우승자 여부 확인")
    void testCarConstraints() {
        // Given: CarConstraints 클래스의 상수 값을 준비
        int maxCarNameLength = CarConstraints.MAX_CAR_NAME_LENGTH;
        String carNameRegex = CarConstraints.CAR_NAME_REGEX;
        int minMoveValue = CarConstraints.MIN_MOVE_VALUE;

        // When: 각 상수 값을 사용하여 제약 조건을 확인
        // - 자동차 이름 최대 길이는 5이어야 한다.
        // - 자동차 이름은 알파벳으로 시작하고, 숫자만 뒤에 올 수 있어야 한다.
        // - 자동차 이동에 필요한 최소 값은 4이어야 한다.

        // Then: 각 상수가 예상한 값을 가지고 있는지 확인
        assertEquals(5, maxCarNameLength, "자동차 이름 최대 길이는 5이어야 한다.");
        assertEquals("^[a-zA-Z]+[0-9]*$", carNameRegex, "자동차 이름 유효성 검사 정규식은 알파벳으로 시작하고 숫자가 뒤따르는 형식이어야 한다.");
        assertEquals(4, minMoveValue, "자동차 이동에 필요한 최소값은 4이어야 한다.");
    }
}
