package racinggame.model;

import racinggame.utils.StringUtil;
import racinggame.view.OutputView;

public class RacingGame {
  private final Cars cars;
  private final GameCount gameCount;

  public RacingGame(Cars cars, GameCount gameCount) {
    this.cars = cars;
    this.gameCount = gameCount;
  }

  public void play(MovingStrategy movingStrategy) {
    OutputView.printStartResultMessage();
    for (int i = 0; i < gameCount.getGameCount(); i++) {
      cars.moveAllCar(movingStrategy);

      OutputView.printRacingGameEachResult(cars);
    }
    OutputView.printRacingGameWinner(StringUtil.joinListToString(cars.getMaxMovedCarNames()));
  }

  public GameCount getGameCount() {
    return gameCount;
  }
}
