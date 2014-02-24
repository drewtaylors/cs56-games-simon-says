package edu.ucsb.cs56.projects.games.simon_says.edu.ucsb.cs56.projects.games.simon_says.model;

import edu.ucsb.cs56.projects.games.simon_says.SimonButton;
import edu.ucsb.cs56.projects.games.simon_says.SimonFlash;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by Administrator on 14-2-23.
 */
public class SimonSaysGame {

    private ArrayList<Integer> computerButtonPresses;
    private SimonButton[] buttons; // order: Green Red, Yellow, Blue
    private JButton startButton;
    private JComponent startButtonLocation;
    private int currentButton;
    private int placeInSequence; // will be zero-based
    private int greenInt = 0;
    private int redInt = 1;
    private int yellowInt= 2;
    private int blueInt =3;


//    public SimonSaysGame(){
//        computerButtonPresses = new ArrayList<Integer>();
////        computerButtonPresses.add(0,redInt);
////        computerButtonPresses.add(1,greenInt);
////        computerButtonPresses.add(2,yellowInt);
////        computerButtonPresses.add(3,blueInt);
//        buttons = new SimonButton[4];
//        for (int i=0; i<4; i++) {
//            buttons[i] = new SimonButton();
//        }
//        startButton = new JButton();
//        startButtonLocation = new JPanel();
//        currentButton = 0;
//    }

    public SimonSaysGame(ArrayList<Integer> flashes, SimonButton[] buttons, JButton startButton, JComponent startButtonLocation) {
        //userButtonPresses = new ArrayList<Integer>();
        //	 this.computerButtonPresses = new ArrayList<Integer>();
        computerButtonPresses = flashes;
        // System.out.println(flashes.get(0));
        //System.out.println(flashes.get(1));
        //System.out.println(flashes.get(2)+"\n");

        //computerButtonPresses.addAll(flashes);
        //Debug
        //System.out.println(computerButtonPresses.get(0));
        //System.out.println(computerButtonPresses.get(1));
        //System.out.println(computerButtonPresses.get(2));
        this.buttons = buttons;
        this.currentButton = flashes.get(0);
        this.startButton = startButton;
        this.startButtonLocation = startButtonLocation;
    }





    public ArrayList getCurrentSequence(){
        return computerButtonPresses;
    }

    public int getSequenceLength(){
        return placeInSequence+1;

    }



    public void startTurn(){
        new Thread(new Runnable() {
            public void run() {
                try {
                    for (SimonButton button : buttons) {
                        button.setEnabled(false);
                        ///   button.removeActionListeners();
                    }
                    for (int button_num : computerButtonPresses) { // iterate through each sequence element
                        Thread.sleep(500);
                        SimonButton button = buttons[button_num]; // for readiblity
                        //System.out.println("hey"); // DEBUG
                        Color buttonColor = button.getBackground();
                        button.setBackground(Color.WHITE);
                        Thread.sleep(250);
                        button.setBackground(buttonColor);
                    }

                    for (SimonButton button : buttons) { // reactivate buttons
                        button.setEnabled(true);
                    }
                } catch (InterruptedException ex) {ex.printStackTrace();}
            }
        }).start();

        // Change this to 1 later -  DEBUG
        if (computerButtonPresses.size() == 1 ) {
            buttons[0].addActionListener(new SimonSaysGame.GreenPushListener()); // listen for inputs
            buttons[1].addActionListener(new SimonSaysGame.RedPushListener());
            buttons[2].addActionListener(new SimonSaysGame.YellowPushListener());
            buttons[3].addActionListener(new SimonSaysGame.BluePushListener());
            startButton.addActionListener(new SimonSaysGame.StartPushListener());
        }
        }
    }


    public boolean guessNextColor(int buttonNum){
        placeInSequence++;
        boolean didWeLose;
        //debug

        System.out.println("current button: "+currentButton);
        System.out.println("button number: "+buttonNum);
        System.out.println("length of sequence guessed: "+getSequenceLength());
        System.out.println("size of computerButtonPresses: "+computerButtonPresses.size());

        if (currentButton != buttonNum) {
            didWeLose = true;

            this.endTurn(didWeLose); // we lost
        }
        else if (placeInSequence >= computerButtonPresses.size()) {
            //Debug
            // System.out.println("placeinSequence bigger than computerButtonPresses.size()");
            didWeLose = false;
            this.endRound(didWeLose); // we did *not* lose; game continues
        }
        else if (currentButton == buttonNum) {
            //
            currentButton = computerButtonPresses.get(placeInSequence);
        }


    }


}
