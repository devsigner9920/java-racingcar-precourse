package racinggame.constant;

public class ErrorMessage {
  public static final String ERROR_PREFIX = "[ERROR] ";
  public static final int MAX_NAME_SIZE = 5;
  public static final String NOT_POSITIVE_GAME_COUNT_MESSAGE =
    ERROR_PREFIX + "1이상의 유효한 숫자를 입력하세요.";
  public static final String INPUT_DUPLICATE_MESSAGE =
    ERROR_PREFIX + "중복된 값이 존재합니다.";
  public static final String INPUT_NOT_SEPARATED_ERROR_MESSAGE =
    ERROR_PREFIX + "쉼표(,)로 구분되지 않는 입력값 입니다.";
  public static final String INPUT_OUT_OF_NAME_LENGTH_MESSAGE =
    ERROR_PREFIX + MAX_NAME_SIZE + "자 이하의 이름을 입력하세요.";
  public static final String INPUT_INVALID_NUMBER_MESSAGE =
    ERROR_PREFIX + "유효한 숫자를 입력하세요.";
  public static final String INPUT_INVALID_NUMBER_SIZE_MESSAGE =
    ERROR_PREFIX + "1이상의 숫자를 입력하세요.";
}
