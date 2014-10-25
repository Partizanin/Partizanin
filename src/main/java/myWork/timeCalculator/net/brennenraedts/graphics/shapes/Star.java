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
public class Star extends Path2D.Double {

    public Star(Point2D center, double outerRadius, double innerRadiusRatio, int outerPoints, double startAngleOffset) {
        double increment = Math.toRadians(180 / outerPoints);
        double angle = Math.toRadians(startAngleOffset);
        double x = center.getX();
        double y = center.getY();
        double innerDimension = outerRadius * innerRadiusRatio;
        double outerDimension = outerRadius;
        moveTo(x + Math.cos(angle) * outerDimension, y + Math.sin(angle) * outerDimension);
        for (int i = 0; i < outerPoints * 2; i++) {
            if (i == (outerPoints * 2) - 1) closePath();
            angle += increment;
            if (i % 2 == 0) {
                //going in
                lineTo(x + Math.cos(angle) * innerDimension,
                        y + Math.sin(angle) * innerDimension);
            } else {
                //going out
                lineTo(x + Math.cos(angle) * outerDimension,
                        y + Math.sin(angle) * outerDimension);
            }
        }
    }
}
