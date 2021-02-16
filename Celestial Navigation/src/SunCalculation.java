
public class SunCalculation{

		public SunCalculation () {
			
		Sight sight;
		sight = new Sight();
		Sun sun;
		sun = new Sun();
		
		sight.setLocalTimeOfSightString(UserInputs.LOCAL_TIME_OF_SIGHT);
		System.out.println(sight.getLocalTimeOfSightString());
		System.out.println(sight.getLocalTimeZone());
		System.out.println(sight.getUTCOfSightString());
		System.out.printf("%.4f", sight.getInterpolationFactor());
		System.out.println();
		System.out.printf("%.4f", sun.getSemiDiameter());
		}
}
 