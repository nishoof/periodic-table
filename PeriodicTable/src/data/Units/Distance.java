package data.Units;

public class Distance extends Unit {

    public static final int centimeters = 4;
    public static final int inches = 3;
    public static final int feet = 2;
    public static final int yards = 1;
    public static final int miles = 0;

    private static final double[] ratios = new double[]{1,                 // 1 mi = 1 mi
                                                        1760,               //      = 1760 yd
                                                        5280,               //      = 5280 ft
                                                        63360,              //      = 63360 in
                                                        160934.4};          //      = 160934.4 cm

    public static double convert(int previousUnit, int targetUnit, double amount) {

        return amount * (ratios[targetUnit] / ratios[previousUnit]);

    }

}
