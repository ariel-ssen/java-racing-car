import java.util.Arrays;

public class InputParser {

    public String[] parseInput(String input) {
        if (isEmpty(input)) {
            return new String[]{"0"}; // 빈 문자열일 때 0 반환을 위해 기본값 설정
        }

        String numbersOnly = removeDelimiterPrefix(input);
        String delimiter = getDelimiter(input);
        return splitByDelimiter(numbersOnly, delimiter);
    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private String getDelimiter(String input) {
        return input.startsWith("//") ? extractCustomDelimiter(input) : ",|:";
    }

    private String extractCustomDelimiter(String input) {
        return input.substring(2, input.indexOf("\n"));
    }

    private String removeDelimiterPrefix(String input) {
        return input.startsWith("//") ? input.substring(input.indexOf("\n") + 1) : input;
    }

    private String[] splitByDelimiter(String input, String delimiter) {
        return Arrays.stream(input.split(delimiter))
                .filter(num -> !num.isBlank())
                .toArray(String[]::new);
    }
}
