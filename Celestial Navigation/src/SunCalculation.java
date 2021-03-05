
public class SunCalculation{
	
		private String plot;
		
		
		public SunCalculation () {	
			
			Sight sight;
			sight = new Sight("2020-02-10 12:12:13", 13);
			
			Sun sun;
			sun = new Sun();
			
			DRPosition DRPosn;
			DRPosn = new DRPosition();
			
			SunSightDetails sunSightDetails = new SunSightDetails(sight);
			sunSightDetails.setVisible(true);
			
			
				
			double GHA = sun.getGHA0() + (sight.getInterpolationFactor() * (sun.getGHA1() - sun.getGHA0()));
			if (GHA > 360 ) {
				GHA = GHA - 360;
			}
			
			double DEC = sun.getDec0() + (sight.getInterpolationFactor() * (sun.getDec1() - sun.getDec0()));
			
			double LHA = GHA + DRPosn.getDRLongitude();
			if (LHA > 360) {
				LHA = LHA - 360;
			} else if (LHA < 0) {
				LHA = LHA + 360;
			}
			
			double DECrad = DEC * (Math.PI / 180.0);
			double S = Math.sin(DECrad);
			
			double LHArad = LHA * (Math.PI / 180.0);
			double C = Math.cos(DECrad) * Math.cos(LHArad);
			
			double DRLATrad = DRPosn.getDRLatitude() * (Math.PI / 180.0);
			
			double HCrad =  Math.asin((S * Math.sin(DRLATrad)) + (C * Math.cos(DRLATrad)));
			double HC = HCrad / (Math.PI /180.0);
			
			double X = ((S * Math.cos(DRLATrad)) - (C * Math.sin(DRLATrad))) / Math.cos(HCrad);
			if (X > 1) {
				X = 1;
			} else if (X < -1) {
				X = -1;
			}
			
			double Zrad = Math.acos(X);
			
			double Z;
			if (LHA > 180) {
				Z = Zrad / (Math.PI / 180);
			} else {
				Z = 360 - (Zrad / (Math.PI /180));
			}
			Z = Math.round(Z);
			
			double D = 0.0293 * Math.sqrt(sight.getHeightOfObserver());
			
			double H = sight.getObservedHeightOfBody() + sight.getSextantIndexError() - D;
			double Hrad = H * (Math.PI / 180);
			double Hcalc = (H + (7.32 / (H + 4.32))) * (Math.PI / 180);
			
			double f = (0.28 * sight.getAtmosphericPressure()) / (sight.getTemperature() + 273);
			
			double refractionConstant = 0.0167 * (Math.PI / 180);
			
			double Rrad = refractionConstant / (Math.tan(Hcalc));
			
			double Ro = Rrad / (Math.PI / 180);
			
			double R = f * Ro;
			
			double HP = 0.0024;
			double HPrad = HP * (Math.PI / 180);
			
			double PArad = HPrad * Math.cos(Hrad);
			double PA = PArad / (Math.PI / 180);
			
			double HO = H - R + PA + sun.getSemiDiameter();
			
			double P = (HO - HC) * 60;
			
			
			if (Z < 100) {
				plot = "Plot 0" + Double.toString(Z) + "T / " + Double.toString((Math.round((P * 100.00)) / 100.00)) + "nm";
			}
			else if (Z >= 100){
				plot = "Plot " + Double.toString(Z) + "T / " + Double.toString((Math.round((P * 100.00)) / 100.00)) + "nm";
			}
			
			//sunSightInputs.setTextFieldPlot(plot);
			System.out.println(getPlot());
			
		}
		
		//getter methods
		public String getPlot() {
			return plot;
		}
			
}

 