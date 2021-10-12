package racinggame.model;

import java.util.Objects;

public class Car {
  private final Name name;
  private Position position;

  public Car(Name name) {
    this.name = name;
    position = new Position(0);
  }

  public String getName() {
    return name.getName();
  }

  public int getPosition() {
    return position.getPosition();
  }

  public void move(MovingStrategy movingStrategy) {
    if (movingStrategy.isMoving()) {
      position.increment();
    }
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return name.equals(car.name) && position.equals(car.position);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, position);
  }
}
