package data;

import core.DrawingSurface;

/**
 * Represents a Periodic Table which holds Elements
 * 
 * @author nishoof
 */
public class PeriodicTable {
	
	private Element[] elements;
	
	
	/**
	 * Constructs a new PeriodicTable
	 */
	public PeriodicTable() {
		
		final int numElements = 10;
		
		elements = new Element[numElements];
		
		for (int i = 0; i < numElements; i++) {
			elements[i] = new Element(i+1);
		}
		
	}
	
	/**
	 * Draws this PeriodicTable to surface
	 * 
	 * @param surface the DrawingSurface to draw with
	 */
	public void draw(DrawingSurface surface) {
		
		int i = 0;
		final int width = 90;
		final int height = 90;
		for (int y = 10; y < 500; y += height+10) {
			for (int x = 10; x < 750; x += width+10) {
				if (i == 10) break;
				elements[i].draw(surface, x, y, width, height);
				i++;
			}
			if (i == 11) break;
		}
		
	}
	
	/**
	 * Returns a list of the elements in this PeriodicTable
	 * 
	 * @return a list of the elements in this PeriodicTable
	 */
	public Element[] getElements() {
		return this.elements;
	}
	
}
