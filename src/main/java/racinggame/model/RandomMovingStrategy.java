package racinggame.model;

import racinggame.utils.RandomNumberGenerator;

public class RandomMovingStrategy implements MovingStrategy {
  public static final int MOVABLE_NUMBER = 4;
  @Override
  public boolean isMoving() {
    return RandomNumberGenerator.generate() >= MOVABLE_NUMBER;
  }
}
