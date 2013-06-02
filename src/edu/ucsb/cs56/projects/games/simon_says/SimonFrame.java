package edu.ucsb.cs56.projects.games.simon_says;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/** JFrame which contains all of the components for the Simon game.
 */

public class SimonFrame extends JFrame {

    /** A no-arg constructor which builds the skeleton for the
     *  game's frame, generating an empty frame of a particular size. 
     */
    public SimonFrame() {
	super("Simon"); 
	this.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
	this.setSize(300,300);
	
	// Filler areas that former border around frame
	Dimension fillerSizeVert = new Dimension(0, 30);
	Dimension fillerSizeHoriz = new Dimension(30, 30);
	this.getContentPane().add(BorderLayout.NORTH, Box.createRigidArea(fillerSizeVert));
	this.getContentPane().add(BorderLayout.SOUTH, Box.createRigidArea(fillerSizeVert));
	this.getContentPane().add(BorderLayout.WEST, Box.createRigidArea(fillerSizeHoriz));
	this.getContentPane().add(BorderLayout.EAST, Box.createRigidArea(fillerSizeHoriz));


	// Generate all of the buttons, constructor automatically assings color and sets preferred size
	SimonButton redButton = new SimonButton(Color.RED);
	SimonButton greenButton = new SimonButton(Color.GREEN);
	SimonButton yellowButton = new SimonButton(Color.YELLOW);
	SimonButton blueButton = new SimonButton(Color.BLUE);

	// Generate center of frame for buttons
	JPanel center = new JPanel(new BorderLayout());
	this.getContentPane().add(BorderLayout.CENTER, center);

	// Top section of center will 
	JPanel top = new JPanel(new BorderLayout());
	center.add(BorderLayout.NORTH, top);

	JPanel bottom = new JPanel(new BorderLayout());
	center.add(BorderLayout.SOUTH, bottom);

	top.add(BorderLayout.WEST, greenButton);
	top.add(BorderLayout.EAST, redButton);
	bottom.add(BorderLayout.WEST, yellowButton);
	bottom.add(BorderLayout.EAST, blueButton);

	/*
	JPanel center = new JPanel(new BorderLayout());
	center.setBackground(Color.GRAY);
	this.getContentPane().add(center, BorderLayout.CENTER);

	JPanel left = new JPanel(new BorderLayout());
	left.setBackground(Color.gray);
	this.getContentPane().add(left, BorderLayout.WEST);

	JPanel right = new JPanel(new BorderLayout());
	right.setBackground(Color.gray);
	this.getContentPane().add(right, BorderLayout.EAST);

	center.add(BorderLayout.NORTH, redButton);
	this.getContentPane().add(Box.createRigidArea(new Dimension(0,10)));
	left.add(BorderLayout.CENTER, greenButton);
	center.add(BorderLayout.SOUTH, yellowButton);
	right.add(BorderLayout.CENTER, blueButton);
   
	*/
	this.setBackground(Color.BLACK);
    }

    /** Method called by main() once all components have been added by frame
     *  to display the frame.
     */

    public void display() {
	this.setVisible(true);
    }

    public static void main(String[] args) {
	SimonFrame frame = new SimonFrame();
	frame.display();
 
    }
}
