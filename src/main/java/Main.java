public class Main {
    public static void main(String[] args) {
        StringCalculator calculator = new StringCalculator();

        try {
            int result = calculator.calculate("//;\n1;3;3");
            System.out.println("계산 결과: " + result);
        } catch (CalculatorException.InvalidInputException e) {
            System.out.println("예외 발생: " + e.getMessage());
        }
    }
}
