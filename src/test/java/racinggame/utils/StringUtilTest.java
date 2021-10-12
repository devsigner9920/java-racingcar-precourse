package racinggame.utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class StringUtilTest {
  @ParameterizedTest
  @ValueSource(strings = {"tommy,test,comma"})
  @DisplayName("문자열을 쉼표(,)로 구분하여 리스트 형태로 반환한다.")
  public void separateStringByComma(String string) {
    assertThat(StringUtil.separateStringByComma(string).size()).isEqualTo(3);
  }

  @Test
  @DisplayName("입력 받은 숫자 만큼 프로그레스 바를 생성한다.")
  public void numberToProgressString() {
    // given
    int testNumber = 5;

    // when
    String progress = StringUtil.numberToProgressString(testNumber);

    // then
    assertThat(progress).isEqualTo("-----");
  }

  @Test
  @DisplayName("문자열 리스트를 쉼표(,)로 구분하여 문자열 형태로 반환한다.")
  public void joinListToString() {
    // given
    List<String> strings = Arrays.asList("tommy", "test", "comma");

    // when
    String string = StringUtil.joinListToString(strings);

    // then
    assertThat(string).isEqualTo("tommy,test,comma");
  }
}
