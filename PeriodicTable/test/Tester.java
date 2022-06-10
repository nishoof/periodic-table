import data.Units.Unit;

public class Tester {

    public static void main(String[] args) {
        
        double amount;
        
        amount = 63360;
        System.out.println(amount + " inches = "
                        + Unit.convert(Unit.inch, Unit.kilometer, amount)
                        + " kilometers");
        
        amount = 5;
        System.out.println(amount + " meters = "
                        + Unit.convert(Unit.meter, Unit.decimeter, amount)
                        + " decimeters");

        amount = 1130;
        System.out.println(amount + " feet/minute = "
                        + Unit.convert(Unit.foot, Unit.minute, Unit.mile, Unit.hour, amount)
                        + " miles/hour");

    }

}
