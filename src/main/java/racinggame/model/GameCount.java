package racinggame.model;

import racinggame.constant.ErrorMessage;

public class GameCount {
  private int gameCount;

  public GameCount(final int gameCount) {
    validatePositiveGameCount(gameCount);
    this.gameCount = gameCount;
  }

  private void validatePositiveGameCount(int gameCount) {
    if (gameCount <= 0) {
      throw new IllegalArgumentException(String.format(ErrorMessage.NOT_POSITIVE_GAME_COUNT_MESSAGE, gameCount));
    }
  }

  public int getGameCount() {
    return gameCount;
  }
}
