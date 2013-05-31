package edu.ucsb.cs56.projects.games.simon_says;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class SimonFrame extends JFrame {

    /** A no-arg constructor which builds the skeleton for the
     *  game's frame, generating an empty frame of a particular size. 
     */

    public SimonFrame() {
	super("Simon"); 
	this.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
	this.setSize(300,300);
	this.setVisible(true);
    }

    public static void main(String[] args) {
	SimonFrame frame = new SimonFrame();
    }
}
