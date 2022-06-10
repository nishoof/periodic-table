import data.Units.Distance;
import data.Units.Time;
import data.Units.Unit;

public class Tester {

    public static void main(String[] args) {
        
        double amount;
        
        amount = 63360;
        System.out.println(amount + " inches = "
                        + Unit.convert(Distance.inch, Distance.kilometer, amount)
                        + " kilometers");
        
        amount = 5;
        System.out.println(amount + " meters = "
                        + Unit.convert(Distance.meter, Distance.decimeter, amount)
                        + " decimeters");

        amount = 1130;
        System.out.println(amount + " feet/minute = "
                        + Unit.convert(Distance.foot, Time.minute, Distance.mile, Time.hour, amount)
                        + " miles/hour");

        // // tests the exception
        // amount = 1130;
        // System.out.println(amount + " feet/foot = "
        //                 + Unit.convert(Distance.foot, Distance.foot, Distance.mile, Time.hour, amount)
        //                 + " miles/hour");

    }

}
