package core;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;

class CarTest {

    @Test
    @DisplayName("자동차가 정상적으로 이동하고 잘못된 이동은 무시되는지 확인")
    void testCarMovement() {
        // Given: "Car1"이라는 이름을 가진 새로운 자동차 객체를 생성
        Car car = new Car("Car1");

        // When: 자동차가 랜덤값을 5로 받아 이동시키는 명령을 내림 (유효한 이동)
        car.moveRandomly(5);  // 유효한 이동

        // Then: 자동차의 위치가 1로 업데이트 되어야 한다 (이동은 1칸씩만 진행됨)
        assertEquals(1, car.getPosition());  // 자동차가 1칸 이동했으므로, 위치는 1이어야 한다.

        // When: 자동차가 랜덤값을 3으로 받아 이동시키는 명령을 내림 (잘못된 이동)
        car.moveRandomly(3);  // 잘못된 이동

        // Then: 자동차의 위치는 여전히 1이어야 한다 (잘못된 이동은 무시됨)
        assertEquals(1, car.getPosition());  // 자동차의 위치가 변경되지 않았으므로 여전히 1이어야 한다.
    }

    @Test
    @DisplayName("최종 우승자 여부 확인")
    void testIsWinner() {
        // Given: "Car1"이라는 이름을 가진 새로운 자동차 객체를 생성하고 5칸을 이동시킴
        Car car = new Car("Car1");
        car.moveDistance(5);  // 위치 5로 이동

        // When: 자동차가 최대 위치인 5에 도달했을 때 우승자인지 확인
        // Then: "Car1"은 우승자로 간주되어야 한다.
        assertTrue(car.isWinner(5));  // 자동차의 위치가 최대 위치인 5에 도달하면 우승자로 간주

        // Given: "Car1"을 다시 생성하고 3칸만 이동시킴
        car = new Car("Car1");
        car.moveDistance(3);  // 위치 3으로 이동

        // When: 자동차가 최대 위치인 5에 도달하지 않았을 때 우승자인지 확인
        // Then: "Car1"은 우승자가 아니어야 한다.
        assertFalse(car.isWinner(5));  // 위치가 5에 미치지 않으면 우승자가 아니므로 false 반환
    }
}
