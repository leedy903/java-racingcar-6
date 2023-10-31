package racingcar;

public class Car {

    private String name;
    private Integer drivingDistance = 0;
    private final int MAX_LENGTH = 5;

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
        if (name.length() == 0 || name.length() > MAX_LENGTH) {
            throw new IllegalArgumentException("Name length should be longer than 0 and no more than " + MAX_LENGTH + "characters");

        }
    }

    public void moveForward() {
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
