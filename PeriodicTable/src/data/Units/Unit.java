package data.Units;

public class Unit {

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
