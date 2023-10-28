package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Application {
    private static List<Car> cars;
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String userInputCarNames = userInput();
        List<String> carNames = Arrays.stream(userInputCarNames.split(",")).toList();

        cars = new ArrayList<Car>();
        for (String carName: carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }

        int userInputNumberOfAttempts = Integer.parseInt(userInput());

        for (int i = 0; i < userInputNumberOfAttempts; i++) {
            goForwardRandomCar();
            showRaceResult();
        }

        showFinalWinners();

        Console.close();
    }

    private static String userInput() {
        String userInput = Console.readLine();
        return userInput;
    }

    private static void goForwardRandomCar() {
        for (int i = 0; i < cars.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            System.out.println(i + cars.get(i).getName() + randomNumber);
            if (randomNumber >= 4) {
                cars.get(i).goForward();
            }
        }
    }

    private static void showRaceResult() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).showResult();
        }
    }

    private static void showFinalWinners() {
        List<String> winners = new ArrayList<String>();

        int maxDistance = 0;

        for(int i = 0; i < cars.size(); i++) {
            maxDistance = Math.max(maxDistance, cars.get(i).getDrivingDistance());
        }

        for (int i = 0; i < cars.size(); i++) {
            if (maxDistance == cars.get(i).getDrivingDistance()) {
                winners.add(cars.get(i).getName());
            }
        }

        String result = String.join(", ", winners);
        System.out.println("최종 우승자 : " + result);
    }
}
