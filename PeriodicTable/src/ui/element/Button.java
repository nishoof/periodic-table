package  ui.element;

import processing.core.PApplet;
import processing.core.PConstants;

import java.awt.event.*;
import java.util.ArrayList;


/**
 * Represents a Button to be used with Processing.
 * 
 * <p> The following should be properly called at the appropriate time for intended use.
 * <ul style="margin-top: -14px;">
 *      <li> {@link #mousePressed(int, int, int) mousePressed()}
 *      <li> {@link #mouseMoved(int, int) mouseMoved()}
 * </ul>
 * 
 * <p> ActionListeners added to this Button will have their actionPerformed(ActionEvent) method called when this button
 * is clicked. Below are the meanings of the IDs (use getID() on the ActionEvent):
 * <ul style="margin-top: -14px; margin-bottom: 1px;">
 *      <li> 0: this Button was left-clicked
 *      <li> 1: this Button was right-clicked
 *      <li> 2: this Button is now being hovered
 *      <li> 3: this Button is no longer being hovered
 * </ul>
 * This Button also has public static constants that can be used for this.
 * 
 * @author nishoof
 */
public class Button {

    /**
     * The ActionEvent id when this Button is left-clicked.
     */
    public static final int LEFT_CLICK = 0;

    /**
     * The ActionEvent id when this Button is right-clicked.
     */
    public static final int RIGHT_CLICK = 1;

    /**
     * The ActionEvent id when this Button is now being hovered (mouse is on the Button).
     */
    public static final int HOVER = 2;

    /**
     * The ActionEvent id when this Button is no longer being hovered (mouse is off the Button).
     */
    public static final int UNHOVER = 3;
    


    private int x;
    private int y;
    private int width;
    private int height;

    private double anchorX;
    private double anchorY;

    private int cornerRounding;
    private int fill;
    private float fillr, fillg, fillb;
    private int hoverFill;
    private float hoverFillr, hoverFillg, hoverFillb;
    private int strokeWeight;
    private float opacity;
    private float hoveringOpacity;

    private String text;
    private int textOffsetX;
    private int textOffsetY;

    protected ArrayList<ActionListener> listening;

    private boolean hovering;



    /**
     * Constructs a new Button with positional values.
     * 
     * @param x the x-coordinate of the button
     * @param y the y-coordinate of the button
     * @param width the width of the button (horizontal)
     * @param height the height of the button (vertical)
     */
    public Button(int x, int y, int width, int height) {

        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

        cornerRounding = 0;
        fill = 255;
        hoverFill = 255;
        strokeWeight = 1;
        opacity = 255;
        hoveringOpacity = 255;

        text = null;
        
        listening = new ArrayList<ActionListener>();

    }

    /**
     * Constructs a new Button with positional values and an initial ActionListener.
     * 
     * @param x the x-coordinate of the button
     * @param y the y-coordinate of the button
     * @param width the width of the button (horizontal)
     * @param height the height of the button (vertical)
     * @param actionListener the initial ActionListener to be 
     */
    public Button(int x, int y, int width, int height, ActionListener actionListener) {
        this(x, y, width, height);
        listening.add(actionListener);
    }



    /**
     * Draws this Button to surface.
     * <br> The following surface values may be affected after this is run:
     * <ul>
     *      <li> fill
     *      <li> textAlign
     *      <li> strokeWeight
     * </ul>
     * 
     * @param surface the PApplet to use for drawing
     */
    public void draw(PApplet surface) {
        
        surface.textAlign(PConstants.CENTER, PConstants.CENTER);
        surface.strokeWeight(strokeWeight);
        if (strokeWeight <= 0) {
            surface.noStroke();
        } else {
            surface.stroke(0);
        }
        
        if (hovering) {
            if (hoverFill == -1) {
                surface.fill(hoverFillr, hoverFillg, hoverFillb, hoveringOpacity);
            } else {
                surface.fill(hoverFill, hoveringOpacity);
            }
        } else {
            if (fill == -1) {
                surface.fill(fillr, fillg, fillb, opacity);
            } else {
                surface.fill(fill, opacity);
            }
        }

        surface.rect(x-(int)(anchorX*width), y-(int)(anchorY*height), width, height, cornerRounding);

        if (text != null) {
            surface.fill(0);
            surface.text(text, x + width/2 + textOffsetX - (int)(anchorX*width), y + height/2 + textOffsetY - (int)(anchorY*height));
        }

    }

    /**
     * Sets the anchor points of this Button.
     * <br> Anchor points are used as an offset of where to draw from.
     * <br> For example, if the anchor points (x, y) are (0, 0), this Button will be drawn from the upper left corner.
     * <br> If the anchor points are (0.5, 0.5), this Button will be drawing from the middle.
     * 
     * @param anchorX new x-coordinate for the anchor
     * @param anchorY new y-coordiante for the anchor
     */
    public void setAnchor(double anchorX, double anchorY) {
        this.anchorX = anchorX;
        this.anchorY = anchorY;
    }

