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
	 * @param atomicNumber atomic number for the element, in the range [1, 36]
	 * @throws IllegalArgumentException if atomicNumber is not in the provided range
	 */
	public Element(int atomicNumber) {
		
		if (atomicNumber < 1 || atomicNumber > 36)
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
			case 11:
				elementName = "Sodium";
				elementSymbol = "Na";
				averageAtomicMass = 22.99;
				break;
			case 12:
				elementName = "Magnesium";
				elementSymbol = "Mg";
				averageAtomicMass = 24.31;
				break;
			case 13:
				elementName = "Aluminum";
				elementSymbol = "Al";
				averageAtomicMass = 26.98;
				break;
			case 14:
				elementName = "Silicon";
				elementSymbol = "Si";
				averageAtomicMass = 28.09;
				break;
			case 15:
				elementName = "Phosphorus";
				elementSymbol = "P";
				averageAtomicMass = 30.97;
				break;
			case 16:
				elementName = "Sulfur";
				elementSymbol = "S";
				averageAtomicMass = 32.07;
				break;
			case 17:
				elementName = "Chlorine";
				elementSymbol = "Cl";
				averageAtomicMass = 35.45;
				break;
			case 18:
				elementName = "Argon";
				elementSymbol = "Ar";
				averageAtomicMass = 39.95;
				break;
			case 19:
				elementName = "Potassium";
				elementSymbol = "K";
				averageAtomicMass = 39.10;
				break;
			case 20:
				elementName = "Calcium";
				elementSymbol = "Ca";
				averageAtomicMass = 40.08;
				break;
			case 21:
				elementName = "Scandium";
				elementSymbol = "Sc";
				averageAtomicMass = 44.96;
				break;
			case 22:
				elementName = "Titanium";
				elementSymbol = "Ti";
				averageAtomicMass = 47.87;
				break;
			case 23:
				elementName = "Vanadium";
				elementSymbol = "V";
				averageAtomicMass = 50.94;
				break;
			case 24:
				elementName = "Chromium";
				elementSymbol = "Cr";
				averageAtomicMass = 52.00;
				break;
			case 25:
				elementName = "Manganese";
				elementSymbol = "Mn";
				averageAtomicMass = 54.94;
				break;
			case 26:
				elementName = "Iron";
				elementSymbol = "Fe";
				averageAtomicMass = 55.85;
				break;
			case 27:
				elementName = "Cobalt";
				elementSymbol = "Co";
				averageAtomicMass = 58.93;
				break;
			case 28:
				elementName = "Nickel";
				elementSymbol = "Ni";
				averageAtomicMass = 58.69;
				break;
			case 29:
				elementName = "Copper";
				elementSymbol = "Cu";
				averageAtomicMass = 63.55;
				break;
			case 30:
				elementName = "Zinc";
				elementSymbol = "Zn";
				averageAtomicMass = 65.39;
				break;
			case 31:
				elementName = "Gallium";
				elementSymbol = "Ga";
				averageAtomicMass = 69.72;
				break;
			case 32:
				elementName = "Germanium";
				elementSymbol = "Ge";
				averageAtomicMass = 72.61;
				break;
			case 33:
				elementName = "Arsenic";
				elementSymbol = "As";
				averageAtomicMass = 74.92;
				break;
			case 34:
				elementName = "Selenium";
				elementSymbol = "Se";
				averageAtomicMass = 78.96;
				break;
			case 35:
				elementName = "Bromine";
				elementSymbol = "Br";
				averageAtomicMass = 79.90;
				break;
			case 36:
				elementName = "Krypton";
				elementSymbol = "Kr";
				averageAtomicMass = 83.80;
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
		
		/**
		 * For resizing, numbers are calculated like this: (int)(x+(width/(100.0/50)))
		 * Just change the last value (50 in the example) when adjusting.
		 */
		
		surface.textAlign(PConstants.CENTER, PConstants.CENTER);
		
		// smaller = the smaller value between width and height
		int smaller = width;
		if (height < width)
			smaller = height;
		
		// outer box
		surface.fill(255);
		surface.rect(x, y, width, height);
		
		// atomic number
		surface.fill(0);
		surface.textSize((int)(smaller/(100.0/20)));
		surface.text(atomicNumber, (int)(x+(width/(100.0/50))), (int)(y+(height/(100.0/12))));
		
		// element symbol
		surface.textSize((int)(smaller/(100.0/30)));
		surface.text(elementSymbol, (int)(x+(width/(100.0/50))), (int)(y+(height/(100.0/35))));
		
		// element name
		surface.textSize((int)(smaller/(100.0/20)));
		surface.text(elementName, (int)(x+(width/(100.0/50))), (int)(y+(height/(100.0/65))));
		
		// average atomic mass
		surface.textSize((int)(smaller/(100.0/20)));
		surface.text(Double.toString(averageAtomicMass), (int)(x+(width/(100.0/50))), (int)(y+(height/(100.0/87))));
		
	}
	
}
