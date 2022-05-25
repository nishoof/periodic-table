package data;

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
	
	
	public Element[] getElements() {
		return this.elements;
	}
	
}
