package edu.ucsb.cs56.projects.games.simon_says;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/** JFrame which contains all of the components for the Simon game.
 */

public class SimonFrame extends JFrame {

    /** A no-arg constructor which builds the skeleton for the
     *  game's frame, generating an empty frame of a particular size, 
     *  and adding all of the needed JComponents to that frame
     */
    public SimonFrame() {
	super("Simon"); // Window header title
	this.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
	this.setSize(300,300);
	
	// Filler areas that former border around frame
	Dimension fillerSizeVert = new Dimension(0, 30);
	Dimension fillerSizeHoriz = new Dimension(30, 30);
	this.getContentPane().add(BorderLayout.NORTH, Box.createRigidArea(fillerSizeVert));
	this.getContentPane().add(BorderLayout.SOUTH, Box.createRigidArea(fillerSizeVert));
	this.getContentPane().add(BorderLayout.WEST, Box.createRigidArea(fillerSizeHoriz));
	this.getContentPane().add(BorderLayout.EAST, Box.createRigidArea(fillerSizeHoriz));

	this.getContentPane().setBackground(Color.BLACK); // color borders of frame black

	// Generate all four the buttons, constructor automatically assings color and sets preferred size
	SimonButton redButton = new SimonButton(Color.RED);
	SimonButton greenButton = new SimonButton(Color.GREEN);
	SimonButton yellowButton = new SimonButton(Color.YELLOW);
	SimonButton blueButton = new SimonButton(Color.BLUE);

	// Generate center of frame for buttons
	JPanel center = new JPanel(new BorderLayout());
	this.getContentPane().add(BorderLayout.CENTER, center);

	// Top section of center
	JPanel top = new JPanel(new BorderLayout());
	center.add(BorderLayout.NORTH, top);

	// Bottom section of center
	JPanel bottom = new JPanel(new BorderLayout());
	center.add(BorderLayout.SOUTH, bottom);

	top.add(BorderLayout.WEST, greenButton); // top section of center contains green on the left...
	top.add(BorderLayout.EAST, redButton); // ...and red on the right
	bottom.add(BorderLayout.WEST, yellowButton); // bottom section of center contains yellow on the left...
	bottom.add(BorderLayout.EAST, blueButton); // ...and blue on the right

	// Color all of the background within the border black as well
	top.setBackground(Color.BLACK);
	bottom.setBackground(Color.BLACK);
	center.setBackground(Color.BLACK);
    }

    /** Method called by main() once all components have been added by frame
     *  to display the frame.
     */

    public void display() {
	this.setVisible(true);
    }

    /** A main() method which calls for the frame to be displayed
     */
    public static void main(String[] args) {
	SimonFrame frame = new SimonFrame();
	frame.display();
 
    }
}
