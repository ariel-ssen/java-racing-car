package message;

public enum Message {
    CAR_NAME_PROMPT("경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분)."),
    CAR_NAME_INVALID_FORMAT("자동차 이름은 쉼표(,)로 구분해야 합니다."),
    CAR_NAME_TOO_LONG("자동차 이름은 5자 이하여야 합니다."),
    CAR_NAME_DUPLICATE("자동차 이름이 중복되었습니다. 다시 입력해주세요."),
    ATTEMPT_PROMPT("시도할 회수는 몇회인가요?"),
    INVALID_NUMBER("숫자만 입력 가능합니다. 다시 입력해주세요."),
    CAR_NAME_INVALID("자동차 이름을 올바르게 입력하세요."),
    MAX_ATTEMPTS_EXCEEDED("시도할 회수는 최대 10회까지 가능합니다. 다시 입력해주세요.");

    private final String message;

    // 생성자
    Message(String message) {
        this.message = message;
    }

    // 메시지를 반환하는 메서드
    public String getMessage() {
        return message;
    }
}
