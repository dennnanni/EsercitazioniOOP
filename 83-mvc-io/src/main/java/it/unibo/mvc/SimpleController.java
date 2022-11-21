package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements the controller interface. It takes a string to print
 * and saves the history of the printed strings.
 */
public final class SimpleController implements Controller {

    private String nextString;
    private final List<String> history = new ArrayList<>();

    @Override
    public void setNextString(final String next) {

        if (next == null || next.isEmpty()) {
            throw new IllegalArgumentException("String can't be empty");
        }

        this.nextString = next;
    }

    @Override
    public String getNextString() {
        return this.nextString;
    }

    @Override
    public List<String> getPrintHistory() {
        return new ArrayList<>(this.history);
    }

    @Override
    public void printNextString() {

        if (this.nextString == null || this.nextString.isEmpty()) {
            throw new IllegalStateException("Cannot print an empty string");
        }

        System.out.println(nextString); // NOPMD since it is a requested behaviour

        this.history.add(nextString);
        nextString = null;
    }

}
