/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eps015;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.ArrayList;
import javax.swing.*;

/**
 *
 * @author OriolMiroBarcelo
 */
public class G2Panel extends JPanel {
    //////////////////////////////////////////////
    // CONSTANTS                                //
    //////////////////////////////////////////////
    static final int SIZE_X = 1000;
    static final int SIZE_Y = 500;

    static final int START = 100;
    static final int FINISH = 900;

    static final int REAR_LENGTH = 50;

    static final int NUM_OBS = 10;
    static final int NUM_BONUS = 3;
    static final int BONUS_L = 5;
    static final int BONUS_S = 150;         // Bonus score
    static final Geom cercle = Geom.CIRCLE;
    static final Geom elipse = Geom.ELLIPSE;
    static final Geom quadrat = Geom.SQUARE;
    static final Geom rectangle = Geom.RECTANGLE;

    //////////////////////////////////////////////
    // GLOBAL VARIABLES                         //
    //////////////////////////////////////////////
    private boolean firstTime = true;
    private int currentLevel = 1;
    private boolean startOK = false;
    private boolean secondStart = false;
    private boolean finished = false;
    private boolean block = true;

    private Point j2p1, j2p2;
    private Line2D j2drawn;
    private Obstacle[] obs;
    private Point[] bonus;
    private boolean[] bonus_pass;

    private static ArrayList<Point> back = new ArrayList();
    private static ArrayList<Point> drawn = new ArrayList();

    //////////////////////////////////////////////
    // CONSTRUCTORS                             //
    //////////////////////////////////////////////
    public G2Panel() {}

