package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Game {
    private User user;
    private List<Car> cars;
    private int rounds;

    public Game() {
        user = new User();
        cars = new ArrayList<Car>();
        rounds = 0;
    }

    public void run() {
        initRace();
        playRace();
        Console.close();
    }

    private void initRace() {
        initCars();
        initRounds();
    }

    private void initCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNamesByUserInput = user.getCarNames();
        carNamesParser(carNamesByUserInput);
    }

    private void carNamesParser(String carNamesByUserInput) {
        List<String> carNames = Arrays.stream(carNamesByUserInput.split(",")).toList();
        for (String name: carNames) {
            Car car = new Car(name);
            cars.add(car);
        }
    }

    private void initRounds() {
        System.out.println("시도할 회수는 몇회인가요?");
        rounds = user.getRounds();
        validateRounds(rounds);
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
            showOneRoundResult();
        }
        showFinalWinners();
    }

    private void playOneRound() {
        for (int i = 0; i < cars.size(); i++) {
            int randomNumber = Randoms.pickNumberInRange(0, 9);
            if (randomNumber >= 4) {
                cars.get(i).moveForward();
            }
        }
    }

    private void showOneRoundResult() {
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).showResult();
        }
    }

    private void showFinalWinners() {
        List<String> maxDrivingDistanceCarNames = getMaxDrivingDistanceCarNames();
        String winners = String.join(", ", maxDrivingDistanceCarNames);
        System.out.println("최종 우승자 : " + winners);
    }

    private List<String> getMaxDrivingDistanceCarNames() {
        List<String> maxDrivingDistanceCarNames = new ArrayList<String>();
        int maxDrivingDistance = getMaxDrivingDistance();
        for (int i = 0; i < cars.size(); i++) {
            if (maxDrivingDistance == cars.get(i).getDrivingDistance()) {
                maxDrivingDistanceCarNames.add(cars.get(i).getName());
            }
        }
        return maxDrivingDistanceCarNames;
    }

    private int getMaxDrivingDistance() {
        int maxDrivingDistance = 0;
        for(int i = 0; i < cars.size(); i++) {
            maxDrivingDistance = Math.max(maxDrivingDistance, cars.get(i).getDrivingDistance());
        }
        return maxDrivingDistance;
    }
}
