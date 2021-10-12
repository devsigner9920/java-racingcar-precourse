package racinggame.utils;

import java.util.Arrays;
import java.util.List;

public class StringUtil {

  private static final String DEFAULT_SEPARATOR = ",";
  private static final String DEFAULT_PROGRESS = "-";

  public static List<String> separateStringByComma(String string) {
    return Arrays.asList(string.split(DEFAULT_SEPARATOR));
  }

  public static String numberToProgressString(int number) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < number; i++) {
      sb.append(DEFAULT_PROGRESS);
    }
    return sb.toString();
  }
  
  public static String joinListToString(List<String> strings) {
    return String.join(DEFAULT_SEPARATOR, strings);
  }
}
