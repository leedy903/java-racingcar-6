package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class User {

    public User() {
    }

    public String getCarNames() {
        return input();
    }

    public int getRounds() {
        int rounds = 0;
        try {
            rounds = Integer.parseInt(input());
        } catch (Exception e) {
            throw new IllegalArgumentException("Rounds should be number");
        }
        return rounds;
    }

    private String input() {
        String userInput = Console.readLine();
        validateInput(userInput);
        return userInput;
    }

    private void validateInput(String input) {
        validateInputNullCheck(input);
    }

    private void validateInputNullCheck(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }
    }

}
