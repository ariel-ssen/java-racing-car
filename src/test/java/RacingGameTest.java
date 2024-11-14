import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;  // DisplayName 어노테이션을 import
import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class RacingGameTest {

    @Test
    @DisplayName("주어진 3개의 자동차와 5번의 시도로 경주 진행 및 결과 출력 테스트")  // 테스트 목적을 명확하게 설명
    public void testMainMethod() {
        // Given: 자동차 이름 3개와 시도 횟수 5회에 대한 가짜 입력값 준비
        String input = "Car1,Car2,Car3\n5\n";  // Mock input: 3 cars and 5 attempts

        // System.in을 가짜 입력으로 변경
        System.setIn(new ByteArrayInputStream(input.getBytes()));

        // System.out을 캡처하기 위해 ByteArrayOutputStream 사용
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        try {
            // When: RacingGame의 main 메서드를 실행
            RacingGame.main(new String[]{});

            // Then: 디스플레이 네임이 포함된 출력이 정상적으로 나오는지 확인
            // 출력 결과에 "Car1 : ", "Car2 : ", "Car3 : " 등이 포함되어 있어야 함
            String output = outputStream.toString();
            assertTrue(output.contains("Car1 : "));
            assertTrue(output.contains("Car2 : "));
            assertTrue(output.contains("Car3 : "));
            assertTrue(output.contains("가 최종 우승했습니다."));  // 최종 우승자가 출력되는지 확인
        } catch (Exception e) {
            // 예외 발생 시 테스트 실패
            fail("Main method failed with exception: " + e.getMessage());
        } finally {
            // 테스트 후 System.in과 System.out을 원래 상태로 복원
            System.setIn(System.in);
            System.setOut(System.out);
        }
    }
}
