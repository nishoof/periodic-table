package core;

import processing.core.PApplet;
import screens.Menu;
import screens.PeriodicTable;
import screens.Screen;

/**
 * @author nishoof
 */
public class DrawingSurface extends PApplet {
	
	private Screen currentScreen;			// the current screen being used
	private Screen menu;
	private Screen periodicTable;
	

	/**
	 * Constructs a new DrawingSurface
	 */
	public DrawingSurface() {

	}
	

	public void settings() {
	  size(1200, 600);
	}
	
	/**
	 * Called once when the program starts
	 */
	public void setup() {
		
		windowResizable(false);

		periodicTable = new PeriodicTable(this);
		menu = new Menu(this);

		currentScreen = menu;

	}
	
	/**
	 * Draws to the window
	 */
	public void draw() {

		if (currentScreen == null) return;
		
		currentScreen.draw();
		
	}

	public void mousePressed() {

		currentScreen.mousePressed();

	}

	/**
	 * Switches the currentScreen to a different Screen based on screenCode
	 * 0 - menu
	 * 1 - periodicTable
	 * 
	 * @param screenCode the code for the new Screen
	 */
	public void switchScreen(int screenCode) {
		switch (screenCode) {
			case 0:
				currentScreen = menu;
			case 1:
				currentScreen = periodicTable;
			default:
				System.err.println("Unknwon screenCode " + screenCode);
		}
	}
	
}
