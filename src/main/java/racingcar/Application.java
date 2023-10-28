package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        String userInputCarNames = Console.readLine();
        List<String> carNames = Arrays.stream(userInputCarNames.split(",")).toList();
        List<Integer> carDrivingDistance = new ArrayList<Integer>();
        for(int i = 0; i < carNames.size(); i++) {
            carDrivingDistance.add(0);
        }

        int userInputNumberOfAttempts = Integer.parseInt(Console.readLine());

        for (int i = 0; i < userInputNumberOfAttempts; i++) {
            for (int j = 0; j < carNames.size(); j++) {
                int randomNumber = Randoms.pickNumberInRange(0, 9);
                if (randomNumber >= 4) {
                    carDrivingDistance.set(j, carDrivingDistance.get(j) + 1);
                }
            }
            for (int j = 0; j < carNames.size(); j++) {
                StringBuilder result = new StringBuilder();
                String carName = carNames.get(j);
                String carDistanceExpression = "";

                for (int k = 0; k < carDrivingDistance.get(j); k++) {
                    carDistanceExpression += "-";
                }

                result.append(carName).append(" : ").append(carDistanceExpression);
                System.out.println(result);
            }
        }

        StringBuilder winners = new StringBuilder();
        Integer maxDistance = Collections.max(carDrivingDistance);
        for (int i = 0; i < carDrivingDistance.size(); i++) {
            if (maxDistance == carDrivingDistance.get(i)) {
                if (winners.length() != 0) {
                    winners.append(", ");
                }
                winners.append(carNames.get(i));
            }
        }
        System.out.println("최종 우승자 : " + winners);
    }
}
