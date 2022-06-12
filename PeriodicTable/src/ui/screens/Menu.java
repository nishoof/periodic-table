package ui.screens;

import core.DrawingSurface;
import ui.element.Button;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * @author nishoof
 */
public class Menu extends Screen implements ActionListener {

    private Button[] buttons;
    private Button periodicTableButton;
    private Button unitConverterButton;

    /**
     * Constructs a new Menu Screen.
     * 
     * @param surface the DrawingSurface to use. Should not be null
     */
    public Menu(DrawingSurface surface) {
        
        super(surface);             // stores the DrawingSurface to use in a public final field in the superclass (Screen)

        periodicTableButton = new Button(500, 300, 150, 50, this);
        periodicTableButton.setAnchor(0.5, 0.5);                                // makes the Button use it's position as the center of the Button instead of the top-left
        periodicTableButton.setRounding(10);
        periodicTableButton.setText("Periodic Table");
        periodicTableButton.setHoverFill(240);

        unitConverterButton = new Button(500, 400, 150, 50, this);
        unitConverterButton.setAnchor(0.5, 0.5);                                // makes the Button use it's position as the center of the Button instead of the top-left
        unitConverterButton.setRounding(10);
        unitConverterButton.setText("Unit Converter");
        unitConverterButton.setHoverFill(240);

        buttons = new Button[]{periodicTableButton, unitConverterButton};
        
    }


    /**
     * Draws this Menu. Called every frame.
     */
    public void draw() {

        surface.background(255);                // clears anything that was drawn in the previous frame

        surface.textSize(20);
        periodicTableButton.draw(surface);
        unitConverterButton.draw(surface);

    }

    /**
     * Called once after every time a mouse periodicTableButton is pressed.
     */
    public void mousePressed() {
        for (Button button: buttons) {
            button.mousePressed(surface.mouseX, surface.mouseY, surface.mouseButton);
        }
    }

    /**
     * Called every time the mouse moves and a mouse periodicTableButton is not pressed.
     */
    public void mouseMoved() {
        for (Button button: buttons) {
            button.mouseMoved(surface.mouseX, surface.mouseY);
        }
    }

    /**
     * Invoked when an action occurs.
     * 
     * @param actionEvent the ActionEvent representing the action that occurred
     */
    public void actionPerformed(ActionEvent actionEvent) {
        if (actionEvent.getSource().equals(periodicTableButton)) {
            if (actionEvent.getID() == Button.LEFT_CLICK) {
                surface.switchScreen(DrawingSurface.periodicTableID);
            }
        } else if (actionEvent.getSource().equals(unitConverterButton)) {
            if (actionEvent.getID() == Button.LEFT_CLICK) {
                surface.switchScreen(DrawingSurface.unitConverterID);
            }
        }
    }

}
