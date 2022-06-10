package data.Units;

//  https://en.wikipedia.org/wiki/Unit_of_time

public class Time extends Unit {

    // units for Time are allowed to range from 100-199 (inclusive)

    /**
     * Unit identifier for a nanosecond
     */
    public static final int nanosecond = 100;
    /**
     * Unit identifier for a microsecond
     */
    public static final int microsecond = 101;
    /**
     * Unit identifier for a millisecond
     */
    public static final int millisecond = 102;
    /**
     * Unit identifier for a second
     */
    public static final int second = 103;
    /**
     * Unit identifier for a minute
     */
    public static final int minute = 104;
    /**
     * Unit identifier for an hour
     */
    public static final int hour = 105;
    /**
     * Unit identifier for a day (24 hours)
     */
    public static final int day = 106;
    /**
     * Unit identifier for a week (7 days)
     */
    public static final int week = 107;
    /**
     * Unit identifier for a month (30 days)
     */
    public static final int month = 108;
    /**
     * Unit identifier for a common year (365 days)
     */
    public static final int commonYear = 109;
    /**
     * Unit identifier for a leap year (366 days)
     */
    public static final int leapYear = 110;

    private static final double[] ratios = new double[]{
        0.000000001,            // nanosecond
        0.000001,               // microsecond
        0.001,                  // millisecond
        1,                      // second
        60,                     // minute
        3600,                   // hour
        86400,                  // day
        604800,                 // week
        2592000,                // month (30 days)
        31536000,               // common year
        31622400                // leap year
    };
    
    public static double convert(int previousUnit, int targetUnit, double amount) {
        previousUnit -= 100;
        targetUnit -= 100;
        return amount * (ratios[targetUnit] / ratios[previousUnit]);
    }

    public static double convert(int previousUnitNumerator, int previousUnitDenominator, int targetUnitNumerator, int targetUnitDenominator, double amount) {
        previousUnitNumerator -= 100;
        previousUnitDenominator -= 100;
        targetUnitNumerator -= 100;
        targetUnitDenominator -= 100;
        return amount * (ratios[previousUnitNumerator] / ratios[targetUnitNumerator]) * (ratios[previousUnitDenominator] / ratios[targetUnitDenominator]);
    }

}
