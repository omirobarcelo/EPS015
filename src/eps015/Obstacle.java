/*
 * Main
 *
 * Global variables:
 * Self explanatory
 *
 * Constructors:
 * Main - JFrame window setup. 800x600px, screen centered, no resizable.
 *
 * Methods:
 * initComponents - Menu Bar, Menus and MenuItems implementation.
 *
 * Events:
 * actionPerformed - Identifies which menu item has provoked the event and
 *      executes corresponding action.
 *
 * Main program:
 * main - Sets window visible.
 */

package eps015;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author OriolMiroBarcelo
 */
enum Geom  {
    CIRCLE, ELLIPSE, SQUARE, RECTANGLE
}

public class Obstacle {
    public static final int NULL = -1;

    private int cx;
    private int cy;
    private Geom figure;
    private int d1 = NULL;
    private int d2 = NULL;

    public Obstacle(int x, int y, Geom g) {
        cx = x;
        cy = y;
        figure = g;
    }

    public int getcx() {
        return this.cx;
    }

    public int getcy() {
        return this.cy;
    }

    public int getd1() {
        return this.d1;
    }

    public int getd2() {
        return this.d2;
    }

    public Geom getFigure() {
        return this.figure;
    }

//    public float getArea() {
//        float area = NULL;
//
//        if (d1 != NULL) {
//            switch (figure) {
//                case CIRCLE: {
//                    area = (float)(Math.PI * Math.pow((d1/2), 2));
//                    break;
//                }
//                case SQUARE: {
//                    break;
//                }
//                case RECTANGLE: {
//                    break;
//                }
//            }
//        }
//
//        return area;
//    }

    public void setcx(int x) {
        this.cx = x;
    }

    public void setcy(int y) {
        this.cy = y;
    }

    public void paintObstacle(Graphics g, int d1, int d2) {
        this.d1 = d1;
        this.d2 = d2;

        if (d1 != NULL) {
            Graphics2D g2d = (Graphics2D)g;
            // Top Left x and y
            int tlx = cx - d1/2;
            int tly = cy - d1/2;

            switch (this.figure) {
                case CIRCLE: {
                    this.d1 = d1; this.d2 = d1;
                    Ellipse2D.Float eli = new Ellipse2D.Float(tlx, tly, d1, d1);
                    g2d.setPaint(Color.BLACK);
                    g2d.setStroke(new BasicStroke(5.0f));
                    g2d.draw(eli);
                    g2d.setColor(Color.ORANGE);
                    g2d.fill(eli);
                    break;
                }
                case ELLIPSE: {
                    if (d2 != NULL) {
                        this.d1 = d1; this.d2 = d2;
                        Ellipse2D.Float eli = new Ellipse2D.Float(tlx, tly, d1, d2);
                        g2d.setPaint(Color.BLACK);
                        g2d.setStroke(new BasicStroke(5.0f));
                        g2d.draw(eli);
                        g2d.setColor(Color.ORANGE);
                        g2d.fill(eli);
                    }
                    break;
                }
                case SQUARE: {
                    this.d1 = d1; this.d2 = d1;
                    Rectangle2D.Float rec = new Rectangle2D.Float(tlx, tly, d1, d1);
                    g2d.setPaint(Color.BLACK);
                    g2d.setStroke(new BasicStroke(5.0f));
                    g2d.draw(rec);
                    g2d.setColor(Color.ORANGE);
                    g2d.fill(rec);
                    break;
                }
                case RECTANGLE: {
                    if (d2 != NULL) {
                        this.d1 = d1; this.d2 = d2;
                        Rectangle2D.Float rec = new Rectangle2D.Float(tlx, tly, d1, d2);
                        g2d.setPaint(Color.BLACK);
                        g2d.setStroke(new BasicStroke(5.0f));
                        g2d.draw(rec);
                        g2d.setColor(Color.ORANGE);
                        g2d.fill(rec);
                    }
                    break;
                }
            }
        }
    }
}