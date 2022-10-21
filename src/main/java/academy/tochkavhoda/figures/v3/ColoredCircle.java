package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;

import static academy.tochkavhoda.colors.v3.ColorErrorCode.NULL_COLOR;

public class ColoredCircle extends Circle implements Colored {
    private Color color;

    public ColoredCircle(Point center, int radius, Color color) throws ColorException {
        this(center.getX(), center.getY(), radius, color);
    }

    public ColoredCircle(Point center, int radius, String str) throws ColorException {
        super(center.getX(), center.getY(), radius);
        setColor(str);
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, String str) throws ColorException {
        super(xCenter, yCenter, radius);
        setColor(str);
    }

    public ColoredCircle(int xCenter, int yCenter, int radius, Color color) throws ColorException {
        super(xCenter, yCenter, radius);
        if (color == null) {
            throw new ColorException(NULL_COLOR);
        }
        this.color = color;
    }

    public ColoredCircle(int radius, Color color) throws ColorException {
        this(0, 0, radius, color);
    }

    public ColoredCircle(int radius, String str) throws ColorException {
        this(0, 0, radius, str);
    }

    public ColoredCircle(Color color) throws ColorException {
        this(0, 0, 1, color);
    }

    public ColoredCircle(String str) throws ColorException {
        this(0, 0, 1, str);
    }

    public ColoredCircle() throws ColorException {
        this(Color.RED);
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(NULL_COLOR);
        }
        this.color = color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        setColor(Color.colorFromString(colorString));
    }
}