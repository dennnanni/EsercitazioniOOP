package it.unibo.collections.comparators;

import java.util.Comparator;

public class TreeSetComparator implements Comparator<String> {

    public int compare(String arg0, String arg1) {
        final double value0 = Double.valueOf(arg0);
        final double value1 = Double.valueOf(arg1);

        if (value0 > value1) {
            return 1;
        }
        
        if(value0 < value1) {
            return -1;
        }

        return 0;
    }

}