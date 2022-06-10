package data.Units;

public class Unit {

    /**
     * Converts an amount of previousUnit to an amount of the targetUnit.
     * For example, to convert 63360 inches to kilometers, I would use:
     * {@code 
     *  double answer = Unit.convert(Distance.inch, Distance.kilometer, 63360);
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

        if (unitType1 == 0) {
            return Distance.convert(previousUnit, targetUnit, amount);
        } else if (unitType1 == 1) {
            return Time.convert(previousUnit, targetUnit, amount);
        } else {
            throw new IllegalArgumentException("Unknown unit type " + unitType1);
        }

    }

    /**
     * Converts an amount of previousUnitNumerator/previousUnitDenominator to an amount of the targetUnitNumerator/targetUnitDenominator.
     * For example, to convert 1130 feet per minute to mph (miles per hour), I would use:
     * {@code 
     *  double answer = Unit.convert(Distance.foot, Time.minute, Distance.mile, Time.hour, amount);
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

}
