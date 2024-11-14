package view;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import core.Car;
import message.Message;
import utils.InputValidator;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    // 자동차 이름을 입력받는 메서드
    public static List<Car> getCars() {
        printCarNamePrompt();
        return getValidCarNames();
    }

    private static List<Car> getValidCarNames() {
        while (true) { // 반복문을 사용하여 유효한 입력을 받을 때까지 계속 요청
            String input = scanner.nextLine();
            String[] names = input.split(",");

            String errorMessage = InputValidator.validateCarNames(names);
            if (errorMessage != null) {
                printErrorMessage(errorMessage);
                continue; // 유효하지 않으면 다시 입력 받기
            }

            return createCars(names); // 유효한 이름이 입력되면 반환
        }
    }

    private static void printCarNamePrompt() {
        System.out.println(Message.CAR_NAME_PROMPT.getMessage());
    }

    private static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    // 자동차 객체 리스트를 생성하는 메서드
    private static List<Car> createCars(String[] names) {
        return Arrays.stream(names)
                .map(String::trim) // 공백 제거
                .map(Car::new) // 각 이름으로 Car 객체 생성
                .toList();
    }

    // 시도 횟수를 입력받는 메서드
    public static int getAttempts() {
        printAttemptPrompt();
        return getValidAttempt();
    }

    private static int getValidAttempt() {
        while (true) { // 반복문으로 시도 횟수를 유효하게 받을 때까지 반복
            String input = scanner.nextLine();
            if (InputValidator.isValidAttempt(input)) {
                return parseAttempt(input);
            }

            printErrorMessage(Message.INVALID_NUMBER.getMessage());
        }
    }

    private static void printAttemptPrompt() {
        System.out.println(Message.ATTEMPT_PROMPT.getMessage());
    }

    private static int parseAttempt(String input) {
        int attempts = Integer.parseInt(input);
        if (attempts > 10) {
            printErrorMessage(Message.MAX_ATTEMPTS_EXCEEDED.getMessage());
            return getAttempts(); // 시도 횟수 초과시 다시 입력 받기
        }
        return attempts;
    }
}
