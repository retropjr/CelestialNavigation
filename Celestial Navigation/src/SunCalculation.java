
public class SunCalculation {

	
	
	public static void plot() {
		new Sight();
		System.out.println(Sight.getLocalTimeOfSightString() + "\t" + Sight.getLocalTimeOfSight());
		System.out.println(Sight.getLocalTimeZone());
		System.out.println(Sight.getUTCOfSight());
	}
}
 