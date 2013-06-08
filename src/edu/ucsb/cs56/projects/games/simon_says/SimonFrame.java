package edu.ucsb.cs56.projects.games.simon_says;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/** JFrame which contains all of the components for the Simon game.
 */

public class SimonFrame extends JFrame {

    SimonButton redButton;
    SimonButton greenButton;
    SimonButton yellowButton;
    SimonButton blueButton;
    JButton startButton;

    JPanel center;
    JPanel top;
    JPanel bottom;
    JPanel bottomInner;

    /** A no-arg constructor which builds the skeleton for the
     *  game's frame, generating an empty frame of a particular size, 
     *  and adding all of the needed JComponents to that frame
     */
    public SimonFrame() {
	super("Simon"); // Window header title
	this.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
	this.setSize(300,300);
	
	// Filler areas that former border around frame
	final Dimension fillerSizeVert = new Dimension(0, 30);
	final Dimension fillerSizeHoriz = new Dimension(30, 30);
	this.getContentPane().add(BorderLayout.NORTH, Box.createRigidArea(fillerSizeVert));
	this.getContentPane().add(BorderLayout.SOUTH, Box.createRigidArea(fillerSizeVert));
	this.getContentPane().add(BorderLayout.WEST, Box.createRigidArea(fillerSizeHoriz));
	this.getContentPane().add(BorderLayout.EAST, Box.createRigidArea(fillerSizeHoriz));
        
	this.getContentPane().setBackground(Color.BLACK); // color borders of frame black

	// Generate all four the buttons, constructor automatically assings color and sets preferred size
	this.redButton = new SimonButton(Color.RED);
	this.greenButton = new SimonButton(Color.GREEN);
	this.yellowButton = new SimonButton(Color.YELLOW);
	this.blueButton = new SimonButton(Color.BLUE);

	// Generate center of frame for buttons
	 center = new JPanel(new BorderLayout());
	this.getContentPane().add(BorderLayout.CENTER, center);

	// Top section of center
	top = new JPanel(new BorderLayout());
	center.add(BorderLayout.NORTH, top);

	// Bottom section of center
	bottom = new JPanel(new BorderLayout());
	center.add(BorderLayout.SOUTH, bottom);

	// Finally, add buttons to panels
	top.add(BorderLayout.WEST, greenButton); // top section of center contains green on the left...
	top.add(BorderLayout.EAST, redButton); // ...and red on the right
	bottom.add(BorderLayout.WEST, yellowButton); // bottom section of center contains yellow on the left...
	bottom.add(BorderLayout.EAST, blueButton); // ...and blue on the right

	// Add Start button to bottom to Filler area
	startButton = new JButton("Start");
	bottomInner = new JPanel(); // Create a panel to put button so button doesn't span whole border
	bottomInner.add(startButton);
	this.bottomInner.add(Box.createRigidArea(fillerSizeVert)); // Makes sure that when button is deleted, the filler area
	                                                           // of the proper size will remain behind it
	this.getContentPane().add(BorderLayout.SOUTH, bottomInner); //

	

	startButton.addActionListener(new StartListener());

	// Color all of the background within the border black as well
	top.setBackground(Color.BLACK);
	bottom.setBackground(Color.BLACK);
	center.setBackground(Color.BLACK);
	bottomInner.setBackground(Color.BLACK);
    }


    public class StartListener implements ActionListener {
	public void actionPerformed(ActionEvent ex) {
	    bottomInner.remove(startButton); // erase button from screen
	    bottomInner.revalidate();
	    bottomInner.repaint();
	    startGame();
	}
    }
    /** Method called by main() once all components have been added by frame
     *  to display the frame.
     */

    public void display() {
	this.setVisible(true);
	/* DEBUG, remove
	try {
	    System.out.println("red");
	    redButton.doClick(1000);
	    Thread.sleep(1000);
	    System.out.println("green");
	    greenButton.doClick(500);
	    Thread.sleep(1000);
	    System.out.println("yellow");
	    yellowButton.doClick(1000);
	} catch (InterruptedException ex) { }
	*/
	// DEBUG
	//yellowButton.addActionListener(new SimonListener());
	ArrayList<Integer> test_array = new ArrayList<Integer>();

	test_array.add(2); test_array.add(0); test_array.add(0); // Ugly, but just for testing 

	try { Thread.sleep(2000); } catch (InterruptedException ex) { }
	SimonButton button_array[] = {greenButton, redButton, yellowButton, blueButton};
	SimonFlash.FlashSequence(test_array, button_array);
	
	// DEBUG redButton.setBackground(Color.WHITE);
    }
    /** A main() method which calls for the frame to be displayed
     */

    public void startGame() {
	
    }
    public static void main(String[] args) {
	SimonFrame frame = new SimonFrame();
	frame.display();
 
    }
}
