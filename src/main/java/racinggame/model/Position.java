package racinggame.model;

public class Position {
  private int position;

  public Position(final int position) {
    this.position = position;
  }

  public void increment() {
    position++;
  }

  public int getPosition() {
    return position;
  }
}
