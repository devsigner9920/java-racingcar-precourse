package racinggame.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import racinggame.utils.RandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class RandomMovingStrategyTest {
  @ParameterizedTest
  @DisplayName("랜덤 값이 4 이상일 경우 이동가능하다.")
  @ValueSource(ints = {4, 5, 6, 7, 8, 9})
  public void moveRandomNumberIsFour(int randomNumber) {
    try(MockedStatic<RandomNumberGenerator> mockedRandom = Mockito.mockStatic(RandomNumberGenerator.class)) {
      mockedRandom.when(RandomNumberGenerator::generate)
        .thenReturn(randomNumber);
      MovingStrategy movingStrategy = new RandomMovingStrategy();

      assertThat(movingStrategy.isMoving()).isTrue();
    }
  }

  @ParameterizedTest
  @DisplayName("랜덤 값이 4 이하일 경우 이동이 불가능하다.")
  @ValueSource(ints = {0, 1, 2, 3})
  public void stopRandomNumberIsFourUnder(int randomNumber) {
    try(MockedStatic<RandomNumberGenerator> mockedRandom = Mockito.mockStatic(RandomNumberGenerator.class)) {
      mockedRandom.when(RandomNumberGenerator::generate)
        .thenReturn(randomNumber);
      MovingStrategy movingStrategy = new RandomMovingStrategy();

      assertThat(movingStrategy.isMoving()).isFalse();
    }
  }
}