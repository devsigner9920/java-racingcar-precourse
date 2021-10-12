package racinggame.exception;

import racinggame.constant.ErrorMessage;

public class InputNotAllowedException extends RuntimeException {
  public InputNotAllowedException(String message) {
    super(message);
  }
}
