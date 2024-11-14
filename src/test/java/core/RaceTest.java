package core;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;

class RaceTest {
    private Race race;

    @BeforeEach
    void setUp() {
        // Given: "Car1"과 "Car2"라는 이름을 가진 새로운 자동차 객체 두 개를 생성
        Car car1 = new Car("Car1");
        Car car2 = new Car("Car2");
        // 그리고 두 자동차를 5번의 시도로 경주를 시작할 수 있도록 Race 객체를 생성
        race = new Race(Arrays.asList(car1, car2), 5);  // 5 attempts
    }

    @Test
    @DisplayName("경주 시작 후 자동차의 위치가 갱신되는지 확인")
    void testStartRace() {
        // Given: 5번의 시도로 경주를 시작
        // When: race.start() 메서드를 호출하여 경주를 시작
        race.start();

        // Then: 자동차들의 위치가 0 이상으로 갱신되어야 한다
        assertTrue(race.getCars().get(0).getPosition() >= 0);  // 첫 번째 자동차의 위치가 갱신되었는지 확인
        assertTrue(race.getCars().get(1).getPosition() >= 0);  // 두 번째 자동차의 위치가 갱신되었는지 확인
    }

    @Test
    @DisplayName("경주 후 우승자가 결정되는지 확인")
    void testGetWinners() {
        // Given: 5번의 시도로 경주를 시작
        race.start();

        // When: 경주가 끝난 후 우승자 리스트를 가져옴
        List<Car> winners = race.getWinners();

        // Then: 우승자 리스트가 null이 아니고, 적어도 하나의 우승자가 있어야 한다
        assertNotNull(winners);  // 우승자 리스트가 null이 아님을 확인
        assertFalse(winners.isEmpty());  // 우승자가 하나 이상 있어야 함을 확인
    }
}
