package academy.tochkavhoda.figures.v3;

public class CircleFactory  {

private static int  count=0;
private static Circle circle = new Circle( 0);
    public static Circle createCircle(Point center, int radius) {
        count++;
        return circle = new Circle(center, radius);
    }

    public static int getCircleCount() {
        return count;
    }

    public static void reset() {
       count=0;
    }



}
