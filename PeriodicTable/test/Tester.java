import data.Units.Distance;

public class Tester {

    public static void main(String[] args) {
        
        // "input"
        int previousUnit = Distance.inch;
        int targetUnit = Distance.kilometer;
        double amount = 63360;
        
        // calculate
        System.out.println(Distance.convert(previousUnit, targetUnit, amount));

    }

}