    //////////////////////////////////////////////
    // METHODS                                  //
    //////////////////////////////////////////////
    @Override
    public void paintComponent(Graphics g) {
//
//        //super.paintComponent(g);
//
//        Graphics2D g2d = (Graphics2D) g;
//
////        Obstacle obs = new Obstacle(250, 250);
////        obs.paintQuadrat(g, 50);
//        if (!start) {
//            for (int i = 0; i < NUM_OBS; i++) {
//                int p = (int)Math.round(Math.random()*MIDA);
//                int q = (int)Math.round(Math.random()*MIDA);
//                obs[i] = new Obstacle(p, q);
//            }
//            start = true;
//        }
//        for (int i = 0; i < obs.length; i++) obs[i].paintQuadrat(g, 50);
//
//        if (point1 != null && point2 != null) {
//
//            g2d.setPaint(Color.RED);
//            g2d.setStroke(new BasicStroke(1.5f));
//            g2d.draw(line2d);
//
//        }
        Graphics2D g2d = (Graphics2D)g;

        if (firstTime) {
            // Restart control variables
            startOK = false;
            secondStart = false;
            finished = false;
            // Restart panel
            g2d.setColor(Color.WHITE);
            g2d.fillRect(0, 0, SIZE_X, SIZE_Y);
            // Draw start and ending lines
            g2d.setPaint(Color.BLACK);
            g2d.setStroke(new BasicStroke(1.5f));
            g2d.drawLine(START, 0, START, SIZE_Y);
            g2d.drawLine(FINISH, 0, FINISH, SIZE_Y);
            g2d.drawLine(START-25, SIZE_Y/2-50, START+25, SIZE_Y/2-50);
            g2d.drawLine(START+25, SIZE_Y/2-50, START+25, SIZE_Y/2+50);
            g2d.drawLine(START+25, SIZE_Y/2+50, START-25, SIZE_Y/2+50);
            g2d.drawLine(START-25, SIZE_Y/2+50, START-25, SIZE_Y/2-50);
            // Draw obstacles
            obs = new Obstacle[NUM_OBS];
            for (int i = 0; i < NUM_OBS; i++) {
                int p, q;
//                if (i < NUM_OBS/3) {    // For 1/3, possible all area
//                    p = (START+25) + (int)Math.round(Math.random()*(FINISH-START-50));
//                    q = 25 + (int)Math.round(Math.random()*(SIZE_Y-50));
//                } else {                // For 2/3, obstacles more centered
//                    p = (START+(FINISH-START)/4) + (int)Math.round(Math.random()*((FINISH-START)/2));
//                    q = (SIZE_Y/4) + (int)Math.round(Math.random()*(SIZE_Y/2));
//                }
                p = (START+25) + (int)Math.round(Math.random()*(FINISH-START-50));
                q = (i%5)*100 + (int)Math.round(Math.random()*(SIZE_Y/5));
                if (currentLevel == 1) {
                    obs[i] = new Obstacle(p, q, quadrat);
                } else if (currentLevel == 2 || currentLevel == 3) {
                    Geom[] figures = Geom.values();
                    int r = (int)Math.floor(Math.random()*3.99f);
                    obs[i] = new Obstacle(p, q, figures[r]);
                }
            }
            if (currentLevel == 1 || currentLevel == 2) {
                for (int i = 0; i < obs.length; i++) obs[i].paintObstacle(g, 50, 75);
            } else if (currentLevel == 3) {
                int r1 = (int)(45 + Math.random()*50);
                int r2 = (int)(45 + Math.random()*50);
                for (int i = 0; i < obs.length; i++) obs[i].paintObstacle(g, r1, r2);
            }
            // Draw bonus points
            bonus = new Point[NUM_BONUS];
            bonus_pass = new boolean[NUM_BONUS];
            for (int i = 0; i < NUM_BONUS; i++) bonus_pass[i] = false;
            for (int i = 0; i < NUM_BONUS; i++) {
                int p = (START+(FINISH-START)/20) + (int)Math.round(Math.random()*((FINISH-START)*9/10));
                int q = (SIZE_Y/20) + (int)Math.round(Math.random()*(SIZE_Y*9/10));
                bonus[i] = new Point(p, q);
                Ellipse2D.Float eli = new Ellipse2D.Float(p, q, BONUS_L, BONUS_L);
                g2d.setPaint(Color.BLACK);
                g2d.setStroke(new BasicStroke(1.0f));
                g2d.draw(eli);
                g2d.setColor(Color.BLACK);
                g2d.fill(eli);
            }
            firstTime = false;
        }
        if (j2p1 != null && j2p2 != null) {
            g2d.setPaint(Color.RED);
            g2d.setStroke(new BasicStroke(3.5f));
            g2d.draw(j2drawn);
            g2d.setPaint(Color.BLUE);
            g2d.drawLine(back.get(back.size()-2).x, back.get(back.size()-2).y,
                    back.get(back.size()-1).x, back.get(back.size()-1).y);
            //g2d.setPaint(Color.BLACK);
            //g2d.drawLine((int)j2drawn.getX2(), (int)j2drawn.getY2(),
            //        back.get(back.size()-1).x, back.get(back.size()-1).y);
        }
    }

    public void selectLevel(int level) {
        firstTime = true;
        j2p1 = null; j2p2 = null;
        currentLevel = level;
        repaint();
    }

    public void setFirstDrawnPoint(MouseEvent me) {
        block = true;
        if (!secondStart) {
            // Check it starts on back tire
            startOK = (me.getPoint().x >= START - 25)
                    && (me.getPoint().x <= START + 25)
                    && (me.getPoint().y >= SIZE_Y/2-50)
                    && (me.getPoint().y <= SIZE_Y/2+50);
            if (!startOK) {
                JOptionPane.showMessageDialog(this, "Comença per l'inici,"
                    + " que està ben mercat a l'esquerra.",
                    "Inici invàlid", JOptionPane.WARNING_MESSAGE);
            } else {
                drawn.clear();
                back.clear();
                j2p1 = me.getPoint();
                // Save first drawn point
                drawn.add(j2p1);
                // Save first back point
                back.add(new Point((j2p1.x-REAR_LENGTH), j2p1.y));
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
                j2p1 = me.getPoint();
                // Save first drawn point
                drawn.add(j2p1);
                // Save first back point
                //back.add(new Point((back.get(back.size()-1).x + 1), back.get(back.size()-1).y));
                block = false;
            }
        }
    }

