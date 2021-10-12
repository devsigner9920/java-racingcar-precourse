package racinggame.view;

import nextstep.utils.Console;

import java.util.List;

import static racinggame.utils.StringUtil.*;
import static racinggame.validation.InputValidation.*;

public class InputView {
  public static String inputCarNames() {
    OutputView.printInputCarNamesGuideMessage();
    return inputStringAndVerify();
  }

  public static String inputGameCount() {
    OutputView.printInputGameCountGuideMessage();
    return inputNumberAndVerify();
  }

  private static String inputStringAndVerify() {
    String input = Console.readLine();
    try {
      List<String> names = separateStringByComma(input);
      checkNamesSeparateByComma(names);
      checkNamesDuplicate(names);
      checkNamesLength(names);
      return input;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return inputStringAndVerify();
    }
  }

  private static String inputNumberAndVerify() {
    String input = Console.readLine();
    try {
      checkStringIsNumber(input);
      checkNumberSize(Integer.parseInt(input));
      return input;
    } catch (Exception e) {
      System.out.println(e.getMessage());
      return inputNumberAndVerify();
    }
  }
}
