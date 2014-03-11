package edu.ucsb.cs56.projects.games.simon_says.model;

import java.util.ArrayList;

public class SimonSaysGame {

    private ArrayList<Integer> computerPresses;//represents color
    private int currentCorrectButton;//records the correct button at certain time in the sequence
    private int placeInSequence;//records player's position in the sequence
    public boolean amIRightOnTheCurrent;//keeps track of whether the player is correct on the current number in the sequence
    public boolean amIRightOnTheNext;//keeps track of whether the player is correct on the next number in the sequence


    // no-arg constructor initialize computer presses with 1 random number
    public SimonSaysGame(){
        int randomNum = (int) (Math.random() * 3.9999999);
        computerPresses = new ArrayList<Integer>();
        computerPresses.add(randomNum);
        currentCorrectButton = computerPresses.get(0);
        placeInSequence = 0;
    }

    //constructor with arguments to initialize all the instance variables
    public SimonSaysGame(ArrayList<Integer> flashSequence,int tmpPlaceInSequence){
        //if the input placeInSequence is greater than the size of the sequence,initialize to the last one
        if (tmpPlaceInSequence>(flashSequence.size()-1)){
            computerPresses = flashSequence;
            currentCorrectButton = flashSequence.get(flashSequence.size()-1);
            placeInSequence = (flashSequence.size()-1);
        }
        else {
            computerPresses = flashSequence;
            currentCorrectButton = flashSequence.get(tmpPlaceInSequence);
            placeInSequence = tmpPlaceInSequence;
        }
    }

    // Create all the getters
    public  ArrayList<Integer> getComputerPresses(){
        return this.computerPresses;
    }

    public int getCurrentCorrectButton(){
        return this.currentCorrectButton;
    }

    public  int getPlaceInSequence(){
        return this.placeInSequence;
    }


    // Create all the setters
    public void setComputerPresses(ArrayList<Integer> newComputerPresses){
        this.computerPresses.clear();
        this.computerPresses.addAll(newComputerPresses);
    }

    public void setCurrentCorrectButton(int newCurrentCorrectButton){
        this.currentCorrectButton = newCurrentCorrectButton;
    }

    public void setPlaceInSequence(int newPlaceInSequence){
        this.placeInSequence = newPlaceInSequence;
    }




    // returns the length of the sequence currently being guessed
    public int getSequenceLength(){
        return computerPresses.size();
    }

    public boolean sequenceComplete(){
        return (placeInSequence >= (computerPresses.size()-1));
    }


    //guess the next color and it returns a boolean value indicating whether the guess is correct
    public boolean guessNextColor(int guessButtonNum){
        // increment the place in the sequence by 1
        placeInSequence++;

        // set the next correct button as the new correct button
        setCurrentCorrectButton(computerPresses.get(placeInSequence));

        //check whether the guessed button matches the correct button
        if (guessButtonNum == currentCorrectButton)
            return true;   //the player's guess is correct
        else
            return false;  //the player's guess is incorrect

    }


    // returns 1 if the game is over
    // should only be called to start a new game
    public int startTurn(ArrayList<Integer> guessNumAry){
        while(true){

            int currentGuess = guessNumAry.get(0);

            //if there's only one element in the guessNumAry, just check that one
            if(guessNumAry.size()==1){
                if (currentCorrectButton == guessNumAry.get(0))
                    amIRightOnTheCurrent = true;
                endTurn();
                return 1;
            }

            //if there's more than one element in the guessNumAry
            else {
                //get the next guess
                int nextGuess = guessNumAry.get(1);

                //check current guess
                if(currentCorrectButton == currentGuess){
                    //correct, go to the next one
                    amIRightOnTheCurrent = true;
                    amIRightOnTheNext = guessNextColor(nextGuess);
                    //if next guess is wrong OR the player has completed the sequence
                    if(!amIRightOnTheNext || sequenceComplete()){
                        endTurn();
                        return 1;
                    }

                }

                else{
                    endTurn();
                    return 1;
                }
            }

            //delete the first two guesses that we just checked
            guessNumAry.remove(0);
            guessNumAry.remove(1);
            amIRightOnTheCurrent = false;
            amIRightOnTheNext = false;

        }

    }


    public void endTurn(){
        //reset all the instance variables
        computerPresses.clear();
        placeInSequence = 0;
        //currentCorrectButton sets to -1 to indicate that the sequence is empty
        currentCorrectButton = -1;
    }



}
