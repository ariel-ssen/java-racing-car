// view/ResultView.java
package view;

import core.Car;
import java.util.List;

public class ResultView {
    public static void printRaceProgress(List<Car> cars) {
        for (Car car : cars) {
            System.out.print(car.getName() + " : ");
            System.out.println("-".repeat(car.getPosition()));
        }
        System.out.println();
    }

    public static void printWinners(List<Car> winners) {
        String winnerNames = String.join(", ", winners.stream()
                .map(Car::getName)
                .toList());
        System.out.println(winnerNames + "가 최종 우승했습니다.");
    }
}
