package it.unibo.mvc;

import java.util.List;

/**
 * Interface that models a controller.
 */
public interface Controller {

    /**
     * Sets the next string that will be printed.
     * @param next the next string to print
     * @throws IllegalArgumentException if the argument is null
     */
    void setNextString(String next) throws IllegalArgumentException;

    /**
     * Gets the next string that will be printed.
     * @return the next string to be printed
     */
    String getNextString();

    /**
     * Returns the history of the prints.
     * @return a List of the previously printed string
     */
    List<String> getPrintHistory();

    /**
     * Prints the current string.
     * @throws IllegalStateException if the string to be printed is null
     */
    void printNextString() throws IllegalStateException;
}
