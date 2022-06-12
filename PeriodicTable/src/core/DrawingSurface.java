package core;

import processing.core.PApplet;
import ui.screens.Menu;
import ui.screens.PeriodicTable;
import ui.screens.Screen;
import ui.screens.UnitConverter;

/**
 * @author nishoof
 */
public class DrawingSurface extends PApplet {
	
	private Screen currentScreen;				// the current screen being used
	private Screen menu;						public final static int menuID = 0;
	private Screen periodicTable;				public final static int periodicTableID = 1;
	private Screen unitConverter;				public final static int unitConverterID = 2;
	

	/**
	 * Constructs a new DrawingSurface, initializing the Screens
	 */
	public DrawingSurface() {
		
		menu = new Menu(this);
		periodicTable = new PeriodicTable(this);
		unitConverter = new UnitConverter(this);

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
			case menuID:
				currentScreen = menu;
				break;
			case periodicTableID:
				currentScreen = periodicTable;
				break;
			case unitConverterID:
				currentScreen = unitConverter;
				break;
		}
	}
	
}
