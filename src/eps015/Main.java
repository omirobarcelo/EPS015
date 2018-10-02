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

import javax.swing.*;
import java.awt.event.*;

/**
 *
 * @author OriolMiroBarcelo
 */
public class Main extends JFrame implements ActionListener, MouseListener {

    //////////////////////////////////////////////
    // GLOBAL VARIABLES                         //
    //////////////////////////////////////////////
    GamePanel gpan;
    private JMenuBar jmbarE15;
    private JMenu jmInici;
    private JMenu jmAjuda;
    private JMenu jmJoc1;
    private JMenu jmJoc2;
    private JMenuItem jmItemN1;
    private JMenuItem jmItemN2;
    private JMenuItem jmItemN3;
    private JMenuItem jmItemNF;
    private JMenuItem jmItemNN;
    private JMenuItem jmItemND;
    private JMenuItem jmItemExit;
    private JMenuItem jmItemRJoc1;
    private JMenuItem jmItemRJoc2;

    //////////////////////////////////////////////
    // CONSTRUCTORS                             //
    //////////////////////////////////////////////
    public Main() {
        super("EPS015");
        gpan = new GamePanel();
        gpan.addMouseListener(this);
        this.getContentPane().add(gpan);
        this.setSize(gpan.getPreferredSize());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
    }

