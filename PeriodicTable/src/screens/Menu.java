package screens;

import core.DrawingSurface;
import nish.processing.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author nishoof
 */
public class Menu extends Screen implements ActionListener {

    private Button button;
    private boolean buttonHovered;

    /**
     * Constructs a new Menu Screen.
     * 
     * @param surface the DrawingSurface to use. Should not be null
     */
    public Menu(DrawingSurface surface) {
        
        super(surface);             // stores the DrawingSurface to use in a public final field in the superclass (Screen)

        button = new Button(500, 300, 150, 50, this);             // creates a new Button at (500, 300) with a width of 150 and height of 50 (in pixels)
        button.setAnchor(0.5, 0.5);                         // makes the Button use it's position as the center of the Button instead of the top-left
        button.setRounding(10);                             // rounds the edge of the Button
        button.setText("View Periodic Table");                            // adds a message to the center of the Button
        
    }


    /**
     * Draws this Menu. Called every frame.
     */
    public void draw() {

        surface.background(255);                // clears anything that was drawn in the previous frame

        growOnHover(button, buttonHovered);   

        surface.textSize((int)button.getSize().getX()/9);
        button.draw(surface);


    }

    /**
     * Called once after every time a mouse button is pressed.
     */
    public void mousePressed() {
        button.mousePressed(surface.mouseX, surface.mouseY, surface.mouseButton);
    }

    /**
     * Called every time the mouse moves and a mouse button is not pressed.
     */
    public void mouseMoved() {
        button.mouseMoved(surface.mouseX, surface.mouseY);
    }

    /**
     * Invoked when an action occurs.
     * 
     * @param actionEvent the ActionEvent representing the action that occurred
     */
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(button)) {
            if (actionEvent.getID() == Button.LEFT_CLICK) {
                surface.switchScreen(DrawingSurface.periodicTableID);
            } else if (actionEvent.getID() == Button.HOVER) {
                buttonHovered = true;
            } else if (actionEvent.getID() == Button.UNHOVER) {
                buttonHovered = false;
            }
        }
    }

    private void growOnHover(Button button, boolean buttonHovered) {
        int sizeX = (int)(button.getSize().getX());
        if (buttonHovered) {
            if (sizeX < 165) {
                button.grow(3, 1);
            }
        } else {
            if (sizeX > 150) {
                button.grow(-3, -1);
            }
        }
    }

}

