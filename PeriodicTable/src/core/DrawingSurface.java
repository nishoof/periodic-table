package core;

import data.PeriodicTable;
import processing.core.PApplet;

/**
 * @author nishoof
 */
public class DrawingSurface extends PApplet {
	
	private PeriodicTable periodicTable;
	
	/**
	 * Constructs a new DrawingSurface
	 */
	public DrawingSurface() {
		periodicTable = new PeriodicTable();
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
		
		background(255);
		
		periodicTable.draw(this);
		
	}
	
}
