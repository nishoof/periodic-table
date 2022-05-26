package screens;

import core.DrawingSurface;
import java.awt.Point;
import java.awt.Rectangle;
import processing.core.PConstants;


/**
 * Represents a Menu Screen for the user to select what they want to do.
 * 
 * @author nishoof
 */
public class Menu extends Screen {

    private Rectangle button;

    /**
     * Constructs a new Menu Screen
     * 
     * @param surface the DrawingSurface to use. Should not be null.
     */
    public Menu(DrawingSurface surface) {
        
        super(surface);

        button = new Rectangle(SCREEN_WIDTH/2, SCREEN_HEIGHT/2, 150, 50);
        
    }


    /**
     * Draws this Menu
     */
    public void draw() {

        surface.strokeWeight(1);
        surface.fill(255);
        surface.rectMode(PConstants.CENTER);
        surface.textAlign(PConstants.CENTER, PConstants.CENTER);

        surface.background(255);;

        surface.rect(button.x, button.y, button.width, button.height);

        surface.fill(0);
        surface.textSize(17);
        surface.text("View Periodic Table", button.x, button.y);

    }

    /**
     * Called when the mouse is pressed.
     * Used for detecting if the user clicked on a button.
     */
    public void mousePressed() {

        int x = surface.mouseX;
        int y = surface.mouseY;

        if (button.contains(new Point(x + button.width/2, y + button.height/2))) {              // the +/- for button width/height is because the rectangle is drawn in the center
            surface.switchScreen(1);
        }


    }



}
