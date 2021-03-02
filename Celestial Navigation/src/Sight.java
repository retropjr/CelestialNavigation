//Sight represents a celestial sight.  It contains the attributes of a sight and
//the methods to convert these attributes to inputs for the line of position (LOP) calculation.
import java.text.SimpleDateFormat;
import java.util.Date;


public class Sight {
	
	
	//private String localTimeOfSightString = UserInputs.LOCAL_TIME_OF_SIGHT;
	private String localTimeOfSightString = SunCalculationMenu.getLocalTimeOfSight();
	private Date localTimeOfSight;
	//private int localTimeZone = UserInputs.LOCAL_TIME_ZONE;
	private int localTimeZone = SunCalculationMenu.getLocalTimeZone();
	private Date UTCOfSight;
	private String UTCOfSightString;
	private double interpolationFactor;
	private int temperature = UserInputs.TEMPERATURE;
	private int atmosphericPressure = UserInputs.ATMOSPHERIC_PRESSURE;
	private double heightOfObserver = UserInputs.HEIGHT_OF_OBSERVER;
	private double sextantIndexError;
	private double observedHeightOfBody;
	
	
	//constructor
	public Sight() {
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	try {
		localTimeOfSight = dateTimeFormat.parse(localTimeOfSightString);
	}
	catch(Exception e) {
		
	}
	UTCOfSight = calculateUTCOfSight(localTimeOfSight, -localTimeZone);
	UTCOfSightString = buildUTCOfSightString(UTCOfSight.toString());
	interpolationFactor = calculateInterpolationFactor(UTCOfSight);
	sextantIndexError = determineSextantIndexError(UserInputs.INDEX_ERROR);
	observedHeightOfBody = determineObservedHeightOfBody(UserInputs.SEXTANT_ALTITUDE);
	}
	
	//setter methods
	public void setLocalTimeOfSightString(String timeOfSight) {
		localTimeOfSightString = timeOfSight;
	}
	
	
	//getter methods
	public String getLocalTimeOfSightString() {
		return localTimeOfSightString;
	}
	
	public Date getLocalTimeOfSight() {
		return localTimeOfSight;
	}
	
	public int getLocalTimeZone() {
		return localTimeZone;
	}
	
	public Date getUTCOfSight() {
		return UTCOfSight;
	}
	
	public String getUTCOfSightString() {
		return UTCOfSightString;
	}
	
	public double getInterpolationFactor() {
		return interpolationFactor;
	}
	
	public double getSextantIndexError() {
		return sextantIndexError;
	}

	public double getHeightOfObserver() {
		return heightOfObserver;
	}
	
	public double getObservedHeightOfBody() {
		return observedHeightOfBody;
	}
	
	public double getTemperature() {
		return temperature;
	}
	
	public double getAtmosphericPressure() {
		return atmosphericPressure;
	}
	
	//methods
	public Date calculateUTCOfSight(Date date, int hours) {
		final long hoursInMilliSec = hours * 60 * 60 * 1000;
		Date newDate = new Date(date.getTime() + hoursInMilliSec);
		
		return newDate;
	}
	
	
	@SuppressWarnings("deprecation")
	private double calculateInterpolationFactor(Date dateTime) {
		int minutes =  dateTime.getMinutes(); 
		int seconds =  dateTime.getSeconds();
		
		return ((minutes / 60.0) + (seconds / 3600.0));
	}
	
	private String buildUTCOfSightString(String str) {
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
	
	private double determineObservedHeightOfBody(String ht) {
		int degrees = Integer.parseInt(ht.substring(0, 2));
		double minutes = Double.parseDouble(ht.substring(3,7));
		double height = 0.0;
		
		height = degrees + (minutes / 60.0);
		
		return height;
	}
	
}

