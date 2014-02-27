package edu.ucsb.cs56.projects.games.simon_says.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;




public class SimonSaysTest {
    @Test
    public void testNoArgConstructor()
    {
        // default SimonSaysGame has computerPresses with 1 element,
        //currentCorrectButton with the value of the first element in computerPresses
        //and placeInSequence with value 0
        SimonSaysGame g = new SimonSaysGame();
        assertEquals(1, g.getComputerPresses().size());
        assertEquals((int)g.getComputerPresses().get(0),g.getCurrentCorrectButton());
    }
 
    @Test
    public void testConstructorWithArgs_1()
    {        //initial flash sequence is [2,0,1,0]
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(2);sequence.add(0);sequence.add(1);sequence.add(0);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(2);expected.add(0);expected.add(1);expected.add(0);
        int placeInSequence = 2;

        SimonSaysGame g = new SimonSaysGame(sequence,placeInSequence);
        assertEquals(expected, g.getComputerPresses());
        assertEquals(1,g.getCurrentCorrectButton());
        assertEquals(2,g.getPlaceInSequence());
    }


    @Test
    public void testConstructorWithArgs_2()
    {        //initial flash sequence is [2,0,1,0]
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(2);sequence.add(0);sequence.add(1);sequence.add(0);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(2);expected.add(0);expected.add(1);expected.add(0);
        int placeInSequence = 5;

        SimonSaysGame g = new SimonSaysGame(sequence,placeInSequence);
        assertEquals(expected, g.getComputerPresses());
        assertEquals(0,g.getCurrentCorrectButton());
        assertEquals(3,g.getPlaceInSequence());
    }


    @Test
    public void test_getSequenceLength_1() {

        SimonSaysGame g = new SimonSaysGame();
        assertEquals(1,g.getSequenceLength());
    }


    @Test
    public void test_getSequenceLength_2() {
        //initial flash sequence is [2,0,1,0]
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(2);sequence.add(0);sequence.add(1);sequence.add(0);
        int placeInSequence = 2;

        SimonSaysGame g = new SimonSaysGame(sequence,placeInSequence);
        assertEquals(4,g.getSequenceLength());
    }


    @Test
    //sequence is not completed
    public void test_sequenceComplete_1() {
        //initial flash sequence is [2,0,1,0]
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(2);sequence.add(0);sequence.add(1);sequence.add(0);
        int placeInSequence = 2;

        SimonSaysGame g = new SimonSaysGame(sequence,placeInSequence);
        assertEquals(false,g.sequenceComplete());
    }

    @Test
    //sequence is completed with placeInSequence at the end of the sequence
    public void test_sequenceComplete_2() {
        //initial flash sequence is [2,0,1,0]
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(2);sequence.add(0);sequence.add(1);sequence.add(0);
        int placeInSequence = 3;

        SimonSaysGame g = new SimonSaysGame(sequence,placeInSequence);
        assertEquals(true,g.sequenceComplete());
    }


    @Test
    //sequence is completed with placeInSequence exceeding the sequence
    public void test_sequenceComplete_3() {
        //initial flash sequence is [2,0,1,0]
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(2);sequence.add(0);sequence.add(1);sequence.add(0);
        int placeInSequence = 4;

        SimonSaysGame g = new SimonSaysGame(sequence,placeInSequence);
        assertEquals(true,g.sequenceComplete());
    }



    @Test
    //^1 If the player's guess for the next number is correct
    public void test_guessNextColor_1() {
        //initial flash sequence is [2,0,1,0]
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(2);sequence.add(0);sequence.add(1);sequence.add(0);
        int placeInSequence = 0;

        SimonSaysGame g = new SimonSaysGame(sequence,placeInSequence);
        //check whether it returns correct boolean value
        assertEquals(true,g.guessNextColor(0));
        //check whether placeInSequence is incremented
        assertEquals(1,g.getPlaceInSequence());
        //check whether currentCorrectButton is updated
        assertEquals(0,g.getCurrentCorrectButton());

    }

    @Test
    //^2 If the player's guess for the next number is incorrect
    public void test_guessNextColor_2() {
        //initial flash sequence is [2,0,1,0]
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(2);sequence.add(0);sequence.add(1);sequence.add(0);
        int placeInSequence = 0;

        SimonSaysGame g = new SimonSaysGame(sequence,placeInSequence);
        //check whether it returns correct boolean value
        assertEquals(false,g.guessNextColor(3));
        //check whether placeInSequence is incremented
        assertEquals(1,g.getPlaceInSequence());
        //check whether currentCorrectButton is updated
        assertEquals(0,g.getCurrentCorrectButton());

    }


    @Test
    //Just need to test whether it terminates properly
    //^1 If the player's guess is incorrect
    public void test_startTurn_1() {
        //initial flash sequence is [2,0,1,0]
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(2);sequence.add(0);sequence.add(1);sequence.add(0);
        int placeInSequence = 0;
        //guess array is [3], which is not correct
        ArrayList<Integer> guessAry = new ArrayList<Integer>();
        guessAry.add(3);

        SimonSaysGame g = new SimonSaysGame(sequence,placeInSequence);
        //check whether it returns 1 (representing that the game is over)
        assertEquals(1,g.startTurn(guessAry));
        //check whether computerPresses' size is reset to 0 through calling endTurn()
        assertEquals(0,g.getComputerPresses().size());
        //check whether placeInSequence is reset to 0 through calling endTurn()
        assertEquals(0,g.getPlaceInSequence());
        //check whether currentCorrectButton is reset to -1 through calling endTurn()
        assertEquals(-1,g.getCurrentCorrectButton());
    }

    @Test
    //Just need to test whether it terminates properly
    //^2 If the player has got everything in the sequence right
    public void test_startTurn_2() {
        //initial flash sequence is [2,0,1,0]
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(2);sequence.add(0);sequence.add(1);sequence.add(0);
        int placeInSequence = 0;
        //guess array is [2,0,1,0], which is correct
        ArrayList<Integer> guessAry = new ArrayList<Integer>();
        guessAry.add(2);guessAry.add(0);guessAry.add(1);guessAry.add(0);



        SimonSaysGame g = new SimonSaysGame(sequence,placeInSequence);
        //check whether it returns 1 (representing that the game is over)
        assertEquals(1,g.startTurn(guessAry));
        //check whether computerPresses' size is reset to 0 through calling endTurn()
        assertEquals(0,g.getComputerPresses().size());
        //check whether placeInSequence is reset to 0 through calling endTurn()
        assertEquals(0,g.getPlaceInSequence());
        //check whether currentCorrectButton is reset to -1 through calling endTurn()
        assertEquals(-1,g.getCurrentCorrectButton());
    }



    @Test
    public void test_endTurn_1() {
        //initial flash sequence is [2,0,1,0]
        ArrayList<Integer> sequence = new ArrayList<Integer>();
        sequence.add(2);sequence.add(0);sequence.add(1);sequence.add(0);
        int placeInSequence = 2;

        SimonSaysGame g = new SimonSaysGame(sequence,placeInSequence);
        g.endTurn();

        //check whether computerPresses' size is reset to 0 through calling endTurn()
        assertEquals(0,g.getComputerPresses().size());
        //check whether placeInSequence is reset to 0 through calling endTurn()
        assertEquals(0,g.getPlaceInSequence());
        //check whether currentCorrectButton is reset to -1 through calling endTurn()
        assertEquals(-1,g.getCurrentCorrectButton());
    }



}
