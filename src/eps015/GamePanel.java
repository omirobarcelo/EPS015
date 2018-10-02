/*
 * GamePanel
 *
 * 
 */

package eps015;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.geom.Line2D;
import javax.swing.*;

/**
 *
 * @author OriolMiroBarcelo
 */
public class GamePanel extends JPanel {

    //////////////////////////////////////////////
    // CONSTANTS                                //
    //////////////////////////////////////////////
    static final int SIZE_X = 800;
    static final int SIZE_Y = 600;
    static final int START_X = 150;
    static final int START_Y = 300;
    static final int FINISH = 650;

    //////////////////////////////////////////////
    // GLOBAL VARIABLES                         //
    //////////////////////////////////////////////
    static public boolean done = false;
    static public Timer t;
    int x1 = START_X, x2 = x1 + 1, y1 = START_Y, y2;
    static int i = 0;
    Line2D j1line;
    Point j1p1, j1p2;
    boolean first_enter = false;
    boolean block = false;
    //back_curve
    //draw_curve

    //////////////////////////////////////////////
    // CONSTRUCTORS                             //
    //////////////////////////////////////////////
    public GamePanel() {};

    //////////////////////////////////////////////
    // METHODS                                  //
    //////////////////////////////////////////////
    @Override
    public void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D)g;
        if (j1p1 != null && j1p2 != null) {
                System.out.println(j1p2.x+", "+j1p2.y);
            g2d.setPaint(Color.RED);
            g2d.setStroke(new BasicStroke(3.5f));
            g2d.draw(j1line);
        }
    }

    public void plotCurve(int level) {
        //int x1 = START_X, y1 = START_Y, x2 = x1 + 1, y2;
        long startTime = System.currentTimeMillis();
        switch (level) {
            case 1: {
                while (x2 <= FINISH) {
                    //y2 = (int)(Math.sin(Math.toRadians(x2)) * 80 + 300);
                    y2 = y1;
                    j1p1 = new Point(x1, y1);
                    j1p2 = new Point(x2, y2);
                        //System.out.println("- "+j1p2.x+", "+j1p2.y);
                    j1line = new Line2D.Double(j1p1, j1p2);
                    x1 = x2; y1 = y2;
                    x2+=3;
                    repaint();

                }
                    System.out.println("out");
                break;
            }
            case 2: {
                /*j1p1 = new Point(150, 300);
                j1p2 = new Point(200, 300);
                j1line = new Line2D.Double(j1p1, j1p2);
                    System.out.println("done1");
                repaint();
                    System.out.println("done2");
                j1p1 = new Point(250, 300);
                j1p2 = new Point(300, 300);
                j1line = new Line2D.Double(j1p1, j1p2);
                    System.out.println("done3");
                repaint();
                    System.out.println("done4");*/
                j1p1 = new Point(150*(i+1), 300);
                j1p2 = new Point(150*(i+1)+50, 300);
                j1line = new Line2D.Double(j1p1, j1p2);
                    System.out.println("done1");
                repaint();
                    System.out.println("done2");
                break;
            }
            case 3: {
                y2 = y1;
                j1p1 = new Point(x1, y1);
                j1p2 = new Point(x2, y2);
                j1line = new Line2D.Double(j1p1, j1p2);
                x1 = x2; y1 = y2;
                x2++;
                if (x2 > FINISH) t.stop();
                repaint();
                break;
            }
        }
    }

    //////////////////////////////////////////////
    // FUNCTIONS                                //
    //////////////////////////////////////////////
    @Override
    public Dimension getPreferredSize() {
        // 21 added to cover space occupied by the window bar
        return new Dimension(SIZE_X, SIZE_Y+21);
    }

    //////////////////////////////////////////////
    // EVENTS                                   //
    //////////////////////////////////////////////
}
