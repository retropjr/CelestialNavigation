
public class DRPosition {
	
	private String DRLatitudeString;
	private String DRLongitudeString;
	private double DRLatitude;
	private double DRLongitude;
	
	//constructors
	public DRPosition(String drLat, String drLong) {
		setDRLatitudeString(drLat);
		DRLatitude = determineLatitude(DRLatitudeString);
		setDRLongitudeString(drLong);
		DRLongitude = determineLongitude(DRLongitudeString);
	}
	
	
	//setter methods
	public void setDRLatitudeString(String str) {
		DRLatitudeString = str;
	}
	
	public void setDRLongitudeString(String str) {
		DRLongitudeString = str;
	}
	
	
	//getter methods
	public double getDRLatitude() {
		return DRLatitude;
	}
	
	public double getDRLongitude() {
		return DRLongitude;
	}
	
	
	//methods
	private double determineLatitude(String lat) {
		String sign = lat.substring(0,1);
		int degrees = Integer.parseInt(lat.substring(1, 3));
		double minutes = Double.parseDouble(lat.substring(4,8));
		double latitude = 0.0;
		if (sign.contentEquals("+")) {
			latitude = 1 * (degrees + (minutes / 60.0));
		} else if (sign.contentEquals("-")) {
			latitude = -1 * (degrees + (minutes / 60.0));
		} 
		
		return latitude;
	}
	
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
	
}


