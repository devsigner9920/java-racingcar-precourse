package racinggame.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
  Cars cars;
  String[] carArray;

  @BeforeEach
  void setUp() {
    carArray = new String[]{"tommy", "pobi", "이니셜D", "슈마허"};
    cars = new Cars(Arrays.asList(carArray));
  }

  @Test
  @DisplayName("컬렉션에 등록된 모든 차를 움직인다.")
  public void moveAllCar() {
    List<Car> carList = cars.getCars();
    carList.forEach(car -> car.move(CarsTest::isMoving));
    carList.forEach(car -> assertThat(car.getPosition()).isEqualTo(1));
  }

  @Test
  @DisplayName("컬렉션에 등록된 모든 차를 움직이지 않는다.")
  public void notMoveAllCar() {
    List<Car> carList = cars.getCars();
    carList.forEach(car -> car.move(CarsTest::isNotMoving));
    carList.forEach(car -> assertThat(car.getPosition()).isEqualTo(0));
  }

  @Test
  @DisplayName("컬렉션에 등록된 차들의 포지션 맥스 값을 구한다.")
  public void getMaxPosition() {
    List<Car> carList = cars.getCars();
    carList.get(0).move(CarsTest::isMoving);
    assertThat(cars.getMaxPosition()).isEqualTo(1);
  }

  @Test
  @DisplayName("컬렉션에 등록된 차들 중 가장 많이 전진한 차를 구한다.")
  public void getMaxMovedCars() {
    List<Car> carList = cars.getCars();
    carList.get(0).move(CarsTest::isMoving);
    carList.get(1).move(CarsTest::isMoving);
    List<Car> maxMovedCars = new ArrayList<>();
    carList.forEach(car -> {
      setMaxMovedCar(maxMovedCars, car);
    });

    assertThat(maxMovedCars.get(0).getName()).isEqualTo("tommy");
    assertThat(maxMovedCars.get(1).getName()).isEqualTo("pobi");
  }

  private void setMaxMovedCar(List<Car> maxMovedCars, Car car) {
    if (car.getPosition() == cars.getMaxPosition()) {
      maxMovedCars.add(car);
    }
  }

  private static boolean isNotMoving() {
    return false;
  }

  private static boolean isMoving() {
    return true;
  }
}
