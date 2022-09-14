package academy.tochkavhoda.figures.v3;

import academy.tochkavhoda.colors.v3.Color;
import academy.tochkavhoda.colors.v3.ColorErrorCode;
import academy.tochkavhoda.colors.v3.ColorException;
import academy.tochkavhoda.iface.v3.Colored;


import static academy.tochkavhoda.colors.v3.ColorErrorCode.NULL_COLOR;

public class ColoredRectangle extends Rectangle implements Colored {

    private Color color;

    public ColoredRectangle(Point leftTop, Point rightBottom, Color color) throws ColorException {
        super (leftTop, rightBottom);
        if (color == null) {
            throw new ColorException(NULL_COLOR);
        }
        this.color=color;
    }

    public ColoredRectangle(Point leftTop, Point rightBottom,String str) throws ColorException {
        super(leftTop,rightBottom);
        setColor(str);

    }
    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, Color color) {
        super(xLeft, yTop, xRight, yBottom);
        this.color=color;
    }
    public ColoredRectangle(int xLeft, int yTop, int xRight, int yBottom, String str) throws ColorException {
        super(xLeft, yTop, xRight, yBottom);
        setColor(str);
    }

    public ColoredRectangle(int length, int width, Color color) {
        super(length, width);
        this.color=color;
    }
    public ColoredRectangle(int length, int width, String str) throws ColorException {
        super(length, width);
        setColor(str);
    }

    public ColoredRectangle(Color color) throws ColorException {
        super();
        if (color == null) {
            throw new ColorException(NULL_COLOR);
        }
        this.color=color;
    }
    public ColoredRectangle(String str) throws ColorException {
        super();
        setColor(str);
    }

    public ColoredRectangle() throws ColorException {
        this(Color.RED);
    }

    public Color getColor() {
        return color;
    }

    @Override
    public void setColor(String colorString) throws ColorException {
        try {
            setColor(Color.valueOf(colorString));
        } catch (IllegalArgumentException ex) {
            throw new ColorException(ColorErrorCode.WRONG_COLOR_STRING);
        }
        catch (NullPointerException ex) {
            throw new ColorException(ColorErrorCode.NULL_COLOR);
        }
    }

    public void setColor(Color color) throws ColorException {
        if (color == null) {
            throw new ColorException(NULL_COLOR);
        }
        this.color=color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;

        ColoredRectangle that = (ColoredRectangle) o;

        return color == that.color;
    }

    @Override
    public int hashCode() {
        return color != null ? color.hashCode() : 0;
    }
}
