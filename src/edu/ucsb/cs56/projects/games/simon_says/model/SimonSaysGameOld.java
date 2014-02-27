package edu.ucsb.cs56.projects.games.simon_says.model;

import edu.ucsb.cs56.projects.games.simon_says.SimonButton;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Created by Administrator on 14-2-23.
 */
public class SimonSaysGameOld {

    private ArrayList<Integer> computerButtonPresses;
    private SimonButton[] buttons; // order: Green Red, Yellow, Blue
    private JButton startButton;
    private JComponent startButtonLocation;
    private int currentButton;
    private int placeInSequence; // will be zero-based
//    private int greenInt = 0;
//    private int redInt = 1;
//    private int yellowInt= 2;
//    private int blueInt =3;


//    public SimonSaysGameOld(){
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



    public SimonSaysGameOld(ArrayList<Integer> flashes, SimonButton[] buttons, JButton startButton, JComponent startButtonLocation) {
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


    public ArrayList<Integer> getCurrentSequence(){
        return computerButtonPresses;
    }

    public boolean sequenceComplete(){
        return (placeInSequence >= getCurrentSequence().size());
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
                    for (int button_num : getCurrentSequence()) { // iterate through each sequence element
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
        if (getCurrentSequence().size() == 1 ) {
            buttons[0].addActionListener(new SimonSaysGameOld.GreenPushListener()); // listen for inputs
            buttons[1].addActionListener(new SimonSaysGameOld.RedPushListener());
            buttons[2].addActionListener(new SimonSaysGameOld.YellowPushListener());
            buttons[3].addActionListener(new SimonSaysGameOld.BluePushListener());
            startButton.addActionListener(new SimonSaysGameOld.StartPushListener());
        }
        }

    public void checkLoss(int buttonNum){
        System.out.println("current button: "+currentButton);
        System.out.println("button number: "+buttonNum);
        System.out.println("length of sequence guessed: "+getSequenceLength());
        System.out.println("size of computerButtonPresses: "+getCurrentSequence().size());
        if (guessNextColor(buttonNum)){
            this.endTurn(false); // we did *not* lose; game continues
        }
        else {
            this.endTurn(true); // we lost
        }

    }


    public boolean guessNextColor(int buttonNum){
        placeInSequence++;
        boolean canIGuessTheNextColor=true;
        if (currentButton != buttonNum) {
            canIGuessTheNextColor = false;
            return canIGuessTheNextColor;
        }

        else if (sequenceComplete()) {
            canIGuessTheNextColor = true;
        }

        else if (currentButton == buttonNum) {
            currentButton = getCurrentSequence().get(placeInSequence);
        }

        return canIGuessTheNextColor;

    }


    public void endTurn(boolean didWeLose){
        if (didWeLose) {
            for (SimonButton button : buttons) {
                button.setEnabled(false);
                button.removeActionListeners();
                System.out.println("set buttons enabled false"); // DEBUG
            }
            System.out.println("You lost! Press start to begin again.");

            placeInSequence = 0;
            //Random randomGen = new Random(System.currentTimeMillis());
            //int randomNum = randomGen.nextInt(4);
            int randomNum2 = (int)( Math.random() * 3.9999999);
            computerButtonPresses = new ArrayList<Integer>();
            computerButtonPresses.add(randomNum2);
            currentButton = computerButtonPresses.get(0);

            startButtonLocation.add(startButton); // add button back to screen
            startButtonLocation.revalidate();
            startButtonLocation.repaint();
        }

        else if (didWeLose == false) {
            System.out.println("Success! Onto the next round!");
            // initiate new round
//            Random randomGen = new Random(System.currentTimeMillis());
//            int randomNum = randomGen.nextInt(4);
            int randomNum2 = (int)( Math.random() * 3.9999999);
            computerButtonPresses.add(randomNum2);
            placeInSequence = 0;
            currentButton = computerButtonPresses.get(0);
            startTurn();
        }
    }

    public class GreenPushListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            checkLoss(0);
        }
    }
    public class RedPushListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            checkLoss(1);
        }
    }
    public class YellowPushListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            checkLoss(2);
        }
    }
    public class BluePushListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            checkLoss(3);
        }
    }

    public class StartPushListener implements ActionListener {
        public void actionPerformed(ActionEvent ex) {
            startButtonLocation.remove(startButton); // erase button from screen
            startButtonLocation.revalidate();
            startButtonLocation.repaint();
            startTurn();
        }
    }


}




