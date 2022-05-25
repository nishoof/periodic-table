package data;

import core.DrawingSurface;

/**
 * Represents a Periodic Table which holds Elements
 * 
 * @author nishoof
 */
public class PeriodicTable {
	
	private final int COLUMNS = 18;
	private final int ROWS = 2;
	
	private Element[][] elements;
	
	
	/**
	 * Constructs a new PeriodicTable
	 */
	public PeriodicTable() {
		
		elements = new Element[COLUMNS][ROWS];				// [x][y]
		
		/// row 1
		elements[0][0] = new Element(1);
		elements[17][0] = new Element(2);
		
		// row 2
		elements[0][1] = new Element(3);
		elements[1][1] = new Element(4);
		for (int i = 5; i < 11; i++) {
			elements[i+7][1] = new Element(i);
		}
		
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
//					System.out.println(Integer.toString(i*width+10) + "           " + element);
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
