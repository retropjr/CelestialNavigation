
public class CelestialBody {

	protected int x,y,width,height;
	protected int xVelocity, yVelocity;
	protected int initialXPosition, initialYPosition;


	// Setter methods
	public void setX(int x, int panelWidth) {
		// DONE
		this.x = x;
		if (x < 0) {
			this.x = 0;
		} else if (x + width > panelWidth) {
			this.x = panelWidth - width;
		}
	}
	public void setY(int y, int panelHeight) { 
		// DONE
		this.y = y;
		if (y < 0) {
			this.y = 0;
		} else if (y + height > panelHeight) {
			this.y = panelHeight - height;
		}
	}
	public void setWidth(int width) { 
		// DONE
		this.width = width;
	}
	public void setHeight(int height) { 
		// DONE
		this.height = height;
	}
	
	public void setXVelocity(int xVelocity ) {
		this.xVelocity = xVelocity;
	}
	
	public void setYVelocity(int yVelocity ) {
		this.yVelocity = yVelocity;
	}
	
	public void setInitialXPosition(int initialXPosition ) {
		this.initialXPosition = initialXPosition;
	}
	
	public void setInitialYPosition(int initialYPosition ) {
		this.initialYPosition = initialYPosition;
	}
	
	
	// Getter methods
	public int getX() { 
		return x;	// DONE: Return correct value
	}
	
	public int getY() { 
		return y;	// DONE: Return correct value
	}
	
	public int getWidth() { 
		return width;	// DONE: Return correct value
	}
	
	public int getHeight() { 
		return height;	// DONE: Return correct value
	}
	
	public int getXVelocity() { 
		return xVelocity;	// DONE: Return correct value
	}
	
	public int getYVelocity() { 
		return yVelocity;	// DONE: Return correct value
	}
	
	//methods
	
	public void resetPosition() {
		setX(initialXPosition, UserInputs.WINDOW_WIDTH);
		setY(initialYPosition, UserInputs.WINDOW_HEIGHT);
	}
	
	
	
}

