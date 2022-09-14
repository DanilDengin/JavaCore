package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.iface.v3.HasArea;
import academy.tochkavhoda.iface.v3.Movable;
import academy.tochkavhoda.iface.v3.Resizable;

public class Square extends Figure implements Movable, Resizable, HasArea {
    private int yTop, xLeft,yBottom, xRight, size;

    public Square(Point leftTop, int size) {
        this.xLeft= leftTop.getX();
        this.yTop=leftTop.getY();
        this.xRight=this.xLeft + size;
        this.yBottom= this.yTop + size;
    }

    public Square(int xLeft, int yTop, int size) {
        this.xLeft= xLeft;
        this.yTop=yTop;
        this.xRight=this.xLeft + size;
        this.yBottom= this.yTop + size;
    }


    public Square(int size) {
        xLeft= 0;
        yBottom= 0;
        xRight= size;
        yTop = -size;
    }

    public Square() {
        xLeft= 0;
        yBottom= 0;
        xRight= 1;
        yTop = -1;
    }

    public Point getTopLeft() {
        return new Point(xLeft,yTop);
    }

    public Point getBottomRight() {
        return new Point(xRight,yBottom);
    }

    public void setTopLeft(Point topLeft) {
        size=this.xRight-this.xLeft;
        this.xLeft = topLeft.getX();
        this.yTop = topLeft.getY();
        this.xRight=this.xLeft+size;
        this.yBottom=this.yTop+size;
    }

    public int getLength() {
        return xRight-xLeft;
    }

    public void moveTo(int x, int y) {
        size=this.xRight-this.xLeft;
        this.xLeft= x;
        this.yTop=y;
        this.xRight=this.xLeft + size;
        this.yBottom= this.yTop + size;
    }

    public void moveRel(int dx, int dy) {
        xLeft+=dx;
        xRight+=dx;
        yBottom+=dy;
        yTop+=dy;
    }

    public void resize(double ratio) {
        int size=-xLeft+xRight;
        xRight= (int) (xLeft+size*ratio);
        yBottom=(int) (yTop+size*ratio);
    }

    public double getArea() {
        int size=-xLeft+xRight;
        return size*size;
    }

    public double getPerimeter() {
        int size=-xLeft+xRight;
        return size*4;
    }

    public boolean isInside(int x, int y) {
        return x>=xLeft & x<= xRight & y<= yBottom & y>= yTop;
    }



    public boolean isInside(Square square) {
        return square.getTopLeft().getX()>=this.xLeft & square.getBottomRight().getX()<= this.xRight & square.getBottomRight().getY()<= this.yBottom & square.getTopLeft().getY()>= this.yTop;
    }

    public boolean isIntersects(Square square) {
        boolean left = square.getBottomRight().getX()<this.xLeft;
        boolean right = square.getTopLeft().getX()>this.xRight;
        boolean up =square.getTopLeft().getY()>this.yBottom;
        boolean down = square.getBottomRight().getY()<this.yTop;
        return !(left||right||up||down);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Square square = (Square) o;

        if (yTop != square.yTop) return false;
        if (xLeft != square.xLeft) return false;
        if (yBottom != square.yBottom) return false;
        if (xRight != square.xRight) return false;
        return size == square.size;
    }

    @Override
    public int hashCode() {
        int result = yTop;
        result = 31 * result + xLeft;
        result = 31 * result + yBottom;
        result = 31 * result + xRight;
        result = 31 * result + size;
        return result;
    }
}
