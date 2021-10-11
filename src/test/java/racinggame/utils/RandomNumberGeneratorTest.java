package racinggame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class RandomNumberGeneratorTest {
  @Test
  @DisplayName("1-9 사이의 랜덤한 수를 생성한다.")
  public void generate() {
    int randomNumber = RandomNumberGenerator.generate();

    assertThat(randomNumber >= 1 && randomNumber <= 9).isTrue();
  }
}