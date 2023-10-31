package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private List<Car> cars;
    private int rounds = 0;

    public Game() {
    }

    public void run() {
        initCars();
        initRounds();
        playRace();
        showFinalWinners();
        Console.close();
    }

    private void initCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String userInputCarNames = userInput();
        List<String> carNames = Arrays.stream(userInputCarNames.split(",")).toList();
        cars = new ArrayList<Car>();
        for (String name: carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private void initRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        rounds = Integer.parseInt(userInput());
        validateRounds(rounds);
    }

    private String userInput() {
        String userInput = Console.readLine();
        validateUserInput(userInput);
        return userInput;
    }

    private void validateUserInput(String input) {
        validateUserInputNullCheck(input);
    }

    private void validateUserInputNullCheck(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
    }

    private void validateRounds(int rounds) {
        validateRoundsRange(rounds);
    }

    private void validateRoundsRange(int rounds) {
        if (rounds < 0 || rounds > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Invalid rounds Range");
        }
    }

    private void playRace() {
        for (int i = 0; i < rounds; i++) {
            playOneRound();
            showRaceCondition();
        }
    }

    private void playOneRound() {
        for (int i = 0; i < cars.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                cars.get(i).moveForward();
            }
        }
    }

    private void showRaceCondition() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).showResult();
        }
    }

    private void showFinalWinners() {
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
