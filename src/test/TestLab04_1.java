import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

public class TestLab04_1 {

  @Test
  public void test() {
    Point p1 = new Point();
    assertEquals(0, p1.getX());
    assertEquals(0, p1.getY());
    p1.setX(50);
    assertEquals(50, p1.getX());
    assertEquals(0, p1.getY());
    p1.setX(-50);
    assertEquals(-50, p1.getX());
    assertEquals(0, p1.getY());
    p1.setY(5);
    assertEquals(-50, p1.getX());
    assertEquals(5, p1.getY());
    p1.setY(-5);
    assertEquals(-50, p1.getX());
    assertEquals(-5, p1.getY());

    Point p2 = new Point(7,7);
    assertEquals(7, p2.getX());
    assertEquals(7, p2.getY());
    p2.setX(70);
    assertEquals(70, p2.getX());
    assertEquals(7, p2.getY());
    p2.setX(-70);
    assertEquals(-70, p2.getX());
    assertEquals(7, p2.getY());
    p2.setY(5);
    assertEquals(-70, p2.getX());
    assertEquals(5, p2.getY());
    p2.setY(-7);
    assertEquals(-70, p2.getX());
    assertEquals(-7, p2.getY());

  }
}