package view;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import core.Car;

public class ResultViewTest {

    @Test
    @DisplayName("경주 진행 상태 출력 테스트")  // 경주 진행 상태 출력에 대한 테스트
    public void testPrintRaceProgress() {
        // Given: 3개의 자동차와 각 자동차의 위치를 설정
        List<Car> cars = new ArrayList<>();
        cars.add(new Car("Car1", 3));
        cars.add(new Car("Car2", 5));
        cars.add(new Car("Car3", 2));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // When: printRaceProgress 메서드를 실행
        ResultView.printRaceProgress(cars);

        // Then: 각 자동차의 이름과 해당하는 '-'가 출력되는지 확인
        String output = outputStream.toString();
        assertTrue(output.contains("Car1 : ---"));
        assertTrue(output.contains("Car2 : -----"));
        assertTrue(output.contains("Car3 : --"));
    }

    @Test
    @DisplayName("우승자 출력 테스트")  // 우승자 출력에 대한 테스트
    public void testPrintWinners() {
        // Given: 2명의 우승자를 설정
        List<Car> winners = new ArrayList<>();
        winners.add(new Car("Car1", 5));
        winners.add(new Car("Car2", 5));

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        // When: printWinners 메서드를 실행
        ResultView.printWinners(winners);

        // Then: 우승자의 이름이 "Car1, Car2가 최종 우승했습니다." 형식으로 출력되는지 확인
        String output = outputStream.toString();
        assertTrue(output.contains("Car1, Car2가 최종 우승했습니다."));
    }
}
