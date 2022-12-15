class Spacecraft {
  private int width;
  private int height;
  private Point position; 
  
  public Spacecraft() {
    // TODO: pass 1 to both width & height
    this(1);
  }

  public Spacecraft(int side) {
    // TODO: pass side to both width & height
    this(side,side);
  }

  public Spacecraft(int width, int height) {
    // TODO: pass width to width, height to height, and (0, 0) to position
    this(width,height,0,0);
  }

  public Spacecraft(int width, int height, int x, int y) {
    this.width = (width > 1) ? width : 1;
    this.height = (height > 1) ? height : 1;
    // TODO: invoke the constructor that takes x and y
    this.position = new Point(x,y); 
  }

  // FIXME: incorrect return type
  public Point getPosition(){
    // TODO: return a Point with x and y (from the current object)
    return new Point(this.position.getX(), this.position.getY());
  }

  // FIXME: incorrect return type
  public int getWidth(){
    // TODO: return width of the current object
    return this.width;
  }

  // FIXME: incorrect return type
  public int getHeight(){
    // TODO: return height of the current object
    return this.height;
  }

  public void setPosition(int x, int y) {
    // TODO: call setters of x and y for the position of the current object
    this.position.setX(x);
    this.position.setY(y);
  }
}
