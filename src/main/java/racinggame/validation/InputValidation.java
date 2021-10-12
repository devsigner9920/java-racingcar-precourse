package racinggame.validation;


import racinggame.constant.ErrorMessage;
import racinggame.exception.InputDuplicateException;
import racinggame.exception.InputNotAllowedException;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;

import static racinggame.constant.ErrorMessage.*;

public class InputValidation {
  private static Pattern pattern = Pattern.compile("^[0-9]*$");
  public static void checkNamesSeparateByComma(List<String> names) {
    if (names.size() <= 1) {
      throw new InputNotAllowedException(INPUT_NOT_SEPARATED_ERROR_MESSAGE);
    }
  }


  public static void checkNamesDuplicate(List<String> names) {
    Set<String> set = new HashSet<>(names);
    if (names.size() != set.size()) {
      throw new InputDuplicateException();
    }
  }

  public static void checkStringLength(String string) {
    if (string.length() > MAX_NAME_SIZE) {
      throw new InputNotAllowedException(INPUT_OUT_OF_NAME_LENGTH_MESSAGE);
    }
  }

  public static void checkNamesLength(List<String> names) {
    names.forEach(InputValidation::checkStringLength);
  }

  public static void checkStringIsNumber(String string) {
    if (!pattern.matcher(string).matches()) {
      throw new NumberFormatException(INPUT_INVALID_NUMBER_MESSAGE);
    }
  }

  public static void checkNumberSize(int number) {
    if (number < 1) {
      throw new InputNotAllowedException(ErrorMessage.INPUT_INVALID_NUMBER_SIZE_MESSAGE);
    }
  }
}
