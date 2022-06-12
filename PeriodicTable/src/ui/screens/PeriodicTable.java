package ui.screens;

import core.DrawingSurface;
import data.Element;
import processing.core.PConstants;
import ui.element.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents a PeriodicTable Screen with a periodic table displaying elements.
 * 
 * @author nishoof
 */
public class PeriodicTable extends Screen implements ActionListener {

	private final int COLUMNS = 18;
	private final int ROWS = 7;			// does not include inner transition metals
	
	private Element[][] elements;

	private Button backButton;

	private Button highlightedField;
	private StringBuilder highlightedBoxText;
	
	
	/**
	 * Constructs a new PeriodicTable Screen.
	 * 
	 * @param surface the DrawingSurface to use. Should not be null.
	 */
	public PeriodicTable(DrawingSurface surface) {
		
		super(surface);

		elements = new Element[COLUMNS][ROWS+2];				// [x][y]		// +2 for inner transition metals
		
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
		
		// inner transition metals
		for (int i = 58; i <= 71; i++) {
			elements[i-58][7] = new Element(i);
		}
		for (int i = 90; i <= 103; i++) {
			elements[i-90][8] = new Element(i);
		}

		// back Button
		backButton = new Button(0, 550, 50, 50, this);
		backButton.strokeWeight = 0;
		backButton.opacity = 0;
		backButton.hoveringOpacity = 0;
		backButton.text = "<";

		// highlights
		highlightedField = new Button(200, 50, 100, 25, this);
		highlightedBoxText = new StringBuilder("");
		
	}
	
	/**
	 * Draws this PeriodicTable
	 * After this is run, the following surface values may be changed:
	 * -	fill
	 * -	strokeWeight
	 * -	rectMode
	 * -	values specified in Element.draw()
	 */
	public void draw() {

		// width and height of an individual element box 
		final int width = 53;
		final int height = 58;
		
		// offset for the full periodic table
		final int x = 20;
		final int y = 30;
		
		// offset for the inner transition metals (not counting the initial offset from x and y)
		final int x2 = width*4;
		final int y2 = 20;		


		surface.strokeWeight(1);
		surface.background(230);
		surface.stroke(0);
		surface.rectMode(PConstants.CORNER);
		

		// row 1-7
		for (int i = 0; i < COLUMNS; i++) {
			for (int j = 0; j < ROWS; j++) {
				Element element = elements[i][j];
				if (element != null) {
					drawElement(element, i*width+x, j*height+y, width, height);
				}
			}
		}
		
		// inner transition metals
		for (int i = 0; i < COLUMNS-4; i++) {
			for (int j = ROWS; j < ROWS+2; j++) {
				Element element = elements[i][j];
				if (element != null) {
					drawElement(element, i*width+x+x2, j*height+y+y2, width, height);
				}
			}
		}
		
		// black polygon for inner transition metals
		final int rectWidth = 4;
		final int extend = 5;
		surface.strokeWeight(0);
		surface.fill(0);
		surface.rect(x + width*3 - rectWidth/2, y + height*5, rectWidth, height*2 + extend);
		surface.quad(x + width*3 - rectWidth/2, y + height*7 + extend, 
				     x + width*3 + rectWidth/2, y + height*7 + extend, 
				     x + width*4, y + height*7 + y2,
				     x + width*4, y + height*9 + y2);
		
		// back Button
		surface.textSize(20);
		backButton.draw(surface);

		// highlight
		highlightedField.draw(surface);
		
	}
	
	/**
	 * Returns a 2D array of the elements in this PeriodicTable
	 * 
	 * @return a 2D array of the elements in this PeriodicTable
	 */
	public Element[][] getElements() {
		return this.elements;
	}

	/**
     * Called once after every time a mouse button is pressed.
     */
    public void mousePressed() {
        backButton.mousePressed(surface.mouseX, surface.mouseY, surface.mouseButton);
    }

    /**
     * Called every time the mouse moves and a mouse button is not pressed.
     */
    public void mouseMoved() {
        backButton.mouseMoved(surface.mouseX, surface.mouseY);
    }

	/**
	 * Called when a key is pressed
	 */
	public void keyPressed() {
		char key = surface.key;
		if (key == PConstants.BACKSPACE) {
			int l = highlightedBoxText.length();
			if (l > 0) {
				highlightedBoxText.deleteCharAt(l-1);
				updateHighlightedFieldText();
			}
		} else {
			key = Character.toLowerCase(key);
			int ascii = (int) key;
			if (ascii >= 97 && key <= 122) {				// lowercase letter a-z
				if (highlightedBoxText.length() > 0) {
					highlightedBoxText.append(key);
				} else {
					highlightedBoxText.append(Character.toUpperCase(key));
				}
				updateHighlightedFieldText();
			}
		}
	}

	/**
     * Invoked when an action occurs.
     * 
     * @param actionEvent the ActionEvent representing the action that occurred
     */
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(backButton)) {
            if (actionEvent.getID() == Button.LEFT_CLICK) {
                surface.switchScreen(DrawingSurface.menuID);
            }
        }
    }
	
	private void updateHighlightedFieldText() {
		highlightedField.text = highlightedBoxText.toString();
	}

	// helper method for drawing the element, mostly with checking if it is highlighted or not
	private void drawElement(Element element, int x, int y, int width, int height) {
		
		String elementName = element.getName().toLowerCase();
		String elementSymbol = element.getSymbol().toLowerCase();
		String str = highlightedBoxText.toString().toLowerCase();			// the text entered by the user
		int strLength = str.length();

		boolean sameSymbol = elementSymbol.equals(str);
		boolean sameName = strLength > 2 && strLength <= elementName.length() && str.equals(elementName.substring(0, strLength));				// is a name (not symbol) AND no substring exception AND the first part of the element name matches the input
		boolean highlighted = sameSymbol || sameName;

		element.draw(surface, x, y, width, height, highlighted);

	}

}
