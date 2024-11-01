import java.util.Arrays;

public class StringCalculator {

    public int calculate(String input) {
        if (isEmpty(input)) {
            return 0;
        }

        String[] numbers = parseNumbers(input);
        validateNonNegativeAndNonZero(numbers);  // 메소드 이름을 수정하여 0도 포함하도록 명확히 함

        return sum(numbers);
    }

    private boolean isEmpty(String input) {
        return input == null || input.isEmpty();
    }

    private String[] parseNumbers(String input) {
        InputParser parser = new InputParser();
        return parser.parseInput(input);
    }

    private void validateNonNegativeAndNonZero(String[] numbers) {
        Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .filter(num -> num <= 0)  // 0과 음수를 모두 예외로 처리
                .findFirst()
                .ifPresent(num -> {
                    throw new CalculatorException.InvalidInputException(num);
                });
    }

    private int sum(String[] numbers) {
        return Arrays.stream(numbers)
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
