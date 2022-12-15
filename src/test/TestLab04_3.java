import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

public class TestLab04_3 {

  @Test
  public void test()
  {
    Spacecraft s4 = new Spacecraft(-3,-4,-1,1);        
    assertEquals(-1, s4.getPosition().getX()); 
    assertEquals(1, s4.getPosition().getY());
    assertEquals("(-1, 1)", s4.getPosition().toString()); 
    
    s4.setPosition(1, -1); 
    assertEquals(1, s4.getPosition().getX()); 
    assertEquals(-1, s4.getPosition().getY());
    assertEquals("(1, -1)", s4.getPosition().toString()); 

    Point p1 = s4.getPosition();
    assertEquals("(1, -1)", p1.toString()); 
    
    p1.setX(5);
    assertEquals(5, p1.getX());
    assertEquals(-1, p1.getY());
    assertEquals("(5, -1)", p1.toString()); 
    assertEquals("(1, -1)", s4.getPosition().toString()); 
    
    p1.setY(-5);
    assertEquals("(5, -5)", p1.toString()); 
    assertEquals("(1, -1)", s4.getPosition().toString()); 

    s4.setPosition(7, 7);
    assertEquals(5, p1.getX());
    assertEquals(-5, p1.getY());
    assertEquals("(5, -5)", p1.toString()); 
    assertEquals(7, s4.getPosition().getX());
    assertEquals(7, s4.getPosition().getY());
    assertEquals("(7, 7)", s4.getPosition().toString()); 
  }
  
}