
public class SunCalculation{

		public SunCalculation () {	
		Sight sight;
		sight = new Sight();
		Sun sun;
		sun = new Sun();
		DRPosition DRPosn;
		DRPosn = new DRPosition();
		
		
		double GHA = sun.getGHA0() + (sight.getInterpolationFactor() * (sun.getGHA1() - sun.getGHA0()));
		if (GHA > 360 ) {
			GHA = GHA -360;
		}
		
		double DEC = sun.getDec0() + (sight.getInterpolationFactor() * (sun.getDec1() - sun.getDec0()));
		
		double LHA = GHA + DRPosn.getDRLongitude();
		if (LHA > 360) {
			LHA = LHA - 360;
		} else if (LHA < 0) {
			LHA = LHA + 360;
		}
		
		double DECrad = DEC * Math.PI / 180;
		double S = Math.sin(DECrad);
		
		double LHArad = LHA * Math.PI / 180;
		double C = Math.cos(DECrad) * Math.cos(LHArad);
		
		double DRLATrad = DRPosn.getDRLatitude() * Math.PI / 180;
		
		double HCrad =  Math.asin((S * Math.sin(DRLATrad)) + (C * Math.cos(DRLATrad)));
		double HC = HCrad / (Math.PI /180);
		
		
		
		
		
		public void PlotAzimuthAndIntercept(double Z, double P) {
			if (Z < 100) {
				System.out.println("Plot 0" + Double.toString(Z) + "T / " + Double.toString(P) + "nm");
			}
			else if (Z >= 100){
				System.out.println("Plot " + Double.toString(Z) + "T / " + Double.toString(P) + "nm");
			}
		}
		}
}
 