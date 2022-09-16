package byow.Core;

/**
 * Created by Carson Crow on 9/16/2022
 *
 * A class describing a rectangle in 2D space, and thus can be used to describe the
 * dimensions of some game object.
 */
public class Rectangle {
    /** smallestCorner refers to the corner of the rectangle with the smallest x and y coordinates.
     * Outside this class, this Position is referred to as the 'origin'.
     */
    private final Position smallestCorner;
    private final Position largestCorner;

    /** corner1 and corner2 are interpreted as opposite corners of the Rectangle. If these Positions
     * are on a vertical or horizontal lines, the resulting Rectangle will have a width or height
     * of 1, respectively. */
    public Rectangle(Position corner1, Position corner2) {
        smallestCorner = calculateSmallestCorner(corner1, corner2);
        largestCorner = calculateLargestCorner(corner1, corner2);
    }

    /** origin refers to the corner with the smallest x and y coordinates (bottom left in
     * our tile world). */
    public Rectangle(Position origin, int width, int height) {
        smallestCorner = origin;
        largestCorner = new Position(smallestCorner.x + width, smallestCorner.y + height);
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
        return largestCorner.x - smallestCorner.x;
    }

    public int height() {
        return largestCorner.y - smallestCorner.y;
    }

    /** Returns the Position of the Rectangle corner with the smallest x and y coordinates. */
    public Position origin() {
        return smallestCorner;
    }

    /** Returns true if this Rectangle intersects with r. */
    public boolean intersectsWith(Rectangle r) {
        boolean xIntersects = (this.origin().x + this.width() >= r.origin().x || r.origin().x + r.width() >= this.origin().x);
        boolean yIntersects = (this.smallestCorner.y + this.height() >= r.origin().y || r.origin().y + r.height() >= this.origin().y);
        return xIntersects || yIntersects;
    }
}
