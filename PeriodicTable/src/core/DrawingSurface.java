package core;

import data.Element;
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
	
	
	/**
	 * Called once when the program starts
	 */
	public void setup() {
		
		System.out.println("PERIODIC TABLE");
		
		for (Element element: periodicTable.getElements()) {
			int atomicNumber = element.getAtomicNumber();
			String name = element.getElementName();
			System.out.println(String.format("%d: %s", atomicNumber, name));
		}
		
	}
	
	/**
	 * Draws to the window
	 */
	public void draw() {
		
		background(255);
		
	}
	
}
