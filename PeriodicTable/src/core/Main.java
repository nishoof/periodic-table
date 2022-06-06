package core;

import javax.swing.JFrame;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;


public class Main {
	
	public static void main(String[] args) {
		
		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();
		
		window.setSize(1017, 640);				// acting weird with width/height, actual width/height are 1000 and 600
		window.setLocation(20, 20);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);
		
		window.setVisible(true);
		
		canvas.requestFocus();
		
	}
	
}
