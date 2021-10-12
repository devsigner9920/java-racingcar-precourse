package racinggame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
  private Car car;

  private static boolean isMoving() {
    return true;
  }

  private static boolean isNotMoving() {
    return false;
  }

  @BeforeEach
  void setUp() {
    car = new Car(new Name("Tommy"));
  }

  @Test
  @DisplayName("Car 객체 생성")
  public void makeCar() {
    assertThat(car.getName()).isEqualTo("Tommy");
  }

  @Test
  @DisplayName("자동차가 전진한다.")
  public void moveCar() {
    car.move(CarTest::isMoving);
    assertThat(car.getPosition()).isEqualTo(1);
  }

  @Test
  @DisplayName("자동차가 멈춰있다.")
  public void notMoveCar() {
    car.move(CarTest::isNotMoving);
    assertThat(car.getPosition()).isEqualTo(0);
  }
}
