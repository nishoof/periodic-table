package screens;

import core.DrawingSurface;

public abstract class Screen {
    
    /**
     * Represents a DrawingSurface used for interacting with the user (for example drawing/showing graphical interface)
     */
    public DrawingSurface surface;
    
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
