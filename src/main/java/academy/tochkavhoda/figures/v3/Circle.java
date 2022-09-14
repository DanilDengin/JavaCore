package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.iface.v3.HasArea;
import academy.tochkavhoda.iface.v3.Movable;
import academy.tochkavhoda.iface.v3.Resizable;

public class Circle extends Figure implements Movable, Resizable, HasArea {
    // REVU по одному полю на строке
     private int radius;
     private int xCenter;
     private int yCenter;

    public Circle(Point center, int radius) {
        this(center.getX(),center.getY(), radius);
    }

    public Circle(int xCenter, int yCenter, int radius) {
        this.xCenter=xCenter;
        this.yCenter=yCenter;
        this.radius=radius;
    }

    public Circle(int radius) {
        this(0,0,radius);
    }

    public Circle() {
        this(0,0,1);
    }

    public Point getCenter() {
        return new Point(xCenter, yCenter);
    }

    public int getRadius() {
        return radius;
    }

    public void setCenter(Point center) {
        xCenter=center.getX();
        yCenter=center.getY();
    }

    public void setRadius(int radius) {
        this.radius=radius;
    }

    public void moveTo(int x, int y){
        xCenter=x;
        yCenter=y;
    }

    public void moveRel(int dx, int dy) {
        xCenter+=dx;
        yCenter+=dy;
    }

    public void resize(double ratio) {
        radius = (int) ( radius * ratio);
    }

    public double getArea() {
        return radius*radius*Math.PI;
    }

    public double getPerimeter() {
        return 2*radius*Math.PI;
    }

    public boolean isInside(int x, int y) {
        return radius>=Math.sqrt((x-xCenter)*(x-xCenter)+(y-yCenter)*(y-yCenter));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Circle circle = (Circle) o;

        if (radius != circle.radius) return false;
        if (xCenter != circle.xCenter) return false;
        return yCenter == circle.yCenter;
    }

    @Override
    public int hashCode() {
        int result = radius;
        result = 31 * result + xCenter;
        result = 31 * result + yCenter;
        return result;
    }
}
