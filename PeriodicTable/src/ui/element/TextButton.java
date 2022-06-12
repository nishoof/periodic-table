package  ui.element;

import processing.core.PApplet;
import processing.core.PConstants;

import java.awt.event.*;



/**
 * Represents a TextButton to be used with Processing. Basically like a Button but the user
 * can interact by changing the text in the TextButton. Can be used for the user to input
 * data.
 * 
 * @author nishoof
 */
public class TextButton extends Button {

    public StringBuffer text;

    private boolean selected;
    private boolean cursorVisible;
    private int i;
    private int cursorIndex;

    private int textSize;


    public TextButton(int x, int y, int width, int height, int textSize) {
        super(x, y, width, height);
        this.textSize = textSize;
        this.text = new StringBuffer("");
    }

    public TextButton(int x, int y, int width, int height, int textSize, ActionListener actionListener) {
        super(x, y, width, height, actionListener);
        this.textSize = textSize;
        this.text = new StringBuffer("");
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

        // System.out.println(cursorIndex);

        String textStr = text.toString();
        super.text = textStr;

        surface.textSize(textSize);
        super.draw(surface);

        if (selected) {
            i += 1;

            if (i % 30 == 0) {
                cursorVisible = !cursorVisible;
                i = 0;
            }

            if (cursorVisible) {

                surface.fill(0);
                surface.stroke(0);

                float xOffset, space, letters;
                space = (this.width - surface.textWidth(textStr)) / 2;
                if (cursorIndex == 0) {
                    letters = 0;
                } else {
                    if (textStr.length() <= 0) {
                        letters = 0;
                    } else {
                        letters = surface.textWidth(textStr.substring(0, cursorIndex)) + 1;
                    }
                }
                xOffset = space + letters;

                // System.out.println(space + "         " + letters);
                // System.out.println("." + textStr + ".");
                
                int x = (int)(this.x - (int)(anchorX*this.width) + xOffset + textOffsetX);
                int y = this.y - (int)(anchorY*this.height) + this.height/2 - textSize/2;
                System.out.println(space);
                surface.line(x, y, x, y+textSize);
            }
        }


    }

    /**
     * Should be called whenever the mouse is pressed.
     * <br> Used for checking if this Button was clicked and for selecting.
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
                selected = true;
                i = 0;
                cursorVisible = true;
            } else {
                id = RIGHT_CLICK;
            }

            for (ActionListener listener: listening) {
                listener.actionPerformed(new ActionEvent(this, id, null));
            }

        } else {
            selected = false;
            i = 0;
        }
    }

    /**
	 * Called when a key is pressed
	 */
	public void keyPressed(PApplet surface) {
		
        char key = surface.key;
        String text = this.text.toString();
        int length = text.length();

        if (key == PConstants.CODED) {
            int key2 = surface.keyCode;
            switch (key2) {
                case PConstants.LEFT:
                    cursorIndex -= 1;
                    if (cursorIndex < 0) {
                        cursorIndex = 0;
                    }
                    showCursor();
                    break;
                case PConstants.RIGHT:
                    cursorIndex += 1;
                    if (cursorIndex > length) {
                        cursorIndex = length;
                    }
                    showCursor();
                    break;
            }
        } else if (key == PConstants.BACKSPACE) {
			if (length > 0 && cursorIndex > 0) {
                // if (cursorIndex == 1) {
                //     setText(text.substring(1));
                // } else if (cursorIndex == length) {
                //     setText(text.substring(0, cursorIndex-1));
                // } else {
                //     setText(text.substring(0, cursorIndex-1) + text.substring(cursorIndex, length));
                // }
                this.text.deleteCharAt(cursorIndex-1);
                cursorIndex -= 1;
			}
		} else {
            // if (cursorIndex == 0) {
            //     setText(key + text);
            // } else if (cursorIndex == length) {
            //     setText(text + key);
            // } else {
            //     setText(text.substring(0, cursorIndex) + key + text.substring(cursorIndex, length) );
            // }
            this.text.insert(cursorIndex, key);
            cursorIndex += 1;
        }

	}

    /*
      Checks if (x, y) is in this Button (including border).
     */
    private boolean contains(int x, int y) {
        
        // variable names: https://cdn.discordapp.com/attachments/421191351451779075/982391029091164250/buttonContainsImage1.png
        // area numbers: https://cdn.discordapp.com/attachments/421191351451779075/982393687994671135/buttonContainsImage2.png


        int x2 = x-(int)(anchorX*width);
        int y2 = y-(int)(anchorY*height);

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

    /*
     * Shows cursor and resets counter, used for when moving the cursor around.
     */
    private void showCursor() {
        i = 0;
        cursorVisible = true;
    }

}
