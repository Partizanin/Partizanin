/*
 * Copyright (c) 2005, 2006, Oracle and/or its affiliates. All rights reserved.
 * DO NOT ALTER OR REMOVE COPYRIGHT NOTICES OR THIS FILE HEADER.
 *
 * This code is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 only, as
 * published by the Free Software Foundation.  Oracle designates this
 * particular file as subject to the "Classpath" exception as provided
 * by Oracle in the LICENSE file that accompanied this code.
 *
 * This code is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE.  See the GNU General Public License
 * version 2 for more details (a copy is included in the LICENSE file that
 * accompanied this code).
 *
 * You should have received a copy of the GNU General Public License version
 * 2 along with this work; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin St, Fifth Floor, Boston, MA 02110-1301 USA.
 *
 * Please contact Oracle, 500 Oracle Parkway, Redwood Shores, CA 94065 USA
 * or visit www.oracle.com if you need additional information or have any
 * questions.
 */
package myWork.timeCalculator.net.brennenraedts.swing.laf;


import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;


public class ShapeRoundedCornerButtonPainter extends RoundedCornerButtonPainter {

    private Shape shape;
    private boolean respectRatio;
    private double shapeSpaceRatio;

    //the following 2 variables are reused during the painting code of the layers
    private Rectangle2D shapeBounds = new Rectangle2D.Float(0, 0, 0, 0);
    private AffineTransform affineTransform = new AffineTransform();

    //Additional color for shapes
    private Color color52 = decodeColor("textForeground", 0, 0, 0, 0);

    public ShapeRoundedCornerButtonPainter(java.awt.PaintContext ctx, int state, Shape shape, boolean respectRatio, double shapeSpaceRatio) {
        super((JComponent) ctx, state);
        this.shape = shape;
        this.respectRatio = respectRatio;
        this.shapeSpaceRatio = shapeSpaceRatio;
    }

    public ShapeRoundedCornerButtonPainter(int state, Shape shape, boolean respectRatio, double shapeSpaceRatio) {
        super(state);
        this.shape = shape;
        this.respectRatio = respectRatio;
        this.shapeSpaceRatio = shapeSpaceRatio;
    }

    public ShapeRoundedCornerButtonPainter(JComponent c, int state, Shape shape, boolean respectRatio, double shapeSpaceRatio) {
        super(c, state);
        this.shape = shape;
        this.respectRatio = respectRatio;
        this.shapeSpaceRatio = shapeSpaceRatio;
    }

    @Override
    protected void doPaint(Graphics2D g, JComponent c, int width, int height, Object[] extendedCacheKeys) {
        //populate componentColors array with colors calculated in getExtendedCacheKeys call
        componentColors = extendedCacheKeys;

        //generate this entire method. Each state/bg/fg/border combo that has
        //been painted gets its own KEY and paint method.
        switch (state) {
            case BACKGROUND_DEFAULT:
                paintBackgroundDefault(g);
                break;
            case BACKGROUND_DEFAULT_FOCUSED:
                paintBackgroundDefaultAndFocused(g);
                break;
            case BACKGROUND_MOUSEOVER_DEFAULT:
                paintBackgroundMouseOverAndDefault(g);
                break;
            case BACKGROUND_MOUSEOVER_DEFAULT_FOCUSED:
                paintBackgroundMouseOverAndDefaultAndFocused(g);
                break;
            case BACKGROUND_PRESSED_DEFAULT:
                paintBackgroundPressedAndDefault(g);
                break;
            case BACKGROUND_PRESSED_DEFAULT_FOCUSED:
                paintBackgroundPressedAndDefaultAndFocused(g);
                break;
            case BACKGROUND_DISABLED:
                paintBackgroundDisabled(g);
                break;
            case BACKGROUND_ENABLED:
                paintBackgroundEnabled(g);
                break;
            case BACKGROUND_FOCUSED:
                paintBackgroundFocused(g);
                break;
            case BACKGROUND_MOUSEOVER:
                paintBackgroundMouseOver(g);
                break;
            case BACKGROUND_MOUSEOVER_FOCUSED:
                paintBackgroundMouseOverAndFocused(g);
                break;
            case BACKGROUND_PRESSED:
                paintBackgroundPressed(g);
                break;
            case BACKGROUND_PRESSED_FOCUSED:
                paintBackgroundPressedAndFocused(g);
                break;
        }
        paintShape(g);
    }

