import java.text.SimpleDateFormat;
import java.util.Date;

public class MeridianAltitudeCalculation {
	private String passageUTCString;
	private Date passageUTC;
	private String passageLocalString;
	private Date passageLocal;
	private String latitudeString;
	private Double latitude;
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
		
		passageLocal = calculateLocalOfPassage(passageUTC, tZ);
		passageLocalString = buildPassageString(passageLocal.toString());
		 
		
	}
	
	
		public MeridianAltitudeCalculation (String lon, int tZ, String almanacPassageString, String dec0, String dec1, double hT,
											String heightOfBody, String indexError, String sd, double temperature, double atmosphericPressure,
											String nameMZD) {	
			
		
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
		
		passageLocal = calculateLocalOfPassage(passageUTC, tZ);
		passageLocalString = buildPassageString(passageLocal.toString());
		 
		double interpFactor = calculateInterpolationFactor(passageLocal);
		
		double DEC = determineDec(dec0) + (interpFactor * (determineDec(dec1) - determineDec(dec0)));
		
		double h = hT;
		double D = 0.0293 * (Math.sqrt(h));
				
		double H = determineObservedHeightOfBody(heightOfBody) + determineSextantIndexError(indexError) - D;
		double Hrad = H * (Math.PI / 180);
		double Hcalc = (H + (7.32 / (H + 4.32))) * (Math.PI / 180);
		
		double SD = CalculateSD(sd);
		
		double f = (0.28 * atmosphericPressure) / (temperature + 273);
		
		double refractionConstant = 0.0167 * (Math.PI / 180);
		
		double Rrad = refractionConstant / (Math.tan(Hcalc));
		
		double Ro = Rrad / (Math.PI / 180);
		
		double R = f * Ro;
		
		double HP = 0.0024;
		double HPrad = HP * (Math.PI / 180);
		
		double PArad = HPrad * Math.cos(Hrad);
		double PA = PArad / (Math.PI / 180);
		
		double HO = H - R + PA + SD;
		
		double MZD = 90 - HO;
		
		String nameOfMZD = nameMZD;
		
		String nameOfDEC;
		if (DEC < 0) {
			nameOfDEC = "S";
		} else nameOfDEC = "N";
		
		if (nameOfMZD == nameOfDEC) {
			latitude = Math.abs(MZD) + Math.abs(DEC);
		} else if (Math.abs(MZD) > Math.abs(DEC)) {
			latitude = MZD - Math.abs(DEC);
		} else {
			latitude = Math.abs(DEC) - Math.abs(MZD);
		}
		
		
		latitudeString = latitude.toString();
	
			
	}
	
	//getter methods
	public String getLatitude() {
		return latitudeString;
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
		long hoursInMilliSec = hours * 60 * 60 *1000;
		long minutesInMilliSec = minutes * 60 * 1000;
		
		
		Date newDate = new Date(date.getTime() - hoursInMilliSec - minutesInMilliSec);
		
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
	
	
	@SuppressWarnings("deprecation")
	private double calculateInterpolationFactor(Date dateTime) {
		int minutes =  dateTime.getMinutes(); 
		int seconds =  dateTime.getSeconds();
		
		return ((minutes / 60.0) + (seconds / 3600.0));
	}
	
	private double determineDec(String dec) {
		String sign = dec.substring(0,1);
		int degrees = Integer.parseInt(dec.substring(1, 3));
		double minutes = Double.parseDouble(dec.substring(4,8));
		double declination = 0.0;
		if (sign.contentEquals("+")) {
			declination = 1 * (degrees + (minutes / 60.0));
		} else if (sign.contentEquals("-")) {
			declination = -1 * (degrees + (minutes / 60.0));
		} 
		
		return declination;
	}
	
	private double determineObservedHeightOfBody(String ht) {
		int degrees = Integer.parseInt(ht.substring(0, 2));
		double minutes = Double.parseDouble(ht.substring(3,7));
		double height = 0.0;
		
		height = degrees + (minutes / 60.0);
		
		return height;
	}
	
	private double determineSextantIndexError(String indexError) {
		String sign = indexError.substring(0,1);
		int degrees = Integer.parseInt(indexError.substring(1, 3));
		double minutes = Double.parseDouble(indexError.substring(4,8));
		double error = 0.0;
		if (sign.contentEquals("+")) {
			error = 1 * (degrees + (minutes / 60.0));
		} else if (sign.contentEquals("-")) {
			error = -1 * (degrees + (minutes / 60.0));
		} 
		
		return error;
	}
	
	public double CalculateSD(String inputSD) {
		double SD = Double.parseDouble(inputSD) / 60.0;
		return SD;
	}	
}

