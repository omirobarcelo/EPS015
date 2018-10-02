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
import java.awt.event.MouseEvent;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author OriolMiroBarcelo
 */
////v.1.0
//public class GPanel extends JPanel {
//
//    //////////////////////////////////////////////
//    // CONSTANTS                                //
//    //////////////////////////////////////////////
//    static final int SIZE_X = 1000;
//    static final int SIZE_Y = 500;
//    static final int START_X = 100;
//    static final int START_Y = 250;
//    static final int FINISH = 850;
//
//    //////////////////////////////////////////////
//    // GLOBAL VARIABLES                         //
//    //////////////////////////////////////////////
//    //int x1 = START_X, x2 = x1 + 1, y1 = START_Y, y2;
//    int x1, x2, y1, y2;
//    Line2D j1line;
//    Point j1p1, j1p2;
//    boolean firstEnter = false;
//    boolean block = false;
//    boolean firstCall = true;
//    GPoint drawnCurve = new GPoint(new Point(START_X, START_Y));
//    //back_curve
//    //draw_curve
//
//    //////////////////////////////////////////////
//    // CONSTRUCTORS                             //
//    //////////////////////////////////////////////
//    public GPanel() {};
//
//    //////////////////////////////////////////////
//    // METHODS                                  //
//    //////////////////////////////////////////////
//    @Override
//    public void paintComponent(Graphics g) {
//        Graphics2D g2d = (Graphics2D)g;
//        if (j1p1 != null && j1p2 != null) {
//            // Didn't use firstCall because erases curve just after it's completed,
//            // because on completion firstCall immediately becomes true
//            // Added 1 to START_X because x1 it's updated before first call of repaint
//            if (x1 == START_X + 1) {
//                g2d.setColor(Color.WHITE);
//                g2d.fillRect(0, 0, SIZE_X, SIZE_Y);
//            }
//                //System.out.println(j1p2.x+", "+j1p2.y);
//            drawnCurve.insert(j1p2);
//            g2d.setPaint(Color.RED);
//            g2d.setStroke(new BasicStroke(3.5f));
//            g2d.draw(j1line);
//        }
//    }
//
//    public void plotCurve(int level) {
//        if (firstCall) {
//            x1 = START_X; x2 = x1 + 1; y1 = START_Y;
//            firstCall = false;
//        }
//        switch (level) {
//            case 1: {
//                y2 = (int)(Math.sin(Math.toRadians(x2)) * 80 + START_Y);
//                j1p1 = new Point(x1, y1);
//                j1p2 = new Point(x2, y2);
//                j1line = new Line2D.Double(j1p1, j1p2);
//                x1 = x2; y1 = y2;
//                x2++;
//                if (x2 > FINISH) {GUtilities.stopTimer(); firstCall = true;}
//                repaint();
//                break;
//            }
//            case 2: {
//                y2 = (int)((Math.cos(Math.toRadians(2*x2)) +
//                        Math.sin(Math.toRadians(x2))) * 80 + START_Y);
//                j1p1 = new Point(x1, y1);
//                j1p2 = new Point(x2, y2);
//                j1line = new Line2D.Double(j1p1, j1p2);
//                x1 = x2; y1 = y2;
//                x2++;
//                if (x2 > FINISH) {GUtilities.stopTimer(); firstCall = true;}
//                repaint();
//                break;
//            }
//            case 3: {
//                y2 = (int)((Math.cos(Math.toRadians(2*x2)) +
//                        Math.sin(Math.toRadians(x2/2))) * 80 + START_Y);
//                j1p1 = new Point(x1, y1);
//                j1p2 = new Point(x2, y2);
//                j1line = new Line2D.Double(j1p1, j1p2);
//                x1 = x2; y1 = y2;
//                x2++;
//                if (x2 > FINISH) {GUtilities.stopTimer(); firstCall = true;}
//                repaint();
//                break;
//            }
//        }
//    }
//
//    public void listDrawnCurve() {
//        drawnCurve.list();
//    }
//
//    //////////////////////////////////////////////
//    // FUNCTIONS                                //
//    //////////////////////////////////////////////
//    @Override
//    public Dimension getPreferredSize() {
//        // 21 added to cover space occupied by the window bar
//        return new Dimension(SIZE_X, SIZE_Y+21);
//    }
//
//    //////////////////////////////////////////////
//    // EVENTS                                   //
//    //////////////////////////////////////////////
//}


