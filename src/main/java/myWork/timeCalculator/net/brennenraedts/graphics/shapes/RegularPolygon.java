/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package myWork.timeCalculator.net.brennenraedts.graphics.shapes;

import java.awt.geom.Path2D;
import java.awt.geom.Point2D;

/**
 * @author Benjamin Brennenraedts
 */
public class RegularPolygon extends Path2D.Double {

    private Point2D center;
    private double radius;
    private int sides;
    private double startAngleOffset;

    /**
     * @param center           of the regular polygon
     * @param radius           radius from center to corners
     * @param sides            number of sides or corners
     * @param startAngleOffset start angle of the first corner in degrees
     */
    public RegularPolygon(Point2D center, double radius, int sides, double startAngleOffset) {
        this.center = center;
        this.radius = radius;
        this.sides = sides;
        this.startAngleOffset = startAngleOffset;
        updateShape();
    }

    /**
     * @param center of the regular polygon
     * @param radius radius from center to corners
     * @param sides  number of sides or corners
     */
    public RegularPolygon(Point2D center, double radius, int sides) {
        this(center, radius, sides, 0);
    }

    public void updateShape() {
        reset();
        double x, y, angle;
        for (int i = 0; i < this.sides; i++) {
            angle = Math.toRadians(this.startAngleOffset) + i * (2 * Math.PI / this.sides);
            x = this.center.getX() + Math.cos(angle) * this.radius;
            y = this.center.getY() + Math.sin(angle) * this.radius;
            if (i == 0) {
                moveTo(x, y);
            } else {
                lineTo(x, y);
            }
        }
        closePath();
    }
}
