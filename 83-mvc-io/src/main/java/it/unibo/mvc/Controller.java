package it.unibo.mvc;

import java.util.List;

/**
 * Interface that models a controller.
 */
public interface Controller {

    void setNextString(String next);

    void getNextString();

    List<String> getPrintHistory();

    void printNextString();
}
