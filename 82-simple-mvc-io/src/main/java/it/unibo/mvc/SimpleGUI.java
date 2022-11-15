package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;
import java.io.IOException;



/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final int PROPORTION = 5;
    private final JFrame frame = new JFrame();

    public SimpleGUI(final Controller controller) {
        
        final JPanel pnlMain = new JPanel();
        pnlMain.setLayout(new BorderLayout());
        final JTextArea txtInput = new JTextArea();
        final JButton btnSave = new JButton("Save");
        pnlMain.add(txtInput, BorderLayout.CENTER);
        pnlMain.add(btnSave, BorderLayout.SOUTH);

        frame.add(pnlMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Handler
        btnSave.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                try {
                    controller.writeOnFile(txtInput.getText());
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(frame, "Something went wrong...");
                }
            }
        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(final String[] args) {
        new SimpleGUI(new Controller()).display();
    }

}
