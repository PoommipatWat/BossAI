[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=9620066&assignment_repo_type=AssignmentRepo)
# 261200-Lab04

## Encapsulation (setter)

When we declare fields `private`, we are essentially preventing client code from accessing object properties directly. As we saw earlier, client code can only read these properties via getter methods, like `getX()` in class `Point`. What if we want to modify these properties? We need to use **setters**.

In fact, we've already seen setters earlier, in the previous lab, when we implemented `setSize` method in class `Spacecraft`. There, our goal is to change the dimensions of a spacecraft. The setter method is another conventional method that takes a parameter, updates the designated field, and gives no output.

- [ ] **Lab04_1**: Your first task for this lab is to implement setter methods, `setX` and `setY`, for the `x`- and `y`-coordinates in class `Point`. Assume that the coordinates can be any integers and no validation is needed yet. The client code shows examples of using setters.

```
// Client code's main method
Point mareTranquilitatis = new Point();            // x=0, y=0
System.out.println(mareTranquilitatis.toString()); // "(0, 0)"
mareTranquilitatis.setX(50);                       // x=50, y=0
System.out.println(mareTranquilitatis.toString()); // "(50, 0)"
mareTranquilitatis.setY(-50);                      // x=50, y=-50
System.out.println(mareTranquilitatis.toString()); // "(50, -50)"
```

- [ ] **Lab04_2**: Next, implement a method called `setPosition` in `Spacecraft` that takes two arguments, the `x`- and `y`-coordinates of the new position (`Point` instance) of the spacecraft. When called, the method should set the spacecraft's position by calling the provided setter methods. Below is an example of using `setPosition`.

```
// Client code's main method
Spacecraft apollo13 = new Spacecraft(3, 5);            // width=3, height=5, x=0, y=0
System.out.println(apollo13.getPosition().toString()); // "(0, 0)"
apollo13.setPosition(50, 50);                          // x=50, y=50
System.out.println(apollo13.getPosition().toString()); // "(50, 50)"
```

*You will need to fix and complete the other parts of the classes, `Point` and `Spacecraft` using what you already learned from the previous labs.*

## Houston, we've had a problem

Simply adding setters to the class can lead to unintended consequences. 
The following code shows that arbitrary code, for example, calling setters of `Point` in client code can change the properties of an object of `Spacecraft` in an implicit way.

```
// Spacecraft class
public class Spacecraft {
    ...
  private Point position;
    ...
  public Point getPosition(){
    return this.position;
  }
}
```

We clearly see that the field `position` of class `Spacecraft` is encapsulated and no setter method is provided, so it shouldn't be modified. However, look at what's happening in the client code below carefully.

```
// Client code's main method
Spacecraft s1 = new Spacecraft(3,4,2,2);
Point p1 = s1.getPosition();             // p1 = (2, 2), s1.position = (2, 2)
p1.setX(5);                              // p1 = (5, 2)
System.out.println(s1.getPosition());    // s1.position: (5, 2) -> UNWANTED!
```

In the example code, we assign a point `p1` by calling `getPosition` of the spacecraft `s1`. Then, we change `x`-coordinate of `p1`. So `p1` gets updated. Everything looks normal at this moment. However, if we check `x`-coordinate of `position` of `s1`, we will see that it is also changed. This scenario is unwanted, because the spacecraft itself doesn't know that its property is being changed.

By calling `p1 = s1.getPosition()`, `p1` will get the reference to the private object `position` of `s1`, therefore modifying `p1` means modifying `position` of `s1`. We consider this getter method a "**privacy leaking getter**". In other words, we are violating the abstraction barrier between a spacecraft object and client code, because changing a spacecraft's position should be done through the spacecraft object itself. We should carefully design and implement our getter/setter methods to avoid this. There are many approaches to prevent privacy leaking, for example, we can simply change getter to return a new instance instead of the field of the current object. 

- [ ] **Lab04_3**: Change the `getPosition` method to return anonymous object of `Point` instead of `position` as shown below, given `x` and `y` are `int` (primitive data type).

```
// Spacecraft class
public class Spacecraft {
    ...
  private Point position;
    ...
  public Point getPosition(){
    return new Point(this.position.getX(), this.position.getY());
  }
}
```

Therefore, the changing `p1` won't affect `position` of `s1` (internal state) anymore.

```
// Client code's main method
Spacecraft s1 = new Spacecraft(3,4,2,2);
Point p1 = s1.getPosition();             // p1 = (2, 2), s1.position = (2, 2)
p1.setX(5);                              // p1 = (5, 2)
System.out.println(s1.getPosition());    // s1.position: (2, 2) -> NO CHANGE!
```

Whenever practical, you don't have to always define getter/setter methods for fields, you will rather need to think and provide only what the client really wants to do to the fields.

**Do your own work, avoid copying, and avoid cheating at all costs. Your future depends on the choice you make today.**

_Chinawat Isradisaikul and Navadon Khunlertgit_

_261200 Object-Oriented Programming, Department of Computer Engineering, Chiang Mai University_
