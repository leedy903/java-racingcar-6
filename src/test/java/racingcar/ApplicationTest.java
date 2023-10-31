package racingcar;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    private static final int MOVING_FORWARD = 4;
    private static final int STOP = 3;

    @Test
    void 전진_정지() {
        assertRandomNumberInRangeTest(
            () -> {
                run("pobi,woni", "1");
                assertThat(output()).contains("pobi : -", "woni : ", "최종 우승자 : pobi");
            },
            MOVING_FORWARD, STOP
        );
    }

    @Test
    @DisplayName("중복된 자동차 이름")
    void duplicateCarName() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("pobi,pobi", "1");
                    assertThat(output()).contains("pobi : -", "pobi : -", "최종 우승자 : pobi, pobi");
                },
                MOVING_FORWARD, MOVING_FORWARD
        );
    }

    @Test
    @DisplayName("자동차 이름이 6자 이상인 경우")
    void 이름에_대한_예외_처리() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,javaji", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 입력이 쉼표인 경우")
    void carNamesIsComma() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 입력이 쉼표들로만 구성된 경우")
    void carNamesOnlyContainsComma() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 입력이 쉼표로 시작한 경우")
    void carNamesStartWithComma() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",pobi,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 입력이 쉼표들로 시작한 경우")
    void carNamesStartWithCommas() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(",,,pobi,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 입력 중간에 쉼표가 여러 번 들어간 경우")
    void carNamesContainsDuplicatedComma() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,,,woni", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 입력 마지막이 쉼표인 경우")
    void carNamesEndWithComma() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("자동차 이름 입력 마지막이 쉼표들인 경우")
    void carNamesEndWithCommas() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni,,,", "1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도할 횟수가 음수인 경우")
    void roundsIsNegative() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "-1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도할 횟수가 int 범위를 벗어난 경우")
    void RoundsBiggerThanMaxInteger() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "10,000,000,000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("시도할 횟수가 숫자 타입이 아닌 경우")
    void RoundsIsNotInteger() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("pobi,woni", "1a"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
