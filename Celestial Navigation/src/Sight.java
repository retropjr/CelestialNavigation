import java.text.SimpleDateFormat;
import java.util.Date;


public class Sight {

	
	private  static String localTimeOfSightString = UserInputs.LOCAL_TIME_OF_SIGHT;
	private  static Date localTimeOfSight;
	private static int localTimeZone = UserInputs.LOCAL_TIME_ZONE;
	private static Date UTCOfSight;
	
	
	public Sight() {
	SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	try {
		localTimeOfSight = dateTimeFormat.parse(localTimeOfSightString);
	}
	catch(Exception e) {
		
	}
	
	UTCOfSight = calculateUTCOfSight(localTimeOfSight, -localTimeZone);
	
	}
	
	
	//getters
	public static String getLocalTimeOfSightString() {
		return localTimeOfSightString;
	}
	
	public static Date getLocalTimeOfSight() {
		return localTimeOfSight;
	}
	
	public static int getLocalTimeZone() {
		return localTimeZone;
	}
	
	
	public static Date getUTCOfSight() {
		return UTCOfSight;
	}
	
	
	//methods
	
	
	public static Date calculateUTCOfSight(Date date, int hours) {
		final long reqHoursInMillis = hours * 60 * 60 * 1000;
		Date newDate = new Date(date.getTime() + reqHoursInMillis);
		
		return newDate;
	}
	
	
}
