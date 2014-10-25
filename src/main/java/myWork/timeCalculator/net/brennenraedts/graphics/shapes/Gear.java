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
public class Gear extends Path2D.Double {

    private double btan(double increment) {
        increment /= 2.0;
        return 4.0 / 3.0 * Math.sin(increment) / (1.0 + Math.cos(increment));
    }

    public Gear(Point2D center, double outerRadius, double innerRadiusRatio, int teeth, double teethWidthRatio, double outerTeethWidthRatio, double startAngleOffset) {
        double fullIncrement = Math.toRadians(360 / teeth);
        double toothIncrement = fullIncrement * teethWidthRatio;
        double outerToothIncrement = fullIncrement * outerTeethWidthRatio;
        double spaceIncrement = fullIncrement * (1 - teethWidthRatio);
        double cv = btan(spaceIncrement);
        double angle = Math.toRadians(startAngleOffset);
        double x = center.getX();
        double y = center.getY();
        double innerDimension = outerRadius * innerRadiusRatio * 2;
        double outerDimension = outerRadius * 2;
        double[] coords = new double[6];
        moveTo(x + Math.cos(angle) * innerDimension, y + Math.sin(angle) * innerDimension);
        for (int i = 0; i < teeth * 2; i++) {
            if (i % 2 == 0) {
                //space
                double relx = Math.cos(angle);
                double rely = Math.sin(angle);
                coords[0] = (x + (relx - (cv) * rely) * innerDimension);
                coords[1] = (y + (rely + (cv) * relx) * innerDimension);
                angle += spaceIncrement;
                relx = Math.cos(angle);
                rely = Math.sin(angle);
                coords[2] = (x + (relx + (cv) * rely) * innerDimension);
                coords[3] = (y + (rely - (cv) * relx) * innerDimension);
                coords[4] = (x + relx * innerDimension);
                coords[5] = (y + rely * innerDimension);
                curveTo(coords[0], coords[1], coords[2], coords[3], coords[4], coords[5]);
            } else {
                //tooth
                coords[0] = (x + Math.cos(angle + ((toothIncrement - outerToothIncrement) / 2)) * outerDimension);
                coords[1] = (y + Math.sin(angle + ((toothIncrement - outerToothIncrement) / 2)) * outerDimension);
                lineTo(coords[0], coords[1]);
                angle += toothIncrement;
                coords[0] = (x + Math.cos(angle - ((toothIncrement - outerToothIncrement) / 2)) * outerDimension);
                coords[1] = (y + Math.sin(angle - ((toothIncrement - outerToothIncrement) / 2)) * outerDimension);
                lineTo(coords[0], coords[1]);
                coords[0] = (x + Math.cos(angle) * innerDimension);
                coords[1] = (y + Math.sin(angle) * innerDimension);
                lineTo(coords[0], coords[1]);
            }
        }
    }
}
