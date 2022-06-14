package ui.screens;

import core.DrawingSurface;
import nish.processing.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Represents a Screen that allows the user to convert units.
 * 
 * @author nishoof
 */
public class UnitConverter extends Screen implements ActionListener {

	private Button backButton;
	
	
	/**
	 * Constructs a new UnitConverter Screen.
	 * 
	 * @param surface the DrawingSurface to use. Should not be null.
	 */
	public UnitConverter(DrawingSurface surface) {
		
		super(surface);

		// back Button
		backButton = new Button(0, 550, 50, 50, this);
		backButton.strokeWeight = 0;
		backButton.opacity = 0;
		backButton.hoveringOpacity = 0;
		backButton.text = "<";
		
	}
	
	/**
	 * Draws this UnitConverter
	 * After this is run, the following surface values may be changed:
	 * -	fill
	 */
	public void draw() {

		surface.background(255);

		// back Button
		surface.textSize(20);
		backButton.draw(surface);
		
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
	 * */
	public void keyPressed() {
		
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

}
