package academy.tochkavhoda.boxes.v3;

import academy.tochkavhoda.figures.v3.Figure;
import academy.tochkavhoda.iface.v3.HasArea;

public class PairBox<T extends Figure, V extends Figure> implements HasArea {
    private T ContentFirst;
    private V ContentSecond;

    public PairBox(T contentFirst, V contentSecond) {
        ContentFirst = contentFirst;
        ContentSecond = contentSecond;
    }

    public static boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> pb1, PairBox<? extends Figure, ? extends Figure> pb2) {
        double eps = 0.000001;
        return Math.abs(pb1.getArea() - pb2.getArea()) < eps;
    }

    public T getContentFirst() {
        return ContentFirst;
    }

    public void setContentFirst(T contentFirst) {
        ContentFirst = contentFirst;
    }

    public V getContentSecond() {
        return ContentSecond;
    }

    public void setContentSecond(V contentSecond) {
        ContentSecond = contentSecond;
    }

    @Override
    public double getArea() {
        return ContentFirst.getArea() + ContentSecond.getArea();
    }

    public boolean isAreaEqual(PairBox<? extends Figure, ? extends Figure> figure) {
        double eps = 0.000001;
        return Math.abs(this.getArea() - figure.getArea()) < eps;
    }
}
