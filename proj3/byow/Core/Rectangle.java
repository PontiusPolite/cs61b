package byow.Core;

import java.util.Random;

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


    /** Origin is the reference point from which the width and height are added. Width and
     * height can be negative. */
    public Rectangle(Position origin, int width, int height) {
        corners = new Position[4];
        // if the width or height are negative, we 'flip' the Rectangle to maintain corners[0] invariance
        if (width < 0) {
            origin.x += width;
            width *= -1;
        }
        if (height < 0) {
            origin.y += height;
            height *= -1;
        }

        corners[0] = origin;
        corners[1] = new Position(origin.x + width - 1, origin.y);
        corners[2] = new Position(origin.x + width - 1, origin.y + height - 1);
        corners[3] = new Position(origin.x, origin.y + height - 1);
    }

    public Rectangle(int x, int y, int width, int height) {
        corners = new Position[4];
        // if the width or height are negative, we 'flip' the Rectangle to maintain corners[0] invariance
        if (width < 0) {
            x += width;
            width *= -1;
        }
        if (height < 0) {
            y += height;
            height *= -1;
        }
        Position origin = new Position(x, y);
        corners[0] = origin;
        corners[1] = new Position(origin.x + width - 1, origin.y);
        corners[2] = new Position(origin.x + width - 1, origin.y + height - 1);
        corners[3] = new Position(origin.x, origin.y + height - 1);
    }

    public int width() {
        return corners[2].x - corners[0].x + 1;
    }

    public int height() {
        return corners[2].y - corners[0].y + 1;
    }

    /** Returns the Position of the Rectangle corner with the smallest x and y coordinates. */
    public Position origin() {
        return corners[0];
    }

    public int x() { return corners[0].x; }

    public int y() { return corners[0].y; }

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

    /** Returns a random point within the Rectangle. */
    public Position getRandomPoint(Random r) {
        int rx = RandomUtils.uniform(r, corners[0].x, corners[0].x + width());
        int ry = RandomUtils.uniform(r, corners[0].y, corners[0].y + height());

        return new Position(rx, ry);
    }

    /** Returns a random point within the Rectangle that does not include any edges. */
    public Position getRandomInsidePoint(Random r) {
        int rx = RandomUtils.uniform(r, corners[0].x + 1, corners[0].x + width() - 1);
        int ry = RandomUtils.uniform(r, corners[0].y + 1, corners[0].y + height() - 1);

        return new Position(rx, ry);
    }

    /** Returns true if p lies on the edge of this Rectangle. */
    public boolean hasPointOnEdge(Position p) {
        boolean onRectangle = this.contains(p);
        boolean xEdge = p.x == corners[0].x || p.x == corners[2].x;
        boolean yEdge =  p.y == corners[0].y || p.y == corners[2].y;
        return onRectangle && (xEdge || yEdge);
    }

    /** Returns true if (x, y) lies on the edge of this Rectangle. */
    public boolean hasPointOnEdge(int x, int y) {
        boolean onRectangle = this.contains(new Position(x, y));
        boolean xEdge = x == corners[0].x || x == corners[2].x;
        boolean yEdge =  y == corners[0].y || y == corners[2].y;
        return onRectangle && (xEdge || yEdge);
    }
}
