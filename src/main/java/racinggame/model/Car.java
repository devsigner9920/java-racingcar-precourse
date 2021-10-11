package racinggame.model;

import java.util.Objects;

public class Car {
  private final String name;
  private int position;

  public Car(String name) {
    this.name = name;
    position = 0;
  }

  public String getName() {
    return name;
  }

  public int getPosition() {
    return position;
  }

  public void move(MovingStrategy movingStrategy) {
    if (movingStrategy.isMoving()) {
      position++;
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return position == car.position && name.equals(car.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, position);
  }
}
