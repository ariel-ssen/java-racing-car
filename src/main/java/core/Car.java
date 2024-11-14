package core;

import message.Message;
import utils.InputValidator;

public class Car {
    private final String name;
    private int position;

    public Car(String name) {
        String errorMessage = InputValidator.validateCarName(name);
        if (errorMessage != null) {
            throw new IllegalArgumentException(errorMessage); // 유효성 검사 실패시 예외 던짐
        }
        this.name = name;
        this.position = 0;
    }

    // 새로운 생성자 (name과 position을 초기화할 수 있게 수정)
    public Car(String name, int position) {
        this.name = name;
        this.position = position;
    }


    // 일정 거리 이상일 때만 위치를 1칸 증가시키는 메서드
    public void moveRandomly(int randomValue) {
        if (randomValue >= CarConstraints.MIN_MOVE_VALUE) {
            position++;
        }
    }

    // 주어진 거리만큼 위치를 이동시키는 메서드
    public void moveDistance(int distance) {
        this.position += distance;
    }

    public int getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public boolean isWinner(int maxPosition) {
        return position == maxPosition;
    }
}
