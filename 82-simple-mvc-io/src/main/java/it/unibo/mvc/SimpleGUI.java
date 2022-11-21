package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;



/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {
    private final JFrame frame = new JFrame();

    /**
     * Builds the graphical interface of the application.
     * @param controller the controller used to write the text on file
     */
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

    /**
     * Gets the frame object of the GUI.
     * @return the frame
     */
    public JFrame getFrame() {
        return this.frame;
    }

    /**
     * Entry point of the program.
     * @param args the array of arguments of the command line
     */
    public static void main(final String[] args) {
        SimpleGUIUtility.display(new SimpleGUI(new Controller()).getFrame());
    }

}
