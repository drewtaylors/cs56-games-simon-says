package edu.ucsb.cs56.projects.games.simon_says.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;



public class SimonSaysTest {
    @Test public void testNoArgConstructor()
    {
        // default SimonSaysGame has computerPresses with 1 element,
        //currentCorrectButton with the value of the first element in computerPresses
        //and
        Polynomial p = new Polynomial();
        assertEquals(0,p.getDegree());
        assertEquals(0,(int) p.get(0));
    }

}
