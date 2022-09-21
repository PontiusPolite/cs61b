package byow.Core;

/**
 * Created by Carson Crow on 9/1/2022
 */
public class Position {
    public int x;
    public int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public double distanceTo(Position p) {
        double x2 = Math.pow(this.x - p.x, 2);
        double y2 = Math.pow(this.y - p.y, 2);
        return Math.sqrt(x2 + y2);
    }

    @Override
    public String toString() {
        return String.format("Position at (%d, %d)", x, y);
    }
}
