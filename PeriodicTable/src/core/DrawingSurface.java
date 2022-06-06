package core;

import processing.core.PApplet;
import screens.Menu;
import screens.PeriodicTable;
import screens.Screen;

/**
 * @author nishoof
 */
public class DrawingSurface extends PApplet {
	
	private Screen currentScreen;				// the current screen being used
	private Screen menu;						public final static int menuID = 0;
	private Screen periodicTable;				public final static int periodicTableID = 1;
	

	/**
	 * Constructs a new DrawingSurface
	 */
	public DrawingSurface() {
		menu = new Menu(this);
		periodicTable = new PeriodicTable(this);

		currentScreen = menu;
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

	public void mousePressed() {
		currentScreen.mousePressed();
	}

	public void mouseMoved() {
		currentScreen.mouseMoved();
	}

	public void keyPressed() {
		currentScreen.keyPressed();
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
				break;
			case 1:
				currentScreen = periodicTable;
				break;
		}
	}
	
}
