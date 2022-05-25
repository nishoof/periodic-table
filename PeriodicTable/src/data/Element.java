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
	private String elementSymbol;
	private String elementName;
	private double averageAtomicMass;
	
	
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
				elementName = "Hydrogen";
				elementSymbol = "H";
				averageAtomicMass = 1.01;
				break;
			case 2:
				elementName = "Helium";
				elementSymbol = "He";
				averageAtomicMass = 4.00;
				break;
			case 3:
				elementName = "Lithium";
				elementSymbol = "Li";
				averageAtomicMass = 6.94;
				break;
			case 4:
				elementName = "Beryllium";
				elementSymbol = "Be";
				averageAtomicMass = 9.01;
				break;
			case 5:
				elementName = "Boron";
				elementSymbol = "B";
				averageAtomicMass = 10.81;
				break;
			case 6:
				elementName = "Carbon";
				elementSymbol = "C";
				averageAtomicMass = 12.01;
				break;
			case 7:
				elementName = "Nitrogen";
				elementSymbol = "N";
				averageAtomicMass = 14.01;
				break;
			case 8:
				elementName = "Oxygen";
				elementSymbol = "O";
				averageAtomicMass = 16.00;
				break;
			case 9:
				elementName = "Fluorine";
				elementSymbol = "F";
				averageAtomicMass = 19.00;
				break;
			case 10:
				elementName = "Neon";
				elementSymbol = "Ne";
				averageAtomicMass = 20.18;
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
		
		// outer box
		surface.fill(255);
		surface.rect(x, y, width, height);
		
		// atomic number
		surface.fill(0);
		surface.textSize(15);
		surface.text(atomicNumber, (int)(x+(width/(100.0/50))), (int)(y+(height/(100.0/10))));
		
		// element symbol
		surface.textSize(30);
		surface.text(elementSymbol, (int)(x+(width/(100.0/50))), (int)(y+(height/(100.0/40))));
		
		// element name
		surface.textSize(15);
		surface.text(elementName, (int)(x+(width/(100.0/50))), (int)(y+(height/(100.0/70))));
		
		// average atomic mass
		surface.textSize(10);
		surface.text(Double.toString(averageAtomicMass), (int)(x+(width/(100.0/50))), (int)(y+(height/(100.0/90))));
		
	}
	
}