    //////////////////////////////////////////////
    // METHODS                                  //
    //////////////////////////////////////////////
    private void initComponents() {
        jmbarE15 = new JMenuBar();
        jmInici = new JMenu();
        jmAjuda = new JMenu();
        jmJoc1 = new JMenu();
        jmJoc2 = new JMenu();
        jmItemN1 = new JMenuItem();
        jmItemN2 = new JMenuItem();
        jmItemN3 = new JMenuItem();
        jmItemNF = new JMenuItem();
        jmItemNN = new JMenuItem();
        jmItemND = new JMenuItem();
        jmItemExit = new JMenuItem();
        jmItemRJoc1 = new JMenuItem();
        jmItemRJoc2 = new JMenuItem();

        // Inici Menu definition
        // Joc 1 Menu definition
        jmItemN1.setText("Nivell 1");
        jmItemN1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
        jmItemN1.addActionListener(this);
        jmItemN2.setText("Nivell 2");
        jmItemN2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
        jmItemN2.addActionListener(this);
        jmItemN3.setText("Nivell 3");
        jmItemN3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK));
        jmItemN3.addActionListener(this);
        jmJoc1.setText("Joc 1");
        jmJoc1.add(jmItemN1);
        jmJoc1.add(jmItemN2);
        jmJoc1.add(jmItemN3);
        //jmJoc1.setMnemonic(KeyEvent.VK_A);
        jmInici.add(jmJoc1);

        // Joc 2 Menu definition
        jmItemNF.setText("Nivell Fàcil");
        jmItemNF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
        jmItemNF.addActionListener(this);
        jmItemNN.setText("Nivell Normal");
        jmItemNN.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
        jmItemNN.addActionListener(this);
        jmItemND.setText("Nivell Difícil");
        jmItemND.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
        jmItemND.addActionListener(this);
        jmJoc2.setText("Joc 2");
        jmJoc2.add(jmItemNF);
        jmJoc2.add(jmItemNN);
        jmJoc2.add(jmItemND);
        //jmJoc1.setMnemonic(KeyEvent.VK_S);
        jmInici.add(jmJoc2);

        jmItemExit.setText("Sortir");
        jmItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
        jmItemExit.addActionListener(this);

        jmInici.setText("Inici");
        jmInici.add(jmJoc1);
        jmInici.add(jmJoc2);
        jmInici.add(jmItemExit);
        jmbarE15.add(jmInici);

        // Ajuda Menu definition
        jmItemRJoc1.setText("Regles Joc 1");
        jmItemRJoc1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
        jmItemRJoc1.addActionListener(this);
        jmItemRJoc2.setText("Regles Joc 2");
        jmItemRJoc2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
        jmItemRJoc2.addActionListener(this);

        jmAjuda.setText("Ajuda");
        jmAjuda.add(jmItemRJoc1);
        jmAjuda.add(jmItemRJoc2);
        jmbarE15.add(jmAjuda);

        this.setJMenuBar(jmbarE15);
    }

    //////////////////////////////////////////////
    // EVENTS                                   //
    //////////////////////////////////////////////
    public void actionPerformed(ActionEvent evt) {
        // Event provoked Menu Item identification
        JMenuItem item = (JMenuItem)evt.getSource();
        // Exit Game
        if (item == jmItemExit) System.exit(0);
        // Joc 1 rules
        else if (item == jmItemRJoc1) {
            String rjoc1 = "  L'objectiu del joc és aconseguir destapar totes les "
                    + "mines sense explotar-ne cap.\n\n  Hi ha deu mines amagades, així "
                    + "que vés en compte on cliques!\n\n  Clicant amb el botó esquerre "
                    + "destapes la casella i amb el botó dret indiques que \nen la "
                    + "casella pot haver una mina. Una vegada destapada la casella, "
                    + "el nombre indica \nla quantitat de mines al voltant. Les diagonals "
                    + "de la casella també compten.\n\n  Sort!";
            JOptionPane jopRJoc1 = new JOptionPane();
            JOptionPane.showMessageDialog(jopRJoc1, rjoc1, "Regles Joc 1",
                JOptionPane.PLAIN_MESSAGE);
        }
        // Joc 2 rules
        else if (item == jmItemRJoc2) {
            String rjoc2 = "  L'objectiu del joc és aconseguir destapar totes les "
                    + "mines sense explotar-ne cap.\n\n  Hi ha deu mines amagades, així "
                    + "que vés en compte on cliques!\n\n  Clicant amb el botó esquerre "
                    + "destapes la casella i amb el botó dret indiques que \nen la "
                    + "casella pot haver una mina. Una vegada destapada la casella, "
                    + "el nombre indica \nla quantitat de mines al voltant. Les diagonals "
                    + "de la casella també compten.\n\n  Sort!";
            JOptionPane jopRJoc2 = new JOptionPane();
            JOptionPane.showMessageDialog(jopRJoc2, rjoc2, "Regles Joc 2",
                JOptionPane.PLAIN_MESSAGE);
        }
        // Select Joc 1 - Level 1
        else if (item == jmItemN1) {
            System.out.println("N1");
            gpan.plotCurve(1);
        }
        // Select Joc 1 - Level 2
        else if (item == jmItemN2) {
            System.out.println("N2");
            //while (!GamePanel.done) gpan.plotCurve(2);
            //gpan.plotCurve(2);
            while (GamePanel.i < 2) {
                gpan.plotCurve(2);
                GamePanel.i++;
            }
        }
        // Select Joc 1 - Level 3
        else if (item == jmItemN3) {
            System.out.println("N3");
            ActionListener alis = new ActionListener() {
                public void actionPerformed(ActionEvent evt) {
                    gpan.plotCurve(3);
                }
            };
            GamePanel.t = new Timer(1, alis);
            GamePanel.t.setInitialDelay(10);
            GamePanel.t.start();
        }
        // Select Joc 2 - Level Easy
        else if (item == jmItemNF) {
            System.out.println("NF");
        }
        // Select Joc 2 - Level Normal
        else if (item == jmItemNN) {
            System.out.println("NN");
        }
        // Select Joc 2 - Level Hard
        else if (item == jmItemND) {
            System.out.println("ND");
        }
    }    

    public void mouseClicked(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    //En el mousePressed recau tota la càrrega d'interacció del ratolí, que
    //consisteix en discernir quina casella s'ha premut.
    public void mousePressed(MouseEvent me) {
//        if (me.getButton()==MouseEvent.BUTTON1) tauler.destapar(me.getX(), me.getY());
//        else if (me.getButton()==MouseEvent.BUTTON3) tauler.marcar(me.getX(), me.getY());
//        tauler.repaint();
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseReleased(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    //////////////////////////////////////////////
    // MAIN PROGRAM                             //
    //////////////////////////////////////////////
    public static void main(String[] args) {
        Main e15 = new Main();
        e15.setVisible(true);
    }
}
