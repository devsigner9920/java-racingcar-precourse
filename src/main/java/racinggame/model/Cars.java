package racinggame.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cars {
  private final List<Car> cars;

  public Cars(List<String> carNames) {
    this.cars = mapToCars(carNames);
  }

  private List<Car> mapToCars(List<String> carNames) {
    List<Car> carList = new ArrayList<>();
    carNames.forEach(carName -> carList.add(new Car(new Name(carName))));
    return carList;
  }

  public List<Car> getCars() {
    return cars;
  }

  public int getMaxPosition() {
    return Collections.max(getPositions());
  }

  private List<Integer> getPositions() {
    List<Integer> positionList = new ArrayList<>();
    cars.forEach(car -> positionList.add(car.getPosition()));
    return positionList;
  }

  public List<Car> getMaxMovedCars() {
    List<Car> maxMovedCars = new ArrayList<>();
    cars.forEach(car -> setMaxMovedCar(maxMovedCars, car));

    return maxMovedCars;
  }

  public List<String> getMaxMovedCarNames() {
    List<String> maxMovedCarNames = new ArrayList<>();
    getMaxMovedCars().forEach(car -> maxMovedCarNames.add(car.getName()));

    return maxMovedCarNames;
  }

  private void setMaxMovedCar(List<Car> maxMovedCars, Car car) {
    if (car.getPosition() == getMaxPosition()) {
      maxMovedCars.add(car);
    }
  }

  public void moveAllCar(MovingStrategy movingStrategy) {
    cars.forEach(car -> car.move(movingStrategy));
  }
}
