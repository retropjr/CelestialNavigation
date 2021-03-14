import java.text.SimpleDateFormat;
import java.util.Date;

public class MeridianAltitudeCalculation {
	private String passageUTCString;
	private Date passageUTC;
	private String passageLocalString;
	private Date passageLocal;
	private String latitude;
	private Date almanacPassage;
	
	
	
	public MeridianAltitudeCalculation (String lon, int tZ, String almanacPassageString) {	
			
		
		double DRLon = determineLongitude(lon);
		double timeToArc = DRLon / 15;
		int timeToArcHours = (int) Math.floor(timeToArc);
		int timeToArcMinutes = (int) ((timeToArc - timeToArcHours) * 60);
		
		
		
		SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			almanacPassage = dateTimeFormat.parse(almanacPassageString);
		}
		catch(Exception e) {
		
		}
		
		
		
		passageUTC = calculateUTCOfPassage(almanacPassage, timeToArcHours, timeToArcMinutes);
		passageUTCString = buildPassageString(passageUTC.toString());
		
		passageLocal = calculateLocalOfPassage(passageUTC, -tZ);
		passageLocalString = buildPassageString(passageLocal.toString());
		
		/*
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
			latitude = "Plot 0" + Double.toString(Z) + "T / " + Double.toString((Math.round((P * 100.00)) / 100.00)) + "nm";
		}
		else if (Z >= 100){
			latitude = "Plot " + Double.toString(Z) + "T / " + Double.toString((Math.round((P * 100.00)) / 100.00)) + "nm";
		}		
		*/	
	}
	
	//getter methods
	public String getLatitude() {
		return latitude;
	}
	
	public String getPassageUTC() {
		return passageUTCString;
	}
	
	public String getPassageLocal() {
		return passageLocalString;
	}
	
	//methods
	
	private double determineLongitude(String lon) {
		String sign = lon.substring(0,1);
		int degrees = Integer.parseInt(lon.substring(1, 4));
		double minutes = Double.parseDouble(lon.substring(5,9));
		double longitude = 0.0;
		if (sign.contentEquals("+")) {
			longitude = 1 * (degrees + (minutes / 60.0));
		} else if (sign.contentEquals("-")) {
			longitude = -1 * (degrees + (minutes / 60.0));
		} 
		
		return longitude;
	}
	
	
	public Date calculateUTCOfPassage(Date date, int hours, int minutes) {
		final long hoursInMilliSec = hours * 60 * 60 *1000;
		final long minutesInMilliSec = minutes * 60 * 1000;
		
		Date newDate = new Date(date.getTime() + hoursInMilliSec + minutesInMilliSec);
		
		return newDate;
	}
	
	
	public Date calculateLocalOfPassage(Date date, int hours) {
		final long hoursInMilliSec = hours * 60 * 60 * 1000;
		Date newDate = new Date(date.getTime() + hoursInMilliSec);
		
		return newDate;
	}
	
	private String buildPassageString(String str) {
		String year = str.substring(25, 29);
		String month = str.substring(4, 7);
		switch (month) {
		case "Jan": {
			month = "01";
			break;
		}
		case "Feb": {
			month = "02";
			break;
		}
		case "Mar": {
			month = "03";
			break;
		}
		case "Apr": {
			month = "04";
			break;
		}
		case "May": {
			month = "05";
			break;
		}
		case "Jun": {
			month = "06";
			break;
		}
		case "Jul": {
			month = "07";
			break;
		}
		case "Aug": {
			month = "08";
			break;
		}
		case "Sep": {
			month = "09";
			break;
		}
		case "Oct": {
			month = "10";
			break;
		}
		case "Nov": {
			month = "11";
			break;
		}
		case "Dec": {
			month = "12";
			break;
		}
		}
		String day = str.substring(8, 10);
		String time = str.substring(11,20);
		
		String string = (year + "-" + month + "-" + day + " " + time);
		return string;
	}
		
}

