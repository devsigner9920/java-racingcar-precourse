package racinggame.utils;

import nextstep.utils.Randoms;

public class RandomNumberGenerator {
  public static final int MIN_RANDOM_NUMBER = 0;
  public static final int MAX_RANDOM_NUMBER = 9;

  public static int generate() {
    return Randoms.pickNumberInRange(MIN_RANDOM_NUMBER, MAX_RANDOM_NUMBER);
  }
}
