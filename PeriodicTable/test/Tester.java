import data.Units.Distance;

public class Tester {

    public static void main(String[] args) {
        
        // "input"
        int previousUnit = Distance.yards;
        int targetUnit = Distance.centimeters;
        double amount = 20;
        
        // calculate
        System.out.println(Distance.convert(previousUnit, targetUnit, amount));

    }

}
