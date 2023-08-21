package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void isEven_true(){
        assertTrue(App.isEven(0));
        assertTrue(App.isEven(2));
        assertTrue(App.isEven(-2));
    }

    @Test
    public void isEven_false(){
        assertFalse(App.isEven(1));
        assertFalse(App.isEven(3));
        assertFalse(App.isEven(-1));
    }

    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }
}
