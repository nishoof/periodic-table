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
	private boolean mostStableIsotope;
	
	
	/**
	 * Constructs a new Element using an atomic number
	 * 
	 * @param atomicNumber atomic number for the element, in the range [1, 109]
	 * @throws IllegalArgumentException if atomicNumber is not in the provided range
	 */
	public Element(int atomicNumber) {
		
		if (atomicNumber < 1 || atomicNumber > 109)
			throw new IllegalArgumentException("Unknown atomic number " + atomicNumber);
		
		this.atomicNumber = atomicNumber;
		mostStableIsotope = false;
		
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
				
			case 37:
				elementName = "Rubidium";
				elementSymbol = "Rb";
				averageAtomicMass = 85.47;
				break;
			case 38:
				elementName = "Strontium";
				elementSymbol = "Sr";
				averageAtomicMass = 87.62;
				break;
			case 39:
				elementName = "Yttrium";
				elementSymbol = "Y";
				averageAtomicMass = 88.91;
				break;
			case 40:
				elementName = "Zirconium";
				elementSymbol = "Zr";
				averageAtomicMass = 91.22;
				break;
			case 41:
				elementName = "Niobium";
				elementSymbol = "Nb";
				averageAtomicMass = 92.91;
				break;
			case 42:
				elementName = "Molybdenum";
				elementSymbol = "Mo";
				averageAtomicMass = 95.94;
				break;
			case 43:
				elementName = "Technetium";
				elementSymbol = "Tc";
				averageAtomicMass = 98.00;
				mostStableIsotope = true;
				break;
			case 44:
				elementName = "Ruthenium";
				elementSymbol = "Ru";
				averageAtomicMass = 101.07;
				break;
			case 45:
				elementName = "Rhodium";
				elementSymbol = "Rh";
				averageAtomicMass = 102.91;
				break;
			case 46:
				elementName = "Palladium";
				elementSymbol = "Pd";
				averageAtomicMass = 106.42;
				break;
			case 47:
				elementName = "Silver";
				elementSymbol = "Ag";
				averageAtomicMass = 107.87;
				break;
			case 48:
				elementName = "Cadmium";
				elementSymbol = "Cd";
				averageAtomicMass = 112.41;
				break;
			case 49:
				elementName = "Indium";
				elementSymbol = "In";
				averageAtomicMass = 114.82;
				break;
			case 50:
				elementName = "Tin";
				elementSymbol = "Sn";
				averageAtomicMass = 118.71;
				break;
			case 51:
				elementName = "Antimony";
				elementSymbol = "Sb";
				averageAtomicMass = 121.76;
				break;
			case 52:
				elementName = "Tellurium";
				elementSymbol = "Te";
				averageAtomicMass = 127.60;
				break;
			case 53:
				elementName = "Iodine";
				elementSymbol = "I";
				averageAtomicMass = 126.90;
				break;
			case 54:
				elementName = "Xenon";
				elementSymbol = "Xe";
				averageAtomicMass = 131.29;
				break;
				
			case 55:
				elementName = "Caesium";
				elementSymbol = "Cs";
				averageAtomicMass = 132.91;
				break;
			case 56:
				elementName = "Barium";
				elementSymbol = "Ba";
				averageAtomicMass = 137.33;
				break;
			case 57:
				elementName = "Lanthanum";
				elementSymbol = "La";
				averageAtomicMass = 138.91;
				break;
			case 72:
				elementName = "Hafnium";
				elementSymbol = "Hf";
				averageAtomicMass = 178.49;
				break;
			case 73:
				elementName = "Tantalum";
				elementSymbol = "Ta";
				averageAtomicMass = 180.95;
				break;
			case 74:
				elementName = "Tungsten";
				elementSymbol = "W";
				averageAtomicMass = 183.84;
				break;
			case 75:
				elementName = "Rhenium";
				elementSymbol = "Re";
				averageAtomicMass = 186.21;
				break;
			case 76:
				elementName = "Osmium";
				elementSymbol = "Os";
				averageAtomicMass = 190.23;
				break;
			case 77:
				elementName = "Iridium";
				elementSymbol = "Ir";
				averageAtomicMass = 192.22;
				break;
			case 78:
				elementName = "Platinum";
				elementSymbol = "Pt";
				averageAtomicMass = 195.08;
				break;
			case 79:
				elementName = "Gold";
				elementSymbol = "Au";
				averageAtomicMass = 196.97;
				break;
			case 80:
				elementName = "Mercury";
				elementSymbol = "Hg";
				averageAtomicMass = 200.59;
				break;
			case 81:
				elementName = "Thallium";
				elementSymbol = "Tl";
				averageAtomicMass = 204.38;
				break;
			case 82:
				elementName = "Lead";
				elementSymbol = "Pb";
				averageAtomicMass = 207.20;
				break;
			case 83:
				elementName = "Bismuth";
				elementSymbol = "Bi";
				averageAtomicMass = 208.98;
				break;
			case 84:
				elementName = "Polonium";
				elementSymbol = "Po";
				averageAtomicMass = 209;
				mostStableIsotope = true;
				break;
			case 85:
				elementName = "Astatine";
				elementSymbol = "At";
				averageAtomicMass = 210;
				mostStableIsotope = true;
				break;
			case 86:
				elementName = "Radon";
				elementSymbol = "Rn";
				averageAtomicMass = 222;
				mostStableIsotope = true;
				break;
				
			case 87:
				elementName = "Francium";
				elementSymbol = "Fr";
				averageAtomicMass = 223;
				mostStableIsotope = true;
				break;
			case 88:
				elementName = "Radium";
				elementSymbol = "Ra";
				averageAtomicMass = 226;
				mostStableIsotope = true;
				break;
			case 89:
				elementName = "Actinium";
				elementSymbol = "Ac";
				averageAtomicMass = 227;
				mostStableIsotope = true;
				break;
			case 104:
				elementName = "Rutherfordium";
				elementSymbol = "Rf";
				averageAtomicMass = 261;
				mostStableIsotope = true;
				break;
			case 105:
				elementName = "Dubnium";
				elementSymbol = "Db";
				averageAtomicMass = 262;
				mostStableIsotope = true;
				break;
			case 106:
				elementName = "Seaborgium";
				elementSymbol = "Sg";
				averageAtomicMass = 266;
				mostStableIsotope = true;
				break;
			case 107:
				elementName = "Bohrium";
				elementSymbol = "Bh";
				averageAtomicMass = 264;
				mostStableIsotope = true;
				break;
			case 108:
				elementName = "Hassium";
				elementSymbol = "Hs";
				averageAtomicMass = 269;
				mostStableIsotope = true;
				break;
			case 109:
				elementName = "Meitnerium";
				elementSymbol = "Mt";
				averageAtomicMass = 268;
				mostStableIsotope = true;
				break;
				
			case 58:
				elementName = "Cerium";
				elementSymbol = "Ce";
				averageAtomicMass = 140.12;
				break;
			case 59:
				elementName = "Praseodymium";
				elementSymbol = "Pr";
				averageAtomicMass = 140.91;
				break;
			case 60:
				elementName = "Neodymium";
				elementSymbol = "Nd";
				averageAtomicMass = 144.24;
				break;
			case 61:
				elementName = "Promethium";
				elementSymbol = "Pm";
				averageAtomicMass = 145;
				mostStableIsotope = true;
				break;
			case 62:
				elementName = "Samarium";
				elementSymbol = "Sm";
				averageAtomicMass = 150.36;
				break;
			case 63:
				elementName = "Europium";
				elementSymbol = "Eu";
				averageAtomicMass = 151.96;
				break;
			case 64:
				elementName = "Gadolinium";
				elementSymbol = "Gd";
				averageAtomicMass = 157.25;
				break;
			case 65:
				elementName = "Terbium";
				elementSymbol = "Tb";
				averageAtomicMass = 158.93;
				break;
			case 66:
				elementName = "Dysprosium";
				elementSymbol = "Dy";
				averageAtomicMass = 162.5;
				break;
			case 67:
				elementName = "Holmium";
				elementSymbol = "Ho";
				averageAtomicMass = 164.93;
				break;
			case 68:
				elementName = "Erbium";
				elementSymbol = "Er";
				averageAtomicMass = 167.26;
				break;
			case 69:
				elementName = "Thulium";
				elementSymbol = "Tm";
				averageAtomicMass = 168.93;
				break;
			case 70:
				elementName = "Ytterbium";
				elementSymbol = "Yb";
				averageAtomicMass = 173.04;
				break;
			case 71:
				elementName = "Lutetium";
				elementSymbol = "Lu";
				averageAtomicMass = 174.97;
				break;
			
			case 90:
				elementName = "Thorium";
				elementSymbol = "Th";
				averageAtomicMass = 232.04;
				break;
			case 91:
				elementName = "Protactinium";
				elementSymbol = "Pa";
				averageAtomicMass = 231.04;
				break;
			case 92:
				elementName = "Uranium";
				elementSymbol = "U";
				averageAtomicMass = 238.03;
				break;
			case 93:
				elementName = "Neptunium";
				elementSymbol = "Np";
				averageAtomicMass = 237.05;
				mostStableIsotope = true;
				break;
			case 94:
				elementName = "Plutonium";
				elementSymbol = "Pu";
				averageAtomicMass = 244;
				mostStableIsotope = true;
				break;
			case 95:
				elementName = "Americium";
				elementSymbol = "Am";
				averageAtomicMass = 243;
				mostStableIsotope = true;
				break;
			case 96:
				elementName = "Curium";
				elementSymbol = "Cm";
				averageAtomicMass = 247;
				mostStableIsotope = true;
				break;
			case 97:
				elementName = "Berkelium";
				elementSymbol = "Bk";
				averageAtomicMass = 247;
				mostStableIsotope = true;
				break;
			case 98:
				elementName = "Californium";
				elementSymbol = "Cf";
				averageAtomicMass = 251;
				mostStableIsotope = true;
				break;
			case 99:
				elementName = "Einsteinium";
				elementSymbol = "Es";
				averageAtomicMass = 252;
				mostStableIsotope = true;
				break;
			case 100:
				elementName = "Fermium";
				elementSymbol = "Fm";
				averageAtomicMass = 257;
				mostStableIsotope = true;
				break;
			case 101:
				elementName = "Mendelevium";
				elementSymbol = "Md";
				averageAtomicMass = 258;
				mostStableIsotope = true;
				break;
			case 102:
				elementName = "Nobelium";
				elementSymbol = "No";
				averageAtomicMass = 259;
				mostStableIsotope = true;
				break;
			case 103:
				elementName = "Lawrencium";
				elementSymbol = "Lr";
				averageAtomicMass = 262;
				mostStableIsotope = true;
				break;
			
		}
	}
	
	/**
	 * Draws this element as a box.
	 * After this is run, the following surface values may be changed:
	 * -	fill
	 * -	strokeWeight
	 * -	textAlign
	 * -	textSize
	 * 
	 * @param surface
	 * @param x the x-coordinate of the upper left corner of where to draw
	 * @param y the y-coordinate of the upper left corner of where to draw
	 * @param width the width of the box
	 * @param height the height of the box
	 */
	public void draw(DrawingSurface surface, int x, int y, int width, int height) {
		draw(surface, x, y, width, height, false);
	}

	/**
	 * Returns the atomic number of this element.
	 * 
	 * @return the atomic number of this element
	 */
	public int getAtomicNumber() {
		return atomicNumber;
	}

	/**
	 * Returns the symbol of this element.
	 * 
	 * @return the symbol of this element
	 */
	public String getSymbol() {
		return elementSymbol;
	}

	/**
	 * Returns the name of this element.
	 * 
	 * @return the name of this element
	 */
	public String getName() {
		return elementName;
	}

	/**
	 * Draws this element as a box.
	 * After this is run, the following surface values may be changed:
	 * -	fill
	 * -	strokeWeight
	 * -	textAlign
	 * -	textSize
	 * 
	 * @param surface
	 * @param x the x-coordinate of the upper left corner of where to draw
	 * @param y the y-coordinate of the upper left corner of where to draw
	 * @param width the width of the box
	 * @param height the height of the box
	 * @param highlighted if the box should be highlighted
	 */
	public void draw(DrawingSurface surface, int x, int y, int width, int height, boolean highlighted) {
		
		/**
		 * For resizing, numbers are calculated like this: (int)(x+(width/(100.0/50)))
		 * Just change the last value (50 in the example) when adjusting.
		 */
		
		surface.textAlign(PConstants.CENTER, PConstants.CENTER);
		surface.strokeWeight(1);
		
		// smaller = the smaller value between width and height
		int smaller = width;
		if (height < width)
			smaller = height;
		
		// outer box
		if (highlighted) {
			surface.fill(253, 255, 50, 200);
		} else {
			surface.fill(255);
		}
		surface.rect(x, y, width, height);
		
		// atomic number
		surface.fill(0);
		surface.textSize((int)(smaller/(100.0/20)));
		surface.text(atomicNumber, (int)(x+(width/(100.0/50))), (int)(y+(height/(100.0/12))));
		
		// element symbol
		surface.textSize((int)(smaller/(100.0/30)));
		surface.text(elementSymbol, (int)(x+(width/(100.0/50))), (int)(y+(height/(100.0/35))));
		
		// element name
		int textSize = (int)(smaller/(100.0/20));
		surface.textSize(textSize);
		while (surface.textWidth(elementName) >= width-4) {
			textSize -= 1;
			surface.textSize(textSize);
		}
		surface.text(elementName, (int)(x+(width/(100.0/50))), (int)(y+(height/(100.0/65))));
		
		// average atomic mass
		surface.textSize((int)(smaller/(100.0/20)));
		String str = Double.toString(averageAtomicMass);
		if (mostStableIsotope) {
			str = String.format("(%s)", str.substring(0,str.length()-2));			// if it refers to the most stable isotope, put it in parenthesis  |  "(98)" instead of "98.0")
		}
		surface.text(str, (int)(x+(width/(100.0/50))), (int)(y+(height/(100.0/87))));
		
	}

}
