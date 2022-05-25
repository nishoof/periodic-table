package data;

import core.DrawingSurface;

/**
 * Represents a Periodic Table which holds Elements
 * 
 * @author nishoof
 */
public class PeriodicTable {
	
	private final int COLUMNS = 18;
	private final int ROWS = 7;
	
	private Element[][] elements;
	
	
	/**
	 * Constructs a new PeriodicTable
	 */
	public PeriodicTable() {
		
		elements = new Element[COLUMNS][ROWS];				// [x][y]
		
		// row 1
		elements[0][0] = new Element(1);
		elements[17][0] = new Element(2);
		
		// row 2
		elements[0][1] = new Element(3);
		elements[1][1] = new Element(4);
		for (int i = 5; i <= 10; i++) {
			elements[i+7][1] = new Element(i);
		}
		
		// row 3
		elements[0][2] = new Element(11);
		elements[1][2] = new Element(12);
		for (int i = 13; i <= 18; i++) {
			elements[i-1][2] = new Element(i);
		}
		
		// row 4
		for (int i = 19; i <= 36; i++) {
			elements[i-19][3] = new Element(i);
		}
		
		// row 5
		for (int i = 37; i <= 54; i++) {
			elements[i-37][4] = new Element(i);
		}
		
		// row 6
		for (int i = 55; i <= 57; i++) {
			elements[i-55][5] = new Element(i);
		}
		for (int i = 72; i <= 86; i++) {
			elements[i-69][5] = new Element(i);
		}
		
		// row 7
		for (int i = 87; i <= 89; i++) {
			elements[i-87][6] = new Element(i);
		}
		for (int i = 104; i <= 109; i++) {
			elements[i-101][6] = new Element(i);
		}
		
		// TODO: inner transition metals
		
	}
	
	/**
	 * Draws this PeriodicTable to surface
	 * 
	 * @param surface the DrawingSurface to draw with
	 */
	public void draw(DrawingSurface surface) {
		
		final int width = 53;
		final int height = 60;
		
		for (int i = 0; i < COLUMNS; i++) {
			for (int j = 0; j < ROWS; j++) {
				Element element = elements[i][j];
				if (element != null) {
					elements[i][j].draw(surface, i*width+10, j*height+10, width, height);
				}
			}
		}
		
	}
	
	/**
	 * Returns a 2D array of the elements in this PeriodicTable
	 * 
	 * @return a 2D array of the elements in this PeriodicTable
	 */
	public Element[][] getElements() {
		return this.elements;
	}
	
}
