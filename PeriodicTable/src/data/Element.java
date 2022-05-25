package data;

/**
 * Represents an Element with an atomic number and an element name
 * 
 * @author nishoof
 */
public class Element {
	
	private int atomicNumber;
	private String elementName;
	
	
	public Element(int atomicNumber, String elementName) {
		this.atomicNumber = atomicNumber;
		this.elementName = elementName;
	}


	public int getAtomicNumber() {
		return atomicNumber;
	}


	public String getElementName() {
		return elementName;
	}
	
}
