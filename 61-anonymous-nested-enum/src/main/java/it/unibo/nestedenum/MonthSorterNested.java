package it.unibo.nestedenum;

import java.util.Comparator;
import java.util.Locale;
import java.util.Objects;

/**
 * Implementation of {@link MonthSorter}.
 */
public final class MonthSorterNested implements MonthSorter {

    public enum Month {
        JANUARY(31),
        FEBRUARY(28),
        MARCH(31),
        APRIL(30),
        MAY(31),
        JUNE(30),
        JULY(31),
        AUGUST(31), 
        SEPTEMBER(30),
        OCTOBER(31),
        NOVEMBER(30),
        DECEMBER(31);

        private final int days;

        private Month(final int days) {
            this.days = days;
        }

        public static Month fromString(final String value) {
            for (Month month : Month.values()) {
                if (month.name().startsWith(value.toUpperCase())) {
                    return month;
                }
            }

            throw new IllegalArgumentException();
        }
    }

    @Override
    public Comparator<String> sortByDays() {
        return new Comparator<String>() {
            public int compare(String o1, String o2) {
                return Integer.compare(Month.fromString(o1).days, Month.fromString(o2).days);
            }
        };
    }

    @Override
    public Comparator<String> sortByOrder() {
        return null;
    }
}
