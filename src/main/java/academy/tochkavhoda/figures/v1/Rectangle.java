package academy.tochkavhoda.figures.v1;

public class Rectangle {
    private int xLeft, yTop, xRight, yBottom;

    public Rectangle(Point leftTop, Point rightBottom) {
        xLeft = leftTop.getX();
        xRight = rightBottom.getX();
        yBottom = rightBottom.getY();
        yTop = leftTop.getY();
    }

    public Rectangle(int xLeft, int yTop, int xRight, int yBottom) {
        this.xLeft = xLeft;
        this.yTop = yTop;
        this.xRight = xRight;
        this.yBottom = yBottom;
    }

    public Rectangle(int length, int width) {
        this(0, -width, length, 0);
    }

    public Rectangle() {
        this(0, -1, 1, 0);
    }

    public Point getTopLeft() {
        return new Point(xLeft, yTop);
    }

    public void setTopLeft(Point topLeft) {
        xLeft = topLeft.getX();
        yTop = topLeft.getY();
    }

    public Point getBottomRight() {
        return new Point(xRight, yBottom);
    }

    public void setBottomRight(Point bottomRight) {
        xRight = bottomRight.getX();
        yBottom = bottomRight.getY();
    }

    public int getLength() {
        return (xRight - xLeft);
    }

    public int getWidth() {
        return (yBottom - yTop);
    }

    public void moveTo(int x, int y) {
        int Dx = -xLeft + xRight;
        int Dy = yBottom - yTop;
        xLeft = x;
        yTop = y;
        xRight = x + Dx;
        yBottom = y + Dy;
    }

    public void moveTo(Point point) {
        int dx = -xLeft + xRight;
        int dy = yBottom - yTop;
        xLeft = point.getX();
        yTop = point.getY();
        xRight = dx + point.getX();
        yBottom = dy + point.getY();

    }

    public void moveRel(int dx, int dy) {
        xRight += dx;
        yBottom += dy;
        xLeft += dx;
        yTop += dy;
    }

    public void resize(double ratio) {
        int dx = -xLeft + xRight;
        int dy = yBottom - yTop;
        xRight = (int) (xLeft + dx * ratio);
        yBottom = (int) (yTop + dy * ratio);
    }

    public void stretch(double xRatio, double yRatio) {
        int dx = -xLeft + xRight;
        int dy = yBottom - yTop;
        xRight = (int) (xLeft + dx * xRatio);
        yBottom = (int) (yTop + dy * yRatio);
    }

    public double getArea() {
        int length = -xLeft + xRight;
        int width = yBottom - yTop;
        return length * width;
    }

    public double getPerimeter() {
        int length = -xLeft + xRight;
        int width = yBottom - yTop;
        return 2 * length + 2 * width;
    }

    public boolean isInside(int x, int y) {
        return x >= xLeft & x <= xRight & y <= yBottom & y >= yTop;
    }

    public boolean isInside(Point point) {
        int x = point.getX();
        int y = point.getY();
        return x >= xLeft & x <= xRight & y <= yBottom & y >= yTop;
    }

    public boolean isIntersects(Rectangle rectangle) {
        boolean left = rectangle.getBottomRight().getX() < this.xLeft;
        boolean right = rectangle.getTopLeft().getX() > this.xRight;
        boolean up = rectangle.getTopLeft().getY() > this.yBottom;
        boolean down = rectangle.getBottomRight().getY() < this.yTop;
        return !(left || right || up || down);
    }

    public boolean isInside(Rectangle rectangle) {
        return rectangle.getTopLeft().getX() >= this.xLeft & rectangle.getBottomRight().getX() <= this.xRight & rectangle.getBottomRight().getY() <= this.yBottom & rectangle.getTopLeft().getY() >= this.yTop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Rectangle rectangle = (Rectangle) o;

        if (xLeft != rectangle.xLeft) return false;
        if (yTop != rectangle.yTop) return false;
        if (xRight != rectangle.xRight) return false;
        return yBottom == rectangle.yBottom;
    }
}
