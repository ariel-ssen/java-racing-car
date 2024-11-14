package message;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void testGetMessage() {
        assertEquals("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).", Message.CAR_NAME_PROMPT.getMessage());
        assertEquals("자동차 이름은 5자 이하여야 합니다.", Message.CAR_NAME_TOO_LONG.getMessage());
    }
}
