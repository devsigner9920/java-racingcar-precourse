package racinggame.exception;

import racinggame.constant.ErrorMessage;

public class InputDuplicateException extends RuntimeException {
  public InputDuplicateException() {
    super(ErrorMessage.INPUT_DUPLICATE_MESSAGE);
  }
}
