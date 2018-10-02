/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package eps015;

/**
 *
 * @author OriolMiroBarcelo
 */
import java.awt.*;
import java.awt.image.*;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

class Image extends JPanel {
    private BufferedImage img;

    public Image(String s) {
        try {
            img = ImageIO.read(new File(s));
        } catch (IOException e) {}
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(img, 0, 0, null);
    }

    @Override
    public Dimension getPreferredSize() {
        if (img == null) {
            return new Dimension(100, 100);
        } else {
            return new Dimension(img.getWidth(null), img.getHeight(null));
        }
    }
}

