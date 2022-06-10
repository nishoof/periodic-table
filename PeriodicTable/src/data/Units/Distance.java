package data.Units;

public class Distance extends Unit {

    // units for Distance are allowed to range from 0-99 (inclusive)

    public static final int millimeter = 10;
    public static final int centimeter = 9;
    public static final int decimeter = 8;
    public static final int meter = 7;
    public static final int decameter = 6;
    public static final int hectometer = 5;
    public static final int kilometer = 4;

    public static final int inch = 3;
    public static final int foot = 2;
    public static final int yard = 1;
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
