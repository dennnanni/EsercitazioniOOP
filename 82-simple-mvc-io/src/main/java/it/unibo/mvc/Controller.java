package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {

    private static final String DEFAULT_FILE = System.getProperty("user.home") + File.separator + "output.txt";

    private String filePath;

    /**
     * Default constructor, initializes the file path of the controller with the default one.
     */
    public Controller() {
        this.filePath = DEFAULT_FILE;
    }

    /**
     * Gets the current file set in the controller.
     * @return the string with the file path
     */
    public String getCurrentFilePath() {
        return this.filePath;
    }

    /**
     * Changes the file path of the controller with the provided one.
     * @param filename
     */
    public void setCurrentFile(final String filename) {
        this.filePath = filename;
    }


    /**
     * Gets the current file set in the controller.
     * @return the file as an object
     */
    public File getCurrentFile() {
        return new File(this.filePath);
    }

    /**
     * Creates a PrintStream to write the provided text on the file referenced by the current file path.
     * @param textToWrite
     * @throws IOException
     */
    public void writeOnFile(final String textToWrite) throws IOException {
        final PrintStream ps = new PrintStream(getCurrentFile());

        ps.println(textToWrite);

        ps.close();
    }
}
