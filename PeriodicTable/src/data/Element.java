package data;

import core.DrawingSurface;
import processing.core.PConstants;

/**
 * Represents an Element with an atomic number and an element name
 * 
 * @author nishoof
 */
public class Element {
	
	private int atomicNumber;
	private String elementName;
	
	
	/**
	 * Constructs a new Element using an atomic number
	 * 
	 * @param atomicNumber atomic number for the element, in the range [1, 10]
	 * @throws IllegalArgumentException if atomicNumber is not in the provided range
	 */
	public Element(int atomicNumber) {
		
		if (atomicNumber < 1 || atomicNumber > 10)
			throw new IllegalArgumentException("Unknown atomic number " + atomicNumber);
		
		this.atomicNumber = atomicNumber;
		
		switch (atomicNumber) {
			case 1:
				this.elementName = "Hydrogen";
				break;
			case 2:
				this.elementName = "Helium";
				break;
			case 3:
				this.elementName = "Lithium";
				break;
			case 4:
				this.elementName = "Beryllium";
				break;
			case 5:
				this.elementName = "Boron";
				break;
			case 6:
				this.elementName = "Carbon";
				break;
			case 7:
				this.elementName = "Nitrogen";
				break;
			case 8:
				this.elementName = "Oxygen";
				break;
			case 9:
				this.elementName = "Fluorine";
				break;
			case 10:
				this.elementName = "Neon";
				break;
		}
	}
	
	/**
	 * Draws this element as a box
	 * 
	 * @param surface
	 * @param x the x-coordinate of the upper left corner of where to draw
	 * @param y the y-coordinate of the upper left corner of where to draw
	 * @param width the width of the box
	 * @param height the height of the box
	 */
	public void draw(DrawingSurface surface, int x, int y, int width, int height) {
		
		surface.textAlign(PConstants.CENTER, PConstants.CENTER);
		
		surface.fill(255);
		surface.rect(x, y, width, height);
		
		surface.fill(0);
		surface.textSize(20);
		surface.text(atomicNumber, (int)(x+(width/(100.0/50))), (int)(y+(height/(100.0/10))));
		
		surface.textSize(15);
		surface.text(elementName, (int)(x+(width/(100.0/50))), (int)(y+(height/(100.0/85))));
		
	}


	public int getAtomicNumber() {
		return atomicNumber;
	}


	public String getElementName() {
		return elementName;
	}
	
}