    public void setDrawnPoint(MouseEvent me) {
        if (me.getX() < 0 || me.getX() > SIZE_X || me.getY() < 0 || me.getY() > SIZE_Y) {
            JOptionPane.showMessageDialog(this, "Tu creus que la roda anirà fora?\n"
                    + "Torna a començar.", "Com que no", JOptionPane.WARNING_MESSAGE);
            this.selectLevel(currentLevel);
        } else {
            block = true;
            boolean pastFinish = false;
            pastFinish = (me.getPoint().x >= FINISH);
            //if (pastFinish) {
            //    finished = true;
            //    setEndingOptionPane();
            //} else {
                j2p2 = me.getPoint();
                j2drawn = new Line2D.Double(j2p1, j2p2);
                // Save next point
                drawn.add(j2p2);
                // Check if it crosses a bonus point
                for (int i = 0; i < NUM_BONUS; i++) {
                    if (j2p2.x >= bonus[i].x && j2p2.x <= bonus[i].x+BONUS_L &&
                            j2p2.y >= bonus[i].y && j2p2.y <= bonus[i].y+BONUS_L)
                        bonus_pass[i] = true;
                }
                // Calculate associted back point
                calcBackPoint();
                // Check if there is a colision
                boolean colision = checkColision(me.getPoint(), back.get(back.size()-1));
                if (colision) {
//                    JOptionPane.showMessageDialog(this, "Comença per on ho has deixat,"
//                    + " que saps ben bé on és.",
//                    "Inici invàlid", JOptionPane.WARNING_MESSAGE);
                    this.selectLevel(currentLevel);
                } else {
                    // Add new line
                    j2p1 = j2p2;
                    block = false;
                    repaint();
                    if (pastFinish) {
                        finished = true;
                        setEndingOptionPane();
                    }
                }
            //}
        }
    }

    public void checkLastPoint(MouseEvent me) {
        // If user has drawn something
        if (startOK && !block) {
            boolean finishNotOK;
            finishNotOK = (me.getPoint().x > START - 25)
                    && (me.getPoint().x < FINISH);
            if (finishNotOK) {
                Object[] buttonOptions = {"Tornar", "Recomençar"};
                int option = JOptionPane.showOptionDialog(this, "Acaba, que no te"
                        + " farà mal.\nPerò, vols tornar a començar?",
                        "Fi invàlid", JOptionPane.YES_NO_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, buttonOptions, buttonOptions[0]);
                // "Recomençar" option
                if (option == 1) this.selectLevel(currentLevel);
                // "Tornar" option
                else secondStart = true;
            //} else {
            //    finished = true;
            //    setEndingOptionPane();
            }
        }
    }

    private void calcBackPoint() {
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

        // Obtain initial back tire values
        bx = back.get(back.size()-1).x;
        by = back.get(back.size()-1).y;

        // Obtein initial front tire point values
        fx = j2p1.x;
        fy = j2p1.y;
        fx1 = j2p2.x;
        fy1 = j2p2.y;
        // Calculate k
        kx = (fx - bx) / REAR_LENGTH;
        ky = (fy - by) / REAR_LENGTH;
        // Calculate alpha (a)
        deltax = fx1 - bx;
        deltay = fy1 - by;
        beta = -(2 * deltax * kx + 2 * deltay * ky);
        theta = (int) (Math.pow(deltax, 2) + Math.pow(deltay, 2) - Math.pow(REAR_LENGTH, 2));
        //ap = (int)((-beta + Math.sqrt(Math.pow(beta, 2) - 4*theta)) / 2);
        am = (float) ((-beta - Math.sqrt(Math.pow(beta, 2) - 4 * theta)) / 2);
        // Get next back tire pointer (bx1, by1) and append
        bx1 = bx + am * kx;
        by1 = by + am * ky;
        back.add(new Point((int) bx1, (int) by1));
    }

