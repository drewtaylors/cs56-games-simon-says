
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
     private SimonButton[] buttons;

     public static void  FlashSequence(ArrayList<Integer> flashes, SimonButton[] buttons) {
	 SimonFlash sequence = new SimonFlash(flashes, buttons);
	 sequence.go();
     }

     public SimonFlash() { 
	 userButtonPresses = new ArrayList<Integer>();
	 computerButtonPresses = new ArrayList<Integer>();
	 buttons = new SimonButton[4];
     }

     public SimonFlash(ArrayList<Integer> flashes, SimonButton[] buttons) {
	 userButtonPresses = new ArrayList<Integer>(); // points all instance variables to same arrays passed in
	 this.computerButtonPresses = flashes;         // no duplication
	 this.buttons = buttons;
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

	 for (SimonButton button : buttons) {
	     button.addActionListener(new ButtonPushListener());
	     button.setEnabled(true);
	 }
	 userButtonPresses = new ArrayList<Integer>();
     }

     public class ButtonPushListener implements ActionListener {
	 public void actionPerformed(ActionEvent e) {
	     
	 }
     }

} 

