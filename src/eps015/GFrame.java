/*
 * GFrame
 *
 * Constants:
 * G1PAN/G2PAN - Used to indicate the current mode.
 *
 * Global variables:
 * Self explanatory.
 * mode initialized to Game 1 Panel to start on Game 1.
 *
 * Constructors:
 * GFrame - JFrame window setup. 800x600px, screen centered, no resizable.
 *
 * Methods:
 * initComponents - Menu Bar, Menus and MenuItems implementation.
 * showRGame1Dialog/showRGame2Dialog - 
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
//v.1.0
//public class GFrame extends JFrame implements ActionListener, MouseListener {
//
//    //////////////////////////////////////////////
//    // GLOBAL VARIABLES                         //
//    //////////////////////////////////////////////
//    GPanel gpan;
//    private JMenuBar jmbarE15;
//    private JMenu jmInici;
//    private JMenu jmAjuda;
//    private JMenu jmJoc1;
//    private JMenu jmJoc2;
//    private JMenuItem jmItemN1;
//    private JMenuItem jmItemN2;
//    private JMenuItem jmItemN3;
//    private JMenuItem jmItemNF;
//    private JMenuItem jmItemNN;
//    private JMenuItem jmItemND;
//    private JMenuItem jmItemExit;
//    private JMenuItem jmItemRJoc1;
//    private JMenuItem jmItemRJoc2;
//
//    //////////////////////////////////////////////
//    // CONSTRUCTORS                             //
//    //////////////////////////////////////////////
//    public GFrame() {
//        super("EPS015");
//        gpan = new GPanel();
//        gpan.addMouseListener(this);
//        this.getContentPane().add(gpan);
//        this.setSize(gpan.getPreferredSize());
//        this.pack();
//        this.setLocationRelativeTo(null);
//        this.setResizable(false);
//        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        initComponents();
//    }
//
//    //////////////////////////////////////////////
//    // METHODS                                  //
//    //////////////////////////////////////////////
//    private void initComponents() {
//        jmbarE15 = new JMenuBar();
//        jmInici = new JMenu();
//        jmAjuda = new JMenu();
//        jmJoc1 = new JMenu();
//        jmJoc2 = new JMenu();
//        jmItemN1 = new JMenuItem();
//        jmItemN2 = new JMenuItem();
//        jmItemN3 = new JMenuItem();
//        jmItemNF = new JMenuItem();
//        jmItemNN = new JMenuItem();
//        jmItemND = new JMenuItem();
//        jmItemExit = new JMenuItem();
//        jmItemRJoc1 = new JMenuItem();
//        jmItemRJoc2 = new JMenuItem();
//
//        // Inici Menu definition
//        // Joc 1 Menu definition
//        jmItemN1.setText("Nivell 1");
//        jmItemN1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1, ActionEvent.CTRL_MASK));
//        jmItemN1.addActionListener(this);
//        jmItemN2.setText("Nivell 2");
//        jmItemN2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_2, ActionEvent.CTRL_MASK));
//        jmItemN2.addActionListener(this);
//        jmItemN3.setText("Nivell 3");
//        jmItemN3.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_3, ActionEvent.CTRL_MASK));
//        jmItemN3.addActionListener(this);
//        jmJoc1.setText("Joc 1");
//        jmJoc1.add(jmItemN1);
//        jmJoc1.add(jmItemN2);
//        jmJoc1.add(jmItemN3);
//        //jmJoc1.setMnemonic(KeyEvent.VK_A);
//        jmInici.add(jmJoc1);
//
//        // Joc 2 Menu definition
//        jmItemNF.setText("Nivell Fàcil");
//        jmItemNF.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, ActionEvent.CTRL_MASK));
//        jmItemNF.addActionListener(this);
//        jmItemNN.setText("Nivell Normal");
//        jmItemNN.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, ActionEvent.CTRL_MASK));
//        jmItemNN.addActionListener(this);
//        jmItemND.setText("Nivell Difícil");
//        jmItemND.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, ActionEvent.CTRL_MASK));
//        jmItemND.addActionListener(this);
//        jmJoc2.setText("Joc 2");
//        jmJoc2.add(jmItemNF);
//        jmJoc2.add(jmItemNN);
//        jmJoc2.add(jmItemND);
//        //jmJoc1.setMnemonic(KeyEvent.VK_S);
//        jmInici.add(jmJoc2);
//
//        jmItemExit.setText("Sortir");
//        jmItemExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
//        jmItemExit.addActionListener(this);
//
//        jmInici.setText("Inici");
//        jmInici.add(jmJoc1);
//        jmInici.add(jmJoc2);
//        jmInici.add(jmItemExit);
//        jmbarE15.add(jmInici);
//
//        // Ajuda Menu definition
//        jmItemRJoc1.setText("Regles Joc 1");
//        jmItemRJoc1.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, ActionEvent.CTRL_MASK));
//        jmItemRJoc1.addActionListener(this);
//        jmItemRJoc2.setText("Regles Joc 2");
//        jmItemRJoc2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, ActionEvent.CTRL_MASK));
//        jmItemRJoc2.addActionListener(this);
//
//        jmAjuda.setText("Ajuda");
//        jmAjuda.add(jmItemRJoc1);
//        jmAjuda.add(jmItemRJoc2);
//        jmbarE15.add(jmAjuda);
//
//        this.setJMenuBar(jmbarE15);
//    }
//
//    //////////////////////////////////////////////
//    // EVENTS                                   //
//    //////////////////////////////////////////////
//    public void actionPerformed(ActionEvent evt) {
//        // Event provoked Menu Item identification
//        JMenuItem item = (JMenuItem)evt.getSource();
//        // Exit Game
//        if (item == jmItemExit) System.exit(0);
//        // Joc 1 rules
//        else if (item == jmItemRJoc1) {
//            String rjoc1 = "  L'objectiu del joc és aconseguir destapar totes les "
//                    + "mines sense explotar-ne cap.\n\n  Hi ha deu mines amagades, així "
//                    + "que vés en compte on cliques!\n\n  Clicant amb el botó esquerre "
//                    + "destapes la casella i amb el botó dret indiques que \nen la "
//                    + "casella pot haver una mina. Una vegada destapada la casella, "
//                    + "el nombre indica \nla quantitat de mines al voltant. Les diagonals "
//                    + "de la casella també compten.\n\n  Sort!";
//            JOptionPane jopRJoc1 = new JOptionPane();
//            JOptionPane.showMessageDialog(jopRJoc1, rjoc1, "Regles Joc 1",
//                JOptionPane.PLAIN_MESSAGE);
//        }
//        // Joc 2 rules
//        else if (item == jmItemRJoc2) {
//            String rjoc2 = "  L'objectiu del joc és aconseguir destapar totes les "
//                    + "mines sense explotar-ne cap.\n\n  Hi ha deu mines amagades, així "
//                    + "que vés en compte on cliques!\n\n  Clicant amb el botó esquerre "
//                    + "destapes la casella i amb el botó dret indiques que \nen la "
//                    + "casella pot haver una mina. Una vegada destapada la casella, "
//                    + "el nombre indica \nla quantitat de mines al voltant. Les diagonals "
//                    + "de la casella també compten.\n\n  Sort!";
//            JOptionPane jopRJoc2 = new JOptionPane();
//            JOptionPane.showMessageDialog(jopRJoc2, rjoc2, "Regles Joc 2",
//                JOptionPane.PLAIN_MESSAGE);
//        }
//        // Select Joc 1 - Level 1
//        else if (item == jmItemN1) {
//            System.out.println("N1");
//            ActionListener alis = new ActionListener() {
//                public void actionPerformed(ActionEvent evt) {
//                    gpan.plotCurve(1);
//                }
//            };
//            GUtilities.startTimer(10, 1, alis);
//        }
//        // Select Joc 1 - Level 2
//        else if (item == jmItemN2) {
//            System.out.println("N2");
//            ActionListener alis = new ActionListener() {
//                public void actionPerformed(ActionEvent evt) {
//                    gpan.plotCurve(2);
//                }
//            };
//            GUtilities.startTimer(10, 1, alis);
//        }
//        // Select Joc 1 - Level 3
//        else if (item == jmItemN3) {
//            System.out.println("N3");
//            ActionListener alis = new ActionListener() {
//                public void actionPerformed(ActionEvent evt) {
//                    gpan.plotCurve(3);
//                }
//            };
//            GUtilities.startTimer(10, 1, alis);
//        }
//        // Select Joc 2 - Level Easy
//        else if (item == jmItemNF) {
//            System.out.println("NF");
//        }
//        // Select Joc 2 - Level Normal
//        else if (item == jmItemNN) {
//            System.out.println("NN");
//        }
//        // Select Joc 2 - Level Hard
//        else if (item == jmItemND) {
//            System.out.println("ND");
//        }
//    }
//
//    public void mouseClicked(MouseEvent me) {
////        throw new UnsupportedOperationException("Not supported yet.");
//        gpan.listDrawnCurve();
//    }
//
//    //En el mousePressed recau tota la càrrega d'interacció del ratolí, que
//    //consisteix en discernir quina casella s'ha premut.
//    public void mousePressed(MouseEvent me) {
////        if (me.getButton()==MouseEvent.BUTTON1) tauler.destapar(me.getX(), me.getY());
////        else if (me.getButton()==MouseEvent.BUTTON3) tauler.marcar(me.getX(), me.getY());
////        tauler.repaint();
////        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public void mouseReleased(MouseEvent me) {
////        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public void mouseEntered(MouseEvent me) {
////        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    public void mouseExited(MouseEvent me) {
////        throw new UnsupportedOperationException("Not supported yet.");
//    }
//
//    //////////////////////////////////////////////
//    // MAIN PROGRAM                             //
//    //////////////////////////////////////////////
//    public static void main(String[] args) {
//        GFrame e15 = new GFrame();
//        e15.setVisible(true);
//    }
//}


//v.2.0
public class GFrame extends JFrame implements ActionListener,
                                              MouseListener,
                                              MouseMotionListener,
                                              KeyListener {

    //////////////////////////////////////////////
    // CONSTANTS                                //
    //////////////////////////////////////////////
    public static final boolean G1PAN = true;
    public static final boolean G2PAN = false;

    //////////////////////////////////////////////
    // GLOBAL VARIABLES                         //
    //////////////////////////////////////////////
    GPanel g1pan;
    G2Panel g2pan;
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

    public boolean mode = G1PAN;

    //////////////////////////////////////////////
    // CONSTRUCTORS                             //
    //////////////////////////////////////////////
    public GFrame() {
        super("EPS015");
        g1pan = new GPanel();
        g2pan = new G2Panel();
        g1pan.addMouseListener(this);
        g2pan.addMouseListener(this);
        g1pan.addMouseMotionListener(this);
        g2pan.addMouseMotionListener(this);
        g1pan.addKeyListener(this);
        g2pan.addKeyListener(this);
        // Gives the keyboard focus, needed for KeyEvents
        g1pan.setFocusable(true);
        g2pan.setFocusable(true);

        this.getContentPane().add(g1pan);
        this.setSize(g1pan.getPreferredSize());
        this.pack();
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();

        // Start frame with level 1 game and its rules
        g1pan.plotCurve(1);
        this.showRGame1Dialog();
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

    private void showRGame1Dialog() {
        String rjoc1 = "  Dibuixa la trajectòria de la roda posterior d'una bicicleta!"
                + "\n\n  La línia vermella representa el moviment de la roda davantera"
                + " d'una bicicleta, i el teu \nobjectiu és dibuixar el recorregut de "
                + "la roda posterior.\n\n  Usa el ratolí per dibuixar aquesta trajectòria"
                + " començant per la roda posterior de la \nbicicleta.\n\n  Per dibuixar "
                + "mantingues pitjat el botó del ratolí. En acabar se't mostrarà la "
                + "la trajectòria\ncorrecta i la puntuació que has tret. Com més "
                + "s'aproximi al moviment real, més punts!";
            JOptionPane jopRJoc1 = new JOptionPane();
            JOptionPane.showMessageDialog(jopRJoc1, rjoc1, "Regles Joc 1",
                JOptionPane.PLAIN_MESSAGE);
    }

    private void showRGame2Dialog() {
        String rjoc2 = "  Arriba al final sense pegar-te amb cap obstacle!\n\n"
                + "  Comença en el recuadre a l'esquerra i avança fins al final."
                + " Si toques un obstacle hauràs\nde recomençar. Si passes pels "
                + "punts obtendràs una bonificació a la puntuació.\n\n  La teva "
                + "puntuació serà la longitut del recorregut que facis, per tant"
                + " quant més curt\nsigui el teu recorregut millor!\n\n  En acabar"
                + " se't mostrarà la teva puntuació i les teves bonificacions.\n"
                + "\n  Sort!";
            JOptionPane jopRJoc2 = new JOptionPane();
            JOptionPane.showMessageDialog(jopRJoc2, rjoc2, "Regles Joc 2",
                JOptionPane.PLAIN_MESSAGE);
    }

    //////////////////////////////////////////////
    // EVENTS                                   //
    //////////////////////////////////////////////
    public void actionPerformed(ActionEvent evt) {
        // Event provoked Menu Item identification
        JMenuItem item = (JMenuItem)evt.getSource();
        // Exit Game
        if (item == jmItemExit) System.exit(0);
        // Game 1 rules
        else if (item == jmItemRJoc1) {
            this.showRGame1Dialog();
        }
        // Game 2 rules
        else if (item == jmItemRJoc2) {
            this.showRGame2Dialog();
        }
        // If Game 1 levels are selected
        else if (item == jmItemN1 || item == jmItemN2 || item == jmItemN3) {
            // If necessary a change of mode
            if (mode == G2PAN) {
                mode = G1PAN;
                this.getContentPane().remove(g2pan);
                //this.getContentPane().add(g2pan);
                this.setContentPane(g1pan);
    //            this.invalidate();
                this.validate();
    //            this.pack();
                repaint();
            }
            // Select Game 1 - Level 1
            if (item == jmItemN1) {
                System.out.println("N1");
                g1pan.plotCurve(1);
            }
            // Select Game 1 - Level 2
            else if (item == jmItemN2) {
                System.out.println("N2");
                g1pan.plotCurve(2);
            }
            // Select Game 1 - Level 3
            else if (item == jmItemN3) {
                System.out.println("N3");
                g1pan.plotCurve(3);
            }
        }
        // If Game 2 levels are selected
        else if (item == jmItemNF || item == jmItemNN || item == jmItemND) {
            // If necessary a change of mode
            if (mode == G1PAN) {
                mode = G2PAN;
                this.getContentPane().remove(g1pan);
                //this.getContentPane().add(g2pan);
                this.setContentPane(g2pan);
    //            this.invalidate();
                this.validate();
    //            this.pack();
                repaint();
            }
            // Select Game 2 - Level Easy
            if (item == jmItemNF) {
                System.out.println("NF");
                g2pan.selectLevel(1);
            }
            // Select Game 2 - Level Normal
            else if (item == jmItemNN) {
                System.out.println("NN");
                g2pan.selectLevel(2);
            }
            // Select Game 2 - Level Hard
            else if (item == jmItemND) {
                System.out.println("ND");
                g2pan.selectLevel(3);
            }
        }
    }

    public void mouseClicked(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    // In mousePressed, mouseDragged and mouseRelesaed cannot draw if you
    // have finished.
    public void mousePressed(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet.");
        if (mode == G1PAN) {
            if (!g1pan.drawFinished())
                g1pan.setFirstDrawnPoint(me);
        } else if (mode ==G2PAN) {
            if (!g2pan.drawFinished())
                g2pan.setFirstDrawnPoint(me);
        }
    }

    public void mouseDragged(MouseEvent me) {
        if (mode == G1PAN) {
            if (!g1pan.drawFinished())
                g1pan.setDrawnPoint(me);
        } else if (mode == G2PAN) {
            g2pan.setDrawnPoint(me);
        }
    }

    public void mouseReleased(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet.");
        if (mode == G1PAN) {
        if (!g1pan.drawFinished())
            g1pan.checkLastPoint(me);
        } else if (mode == G2PAN) {
            g2pan.checkLastPoint(me);
        }
    }

    public void mouseMoved(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseEntered(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void mouseExited(MouseEvent me) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyTyped(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    public void keyPressed(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet.");
        if (ke.getKeyCode() == KeyEvent.VK_ENTER) {
//            if (!fsEnter) {         // First Enter
//                gpan.drawBackCurve();
//                fsEnter = true;
//            } else {                // Second Enter
//                int score = 0; //calcScore();
//                // JOptionPane construction
//                Object[] buttonOptions = {"Següent nivell", "Sortir", "Acceptar"};
//                int option = JOptionPane.showOptionDialog(this, "La teva puntuació és "
//                        +score+".", "Fi de joc", JOptionPane.YES_NO_CANCEL_OPTION,
//                        JOptionPane.PLAIN_MESSAGE, null, buttonOptions, buttonOptions[0]);
//                fsEnter = false;
//                // "Sortir" option
//                if (option == 1) System.exit(0);
//                // "Següent nivell" option
//                else if (option == 0)
//                    gpan.plotCurve(((gpan.getCurrentLevel() + 1)<=3)?(gpan.getCurrentLevel() + 1):3);
//            }

            if (mode == G1PAN) {
                if (g1pan.drawFinished()) {
                    // Show user his results
                    float score = g1pan.calcScore();
                    // JOptionPane construction
                    Object[] buttonOptions3 = {"Següent nivell", "Sortir", "Recomençar"};
                    int option3 = JOptionPane.showOptionDialog(this, "La teva puntuació és "
                        +score+".", "Fi de joc", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, buttonOptions3, buttonOptions3[0]);
                    // "Recomençar" option
                    if (option3 == 2) g1pan.plotCurve(g1pan.getCurrentLevel());
                    // "Sortir" option
                    else if(option3 == 1) System.exit(0);
                    // "Següent nivell" option
                    else if (option3 == 0)
                        g1pan.plotCurve(((g1pan.getCurrentLevel() + 1)<=3)?(g1pan.getCurrentLevel() + 1):3);
                } else {
                    Object[] buttonOptions = {"Cancel·lar", "Recomençar"};
                    int option2 = JOptionPane.showOptionDialog(this, "Vols tornar a començar?",
                            "Fi de joc", JOptionPane.YES_NO_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null, buttonOptions, buttonOptions[0]);
                    // "Recomençar" option
                    if (option2 == 1) g1pan.plotCurve(g1pan.getCurrentLevel());
                }
            } else if (mode == G2PAN) {
                if (g2pan.drawFinished()) {
                    // Show user his results
                    float score = g2pan.calcLength();
                    // JOptionPane construction
                    Object[] buttonOptions3 = {"Següent nivell", "Sortir", "Recomençar"};
                    int option3 = JOptionPane.showOptionDialog(this, "La teva puntuació és "
                        +score+".", "Fi de joc", JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.PLAIN_MESSAGE, null, buttonOptions3, buttonOptions3[0]);
                    // "Recomençar" option
                    if (option3 == 2) g2pan.selectLevel(g2pan.getCurrentLevel());
                    // "Sortir" option
                    else if(option3 == 1) System.exit(0);
                    // "Següent nivell" option
                    else if (option3 == 0)
                        g2pan.selectLevel(((g2pan.getCurrentLevel() + 1)<=3)?(g2pan.getCurrentLevel() + 1):3);
                } else {
                    Object[] buttonOptions = {"Cancel·lar", "Recomençar"};
                    int option2 = JOptionPane.showOptionDialog(this, "Vols tornar a començar?",
                            "Fi de joc", JOptionPane.YES_NO_OPTION,
                            JOptionPane.PLAIN_MESSAGE, null, buttonOptions, buttonOptions[0]);
                    // "Recomençar" option
                    if (option2 == 1) g2pan.selectLevel(g2pan.getCurrentLevel());
                }
            }
        }
    }

    public void keyReleased(KeyEvent ke) {
//        throw new UnsupportedOperationException("Not supported yet.");
    }

    //////////////////////////////////////////////
    // MAIN PROGRAM                             //
    //////////////////////////////////////////////
    public static void main(String[] args) {
        GFrame e15 = new GFrame();
        e15.setVisible(true);
    }
}
