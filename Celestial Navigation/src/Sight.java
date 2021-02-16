//Sight represents a celestial sight.  It contains the attributes of a sight and
//the methods to convert these attributes to inputs for the line of position (LOP) calculation.
import java.text.SimpleDateFormat;
import java.util.Date;


public class Sight {
	
	
	private String localTimeOfSightString = UserInputs.LOCAL_TIME_OF_SIGHT;
	private Date localTimeOfSight;
	private int localTimeZone = UserInputs.LOCAL_TIME_ZONE;
	private Date UTCOfSight;
	private String UTCOfSightString;
	private double interpolationFactor;
	//private int temperature = UserInputs.TEMPERATURE;
	//private int atmosphericPressure = UserInputs.ATMOSPHERIC_PRESSURE;
	//private double heightOfObserver = UserInputs.HEIGHT_OF_OBSERVER;
	
	
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

	
	
	//methods
	public Date calculateUTCOfSight(Date date, int hours) {
		final long hoursInMilliSec = hours * 60 * 60 * 1000;
		Date newDate = new Date(date.getTime() + hoursInMilliSec);
		
		return newDate;
	}
	
	
	@SuppressWarnings("deprecation")
	public double calculateInterpolationFactor(Date dateTime) {
		int minutes =  dateTime.getMinutes(); 
		int seconds =  dateTime.getSeconds();
		
		return ((minutes / 60.0) + (seconds / 3600.0));
	}
	
	public String buildUTCOfSightString(String str) {
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

