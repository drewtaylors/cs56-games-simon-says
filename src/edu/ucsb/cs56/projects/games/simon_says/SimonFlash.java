
package edu.ucsb.cs56.projects.games.simon_says;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/** Flashes a sequence of buttons
 */

public class SimonFlash
 {
     private ArrayList<Integer>  userButtonPresses;
     private ArrayList<Integer> computerButtonPresses;
     private SimonButton[] buttons; // order: Green Red, Yellow, Blue
     private JButton startButton;
     private int currentButton; 
     private int placeInSequence; // will be zero-based
     
     public static void  FlashSequence(ArrayList<Integer> flashes, SimonButton[] buttons, JButton startButton) {
	 SimonFlash sequence = new SimonFlash(flashes, buttons, startButton);
	 sequence.go();
     }

     public SimonFlash() { 
	 userButtonPresses = new ArrayList<Integer>();
	 computerButtonPresses = new ArrayList<Integer>();
	 buttons = new SimonButton[4];
	 for (int i=0; i<4; i++) {
	     buttons[i] = new SimonButton();
	 }
	 startButton = new JButton();
	 currentButton = 0;
     }

     public SimonFlash(ArrayList<Integer> flashes, SimonButton[] buttons, JButton startButton) {
	 userButtonPresses = new ArrayList<Integer>();
	 //	 this.computerButtonPresses = new ArrayList<Integer>();
	 computerButtonPresses = flashes;
	 System.out.println(flashes.get(0));
	 System.out.println(flashes.get(1));
	 System.out.println(flashes.get(2)+"\n");

	 //computerButtonPresses.addAll(flashes);
	 //Debug
	 System.out.println(computerButtonPresses.get(0));
	 System.out.println(computerButtonPresses.get(1));
	 System.out.println(computerButtonPresses.get(2));
	 this.buttons = buttons;
	 this.currentButton = flashes.get(0);
	 this.startButton = startButton;
     }


     /** Flashes in sequential order a sequence of numbers
     */
     public void go() {
	 try {
	     for (SimonButton button : buttons) {
		 button.setEnabled(false);
		 button.removeActionListeners();
	     }
	     for (int button_num : computerButtonPresses) { // iterate through each sequence element
		 Thread.sleep(300);
		 SimonButton button = buttons[button_num]; // for readiblity
		 
		 System.out.println("hey"); // DEBUG
		 Color buttonColor = button.getBackground();
	         button.setBackground(Color.WHITE);

		 Thread.sleep(150);
		 button.setBackground(buttonColor);
		 //button.revalidate(); DEBUG
		 //button.repaint();
	     }
	 } catch (InterruptedException ex) { ex.printStackTrace(); }

	 for (SimonButton button : buttons) { // reactivate buttons
	     button.setEnabled(true);
	 }

	 buttons[0].addActionListener(new GreenPushListener()); // listen for inputs
	 buttons[1].addActionListener(new RedPushListener());
	 buttons[2].addActionListener(new YellowPushListener());
	 buttons[3].addActionListener(new BluePushListener());
	 startButton.addActionListener(new StartPushListener());
     }

     private void  lossCheck(int buttonNum) {
	 userButtonPresses.add(computerButtonPresses.get(currentButton));
	 placeInSequence++;
	 boolean didWeLose = false; // initialization just in case for debug

	 //debug
	 System.out.println("current button: "+currentButton);
	 System.out.println("button number: "+buttonNum);
	 System.out.println("place in sequence: "+placeInSequence);
	 System.out.println("size of computerButtonPresses: "+computerButtonPresses.size());
	 if (currentButton != buttonNum) {
	     didWeLose = true;
	     //System.out.println(computerButtonPresses.get(currentButton)
	 currentButton = computerButtonPresses.get(placeInSequence); 
	     this.endRound(didWeLose); // we lost
	 }
	 else if (placeInSequence >= computerButtonPresses.size()) {
	     //Debug
	     System.out.println("placeinSequence bigger than computerButtonPresses.size()");

	     didWeLose = false;
	     this.endRound(didWeLose); // we did *not* lose; game continues

	 }
	 else if (currentButton == buttonNum) {
	     //
	     currentButton = computerButtonPresses.get(placeInSequence);
	 }

     }

     private void endRound(boolean didWeLose) {
	 if (didWeLose == true) {
	     System.out.println("You lost! Press start to begin again.");
	 }
	 else if (didWeLose == false) {
	     System.out.println("Success! Onto the next round!");
	     // initiate new round
	 }
     }

     public class GreenPushListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
	     lossCheck(0);
	 }
     }
     public class RedPushListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
	     lossCheck(1);
	 }
     }
     public class YellowPushListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
	     lossCheck(2);
	 }
     }
     public class BluePushListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
	     lossCheck(3);
	 }
     }

     public class StartPushListener implements ActionListener {
	 public void actionPerformed(ActionEvent ex) {
	     // bottomInner.remove(startButton); // erase button from screen
	     // bottomInner.revalidate();
	     // bottomInner.repaint();
	     //  startGame();
	 } 
     }

} 

