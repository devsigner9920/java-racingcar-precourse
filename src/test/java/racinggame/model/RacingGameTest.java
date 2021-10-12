package racinggame.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racinggame.utils.StringUtil;

import java.util.List;

public class RacingGameTest {
  RacingGame racingGame;
  @BeforeEach
  void setUp() {
    List<String> carNameList = StringUtil.separateStringByComma("tommy,pobi,audi");
    racingGame = new RacingGame(new Cars(carNameList), new GameCount(4));
  }

  @Test
  @DisplayName("레이싱 게임 횟수를 0 이하로 설정하면 예외를 던진다.")
  public void setGameCountThrowException() {
    Assertions.assertThatThrownBy(() -> new GameCount(-1))
      .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  @DisplayName("레이싱 게임 횟수를 1 이상으로 설정한다.")
  public void setGameCount() {
    Assertions.assertThat(racingGame.getGameCount().getGameCount()).isEqualTo(4);
  }
}