    private void setEndingOptionPane() {
        // Ask user if he wants to restart
        Object[] buttonOptions2 = {"Veure resultats", "Recomençar"};
        int option2 = JOptionPane.showOptionDialog(this, "Has acabat!\nVols tornar a començar"
            +" o veure la teva puntuació?", "Fi de joc", JOptionPane.YES_NO_OPTION,
            JOptionPane.PLAIN_MESSAGE, null, buttonOptions2, buttonOptions2[0]);
        // "Recomençar" option
        if (option2 == 1) this.selectLevel(currentLevel);
        // "Veure resultats" option
        else {
            // Show user his results
            float score = this.calcLength();
            // JOptionPane construction
            int bonus_sc = 0;
            for (boolean b : bonus_pass) if (b) bonus_sc += BONUS_S;
            Object[] buttonOptions3 = {"Següent nivell", "Sortir", "Acceptar"};
            JOptionPane jopShowScore = new JOptionPane("La teva puntuació és "+score+"."
                    +"Bonus: "+bonus_sc,
                JOptionPane.PLAIN_MESSAGE, JOptionPane.YES_NO_CANCEL_OPTION,
                null, buttonOptions3, buttonOptions3[0]);
            JDialog jdShowScore = jopShowScore.createDialog("Fi de joc");
            jdShowScore.setLocation(50, 100);
            jdShowScore.setVisible(true);
            // "Sortir" option
            if (jopShowScore.getValue() == buttonOptions3[1]) System.exit(0);
            // "Següent nivell" option
            else if (jopShowScore.getValue() == buttonOptions3[0])
                this.selectLevel(((currentLevel + 1)<=3)?(currentLevel + 1):3);
        }
    }

    //////////////////////////////////////////////
    // FUNCTIONS                                //
    //////////////////////////////////////////////
    public float calcLength() {
        float length = 0;
        int minx, miny, maxx, maxy;

        // Calculate drawn curve length
        Point prevPoint = null;
        for (Point p : drawn) {
            if (prevPoint != null) {
                minx = Math.min(prevPoint.x, p.x);
                maxx = Math.max(prevPoint.x, p.x);
                miny = Math.min(prevPoint.y, p.y);
                maxy = Math.max(prevPoint.y, p.y);
                length += Math.sqrt(Math.pow((maxx-minx), 2)+Math.pow((maxy-miny), 2));
            }
            prevPoint = p;
        }

        return length;
    }

    private boolean checkColision(Point f, Point b) {
        boolean colision = false;
        int cx, cy, d1, d2;

        for (Obstacle o : obs) {
            cx = o.getcx(); cy = o.getcy(); d1 = o.getd1(); d2 = o.getd2();
            if (f.x > cx-(d1/2) && f.x < cx+(d1/2) &&
                    f.y > cy-(d2/2) && f.y < cy+(d2/2) ||
                    b.x > cx-(d1/2) && b.x < cx+(d1/2) &&
                    b.y > cy-(d2/2) && b.y < cy+(d2/2)) {
                colision = true;
                JDialog d = new JDialog();
                d.setTitle("BAAAAAAAAAAAAAAAAAAM");
                d.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
                d.setModal(true);
                int r = (int)Math.floor(Math.random()*2.99f);
                Image img = new Image("img/colision1.jpg");
                switch (r) {
                    case 1: {
                        img = new Image("img/colision2.jpg");
                        break;
                    }
                    case 2: {
                        img = new Image("img/colision3.jpg");
                        break;
                    }
                }
                d.setSize(img.getPreferredSize());
                d.setLocationRelativeTo(null);
                d.setResizable(false);
                d.getContentPane().add(img);
                d.pack();
                d.setVisible(true);
            }
        }

        return colision;
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
