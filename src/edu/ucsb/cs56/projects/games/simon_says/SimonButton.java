package edu.ucsb.cs56.projects.games.simon_says;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/** JFrame which contains all of the components for the Simon game.
 */

public class SimonButton extends JButton {

    public SimonButton() {
	this.setPreferredSize(new Dimension(100,100));
    }

    public SimonButton(Color color) { 
	this();
	this.setBackground(color);
    }



    public static void main(String[] args) {
    }
}
