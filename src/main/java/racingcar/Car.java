package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {

    private String name;
    private Integer drivingDistance = 0;

    public Car(String name) {
        validateName(name);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Integer getDrivingDistance() {
        return drivingDistance;
    }

    private void validateName(String name) {
        validateNameInComma(name);
        validateNameLength(name);
    }

    private void validateNameInComma(String name) {
        if (name.contains(",")) {
            throw new IllegalArgumentException("Name cannot contains ',' character");
        }
    }

    private void validateNameLength(String name) {
        if (name.length() == 0 || name.length() > 5) {
            throw new IllegalArgumentException("Name length should be longer than no more than 5 characters");

        }
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
