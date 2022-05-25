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
		
		elements = new Element[2];
		
		elements[0] = new Element(1, "Hydrogen");
		elements[1] = new Element(2, "Helium");
		
	}
	
	
	public Element[] getElements() {
		return this.elements;
	}
	
}
