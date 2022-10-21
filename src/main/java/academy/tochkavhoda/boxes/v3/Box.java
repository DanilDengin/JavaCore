package academy.tochkavhoda.boxes.v3;

import academy.tochkavhoda.figures.v3.Figure;
import academy.tochkavhoda.iface.v3.HasArea;

public class Box<T extends Figure> implements HasArea {
    private T figure;

    public Box(T figure) {
        this.figure = figure;
    }

    public static boolean isAreaEqual(Box<? extends Figure> figure1, Box<? extends Figure> figure2) {
        double eps = 0.000001;
        return Math.abs(figure1.getArea() - figure2.getArea()) < eps;
    }

    public T getContent() {
        return figure;
    }

    public void setContent(T figure) {
        this.figure = figure;
    }

    @Override
    public double getArea() {
        return figure.getArea();
    }

    public boolean isAreaEqual(Box<? extends Figure> figure) {
        double eps = 0.000001;
        return Math.abs(this.getArea() - figure.getArea()) < eps;
    }
}
