package data.Units;

public class Distance extends Unit {

    // units for Distance are allowed to range from 0-99 (inclusive)

    /**
     * Unit identifier for a millimeter
     */
    public static final int millimeter = 10;
    /**
     * Unit identifier for a centimeter
     */
    public static final int centimeter = 9;
    /**
     * Unit identifier for a decimeter
     */
    public static final int decimeter = 8;
    /**
     * Unit identifier for a meter
     */
    public static final int meter = 7;
    /**
     * Unit identifier for a decameter
     */
    public static final int decameter = 6;
    /**
     * Unit identifier for a hectometer
     */
    public static final int hectometer = 5;
    /**
     * Unit identifier for a kilometer
     */
    public static final int kilometer = 4;

    /**
     * Unit identifier for an inch
     */
    public static final int inch = 3;
    /**
     * Unit identifier for a foot
     */
    public static final int foot = 2;
    /**
     * Unit identifier for a yard
     */
    public static final int yard = 1;
    /**
     * Unit identifier for a mile
     */
    public static final int mile = 0;

    private static final double[] ratios = new double[]{1,                  // 1 mi = 1 mi
                                                        1760,               //      = 1760 yd
                                                        5280,               //      = ... ft
                                                        63360,              //      = ... in
                                                        1.609344,           //      = ... km
                                                        16.09344,           //      = ... hm
                                                        160.9344,           //      = ... dam
                                                        1609.344,           //      = ... m
                                                        16093.44,           //      = ... dm
                                                        160934.4,           //      = ... cm
                                                        1609344};           //      = ... mm
    
    public static double convert(int previousUnit, int targetUnit, double amount) {
        return amount * (ratios[targetUnit] / ratios[previousUnit]);
    }

    public static double convert(int previousUnitNumerator, int previousUnitDenominator, int targetUnitNumerator, int targetUnitDenominator, double amount) {
        return amount * (ratios[previousUnitNumerator] / ratios[targetUnitNumerator]) * (ratios[previousUnitDenominator] / ratios[targetUnitDenominator]);
    }

}
