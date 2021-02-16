

public class Sun extends CelestialBody {

	private double semiDiameter;
	
	public Sun() {
		semiDiameter = CalculateSD(UserInputs.SD);
	}
	
	//getter methods
	public double getSemiDiameter() {
		return semiDiameter;
	}
	
	//methods
	public double CalculateSD(String inputSD) {
		double SD = Double.parseDouble(inputSD) / 60.0;
		return SD;
	}
}
