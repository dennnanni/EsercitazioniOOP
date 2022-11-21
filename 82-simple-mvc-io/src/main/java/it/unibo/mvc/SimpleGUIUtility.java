package it.unibo.mvc;

import javax.swing.JFrame;

import java.awt.Toolkit;
import java.awt.Dimension;

/**
 * Utility class for GUI operations.
 */
public final class SimpleGUIUtility {

    private static final int PROPORTION = 5;

    private SimpleGUIUtility() {
    }

    /**
     * Utility to display a given frame with default parameters.
     * @param frame
     */
    public static void display(final JFrame frame) {
        final Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        final int sw = (int) screen.getWidth();
        final int sh = (int) screen.getHeight();
        frame.setSize(sw / PROPORTION, sh / PROPORTION);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);
    }
}
