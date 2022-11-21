package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUIWithFileChooser {

    private final JFrame frame = new JFrame();

    /**
     * Builds the GUI of the application.
     * @param controller the controller of this GUI
     */
    public SimpleGUIWithFileChooser(final Controller controller) {
        final JPanel pnlMain = new JPanel();
        pnlMain.setLayout(new BorderLayout());
        final JPanel pnlBrowse = new JPanel();
        pnlBrowse.setLayout(new BorderLayout());

        final JTextField txtFileName = new JTextField();
        txtFileName.setEditable(false);
        txtFileName.setText(controller.getCurrentFilePath());
        final JButton btnBrowse = new JButton("Browse...");

        pnlBrowse.add(txtFileName, BorderLayout.CENTER);
        pnlBrowse.add(btnBrowse, BorderLayout.LINE_END);

        pnlMain.add(pnlBrowse, BorderLayout.NORTH);

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

        btnBrowse.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final JFileChooser flcBrowseFile = new JFileChooser();
                final int result = flcBrowseFile.showSaveDialog(pnlBrowse);
                if (result == JFileChooser.APPROVE_OPTION) {
                    controller.setCurrentFile(flcBrowseFile.getSelectedFile().getAbsolutePath());
                    txtFileName.setText(controller.getCurrentFilePath());
                } else if (result == JFileChooser.CANCEL_OPTION) {
                    return;
                } else {
                    JOptionPane.showMessageDialog(pnlBrowse, "An error has occurred.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }

    /**
     * Gets the frame of the GUI.
     * @return a JFrame
     */
    public JFrame getFrame() {
        return this.frame;
    }

    /**
     * Entry point of the program.
     * @param args the array of arguments in the command line
     */
    public static void main(final String[] args) {
        SimpleGUIUtility.display(new SimpleGUIWithFileChooser(new Controller()).getFrame());
    }

}
