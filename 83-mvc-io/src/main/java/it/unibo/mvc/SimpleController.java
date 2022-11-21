package it.unibo.mvc;

import java.util.ArrayList;
import java.util.List;

/**
 * Class that implements the controller interface. It takes a string to print
 * and saves the history of the printed strings.
 */
public final class SimpleController implements Controller {

    private String nextString = null;
    private final List<String> history = new ArrayList<>();

    @Override
    public void setNextString(final String next) throws IllegalArgumentException {
        
        if (next == null) {
            throw new IllegalArgumentException();
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
        System.out.println(nextString);

        this.history.add(nextString);
        nextString = null;
    }

}