//v.2.0
public class GPanel extends JPanel {

    //////////////////////////////////////////////
    // CONSTANTS                                //
    //////////////////////////////////////////////
    static final int SIZE_X = 1000;
    static final int SIZE_Y = 500;

    static final int START_X = 100;
    static final int START_Y = 250;
    static final int FINISH = 850;

    static final int PLOTTED = 0;
    static final int BACK = 1;
    static final int DRAWN = 2;

    static final int REAR_LENGTH = 50;
    static final int REAR_X = START_X - REAR_LENGTH;

    static final Color DARK_GREEN = new Color(1, 186, 20);

    //////////////////////////////////////////////
    // GLOBAL VARIABLES                         //
    //////////////////////////////////////////////
    private Point j1point, j1p1, j1p2;
    private Line2D j1drawn;
    private boolean block = true;       // Blocks checkLastPoint
    private boolean finished = false;
    private boolean startOK = false;
    private boolean secondStart = false;
    private static ArrayList<Point> plotted = new ArrayList();
    private static ArrayList<Point> back = new ArrayList();
    private static ArrayList<Point> drawn = new ArrayList();
    // Initial values to start game with level 1 curve
    private int toDraw = 0;
    private int currentLevel = 1;

    //////////////////////////////////////////////
    // CONSTRUCTORS                             //
    //////////////////////////////////////////////
    public GPanel() {};

