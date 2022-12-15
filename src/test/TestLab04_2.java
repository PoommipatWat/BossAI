import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.io.*;

public class TestLab04_2 {

  @Test
  public void test()
  {
    Spacecraft s1 = new Spacecraft();        
    assertEquals("(0, 0)", s1.getPosition().toString());  
    s1.setPosition(0, -5); 
    assertEquals(0, s1.getPosition().getX()); 
    assertEquals(-5, s1.getPosition().getY());
    assertEquals("(0, -5)", s1.getPosition().toString()); 

    Spacecraft s2 = new Spacecraft(5);        
    assertEquals("(0, 0)", s2.getPosition().toString()); 
    s2.setPosition(50, 5); 
    assertEquals(50, s2.getPosition().getX()); 
    assertEquals(5, s2.getPosition().getY());
    assertEquals("(50, 5)", s2.getPosition().toString());

    Spacecraft s3 = new Spacecraft(3,4);        
    assertEquals("(0, 0)", s3.getPosition().toString()); 
    s3.setPosition(-5, 50); 
    assertEquals(-5, s3.getPosition().getX()); 
    assertEquals(50, s3.getPosition().getY());
    assertEquals("(-5, 50)", s3.getPosition().toString()); 
  }
  
}
