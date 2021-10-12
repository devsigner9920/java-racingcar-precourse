package racinggame.view;

import racinggame.model.Cars;
import racinggame.utils.StringUtil;

import static racinggame.constant.OutputMessage.*;

public class OutputView {
  public static void printStartResultMessage() {
    System.out.println(RACING_GAME_RESULT_START_MESSAGE);
  }

  public static void printRacingGameEachResult(Cars cars) {
    cars.getCars().forEach(car -> {
      System.out.printf(RACING_GAME_EACH_RESULT_MESSAGE,
        car.getName(),
        StringUtil.numberToProgressString(car.getPosition()));
      System.out.println("");
    });
    System.out.println("");
  }

  public static void printRacingGameWinner(String gameWinner) {
    System.out.printf(RACING_GAME_WINNER_MESSAGE, gameWinner);
    System.out.println("");
  }

  public static void printInputCarNamesGuideMessage() {
    System.out.println(RACING_GAME_INPUT_CAR_NAMES_GUIDE_MESSAGE);
  }

  public static void printInputGameCountGuideMessage() {
    System.out.println(RACING_GAME_INPUT_GAME_COUNT_GUIDE_MESSAGE);
  }
}
