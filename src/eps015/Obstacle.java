/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eps015;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

/**
 *
 * @author OriolMiroBarcelo
 */
public class Obstacle {
    private int cx;
    private int cy;

    public Obstacle(int x, int y) {
        cx = x;
        cy = y;
    }

    public int getcx() {
        return this.cx;
    }

    public int getcy() {
        return this.cy;
    }

    public void setcx(int x) {
        this.cx = x;
    }

    public void setcy(int y) {
        this.cy = y;
    }

    public void paintQuadrat(Graphics g, int l) {
        Graphics2D g2d = (Graphics2D)g;
        int sex = cx - l/2;
        int sey = cy - l/2;
        Rectangle2D.Float rec = new Rectangle2D.Float(sex, sey, l, l);
        g2d.setPaint(Color.BLACK);
        g2d.setStroke(new BasicStroke(5.0f));
        g2d.draw(rec);
        g2d.setColor(Color.ORANGE);
        g2d.fill(rec);
    }
}