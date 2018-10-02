/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eps015;

import java.awt.Point;
/**
 *
 * @author OriolMiroBarcelo
 */
public class GPoint {
    //////////////////////////////////////////////
    // ATTRIBUTES                               //
    //////////////////////////////////////////////
    Point p;
    GPoint n;

    //////////////////////////////////////////////
    // CONSTRUCTOR                              //
    //////////////////////////////////////////////
    public GPoint(Point p) {
        this.p = p;
        this.n = null;
    }

    //////////////////////////////////////////////
    // GETTERS & SETTERS                        //
    //////////////////////////////////////////////
    public GPoint next() {
        return this.n;
    }

    //////////////////////////////////////////////
    // METHODS                                  //
    //////////////////////////////////////////////
    public void insert(Point np) {
        GPoint cp = this;
        while (cp.n != null) cp = cp.n;
        cp.n = new GPoint(np);
    }

    public void list() {
        GPoint cp = this;
        while (cp != null) {
            System.out.println(cp.p.x+", "+cp.p.y);
            cp = cp.n;
        }
    }
}
