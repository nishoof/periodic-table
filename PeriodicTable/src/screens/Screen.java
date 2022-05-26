package screens;

import core.DrawingSurface;

/**
 * Represents a Screen used by DrawingSurface to draw things to the window.
 * 
 * @author nishoof
 */
public abstract class Screen {
    
    /**
     * Represents a DrawingSurface used for interacting with the user (for example drawing/showing graphical interface)
     */
    public final DrawingSurface surface;
    
	/**
	 * The width of the window.
	 */
	public final int SCREEN_WIDTH = 1000;

	/**
	 * The height of the window.
	 */
	public final int SCREEN_HEIGHT = 600;


    public Screen (DrawingSurface surface) {
        this.surface = surface;
    }


    /**
	 * Sets up this Screen (only runs once)
	 * */
	public void setup() {
		
	}
	
	/**
	 * Draws this Screen to the window
	 * */
	public void draw() {
		
	}
	
	/**
	 * Called when the mouse is pressed
	 * */
	public void mousePressed() {
		
	}
	
	/**
	 * Called when a key is pressed
	 * */
	public void keyPressed() {
		
	}

}
