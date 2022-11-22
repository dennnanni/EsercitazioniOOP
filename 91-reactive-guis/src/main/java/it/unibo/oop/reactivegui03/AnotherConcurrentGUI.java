package it.unibo.oop.reactivegui03;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 * Third experiment with reactive gui.
 */
public final class AnotherConcurrentGUI extends JFrame {

    private boolean incrementing;

    private static final double WIDTH_PERC = 0.2;
    private static final double HEIGHT_PERC = 0.1;

    private final JLabel lblCounter = new JLabel();

    /**
     * Builds the GUI.
     */
    public AnotherConcurrentGUI() {
        final JPanel pnlMain = new JPanel();
        final Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setSize((int) (screenSize.getWidth() * WIDTH_PERC), (int) (screenSize.getHeight() * HEIGHT_PERC));

        final JButton btnUp = new JButton("Up");
        final JButton btnDown = new JButton("Down");
        final JButton btnStop = new JButton("Stop");

        pnlMain.add(lblCounter);
        pnlMain.add(btnUp);
        pnlMain.add(btnDown);
        pnlMain.add(btnStop);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(pnlMain);

        this.setVisible(true);

        // Handler
        btnUp.addActionListener((e) -> setIncrementing(true));
        btnDown.addActionListener((e) -> setIncrementing(false));

        final Agent agent = new Agent();
        new Thread(agent).start();

        btnStop.addActionListener((e) -> { 
            agent.setStop(); 
            btnUp.setEnabled(false); 
            btnDown.setEnabled(false);
            btnStop.setEnabled(false);
        });

        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(10000);
                    agent.setStop();
                    SwingUtilities.invokeAndWait(() -> btnStop.doClick());
                } catch (InterruptedException | InvocationTargetException ex) {
                    ex.printStackTrace(); // NOPMD
                }
            }
        }).start();
    }

    private synchronized void setIncrementing(final boolean value) {
        this.incrementing = value;
    }

    private synchronized boolean isIncrementing() {
        return this.incrementing;
    }

    private class Agent implements Runnable {

        private int counter = 0;
        private volatile boolean stop = false;

        @Override
        public void run() {
            while (!this.stop) {
                try {
                    counter += isIncrementing() ? 1 : -1;
                    SwingUtilities.invokeAndWait(() -> AnotherConcurrentGUI.this.lblCounter.setText(Integer.toString(this.counter)));
                    Thread.sleep(100);
                } catch (InterruptedException | InvocationTargetException ex) {
                    ex.printStackTrace(); // NOPMD
                }
            }
        }

        private void setStop() {
            this.stop = true;
        }
    }
}
