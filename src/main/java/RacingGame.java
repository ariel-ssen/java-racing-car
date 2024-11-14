// RacingGame.java
import core.Car;
import core.Race;
import view.InputView;
import view.ResultView;

import java.util.List;

public class RacingGame {
    public static void main(String[] args) {
        try{
            List<Car> cars = InputView.getCars();
            int attempts = InputView.getAttempts();

            Race race = new Race(cars, attempts);
            System.out.println("실행 결과");

            for (int i = 0; i < attempts; i++) {
                race.start();
                ResultView.printRaceProgress(race.getCars());
            }

            List<Car> winners = race.getWinners();
            ResultView.printWinners(winners);
        }
        catch (Exception e){
            e.printStackTrace();
            System.exit(1); // Exit with a non-zero status to indicate an error

        }

    }
}
