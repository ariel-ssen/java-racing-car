public class CalculatorException {

    // 음수 또는 0이 입력될 때 사용하는 예외 클래스
    public static class InvalidInputException extends RuntimeException {
        public InvalidInputException(int value) {
            super("음수 또는 0은 입력할 수 없습니다. 입력된 값: " + value);
        }
    }
}
