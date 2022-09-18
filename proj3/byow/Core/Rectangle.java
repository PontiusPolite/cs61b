package byow.Core;

/**
 * Created by Carson Crow on 9/16/2022
 *
 * A class describing a rectangle in 2D space, and thus can be used to describe the
 * dimensions of some game object.
 */
public class Rectangle {
    /** corners[0] is always the Position with the smallest x and y values (bottom left)
     * corners[1] is always bottom right
     * corners[2] is always top right
     * corners[3] is always top left
     */
    private final Position[] corners;


    /** origin refers to the corner with the smallest x and y coordinates (bottom left in
     * our tile world). */
    public Rectangle(Position origin, int width, int height) {
        corners = new Position[4];
        corners[0] = origin;
        corners[1] = new Position(origin.x + width, origin.y);
        corners[2] = new Position(origin.x + width, origin.y + height);
        corners[3] = new Position(origin.x, origin.y + height);
    }

    public Rectangle(int x, int y, int width, int height) {
        Position origin = new Position(x, y);
        corners = new Position[4];
        corners[0] = origin;
        corners[1] = new Position(origin.x + width, origin.y);
        corners[2] = new Position(origin.x + width, origin.y + height);
        corners[3] = new Position(origin.x, origin.y + height);
    }

    private Position calculateSmallestCorner(Position corner1, Position corner2) {
        if (corner1.x <= corner2.x) {
            if (corner1.y <= corner2.y) {
                return corner1;
            }
            return new Position(corner1.x, corner2.y);
        }
        if (corner2.y <= corner1.y) {
            return corner2;
        }
        return new Position(corner2.x, corner1.y);
    }

    private Position calculateLargestCorner(Position corner1, Position corner2) {
        if (corner1.x >= corner2.x) {
            if (corner1.y >= corner2.y) {
                return corner1;
            }
            return new Position(corner1.x, corner2.y);
        }
        if (corner2.y >= corner1.y) {
            return corner2;
        }
        return new Position(corner2.x, corner1.y);
    }

    public int width() {
        return corners[2].x - corners[0].x;
    }

    public int height() {
        return corners[2].y - corners[0].y;
    }

    /** Returns the Position of the Rectangle corner with the smallest x and y coordinates. */
    public Position origin() {
        return corners[0];
    }

    /** Returns true if the Rectangle intersects with r. */
    public boolean intersects(Rectangle r) {
        for (Position c : this.corners) {
            if (r.contains(c)) {
                return true;
            }
        }
        for (Position c : r.corners) {
            if (this.contains(c)) {
                return true;
            }
        }
        return false;
    }

    /** Returns true if this Rectangle contains p within its bounds. */
    public boolean contains(Position p) {
        boolean containsX = p.x >= this.corners[0].x && p.x <= this.corners[2].x;
        boolean containsY = p.y >= this.corners[0].y && p.y <= this.corners[2].y;
        return containsX && containsY;
    }
}