    /**
     * Returns the x-coordinate of the anchor point of this Button.
     * 
     * @return the x-coordinate of the anchor point of this Button
     */
    public double getAnchorX() {
        return anchorX;
    }

    /**
     * Returns the y-coordinate of the anchor point of this Button.
     * 
     * @return the y-coordinate of the anchor point of this Button
     */
    public double getAnchorY() {
        return anchorY;
    }

    /**
     * Changes how rounded the corners are.
     * <br> 0 by default.
     * 
     * @param cornerRounding new value for how rounded the corners are
     */
    public void setRounding(int cornerRounding) {
        this.cornerRounding = cornerRounding;
    }

    /**
     * Returns how rounded the corners are.
     * 
     * @return how rounded the corners are
     */
    public int getRounding() {
        return this.cornerRounding;
    }

     /**
     * Changes the hoverFill value for this Button (fill when it is being hovered).
     * <br> 255 by default.
     * @see <a href="https://processing.org/reference/fill_.html">processing.core.PApplet.fill(rgb)</a>
     * 
     * @param hoverFill new hoverFill value for this Button (color variable or hex value)
     */
    public void setHoverFill(int hoverFill) {
        this.hoverFill = hoverFill;
        hoverFillr = -1;
        hoverFillg = -1;
        hoverFillb = -1;
    }
    
    /**
     * Changes the hoverFill value for this Button (fill when it is being hovered).
     * @see <a href="https://processing.org/reference/fill_.html">processing.core.PApplet.fill(v1, v2, v3)</a> 
     * 
     * @param r new r hoverFill value for this Button (red or hue value, depending on current color mode)
     * @param g new g hoverFill value for this Button (green or saturation value, depending on current color mode)
     * @param b new b hoverFill value for this Button (blue or brightness value, depending on current color mode)
     */
    public void setHoverFill(float r, float g, float b) {
        hoverFillr = r;
        hoverFillg = g;
        hoverFillb = b;
        hoverFill = -1;
    }

    /**
     * Sets the strokeWeight of this Button to strokeWeight.
     * <br> The strokeWeight is the width of the stroke used for the border around the Button.
     * <br> 1 by default.
     *  
     * @param strokeWeight new strokeWeight for this Button
     */
    public void setStrokeWeight(int strokeWeight) {
        this.strokeWeight = strokeWeight;
    }

    /**
     * Returns the strokeWeight of this Button.
     * <br> The strokeWeight is the width of the stroke used for the border around the Button.
     *  
     * @return the strokeWeight of this Button
     */
    public int getStrokeWeight() {
        return strokeWeight;
    }

