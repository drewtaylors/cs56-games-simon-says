
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
     private int placeInSequence; // will be zero-based

     public static void  FlashSequence(ArrayList<Integer> flashes, SimonButton[] buttons) {
	 SimonFlash sequence = new SimonFlash(flashes, buttons);
	 sequence.go();
     }

     public SimonFlash() { 
	 userButtonPresses = new ArrayList<Integer>();
	 computerButtonPresses = new ArrayList<Integer>();
	 buttons = new SimonButton[4];
	 placeInSequence = 0;
     }

     public SimonFlash(ArrayList<Integer> flashes, SimonButton[] buttons) {
	 userButtonPresses = new ArrayList<Integer>(); // points all instance variables to same arrays passed in
	 this.computerButtonPresses = flashes;         // no duplication
	 this.buttons = buttons;
	 this.placeInSequence = 0;
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
		 
		 Color buttonColor = button.getBackground();	 
	         button.setBackground(Color.WHITE);
		 Thread.sleep(150);
		 button.setBackground(buttonColor);
	     }
	 } catch (InterruptedException ex) { ex.printStackTrace(); }

	 buttons[0].addActionListener(new GreenPushListener());
	 buttons[1].addActionListener(new RedPushListener());
	 buttons[2].addActionListener(new YellowPushListener());
	 buttons[3].addActionListener(new BluePushListener());
     }
     public class GreenPushListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
	     userButtonPresses.add(computerButtonPresses.get(placeInSequence));
	     placeInSequence++;
	 }
     }
     public class RedPushListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
	     userButtonPresses.add(computerButtonPresses.get(placeInSequence));
	     placeInSequence++;
	 }
     }
     public class YellowPushListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
	     userButtonPresses.add(computerButtonPresses.get(placeInSequence));
	     placeInSequence++;
	 }
     }
     public class BluePushListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
	     userButtonPresses.add(computerButtonPresses.get(placeInSequence));
	     placeInSequence++;
	 }
     }

} 