    //////////////////////////////////////////////
    // METHODS                                  //
    //////////////////////////////////////////////
    @Override
    public void paintComponent(Graphics g) {
        Line2D j1line;
        Graphics2D g2d = (Graphics2D)g;
        // Clear screen
        if (toDraw == PLOTTED) {
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, SIZE_X, SIZE_Y);
        }
        if (j1point != null || (j1p1 != null && j1p2 != null)) {
            switch(toDraw) {
                case PLOTTED: {
                    // New plot, restart control variables
                    startOK = false;
                    secondStart = false;
                    finished = false;
                    g2d.setPaint(Color.RED);
                    g2d.setStroke(new BasicStroke(3.5f));
                    Point prevPoint = null;
                    for (Point p : plotted) {
                        if (prevPoint != null) {
                            j1line = new Line2D.Double(prevPoint, p);
                            g2d.draw(j1line);
                        }
                        prevPoint = p;
                    }

                    // Draw bicycle initial position
                    //g2d.setPaint(Color.BLACK);
                    int start_y = plotted.get(0).y;
                    //j1line = new Line2D.Double(new Point(REAR_X, start_y), new Point(START_X, start_y));
                    //g2d.draw(j1line);
                    try {
                    //        File f = new File("img/bicycle.png");
                    //        System.out.println(f.exists());
                        g2d.setPaint(DARK_GREEN);
                        g.drawLine(REAR_X, start_y, REAR_X, start_y);
                        BufferedImage img = ImageIO.read(new File("img/bicycleDraw.png"));
                        g.drawImage(img, REAR_X, start_y-31, null);
                    } catch (Exception e) {}

                    break;
                }
                case BACK: {
                    g2d.setPaint(Color.BLUE);
                    g2d.setStroke(new BasicStroke(3.5f));
                    Point prevPoint = null;
                    for (Point p : back) {
                        if (prevPoint != null) {
                            j1line = new Line2D.Double(prevPoint, p);
                            g2d.draw(j1line);
                        }
                        prevPoint = p;
                    }
                    break;
                }
                case DRAWN: {
                    g2d.setPaint(DARK_GREEN);
                    g2d.setStroke(new BasicStroke(3.5f));
                    g2d.draw(j1drawn);
                    break;
                }
            }
        }
    }

    public void plotCurve(int level) {
        plotted.clear();
        int x1, x2, y1, y2;
        currentLevel = level;
        switch (level) {
            case 1: {
                x1 = START_X;
                y1 = (int)(Math.sin(Math.toRadians(x1)) * 80 + START_Y);
                j1point = new Point(x1, y1);
                plotted.add(j1point);
                x2 = x1 + 1;
                while (x2 <= FINISH) {
                    y2 = (int)(Math.sin(Math.toRadians(x2)) * 80 + START_Y);
                    j1point = new Point(x2, y2);
                    plotted.add(j1point);
                    x1 = x2; y1 = y2;
                    x2++;
                }
                toDraw = PLOTTED;
                repaint();
                break;
            }
            case 2: {
                x1 = START_X;
                y1 = (int)((Math.cos(Math.toRadians(2*x1)) +
                        Math.sin(Math.toRadians(x1))) * 80 + START_Y);
                j1point = new Point(x1, y1);
                plotted.add(j1point);
                x2 = x1 + 1;
                while (x2 <= FINISH) {
                    y2 = (int)((Math.cos(Math.toRadians(2*x2)) +
                        Math.sin(Math.toRadians(x2))) * 80 + START_Y);
                    j1point = new Point(x2, y2);
                    plotted.add(j1point);
                    x1 = x2; y1 = y2;
                    x2++;
                }
                toDraw = PLOTTED;
                repaint();
                break;
            }
            case 3: {
                x1 = START_X;
                y1 = (int)((Math.cos(Math.toRadians(2*x1)) +
                        Math.sin(Math.toRadians(x1/2))) * 80 + START_Y);
                j1point = new Point(x1, y1);
                plotted.add(j1point);
                x2 = x1 + 1;
                while (x2 <= FINISH) {
                    y2 = (int)((Math.cos(Math.toRadians(2*x2)) +
                        Math.sin(Math.toRadians(x2/2))) * 80 + START_Y);
                    j1point = new Point(x2, y2);
                    plotted.add(j1point);
                    x1 = x2; y1 = y2;
                    x2++;
                }
                toDraw = PLOTTED;
                repaint();
                break;
            }
        }
        calcBackCurve();
    }

    private void calcBackCurve() {
        back.clear();
        // Unitary vector
        float kx, ky;
        // Front and back tires vectors
        float fx, fy, bx, by;
        // Next front and back tires (1 -> +1)
        float fx1, fy1, bx1, by1;
        // Alpha modifier
        float am;
        // Auxiliaries variables
        float deltax, deltay, beta, theta;

        // Obtain initial back tire values and append
        bx = REAR_X;
        by = plotted.get(0).y;
        back.add(new Point((int)bx, (int)by));

        // Iterate until size - 1 because usage of next point.
        // Without this clause, Out of boundaries exception when looking
        // for the next point after the last point.
        for (int i = 0; i < plotted.size() - 1; i++) {
            // Obtein initial front tire point values
            fx = plotted.get(i).x;
            fy = plotted.get(i).y;
            fx1 = plotted.get(i+1).x;
            fy1 = plotted.get(i+1).y;
            // Calculate k
            kx = (fx - bx) / REAR_LENGTH;
            ky = (fy - by) / REAR_LENGTH;
            // Calculate alpha (a)
            deltax = fx1 - bx;
            deltay = fy1 - by;
            beta = -(2*deltax*kx + 2*deltay*ky);
            theta = (int)(Math.pow(deltax, 2) + Math.pow(deltay, 2) - Math.pow(REAR_LENGTH, 2));
            //ap = (int)((-beta + Math.sqrt(Math.pow(beta, 2) - 4*theta)) / 2);
            am = (float)((-beta - Math.sqrt(Math.pow(beta, 2) - 4*theta)) / 2);
            // Get next back tire pointer (bx1, by1) and append
            bx1 = bx + am*kx;
            by1 = by + am*ky;
            back.add(new Point((int)bx1, (int)by1));
            // Update back tire points
            bx = bx1; by = by1;
        }
    }

    public void drawBackCurve() {
        toDraw = BACK;
        repaint();
    }

    public void setFirstDrawnPoint(MouseEvent me) {
        block = true;
        if (!secondStart) {
            // Check it starts on back tire
            startOK = (me.getPoint().x >= back.get(0).x - 5)
                    && (me.getPoint().x <= back.get(0).x + 5)
                    && (me.getPoint().y >= back.get(0).y - 5)
                    && (me.getPoint().y <= back.get(0).y + 5);
            if (!startOK) {
//            JOptionPane.showMessageDialog(this, "Comenci a dibuixer a l'inici de"
//                + " la roda posterior, per favor.",
//                "Inici invàlid", JOptionPane.WARNING_MESSAGE);
                JOptionPane.showMessageDialog(this, "Comença per la roda posterior,"
                    + " que està ben mercada.",
                    "Inici invàlid", JOptionPane.WARNING_MESSAGE);
            } else {
                drawn.clear();
                j1p1 = me.getPoint();
                // Save first point
                drawn.add(j1p1);
                block = false;
            }
        } else {
            boolean secondStartOK = false;
            // Check it starts on last point drawn
            secondStartOK = (me.getPoint().x >= drawn.get(drawn.size()-1).x - 3)
                    && (me.getPoint().x <= drawn.get(drawn.size()-1).x + 3)
                    && (me.getPoint().y >= drawn.get(drawn.size()-1).y - 3)
                    && (me.getPoint().y <= drawn.get(drawn.size()-1).y + 3);
            if (!(startOK && secondStartOK)) {
                JOptionPane.showMessageDialog(this, "Comença per on ho has deixat,"
                    + " que saps ben bé on és.",
                    "Inici invàlid", JOptionPane.WARNING_MESSAGE);
            } else {
                j1p1 = me.getPoint();
                // Save first point
                drawn.add(j1p1);
                block = false;
            }
        }
    }

    public void setDrawnPoint(MouseEvent me) {
        if (me.getX() < 0 || me.getX() > SIZE_X || me.getY() < 0 || me.getY() > SIZE_Y) {
            JOptionPane.showMessageDialog(this, "Tu creus que la roda anirà fora?\n"
                    + "Torna a començar.", "Com que no", JOptionPane.WARNING_MESSAGE);
            this.plotCurve(currentLevel);
        } else {
            block = true;
            boolean pastFinish = false, goingBack = false;
            pastFinish = (me.getPoint().x >= back.get(plotted.size()-1).x + 50);
            goingBack = me.getPoint().x < drawn.get(drawn.size() - 1).x;
            if (pastFinish) {
                JOptionPane.showMessageDialog(this, "Sooo, que t'has passat!",
                    "Massa enfora", JOptionPane.WARNING_MESSAGE);
                finished = true;
                setEndingOptionPane();
            } else if (goingBack) {
                JOptionPane.showMessageDialog(this, "Tu creus que la roda anirà cap enrere?",
                    "Com que no", JOptionPane.WARNING_MESSAGE);
                secondStart = true;
            } else {
                j1p2 = me.getPoint();
                j1drawn = new Line2D.Double(j1p1, j1p2);
                // Save next point
                drawn.add(j1p2);
                // Add new line
                j1p1 = j1p2;
                toDraw = DRAWN;
                block = false;
                repaint();
            }
        }
    }

    public void checkLastPoint(MouseEvent me) {
        // If user has drawn something
        if (startOK && !block) {
            boolean finishNotOK;
            finishNotOK = (me.getPoint().x >= back.get(0).x)
                    && (me.getPoint().x <= back.get(back.size()-1).x - 5);
            if (finishNotOK) {
                //JOptionPane.showMessageDialog(this, "Acaba, que no te farà mal.",
                //    "Fi invàlid", JOptionPane.WARNING_MESSAGE);
                //this.plotCurve(currentLevel);
                Object[] buttonOptions = {"Tornar", "Recomençar"};
                int option = JOptionPane.showOptionDialog(this, "Acaba, que no te"
                        + " farà mal.\nPerò, vols tornar a començar?",
                        "Fi invàlid", JOptionPane.YES_NO_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, buttonOptions, buttonOptions[0]);
                // "Recomençar" option
                if (option == 1) this.plotCurve(currentLevel);
                // "Tornar" option
                else secondStart = true;
            } else {
                finished = true;
                setEndingOptionPane();
            }
        }
    }

    private void refillDrawnCurve() {
        final int finish_x = back.get(back.size()-1).x;
        int i = REAR_X, index = 0;
            System.out.println(finish_x);
        // Cut beginning
        while (drawn.get(0).x < i) drawn.remove(0);
        // Fill beginning
        final int first_x = drawn.get(0).x;
        final int first_y = drawn.get(0).y;
        while (i < first_x) {
            drawn.add(index, new Point(i, first_y));
            i++; index++;
        }
            System.out.println(Math.min(finish_x, drawn.get(drawn.size()-1).x));
        // Fill inbetween
        while (i < Math.min(finish_x, drawn.get(drawn.size()-1).x)) {
//            while (i > drawn.get(index+1).x) drawn.remove(index+1);
//            while (i == drawn.get(index+1).x) drawn.remove(index+1);
//            // This clause is duplicated because you need to check it twice if
//            // user has stopped and then continued with the drawing.
//            while (i > drawn.get(index+1).x) drawn.remove(index+1);
//            while (i >= drawn.get(index+1).x) {
//                while (i > drawn.get(index+1).x) drawn.remove(index+1);
//                while (i == drawn.get(index+1).x) drawn.remove(index+1);
//            }
            while (i >= drawn.get(index+1).x) drawn.remove(index+1);
            if (i != drawn.get(index).x) drawn.add(index, new Point(i, drawn.get(index-1).y));
            i++; index++;
        }
        final int last_y = drawn.get(drawn.size()-1).y;
        // If list is short
        if (i == drawn.get(drawn.size()-1).x) {
            // Fill ending
            while (i < finish_x) {
                i++;
                drawn.add(new Point(i, last_y));
            }
        }
        // If list is too large
        else {  // i == finish_x
            // Fill and cut ending
            while (i <= finish_x) {
                drawn.add(index, new Point(i, last_y));
                i++; index++;
            }
            while (index < drawn.size()) drawn.remove(index);
        }
    }

    private void setEndingOptionPane() {
        // Ask user if he wants to restart
        Object[] buttonOptions2 = {"Veure resultats", "Recomençar"};
        int option2 = JOptionPane.showOptionDialog(this, "Vols tornar a començar "
            +"o veure la teva puntuació?", "Fi de joc", JOptionPane.YES_NO_OPTION,
            JOptionPane.PLAIN_MESSAGE, null, buttonOptions2, buttonOptions2[0]);
        // "Recomençar" option
        if (option2 == 1) this.plotCurve(currentLevel);
        // "Veure resultats" option
        else {
            // Show user his results
            this.drawBackCurve();
            float score = this.calcScore();
            // JOptionPane construction
            Object[] buttonOptions3 = {"Següent nivell", "Sortir", "Acceptar"};
            JOptionPane jopShowScore = new JOptionPane("La teva puntuació és "+score+".",
                JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION,
                null, buttonOptions3, buttonOptions3[0]);
            JDialog jdShowScore = jopShowScore.createDialog("Fi de joc");
            jdShowScore.setLocation(50, 100);
            jdShowScore.setVisible(true);
            // "Sortir" option
            if (jopShowScore.getValue() == buttonOptions3[1]) System.exit(0);
            // "Següent nivell" option
            else if (jopShowScore.getValue() == buttonOptions3[0])
                this.plotCurve(((currentLevel + 1)<=3)?(currentLevel + 1):3);
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

    public float calcScore() {
        float score = 0, a = 0, b = 0, length = 0;
        int minx, maxx, miny, maxy;
        int area = 0;

            for (Point p : drawn) System.out.println(p.x+", "+p.y);
            System.out.println("-------------");
        refillDrawnCurve();
            System.out.println("-------------");
            for (Point p : drawn) System.out.println(p.x+", "+p.y);

        // Calculate area between back curve and drawn curve
        for (int i = 0; i < back.size(); i++) {
            area += (Math.max(back.get(i).y, drawn.get(i).y)
                    - Math.min(back.get(i).y, drawn.get(i).y));
        }
            System.out.println("-------------");

        // Calculate back curve length
        Point prevPoint = null;
        for (Point p : back) {
            if (prevPoint != null) {
                minx = Math.min(prevPoint.x, p.x);
                maxx = Math.max(prevPoint.x, p.x);
                miny = Math.min(prevPoint.y, p.y);
                maxy = Math.max(prevPoint.y, p.y);
                length += Math.sqrt(Math.pow((maxx-minx), 2)+Math.pow((maxy-miny), 2));
            }
            prevPoint = p;
        }
            System.out.println(area+", "+(SIZE_X*SIZE_Y));
//        a = 10/((float)SIZE_X*(float)SIZE_Y);
        a = 10/(float)(length*(REAR_LENGTH*2));
            System.out.println(a);
//        b = 1 - (float)area/((float)SIZE_X*(float)SIZE_Y);
        b = 1 - (float)area/(float)((FINISH-REAR_X)*(SIZE_Y));
            System.out.println(b);
        score = (10 - a*area);//*b;
        if (score < 1) score = 1;
            System.out.println(score);

        return score;
    }
    
    public int getCurrentLevel() {
        return currentLevel;
    }

    public boolean drawFinished() {
        return finished;
    }

    //////////////////////////////////////////////
    // EVENTS                                   //
    //////////////////////////////////////////////
}