    /**
     * Sets the opacity of this Button (how transparent it is) to opacity.
     * <br> Ranges from 0 (fully transparent) to 255 (no transparency).
     * <br> 255 by default.
     * 
     * @param opacity new opacity for this Button
     */
    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }

    /**
     * Returns the opacity of this Button (how transparent it is).
     * 
     * @return the opacity of this Button (how transparent it is)
     */
    public float getOpacity() {
        return opacity;
    }

    /**
     * Sets the hoveringOpacity of this Button (how transparent it is) to hoveringOpacity.
     * <br> Ranges from 0 (fully transparent) to 255 (no transparency).
     * <br> 255 by default.
     * 
     * @param hoveringOpacity new hoveringOpacity for this Button
     */
    public void setHoveringOpacity(float hoveringOpacity) {
        this.hoveringOpacity = hoveringOpacity;
    }

    /**
     * Sets the text of this Button to text.
     * <br> Null by default (not shown).
     * 
     * @param text new text for this Button
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * Returns the text of this Button.
     * 
     * @return the text of this Button
     */
    public String getText() {
        return text;
    }

    

    /**
     * Should be called whenever the mouse is pressed.
     * <br> Used for checking if this Button was clicked.
     * 
     * @param mouseX the x-coordiante of the mouse
     * @param mouseY the y-coordinate of the mouse
     * @param mouseButton PApplet.mouseButton, used for checking if it was a left-click or right-click 
     */
    public void mousePressed(int mouseX, int mouseY, int mouseButton) {
        if (contains(mouseX, mouseY)) {
            
            int id;
            
            if (mouseButton == PConstants.LEFT) {
                id = LEFT_CLICK;
            } else {
                id = RIGHT_CLICK;
            }

            for (ActionListener listener: listening) {
                listener.actionPerformed(new ActionEvent(this, id, null));
            }

        }
    }

    /**
     * Should be called whenever the mouse is moved.
     * <br> Used for checking if this Button is being hovered.
     * 
     * @param mouseX the x-coordiante of the mouse
     * @param mouseY the y-coordinate of the mouse
     */
    public void mouseMoved(int mouseX, int mouseY) {
       
        boolean nowHovering;

        if (contains(mouseX, mouseY)) {
            nowHovering = true;
        } else {
            nowHovering = false;
        }

        if (nowHovering != hovering) {
            if (nowHovering) {
                for (ActionListener listener: listening) {
                    listener.actionPerformed(new ActionEvent(this, HOVER, null));
                }
            } else {
                for (ActionListener listener: listening) {
                    listener.actionPerformed(new ActionEvent(this, UNHOVER, null));
                }
            }
            hovering = nowHovering;
        }
        
    }


    
    /*
      Checks if (x, y) is in this Button (including border).
     */
    private boolean contains(int x, int y) {
        
        // variable names: https://cdn.discordapp.com/attachments/421191351451779075/982391029091164250/buttonContainsImage1.png
        // area numbers: https://cdn.discordapp.com/attachments/421191351451779075/982393687994671135/buttonContainsImage2.png

        int x2 = this.x-(int)(anchorX*width);
        int y2 = this.y-(int)(anchorY*height);

        if (cornerRounding == 0) {
            return inRect(x, y, x2, y2, width, height);
        } else if (cornerRounding > 0) {

            int x3 = x2+cornerRounding;
            int y3 = y2+cornerRounding;

            int width2 = width - cornerRounding*2;
            int height2 = height - cornerRounding*2;

            if (inRect(x, y, x3, y3, width2, height2)) return true;                         // area #1

            if (inRect(x, y, x3, y2, width2, cornerRounding)) return true;                  // area #2
            if (inRect(x, y, x3, y3+height2, width2, cornerRounding)) return true;          // area #3
            if (inRect(x, y, x2, y3, cornerRounding, height2)) return true;                 // area #4
            if (inRect(x, y, x3+width2, y3, cornerRounding, height2)) return true;          // area #5

            if (inCircle(x, y, x3, y3, cornerRounding)) return true;                        // area #6
            if (inCircle(x, y, x3+width2, y3, cornerRounding)) return true;                 // area #7
            if (inCircle(x, y, x3, y3+height2, cornerRounding)) return true;                // area #8
            if (inCircle(x, y, x3+width2, y3+height2, cornerRounding)) return true;         // area #9

            return false;

        } else {
            System.err.println("Corner rounding is negative");
            for (StackTraceElement ste : Thread.currentThread().getStackTrace()) {
                System.err.println(ste);
            }
            return false;
        }
        
    }

    /*
      Checks if (x, y) is in a rectangle (including border) with (x2, y2) as upper left, width as width, and height as height.
     */
    private boolean inRect(int x, int y, int x2, int y2, int width, int height) {
        if (x >= x2 && x <= x2+width && y >= y2 && y <= y2+height) {
            return true;
        } else {
            return false;
        }
    }

    /*
      Checks if (x, y) is in a circle (including border) with (x2, y2) as the center, and radius as the radius.
     */
    private boolean inCircle(int x, int y, int x2, int y2, int radius) {
        if (distance(x, y, x2, y2) <= radius) return true;
        else return false;
    }

    /*
      Returns the distance between (x1, y1) and (x2, y2).
     */
    private double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt( Math.pow(x2 - x1, 2) 
                        + Math.pow(y2 - y1, 2));
    }

















    // /**
    //  * Sets if this Button is active.
    //  * <br> If this is active, it can be interacted with through clicking, hovering, etc.
    //  * <br> If this is not active, it can't be interacted with. 
    //  * <br> Note that it does not affect if methods of this Button (such as draw or set/get methods).
    //  * <br> True by default.
    //  * 
    //  * @param active if this Button is active
    //  */
    // public void setActive(boolean active) {
    //     this.active = active;
    // }

    // /**
    //  * Returns if this Button is active.
    //  * 
    //  * @return if this Button is active
    //  */
    // public boolean isActive() {
    //     return active;
    // }

    // /**
    //  * Moves this Button to a new position.
    //  * 
    //  * @param x new x-coordinate of this Button
    //  * @param y new y-coordinate of this Button
    //  */
    // public void moveTo(int x, int y) {
    //     this.x = x;
    //     this.y = y;
    // }

    // /**
    //  * Moves this Button by a given amount.
    //  * <br> Can be negative to move in the other direction.
    //  * 
    //  * @param x how many pixels to move to right
    //  * @param y how many pixels to move to down
    //  */
    // public void moveBy(int x, int y) {
    //     this.x += x;
    //     this.x += y;
    // }

    // /**
    //  * Returns a Point containing information about the location of this Button.
    //  * <br> The Point's x-coordinate is the x-coordinate of this Button.
    //  * <br> The Point's y-coordinate is the y-coordinate of this Button.
    //  * 
    //  * @return a Point containing information about the location of this Button
    //  */
    // public Point getPosition() {
    //     return new Point(x, y);
    // }

    // /**
    //  * Resizes this Button.
    //  * 
    //  * @param width new width of this Button
    //  * @param height new height of this Button
    //  */
    // public void reSize(int width, int height) {
    //     this.width = width;
    //     this.height = height;
    // }

    // /**
    //  * Increases the size of this Button.
    //  * <br> Can be negative to shrink.
    //  * <br> Note that it is possible to have a negative width/height.
    //  * 
    //  * @param width how many pixels to increase the width by
    //  * @param height how many pixels to increase the height by
    //  */
    // public void grow(int width, int height) {
    //     this.width += width;
    //     this.height += height;
    // }

    // /**
    //  * Returns a Point containing information about the size of this Button.
    //  * <br> The Point's x-coordinate is the width of this Button.
    //  * <br> The Point's y-coordinate is the height of this Button.
    //  * 
    //  * @return a Point containing information about the size of this Button
    //  */
    // public Point getSize() {
    //     return new Point(width, height);
    // }

    // /**
    //  * Sets the offset for the text.
    //  * <br> For example, if the offset (x, y) is (0, 0), the text will be drawn in the center of this Button.
    //  * <br> If the offset is (100, 100), the text will be drawn 100 pixels to the right and 100 pixels down (from the center of this Button).
    //  * <br> (0, 0) by default.
    //  * 
    //  * @param x new x-coordinate for the text offset
    //  * @param y new y-coordinate for the text offset
    //  */
    // public void setTextOffset(int x, int y) {
    //     textOffsetX = x;
    //     textOffsetY = y;
    // }

    // /**
    //  * Returns the x-coordinate for the text offset.
    //  * 
    //  * @return the x-coordinate for the text offset
    //  */
    // public int getTextOffsetX() {
    //     return textOffsetX;
    // }

    // /**
    //  * Returns the y-coordinate for the text offset.
    //  * 
    //  * @return the y-coordinate for the text offset
    //  */
    // public int getTextOffsetY() {
    //     return textOffsetY;
    // }

    // /**
    //  * Adds an ActionListener to this Button to be notified.
    //  * <br> There can be multiple ActionListeners.
    //  * <br> Note that if an ActionListener is added twice, it could be notified twice.
    //  * <br> To prevent this, the "isListening" method can be used.
    //  * <br> No actionListeners by default.
    //  * 
    //  * @param actionListener ActionListener for this Button to notify
    //  */
    // public void addActionListener(ActionListener actionListener) {
    //     listening.add(actionListener);
    // }

    // /**
    //  * Removes actionListener from this Button to be notified.
    //  * 
    //  * @param actionListener the ActionListener to be removed from the list to be notified
    //  * @return true if actionListener was removed
    //  */
    // public boolean removeActionListener(ActionListener actionListener) {
    //     return listening.remove(actionListener);
    // }

    // /**
    //  * Checks if listener is listening to this Button.
    //  * 
    //  * @param listener ActionListener to scan for
    //  * @return true if listener is listening to this Button
    //  */
    // public boolean isListening(ActionListener listener) {
    //     for (ActionListener actionListener: listening) {
    //         if (actionListener.equals(listener)) {
    //             return true;
    //         }
    //     }
    //     return false;
    // }

    // /**
    //  * Returns the hoveringOpacity of this Button (how transparent it is).
    //  * 
    //  * @return the hoveringOpacity of this Button (how transparent it is)
    //  */
    // public float getHoveringOpacity() {
    //     return hoveringOpacity;
    // }

    // /**
    //  * Changes the fill value for this Button.
    //  * <br> 255 by default.
    //  * @see <a href="https://processing.org/reference/fill_.html">processing.core.PApplet.fill(rgb)</a>
    //  * 
    //  * @param fill new fill value for this Button (color variable or hex value)
    //  */
    // public void setFill(int fill) {
    //     this.fill = fill;
    //     fillr = -1;
    //     fillg = -1;
    //     fillb = -1;
    // }

    // /**
    //  * Changes the fill value for this Button.
    //  * @see <a href="https://processing.org/reference/fill_.html">processing.core.PApplet.fill(v1, v2, v3)</a> 
    //  * 
    //  * @param r new r fill value for this Button (red or hue value, depending on current color mode)
    //  * @param g new g fill value for this Button (green or saturation value, depending on current color mode)
    //  * @param b new b fill value for this Button (blue or brightness value, depending on current color mode)
    //  */
    // public void setFill(float r, float g, float b) {
    //     fillr = r;
    //     fillg = g;
    //     fillb = b;
    //     fill = -1;
    // }

}
