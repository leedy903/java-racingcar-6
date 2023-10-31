package racingcar;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarTest {

    private static ByteArrayOutputStream outputMessage;

    @BeforeEach
    void setUpStreams() {
        outputMessage = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputMessage));
    }

    @AfterEach
    void restoresStreams() {
        System.setOut(System.out);
    }

    @Test
    @DisplayName("자동차 초기화 테스트")
    void carInitTest() {
        Car car = new Car("pobi");
        assertEquals("pobi", car.getName());
        assertEquals(0, car.getDrivingDistance());
    }

    @Test
    @DisplayName("자동차 거리 이동 테스트")
    void carMoveForwardTest() {
        Car car = new Car("pobi");
        car.moveForward();
        assertEquals(1, car.getDrivingDistance());
    }

    @Test
    @DisplayName("같은 이름 자동차 거리 이동 테스트")
    void duplicatedCarNameMoveForwardTest() {
        Car car1 = new Car("pobi");
        Car car2 = new Car("pobi");
        car1.moveForward();
        assertEquals(1, car1.getDrivingDistance());
        assertEquals(0, car2.getDrivingDistance());
    }

    @Test
    @DisplayName("출력 테스트")
    void showResultTest() {
        Car car = new Car("pobi");
        car.moveForward();
        car.showResult();
        assertEquals("pobi : -\n", outputMessage.toString());
    }

}