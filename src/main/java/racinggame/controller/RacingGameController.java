package racinggame.controller;

import racinggame.model.*;

import static racinggame.utils.StringUtil.*;
import static racinggame.view.InputView.*;

public class RacingGameController {
  public static void run() {
    Cars cars = new Cars(separateStringByComma(inputCarNames()));
    GameCount gameCount = new GameCount(Integer.parseInt(inputGameCount()));

    RacingGame racingGame = new RacingGame(cars, gameCount);
    racingGame.play(getRandomMovingStrategy());
  }

  private static RandomMovingStrategy getRandomMovingStrategy() {
    return new RandomMovingStrategy();
  }
}
