package core;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Race {
    private final List<Car> cars;
    private final int attempts;
    private final Random random;

    public Race(List<Car> cars, int attempts) {
        this.cars = cars;
        this.attempts = attempts;
        this.random = new Random();
    }

    public void start() {
        for (int i = 0; i < attempts; i++) {
            raceOnce();
        }
    }

    private void raceOnce() {
        for (Car car : cars) {
            // 이전에는 random.nextInt(10)을 그대로 사용했으나,
            // 이제는 moveRandomly 메서드를 사용해 자동차의 위치를 이동시킨다.
            car.moveRandomly(random.nextInt(10));
        }
    }

    public List<Car> getWinners() {
        int maxPosition = getMaxPosition();
        List<Car> winners = new ArrayList<>();
        for (Car car : cars) {
            if (car.isWinner(maxPosition)) {
                winners.add(car);
            }
        }
        return winners;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }

    public List<Car> getCars() {
        return cars;
    }
}
