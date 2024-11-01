import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class InputParserTest {

    private final InputParser parser = new InputParser();

    @Test
    @DisplayName("빈 문자열 입력 시 '0'을 기본값으로 반환함")
    public void testParseEmptyInput() {
        assertArrayEquals(new String[]{"0"}, parser.parseInput(""));
    }

    @Test
    @DisplayName("숫자 하나만 입력했을 때 배열로 반환함")
    public void testParseSingleNumber() {
        assertArrayEquals(new String[]{"5"}, parser.parseInput("5"));
    }

    @Test
    @DisplayName("쉼표로 구분된 숫자를 배열로 변환함")
    public void testParseCommaSeparatedNumbers() {
        assertArrayEquals(new String[]{"1", "2", "3"}, parser.parseInput("1,2,3"));
    }

    @Test
    @DisplayName("콜론으로 구분된 숫자를 배열로 변환함")
    public void testParseColonSeparatedNumbers() {
        assertArrayEquals(new String[]{"4", "5", "6"}, parser.parseInput("4:5:6"));
    }

    @Test
    @DisplayName("커스텀 구분자가 있는 경우 해당 구분자로 숫자 분리함")
    public void testParseCustomDelimiter() {
        assertArrayEquals(new String[]{"1", "2", "3"}, parser.parseInput("//;\n1;2;3"));
    }
}
