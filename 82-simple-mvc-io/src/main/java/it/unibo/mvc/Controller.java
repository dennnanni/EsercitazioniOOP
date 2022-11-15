package it.unibo.mvc;

import java.io.File;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Application controller. Performs the I/O.
 */
public final class Controller {

    private static final String DEFAULT_FILE = System.getProperty("user.home") + File.separator + "output.txt";

    private String filename;

    public Controller() {
        this.filename = DEFAULT_FILE;
    }

    public String getCurrentFilePath() {
        return this.filename;
    }

    public void setCurrentFile(final String filename) {
        this.filename = filename;
    }

    public File getCurrentFile() {
        return new File(this.filename);
    }

    public void writeOnFile(final String textToWrite) throws IOException {
        final PrintStream ps = new PrintStream(getCurrentFile());

        ps.println(textToWrite);

        ps.close();
    }
}
