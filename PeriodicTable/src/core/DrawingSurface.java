package core;

import processing.core.PApplet;
import screens.PeriodicTableScreen;
import screens.Screen;

/**
 * @author nishoof
 */
public class DrawingSurface extends PApplet {
	
	private Screen currentScreen;			// the current screen being used
	private Screen periodicTable;
	
	/**
	 * Constructs a new DrawingSurface
	 */
	public DrawingSurface() {
		periodicTable = new PeriodicTableScreen(this);
		currentScreen = periodicTable;
	}
	
	public void settings() {
	  size(1200, 600);
	}
	
	/**
	 * Called once when the program starts
	 */
	public void setup() {
		windowResizable(false);
	}
	
	/**
	 * Draws to the window
	 */
	public void draw() {

		if (currentScreen == null) return;
		
		currentScreen.draw();
		
	}
	
}