    @Override
    protected Object[] getExtendedCacheKeys(JComponent c) {
        Object[] extendedCacheKeys = null;
        switch (state) {
            case BACKGROUND_DEFAULT:
                extendedCacheKeys = new Object[]{
                        getComponentColor(c, "background", color4, -0.6197143f, 0.43137252f, 0),
                        getComponentColor(c, "background", color5, -0.5766426f, 0.38039213f, 0),
                        getComponentColor(c, "background", color6, -0.43866998f, 0.24705881f, 0),
                        getComponentColor(c, "background", color7, -0.46404046f, 0.36470586f, 0),
                        getComponentColor(c, "background", color8, -0.47761154f, 0.44313723f, 0),
                        getComponentColor(c, "foreground", color52, 0, 0, 0)};
                break;
            case BACKGROUND_DEFAULT_FOCUSED:
                extendedCacheKeys = new Object[]{
                        getComponentColor(c, "background", color4, -0.6197143f, 0.43137252f, 0),
                        getComponentColor(c, "background", color5, -0.5766426f, 0.38039213f, 0),
                        getComponentColor(c, "background", color6, -0.43866998f, 0.24705881f, 0),
                        getComponentColor(c, "background", color7, -0.46404046f, 0.36470586f, 0),
                        getComponentColor(c, "background", color8, -0.47761154f, 0.44313723f, 0),
                        getComponentColor(c, "foreground", color52, 0, 0, 0)};
                break;
            case BACKGROUND_MOUSEOVER_DEFAULT:
                extendedCacheKeys = new Object[]{
                        getComponentColor(c, "background", color12, -0.6198413f, 0.43921566f, 0),
                        getComponentColor(c, "background", color13, -0.5822163f, 0.40392154f, 0),
                        getComponentColor(c, "background", color14, -0.4555341f, 0.3215686f, 0),
                        getComponentColor(c, "background", color15, -0.47698414f, 0.43921566f, 0),
                        getComponentColor(c, "background", color16, -0.5455182f, 0.45098037f, 0),
                        getComponentColor(c, "foreground", color52, 0, 0, 0)};
                break;
            case BACKGROUND_MOUSEOVER_DEFAULT_FOCUSED:
                extendedCacheKeys = new Object[]{
                        getComponentColor(c, "background", color12, -0.6198413f, 0.43921566f, 0),
                        getComponentColor(c, "background", color13, -0.5822163f, 0.40392154f, 0),
                        getComponentColor(c, "background", color14, -0.4555341f, 0.3215686f, 0),
                        getComponentColor(c, "background", color15, -0.47698414f, 0.43921566f, 0),
                        getComponentColor(c, "background", color16, -0.5455182f, 0.45098037f, 0),
                        getComponentColor(c, "foreground", color52, 0, 0, 0)};
                break;
            case BACKGROUND_PRESSED_DEFAULT:
                extendedCacheKeys = new Object[]{
                        getComponentColor(c, "background", color20, -0.38050595f, 0.20392156f, 0),
                        getComponentColor(c, "background", color21, -0.29863563f, 0.1490196f, 0),
                        getComponentColor(c, "background", color22, 0.0f, 0.0f, 0),
                        getComponentColor(c, "background", color23, -0.14126986f, 0.15686274f, 0),
                        getComponentColor(c, "background", color24, -0.20852983f, 0.2588235f, 0),
                        getComponentColor(c, "foreground", color52, 0, 0, 0)};
                break;
            case BACKGROUND_PRESSED_DEFAULT_FOCUSED:
                extendedCacheKeys = new Object[]{
                        getComponentColor(c, "background", color20, -0.38050595f, 0.20392156f, 0),
                        getComponentColor(c, "background", color21, -0.29863563f, 0.1490196f, 0),
                        getComponentColor(c, "background", color22, 0.0f, 0.0f, 0),
                        getComponentColor(c, "background", color23, -0.14126986f, 0.15686274f, 0),
                        getComponentColor(c, "background", color24, -0.20852983f, 0.2588235f, 0),
                        getComponentColor(c, "foreground", color52, 0, 0, 0)};
                break;
            case BACKGROUND_ENABLED:
                extendedCacheKeys = new Object[]{
                        getComponentColor(c, "background", color35, -0.10655806f, 0.24313724f, 0),
                        getComponentColor(c, "background", color36, -0.09823123f, 0.2117647f, 0),
                        getComponentColor(c, "background", color30, -0.07016757f, 0.12941176f, 0),
                        getComponentColor(c, "background", color37, -0.0749532f, 0.24705881f, 0),
                        getComponentColor(c, "background", color38, -0.110526316f, 0.25490195f, 0),
                        getComponentColor(c, "foreground", color52, 0, 0, 0)};
                break;
            case BACKGROUND_DISABLED:
                Color foreground = getComponentColor(c, "foreground", color52, 0, 0, 0);
                Color disabledForeground = new Color(
                        foreground.getRed(), foreground.getGreen(), foreground.getBlue(), 100);
                extendedCacheKeys = new Object[]{
                        getComponentColor(c, "background", color35, -0.10655806f, 0.24313724f, 0),
                        getComponentColor(c, "background", color36, -0.09823123f, 0.2117647f, 0),
                        getComponentColor(c, "background", color30, -0.07016757f, 0.12941176f, 0),
                        getComponentColor(c, "background", color37, -0.0749532f, 0.24705881f, 0),
                        getComponentColor(c, "background", color38, -0.110526316f, 0.25490195f, 0),
                        disabledForeground};
                break;
            case BACKGROUND_FOCUSED:
                extendedCacheKeys = new Object[]{
                        getComponentColor(c, "background", color35, -0.10655806f, 0.24313724f, 0),
                        getComponentColor(c, "background", color36, -0.09823123f, 0.2117647f, 0),
                        getComponentColor(c, "background", color30, -0.07016757f, 0.12941176f, 0),
                        getComponentColor(c, "background", color37, -0.0749532f, 0.24705881f, 0),
                        getComponentColor(c, "background", color38, -0.110526316f, 0.25490195f, 0),
                        getComponentColor(c, "foreground", color52, 0, 0, 0)};
                break;
            case BACKGROUND_MOUSEOVER:
                extendedCacheKeys = new Object[]{
                        getComponentColor(c, "background", color41, -0.10658931f, 0.25098038f, 0),
                        getComponentColor(c, "background", color42, -0.098526314f, 0.2352941f, 0),
                        getComponentColor(c, "background", color43, -0.07333623f, 0.20392156f, 0),
                        getComponentColor(c, "background", color38, -0.110526316f, 0.25490195f, 0),
                        Color.BLACK,
                        getComponentColor(c, "foreground", color52, 0, 0, 0)};
                break;
            case BACKGROUND_MOUSEOVER_FOCUSED:
                extendedCacheKeys = new Object[]{
                        getComponentColor(c, "background", color41, -0.10658931f, 0.25098038f, 0),
                        getComponentColor(c, "background", color42, -0.098526314f, 0.2352941f, 0),
                        getComponentColor(c, "background", color43, -0.07333623f, 0.20392156f, 0),
                        getComponentColor(c, "background", color38, -0.110526316f, 0.25490195f, 0),
                        Color.BLACK,
                        getComponentColor(c, "foreground", color52, 0, 0, 0)};
                break;
            case BACKGROUND_PRESSED:
                extendedCacheKeys = new Object[]{
                        getComponentColor(c, "background", color47, -0.05960039f, 0.10196078f, 0),
                        getComponentColor(c, "background", color48, -0.04772438f, 0.06666666f, 0),
                        getComponentColor(c, "background", color49, -0.0018306673f, -0.02352941f, 0),
                        getComponentColor(c, "background", color50, -0.0212406f, 0.13333333f, 0),
                        getComponentColor(c, "background", color51, -0.030845039f, 0.23921567f, 0),
                        getComponentColor(c, "foreground", color52, 0, 0, 0)};
                break;
            case BACKGROUND_PRESSED_FOCUSED:
                extendedCacheKeys = new Object[]{
                        getComponentColor(c, "background", color47, -0.05960039f, 0.10196078f, 0),
                        getComponentColor(c, "background", color48, -0.04772438f, 0.06666666f, 0),
                        getComponentColor(c, "background", color49, -0.0018306673f, -0.02352941f, 0),
                        getComponentColor(c, "background", color50, -0.0212406f, 0.13333333f, 0),
                        getComponentColor(c, "background", color51, -0.030845039f, 0.23921567f, 0),
                        getComponentColor(c, "foreground", color52, 0, 0, 0)};
                break;
        }
        return extendedCacheKeys;
    }

