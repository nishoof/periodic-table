package data.Units;

public class Unit {

    //-- FIELDS
        //---- UNIT IDENTIFIERS
            //------ LENGTH

            /**
             * Unit identifier for a mile
             */
            public static final int mile = 0;
            /**
             * Unit identifier for a yard
             */
            public static final int yard = 1;
            /**
             * Unit identifier for a foot
             */
            public static final int foot = 2;
            /**
             * Unit identifier for an inch
             */
            public static final int inch = 3;
            /**
             * Unit identifier for a kilometer
             */
            public static final int kilometer = 4;
            /**
             * Unit identifier for a hectometer
             */
            public static final int hectometer = 5;
            /**
             * Unit identifier for a decameter
             */
            public static final int decameter = 6;
            /**
             * Unit identifier for a meter
             */
            public static final int meter = 7;
            /**
             * Unit identifier for a decimeter
             */
            public static final int decimeter = 8;
            /**
             * Unit identifier for a centimeter
             */
            public static final int centimeter = 9;
            /**
             * Unit identifier for a millimeter
             */
            public static final int millimeter = 10;    


            //------ TIME

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


        //---- RATIOS

        private static final double[] distanceRatios = new double[]{
            1,                      // mi
            1760,                   // yd
            5280,                   // ft
            63360,                  // in
            1.609344,               // km
            16.09344,               // hm
            160.9344,               // dam
            1609.344,               // m
            16093.44,               // dm
            160934.4,               // cm
            1609344                 // mm
        };

        //  https://en.wikipedia.org/wiki/Unit_of_time
        private static final double[] timeRatios = new double[]{
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

        
    //-- METHODS
        //---- PUBLIC

        /**
         * Converts an amount of previousUnit to an amount of the targetUnit.
         * For example, to convert 63360 inches to kilometers, I would use:
         * {@code 
         *  double answer = Unit.convert(Unit.inch, Unit.kilometer, 63360);
         * }
         * 
         * @param previousUnit the unit to convert from
         * @param targetUnit the unit to convert to
         * @param amount the amount before being converted
         * @return the amount after being converted
         */
        public static double convert(int previousUnit, int targetUnit, double amount) {

            int unitType1 = previousUnit/100;
            int unitType2 = targetUnit/100;

            if (unitType1 != unitType2) {
                throw new IllegalArgumentException("Could not convert unit type " + unitType1 + " to " + unitType2);
            }

            if (unitType1 == 0) {               // length
                return distanceConvert(previousUnit, targetUnit, amount);
            } else if (unitType1 == 1) {        // time
                return timeConvert(previousUnit, targetUnit, amount);
            } else {
                throw new IllegalArgumentException("Unknown unit type " + unitType1);
            }

        }

        /**
         * Converts an amount of previousUnitNumerator/previousUnitDenominator to an amount of the targetUnitNumerator/targetUnitDenominator.
         * For example, to convert 1130 feet per minute to mph (miles per hour), I would use:
         * {@code 
         *  double answer = Unit.convert(Unit.foot, Unit.minute, Unit.mile, Unit.hour, amount);
         * }
         * 
         * @param previousUnitNumerator the numerator of the unit to convert from
         * @param previousUnitDenominator the denominator of the unit to convert from
         * @param targetUnitNumerator the numerator of the unit to convert to
         * @param targetUnitDenominatorthe denominator of the unit to convert to
         * @param amount the amount before being converted
         * @return the amount after being converted
         */
        public static double convert(int previousUnitNumerator, int previousUnitDenominator, int targetUnitNumerator, int targetUnitDenominator, double amount) {

            int unitType1 = previousUnitNumerator/100;
            int unitType2 = previousUnitDenominator/100;
            int unitType3 = targetUnitNumerator/100;
            int unitType4 = targetUnitDenominator/100;

            if (unitType1 != unitType3) {
                throw new IllegalArgumentException("Could not convert unit type " + unitType1 + " to " + unitType3);
            } else if (unitType2 != unitType4) {
                throw new IllegalArgumentException("Could not convert unit type " + unitType2 + " to " + unitType4);
            }

            amount = Unit.convert(previousUnitNumerator, targetUnitNumerator, amount);
            return Unit.convert(previousUnitDenominator, targetUnitDenominator, amount);
            
        }


        //---- HELPERS

        private static double distanceConvert(int previousUnit, int targetUnit, double amount) {
            return amount * (distanceRatios[targetUnit] / distanceRatios[previousUnit]);
        }

        private static double timeConvert(int previousUnit, int targetUnit, double amount) {
            previousUnit -= 100;
            targetUnit -= 100;
            return amount * (timeRatios[targetUnit] / timeRatios[previousUnit]);
        }

}
