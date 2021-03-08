

public class Sun extends CelestialBody {

	private double semiDiameter;
	private String GHA0String;
	private double GHA0;
	private String GHA1String;
	private double GHA1;
	private String dec0String;
	private double DEC0;
	private String dec1String;
	private double DEC1;
	
	public Sun(String gha0, String gha1, String dec0, String dec1, String sd) {
		setGHA0String(gha0);
		GHA0 = determineGHA(GHA0String);
		setGHA1String(gha1);
		GHA1 = determineGHA(GHA1String);
		setDec0String(dec0);
		DEC0 = determineDec(dec0String);
		setDec1String(dec1);
		DEC1 = determineDec(dec1String);
		semiDiameter = CalculateSD(sd);
	}
	
	//setter methods
	public void setGHA0String(String str) {
		GHA0String = str;
	}
	
	public void setGHA1String(String str) {
		GHA1String = str;
	}
	
	public void setDec0String(String str) {
		dec0String = str;
	}
	
	public void setDec1String(String str) {
		dec1String = str;
	}
	
	
	//getter methods
	public double getSemiDiameter() {
		return semiDiameter;
	}
	
	public double getGHA0() {
		return GHA0;
	}
	
	public double getGHA1() {
		return GHA1;
	}
	
	public double getDec0() {
		return DEC0;
	}
	
	public double getDec1() {
		return DEC1;
	}
	
	//methods
	public double CalculateSD(String inputSD) {
		double SD = Double.parseDouble(inputSD) / 60.0;
		return SD;
	}
	
	private double determineGHA(String gha) {
		int degrees = Integer.parseInt(gha.substring(0,3));
		double minutes = Double.parseDouble(gha.substring(4,8));
		double GHA;
		
		GHA = degrees + (minutes / 60.0);
		
		return GHA;
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
}
