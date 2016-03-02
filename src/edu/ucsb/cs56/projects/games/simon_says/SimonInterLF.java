
package edu.ucsb.cs56.projects.games.simon_says;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

/** Speed up version of SimonFrame for intermediate level
 */
public class SimonInterLF extends SimonFrame {
	
	public SimonInterLF(){
		super();

	}
	
	
	public void startGame() {

		Random randomGen = new Random(System.currentTimeMillis());
		int randomNum = randomGen.nextInt(4);
		int randomNum2 = (int)( Math.random() * 3.9999999); 
		
		SimonButton button_array[] = {greenButton, redButton, yellowButton, blueButton};
		
		ArrayList<Integer> test_array =  new ArrayList<Integer>();
		test_array.add(randomNum2); // one element to start off with
		SimonInterL flash = new SimonInterL(test_array, button_array, startButton,returnButton, bottomInner,score);


		flash.go();
		System.out.println("after flash sequence"); // DEBUG}
	}
	    
	  


}
