package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private Integer drivingDistance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getDrivingDistance() {
        return drivingDistance;
    }

    public void goForward() {
        drivingDistance += 1;
    }

    public void showResult() {
        StringBuilder result = new StringBuilder();
        result.append(name).append(" : ");
        for(int i = 0; i < drivingDistance; i++) {
            result.append("-");
        }
        System.out.println(result);
    }

}
