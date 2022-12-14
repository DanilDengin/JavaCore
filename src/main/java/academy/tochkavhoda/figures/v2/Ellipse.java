package academy.tochkavhoda.figures.v2;

import academy.tochkavhoda.iface.v2.HasArea;
import academy.tochkavhoda.iface.v2.Movable;
import academy.tochkavhoda.iface.v2.Stretchable;

public class Ellipse extends Figure implements Movable, Stretchable, HasArea {
    private int xCenter, yCenter, xAxis, yAxis;

    public Ellipse(Point center, int xAxis, int yAxis) {
        xCenter = center.getX();
        yCenter = center.getY();
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xCenter, int yCenter, int xAxis, int yAxis) {
        this.xCenter = xCenter;
        this.yCenter = yCenter;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse(int xAxis, int yAxis) {
        xCenter = 0;
        yCenter = 0;
        this.xAxis = xAxis;
        this.yAxis = yAxis;
    }

    public Ellipse() {
        xCenter = 0;
        yCenter = 0;
        xAxis = 1;
        yAxis = 1;
    }

    public Point getCenter() {
        return new Point(xCenter, yCenter);
    }

    public void setCenter(Point center) {
        xCenter = center.getX();
        yCenter = center.getY();
    }

    public int getXAxis() {
        return xAxis;
    }

    public void setXAxis(int xAxis) {
        this.xAxis = xAxis;
    }

    public int getYAxis() {
        return yAxis;
    }

    public void setYAxis(int yAxis) {
        this.yAxis = yAxis;
    }

    public void moveTo(Point point) {
        xCenter = point.getX();
        yCenter = point.getY();
    }

    @Override
    public void moveTo(int x, int y) {
        xCenter = x;
        yCenter = y;
    }

    public void moveRel(int dx, int dy) {
        xCenter += dx;
        yCenter += dy;
    }

    public void resize(double ratio) {
        xAxis = (int) (xAxis * ratio);
        yAxis = (int) (yAxis * ratio);
    }

    public void stretch(double xRatio, double yRatio) {
        xAxis = (int) (xAxis * xRatio);
        yAxis = (int) (yAxis * yRatio);
    }

    public double getArea() {
        return xAxis * yCenter * Math.PI / 4;
    }

    public double getPerimeter() {
        return 2 * Math.PI * Math.sqrt((double) (xAxis * xAxis + yAxis * yAxis) / 8);
    }


    public boolean isInside(int x, int y) {
        return ((x - xCenter) * (x - xCenter) / (xAxis / 2 * xAxis / 2) + (y - yCenter) * (y - yCenter) / (yAxis / 2 * yAxis / 2)) <= 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ellipse ellipse = (Ellipse) o;

        if (xCenter != ellipse.xCenter) return false;
        if (yCenter != ellipse.yCenter) return false;
        if (xAxis != ellipse.xAxis) return false;
        return yAxis == ellipse.yAxis;
    }

    @Override
    public int hashCode() {
        int result = xCenter;
        result = 31 * result + yCenter;
        result = 31 * result + xAxis;
        result = 31 * result + yAxis;
        return result;
    }
}
