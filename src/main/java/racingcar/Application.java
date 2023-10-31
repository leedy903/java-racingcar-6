package racingcar;

import java.util.List;

public class Application {
    private static List<Car> cars;
    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}
