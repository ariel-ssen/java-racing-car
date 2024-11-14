package core;

public class CarConstraints {
    // 자동차 이름 최대 길이
    public static final int MAX_CAR_NAME_LENGTH = 5;

    // 자동차 이름 유효성 검사 정규식
    public static final String CAR_NAME_REGEX = "^[a-zA-Z]+[0-9]*$";

    // 자동차 이동에 필요한 최소값
    public static final int MIN_MOVE_VALUE = 4;
}
