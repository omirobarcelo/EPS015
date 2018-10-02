/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eps015;

import java.awt.event.ActionListener;
import javax.swing.Timer;

/**
 *
 * @author OriolMiroBarcelo
 */
public class GUtilities {
    //////////////////////////////////////////////
    // GLOBAL VARIABLES                         //
    //////////////////////////////////////////////
    static public Timer t;

    //////////////////////////////////////////////
    // METHODS                                  //
    //////////////////////////////////////////////
    public static void startTimer(int start, int delay, ActionListener al) {
        t = new Timer(delay, al);
        t.setInitialDelay(start);
        t.start();
    }

    public static void stopTimer() {
        t.stop();
    }
}
