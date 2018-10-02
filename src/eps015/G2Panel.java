/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eps015;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
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

    //////////////////////////////////////////////
    // GLOBAL VARIABLES                         //
    //////////////////////////////////////////////

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

        Obstacle[] obs = new Obstacle[4];
        for (int i = 0; i < 4; i++) {
            int p = (int)Math.round(Math.random()*SIZE_X);
            int q = (int)Math.round(Math.random()*SIZE_Y);
            obs[i] = new Obstacle(p, q);
        }
        for (int i = 0; i < obs.length; i++) obs[i].paintQuadrat(g, 50);
    }

    //////////////////////////////////////////////
    // FUNCTIONS                                //
    //////////////////////////////////////////////

    //////////////////////////////////////////////
    // EVENTS                                   //
    //////////////////////////////////////////////
}
