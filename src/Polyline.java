
public class Polyline {

    private Point[] points;

    public Polyline(Point[] points) {
        this.points = points;
    }

    public Polyline() {
        this.points = new Point[0]; // Инициализация пустого массива
    }


    public Point getLastPoint() {
        return points[points.length - 1];
    }


    @Override public String toString() {
        StringBuilder sb = new StringBuilder("Линия [");
        for (int i = 0; i < points.length; i++) {
            sb.append(points[i]);
            if (i < points.length - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

    public void shift(double deltaX, double deltaY) {
        for (Point point : points) {
            point.shift(deltaX, deltaY);
        }
    }
    public void shiftPoint(Polyline polyline, int index, double deltaX, double deltaY) {

        for (Point p : polyline.getPoints()) {
            if (p.equals(points[index-1])) {
                p.shift(deltaX, deltaY);
            }
        }
        points[index-1].shift(deltaX, deltaY);
    }

    public Point[] getPoints() {
        return points;
    }

    public double getLength() {
        double length = 0.0;
        for (int i = 0; i < points.length - 1; i++) {
            length += calculateDistance(points[i], points[i + 1]);
        }
        return length;
    }

    protected double calculateDistance(Point p1, Point p2) {
        return Math.sqrt(Math.pow(p2.getX() - p1.getX(), 2) + Math.pow(p2.getY() - p1.getY(), 2));
    }

    public void addPoints(Point[] newPoints) {
        Point[] combined = new Point[points.length + newPoints.length];
        System.arraycopy(points, 0, combined, 0, points.length);
        System.arraycopy(newPoints, 0, combined, points.length, newPoints.length);
        points = combined;
    }

    public void addPoint(Point point) {
        Point[] combined = new Point[points.length + 1];
        System.arraycopy(points, 0, combined, 0, points.length);
        combined[points.length] = point;
        points = combined;
    }
}
