package edu.ucsb.cs56.projects.games.simon_says.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;



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
    {
        ArrayList<Integer> actual = new ArrayList<Integer>();
        actual.add(2);actual.add(0);actual.add(1);actual.add(0);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(2);expected.add(0);expected.add(1);expected.add(0);
        int placeInSequence = 2;

        SimonSaysGame g = new SimonSaysGame(actual,placeInSequence);
        assertEquals(expected, g.getComputerPresses());
        assertEquals(1,g.getCurrentCorrectButton());
        assertEquals(2,g.getPlaceInSequence());
    }


    @Test
    public void testConstructorWithArgs_2()
    {
        ArrayList<Integer> actual = new ArrayList<Integer>();
        actual.add(2);actual.add(0);actual.add(1);actual.add(0);
        ArrayList<Integer> expected = new ArrayList<Integer>();
        expected.add(2);expected.add(0);expected.add(1);expected.add(0);
        int placeInSequence = 5;

        SimonSaysGame g = new SimonSaysGame(actual,placeInSequence);
        assertEquals(expected, g.getComputerPresses());
        assertEquals(0,g.getCurrentCorrectButton());
        assertEquals(3,g.getPlaceInSequence());
    }


    @Test
    public void test_getSequenceLength_1() {

        SimonSaysGame g = new SimonSaysGame();
        assertEquals(0,g.getSequenceLength());
    }


    @Test
    public void test_getSequenceLength_2() {

        ArrayList<Integer> actual = new ArrayList<Integer>();
        actual.add(2);actual.add(0);actual.add(1);actual.add(0);
        int placeInSequence = 2;

        SimonSaysGame g = new SimonSaysGame(actual,placeInSequence);
        assertEquals(4,g.getSequenceLength());
    }


    @Test
    public void test_sequenceComplete_1() {

        ArrayList<Integer> actual = new ArrayList<Integer>();
        actual.add(2);actual.add(0);actual.add(1);actual.add(0);
        int placeInSequence = 2;

        SimonSaysGame g = new SimonSaysGame(actual,placeInSequence);
        assertEquals(false,g.sequenceComplete());
    }

    @Test
    public void test_sequenceComplete_2() {

        ArrayList<Integer> actual = new ArrayList<Integer>();
        actual.add(2);actual.add(0);actual.add(1);actual.add(0);
        int placeInSequence = 3;

        SimonSaysGame g = new SimonSaysGame(actual,placeInSequence);
        assertEquals(true,g.sequenceComplete());
    }


    @Test
    public void test_sequenceComplete_3() {

        ArrayList<Integer> actual = new ArrayList<Integer>();
        actual.add(2);actual.add(0);actual.add(1);actual.add(0);
        int placeInSequence = 4;

        SimonSaysGame g = new SimonSaysGame(actual,placeInSequence);
        assertEquals(true,g.sequenceComplete());
    }









}
