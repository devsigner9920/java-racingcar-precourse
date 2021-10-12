package racinggame.validation;

import org.assertj.core.api.ThrowableAssert.ThrowingCallable;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racinggame.exception.InputDuplicateException;
import racinggame.constant.ErrorMessage;
import racinggame.exception.InputNotAllowedException;

import static org.assertj.core.api.Assertions.*;
import static racinggame.utils.StringUtil.*;

public class InputValidationTest {
  @ParameterizedTest
  @ValueSource(strings = {"toby tommy pobi porsche audi", "tomy/test/good", "decision"})
  @DisplayName("입력받은 자동차 이름이 쉼표로 구분되지 않으면 InputNotAllowedException 을 던진다.")
  public void checkNamesSeparateByComma(String input) {
    // when
    ThrowingCallable throwingException = () -> InputValidation.checkNamesSeparateByComma(separateStringByComma(input));

    // then
    assertThatExceptionOfType(InputNotAllowedException.class)
      .isThrownBy(throwingException)
      .withMessage(ErrorMessage.INPUT_NOT_SEPARATED_ERROR_MESSAGE);
  }

  @ParameterizedTest
  @ValueSource(strings = {"toby,tommy,pobi,porsche,audi,pobi"})
  @DisplayName("입력받은 자동차 이름이 중복이면 InputDuplicateException 을 던진다.")
  public void checkInputDuplicate(String input) {
    // when
    ThrowingCallable throwingException = () -> InputValidation.checkNamesDuplicate(separateStringByComma(input));

    // then
    assertThatExceptionOfType(InputDuplicateException.class)
      .isThrownBy(throwingException)
      .withMessage(ErrorMessage.INPUT_DUPLICATE_MESSAGE);
  }

  @ParameterizedTest
  @ValueSource(strings = {"toby,tommy,pobi,porsche,audi"})
  @DisplayName("입력받은 자동차 이름이 5글자를 초과하면 InputNotAllowedException 을 던진다.")
  public void checkNamesLength(String input) {
    // when
    ThrowingCallable throwingException = () -> InputValidation.checkNamesLength(separateStringByComma(input));

    // then
    assertThatExceptionOfType(InputNotAllowedException.class)
      .isThrownBy(throwingException)
      .withMessage(ErrorMessage.INPUT_OUT_OF_NAME_LENGTH_MESSAGE);
  }

  @ParameterizedTest
  @ValueSource(strings = {"2e", "3r", " 1"})
  @DisplayName("입력받은 문자열이 유효한 숫자가 아니라면 NumberFormatException 을 던진다.")
  public void checkStringIsNumber(String input) {
    // when
    ThrowingCallable throwingException = () -> InputValidation.checkStringIsNumber(input);

    // then
    assertThatExceptionOfType(NumberFormatException.class)
      .isThrownBy(throwingException)
      .withMessage(ErrorMessage.INPUT_INVALID_NUMBER_MESSAGE);
  }

  @ParameterizedTest
  @ValueSource(strings = {"0", "-1", "-2"})
  @DisplayName("입력받은 문자열이 1이상이 아니라면 InputNotAllowedException 을 던진다.")
  public void checkNumberSize(String input) {
    // when
    ThrowingCallable throwingException = () -> InputValidation.checkNumberSize(Integer.parseInt(input));

    // then
    assertThatExceptionOfType(InputNotAllowedException.class)
      .isThrownBy(throwingException)
      .withMessage(ErrorMessage.INPUT_INVALID_NUMBER_SIZE_MESSAGE);
  }
}
