//
// PIRATE CHESS
// a simple game in Java
//
// Started Code provided by Dr. Barbara Anthony
// Last Modified: October 7, 2018

import acm.graphics.*;
import acm.program.*;
import java.awt.*;
import java.awt.event.*;

public class PirateChess extends GraphicsProgram {

	
	private static final long serialVersionUID = 1L;
	PirateChessGame game;
	GLabel textOutput;
	
	// global constants
	public static int N_SQUARES = 9;
	public static int SQUARE_WIDTH = 60;
	
	// game status
	private boolean quit = false;
	boolean lose=false;
	boolean setup = false;	
	
	public void addObject(DrawableObject drawable) {
		add(drawable.getGObject());
		if (drawable.sendToFront())
			drawable.getGObject().sendToFront();
		if (drawable.sendToBack())
			drawable.getGObject().sendToBack();
	}
	
	public void removeObject(DrawableObject drawable) {
		remove(drawable.getGObject());
	}
	
	public void setConsoleOutput(String str) {
		textOutput.setLabel(str);
	}
	
	// init()
	// this function runs when the applet starts	
	public void init() 
	{
		resize(N_SQUARES*SQUARE_WIDTH, N_SQUARES*SQUARE_WIDTH+40); // set the window size
		addKeyListeners();	   // setup program to accept keyboard info
		addMouseListeners();	   // setup program to accept mouse info

		textOutput = new GLabel("Pirate Chess", 30, N_SQUARES*SQUARE_WIDTH+20);
		add(textOutput);
		setBackground(Color.WHITE);
		
		game = new PirateChessGame(this);
		game.init();
	}
	
	// Called whenever a key is pressed	   
	public void keyPressed(KeyEvent evt) {
		
		int key = evt.getKeyCode();  // Keyboard code for the pressed key.
	    
	    if (key == KeyEvent.VK_X) {  // letter x key
	    	// quit the game
	    	quit = true;
	    }
	}
	
	public void mouseClicked(MouseEvent e) {
		int xCoord = e.getX();
		int yCoord = e.getY();
		
		int x = xCoord/SQUARE_WIDTH;
		int y = yCoord/SQUARE_WIDTH;
		
		if (x < N_SQUARES && y < N_SQUARES) {
			game.squareClicked(new BoardLocation(x,y));
		}		
	}

	// run the game
	public void run() 
	{		
		// run this loop until the game ends
		while(quit!=true){
			pause(50);
		}
	}
}
