package screens;

import core.DrawingSurface;
import data.PeriodicTable;

public class PeriodicTableScreen extends Screen {
    
    private PeriodicTable periodicTable;
    

    /**
     * Constructs a new Menu screen.
     * 
     * @param surface the DrawingSurface to use. Should not be null.
     */
    public PeriodicTableScreen(DrawingSurface surface) {
        super(surface);
        periodicTable = new PeriodicTable();
    }


    public void draw() {
        
        super.draw();
        
        surface.background(230);

        periodicTable.draw(surface);

    }

}
