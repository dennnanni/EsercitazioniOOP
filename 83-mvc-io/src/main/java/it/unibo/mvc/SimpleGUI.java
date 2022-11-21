package it.unibo.mvc;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

/**
 * A very simple program using a graphical interface.
 * 
 */
public final class SimpleGUI {

    private static final String SEPARATOR = "\n";
    private static final int PROPORTION = 2;

    private final JFrame frame = new JFrame();

    /**
     * Builds the GUI.
     * @param controller the controller used for the actions
     */
    public SimpleGUI(final Controller controller) {
        final JPanel pnlMain = new JPanel();
        pnlMain.setLayout(new BorderLayout());

        final JTextField txtStringToPrint = new JTextField();
        final JTextArea txtHistory = new JTextArea();
        txtHistory.setEditable(false);
        final JPanel pnlButtons = new JPanel();
        final JButton btnPrint = new JButton("Print");
        final JButton btnShowHistory = new JButton("Show history");

        pnlButtons.add(btnPrint);
        pnlButtons.add(btnShowHistory);
        pnlMain.add(txtStringToPrint, BorderLayout.NORTH);
        pnlMain.add(txtHistory, BorderLayout.CENTER);
        pnlMain.add(pnlButtons, BorderLayout.SOUTH);

        frame.add(pnlMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Handlers
        btnPrint.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                try {
                    controller.setNextString(txtStringToPrint.getText());
                    controller.printNextString();
                } catch (final IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(btnShowHistory, ex.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
                } catch (final IllegalStateException ex) {
                    JOptionPane.showMessageDialog(btnShowHistory, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        btnShowHistory.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(final ActionEvent arg0) {
                final List<String> history = controller.getPrintHistory();
                final StringBuilder text = new StringBuilder();
                for (final String string : history) {
                    text.append(string + SEPARATOR);
                }
                txtHistory.setText(text.toString());
            }

        });
    }

    private void display() {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    /**
     * Entry point of the program.
     * @param args the array of arguments from the command line
     */
    public static void main(final String[] args) {
        new SimpleGUI(new SimpleController()).display();
    }
}
