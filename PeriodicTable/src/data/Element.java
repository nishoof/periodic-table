package data;

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


	public int getAtomicNumber() {
		return atomicNumber;
	}


	public String getElementName() {
		return elementName;
	}
	
}
