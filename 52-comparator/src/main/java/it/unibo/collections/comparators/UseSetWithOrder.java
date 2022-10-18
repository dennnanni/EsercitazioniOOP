package it.unibo.collections.comparators;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

/**
 * 
 */
public final class UseSetWithOrder {

    private UseSetWithOrder() {
    }

    /**
     * @param s
     *            ignored
     */
    public static void main(final String[] s) {

        /*
         * Write a program which:
         * 
         * 1) Creates a new ORDERED TreeSet of Strings.
         * To order the set, define a new Comparator in a separate class.
         * The comparator must convert the strings to double, then compare the doubles to find the biggest.
         * The comparator does not need to deal with the case of Strings which are not parseable as doubles.
         */
        final Collection<String> treeSet = new TreeSet<>(new TreeSetComparator());
        /*
         * 2) Inserts in the set a hundred strings containing randomly generated numbers
         * (use Math.random(), and convert to String appropriately)
         */
        for (int i = 0; i < 100; i++) {
            treeSet.add(String.valueOf(Math.random()));
        }
        /*
         * 3) Prints the set, which must be ordered
         */
        for (String node : treeSet) {
            System.out.println(node);
        }
    }
}