    private void paintShape(Graphics2D g) {
        shapeBounds = decodeShapeBounds();
        g.setPaint((Color) componentColors[5]);
        if (respectRatio) {
            double shapeRatio = shape.getBounds().getWidth() / shape.getBounds().getHeight();
            double boundsRatio = shapeBounds.getWidth() / shapeBounds.getHeight();
            if (shapeRatio < boundsRatio) {
                affineTransform.setToScale(
                        shapeSpaceRatio * shapeBounds.getHeight() / shape.getBounds().getHeight(),
                        shapeSpaceRatio * shapeBounds.getHeight() / shape.getBounds().getHeight());
            } else {
                affineTransform.setToScale(
                        shapeSpaceRatio * shapeBounds.getWidth() / shape.getBounds().getWidth(),
                        shapeSpaceRatio * shapeBounds.getWidth() / shape.getBounds().getWidth());
            }
        } else {
            affineTransform.setToScale(
                    shapeSpaceRatio * shapeBounds.getWidth() / shape.getBounds().getWidth(),
                    shapeSpaceRatio * shapeBounds.getHeight() / shape.getBounds().getHeight());
        }
        Shape rescaled = affineTransform.createTransformedShape(shape);
        affineTransform.setToTranslation(
                shapeBounds.getWidth() / 2 + shapeBounds.getX() - rescaled.getBounds().getWidth() / 2 - rescaled.getBounds().getX(),
                shapeBounds.getHeight() / 2 + shapeBounds.getY() - rescaled.getBounds().getHeight() / 2 - rescaled.getBounds().getY());
        rescaled = affineTransform.createTransformedShape(rescaled);
        g.fill(rescaled);
    }

    private Rectangle2D decodeShapeBounds() {
        Rectangle2D bounds = new Rectangle2D.Float(decodeX(0.2857143f), //x
                decodeY(0.2857143f), //y
                decodeX(2.7142859f) - decodeX(0.2857143f), //width
                decodeY(2.7142859f) - decodeY(0.2857143f));
        return bounds;
    }
}

