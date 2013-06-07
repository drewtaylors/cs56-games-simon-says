
package edu.ucsb.cs56.projects.games.simon_says;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/** Flashes a sequence of buttons
 */

public class SimonFlash
 {
     /** Flashes in sequential order a sequence of numbers
     */
     public static void  FlashSequence(int[] flashes, SimonButton[] buttons) {
	 try {
	     for (SimonButton button : buttons) {
		 button.setEnabled(false);
	     }

	     for (int button_num : flashes) { // iterate through each sequence element
		 Thread.sleep(300);
		 SimonButton button = buttons[button_num]; // for readiblity
		 // buttons[flash].doClick(5000);
		 // DEBUG
		 Color buttonColor = button.getBackground();	 
	         button.setBackground(Color.WHITE);
		 Thread.sleep(150);
		 button.setBackground(buttonColor);
	     }
	 } catch (InterruptedException ex) { ex.printStackTrace(); }

	 for (SimonButton button : buttons) {
	     button.setEnabled(true);


	 }
     }
} 

