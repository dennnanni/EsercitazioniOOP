package it.unibo.collections.sets;

import java.util.Collection;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * Example class using {@link java.util.Set}.
 *
 */
public final class UseSet {

    private static final int ELEMS = 20;

    private UseSet() {
    }

    /**
     * @param args
     *            ignored
     */
    public static void main(final String[] args) {
        /*
         * Considering the content of "UseCollection, write a program which, in
         * order:
         *
         * 1) Builds a TreeSet containing Strings
         */
        final Collection<String> treeSet = new TreeSet<>();
        /*
         * 2) Populates such Collection with all the Strings representing numbers ranging from "1" to
         * "20" (both included)
         */
        for (int i = 1; i <= ELEMS; i++) {
            treeSet.add(Integer.toString(i));
        }
        /*
         * 3) Prints its content
         */
        System.out.println("Elements in the collection:");
        for (final String node : treeSet) {
            System.out.println(node);
        }
        /*
         * 4) Removes all those strings whose represented number is divisible by three.
         * Note: the method removeIf(Predicate) is not allowed.
         */
        final Iterator<String> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            if (Integer.valueOf(iterator.next()) % 3 == 0) {
                iterator.remove();
            }
        }
        /*
         * 5) Prints the content of the Set using a for-each construct
         */
        System.out.println("New set:");
        for (String node : treeSet) {
            System.out.println(node);
        }
        /*
         * 6) Verifies whether all the numbers left in the set are even
         */
        boolean allEven = true;
        for (String node : treeSet) {
            if (Integer.valueOf(node) % 2 != 0) {
                allEven = false;
            }
        }

        if (allEven) {
            System.out.println("All numbers are even.");
        }
        else {
            System.out.println("Not all numbers are even.");
        }
    }
}
