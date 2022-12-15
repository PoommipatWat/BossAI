public class Point {
  private int x;
  private int y;

  public Point(){
    // NOTE: invoke constructor taking 2 arguments by passing 0 and 0
    this(0,0);
  }
  
  public Point(int x, int y){
    // NOTE: initiate x and y of the current object, respectively
    this.x = x;
    this.y = y;
  }
  
  public int getX() {
    return this.x; 
  }
  
  public int getY() {
    return this.y;
  }

  public void setX(int x) {
    // TODO: assign x to x of the current object
    this.x = x;
  }

  public void setY(int y) {
    // TODO: assign y to y of the current object
    this.y = y;
  }

  public String toString(){
    return "(" + this.x + ", " + this.y + ")";
  }
}
