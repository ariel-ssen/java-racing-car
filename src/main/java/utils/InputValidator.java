package utils;

import java.util.HashSet;
import java.util.Set;
import core.CarConstraints;
import message.Message;

public class InputValidator {

    // 자동차 이름 유효성 검사
    public static String validateCarName(String name) {
        if (name.length() > CarConstraints.MAX_CAR_NAME_LENGTH || !isValidCarName(name)) {
            return Message.CAR_NAME_INVALID.getMessage();
        }
        return null; // 유효한 이름이면 null 반환
    }


    private static boolean isValidCarName(String name) {
        return name.matches(CarConstraints.CAR_NAME_REGEX);
    }

    // 자동차 이름들에 대한 유효성 검사
    public static String validateCarNames(String[] names) {
        if (names.length < 2) {
            return Message.CAR_NAME_INVALID_FORMAT.getMessage();
        }

        if (hasDuplicateName(names)) {
            return Message.CAR_NAME_DUPLICATE.getMessage();
        }

        // 각 자동차 이름에 대해 유효성 검사 수행
        for (String name : names) {
            String errorMessage = validateCarName(name.trim());
            if (errorMessage != null) {
                return errorMessage; // 유효하지 않으면 에러 메시지 반환
            }
        }

        return null;
    }

    // 중복된 자동차 이름이 있는지 확인
    private static boolean hasDuplicateName(String[] names) {
        Set<String> uniqueNames = new HashSet<>();
        for (String name : names) {
            String trimmedName = name.trim().toLowerCase();
            if (!uniqueNames.add(trimmedName)) {
                return true;
            }
        }
        return false;
    }

    // 시도 횟수가 유효한지 확인
    public static boolean isValidAttempt(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
