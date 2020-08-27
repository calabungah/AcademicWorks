/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nextdate;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author callu
 */
public class ContentTest {
    
    Content instance = new Content();
    
    public ContentTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of nextDate method, of class Content.
     */
    @Test
    public void testNextDateValid() {
        String month = "Jan";
        int day = 1;
        int year = 2000;
        String expResult = "Jan 02 2000";
        String result;
        result = (instance.nextDate(month, day, year));
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNextDateMaxDay() {
        String month = "Jan";
        int day = 31;
        int year = 2000;
        String expResult = "Feb 01 2000";
        String result;
        result = (instance.nextDate(month, day, year));
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNextDateMinDay() {
        String month = "Jan";
        int day = 1;
        int year = 2000;
        String expResult = "Jan 02 2000";
        String result;
        result = (instance.nextDate(month, day, year));
        assertEquals(expResult, result);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNextDateMaxPlusDay() {
        String month = "Jan";
        int day = 32;
        int year = 2000;
        instance.nextDate(month, day, year);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNextDateMinPlusDay() {
        String month = "Jan";
        int day = 0;
        int year = 2000;
        instance.nextDate(month, day, year);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testNextDateInvalidDay() {
        String month = "Jan";
        int day = -10;
        int year = 2000;
        instance.nextDate(month, day, year);
    }
    
    @Test
    public void testNextDateValidMonth() {
        String month = "Dec";
        int day = 20;
        int year = 2000;
        String expResult = "Dec 21 2000";
        String result;
        result = (instance.nextDate(month, day, year));
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNextDateMaxMonth() {
        String month = "Dec";
        int day = 31;
        int year = 2000;
        String expResult = "Jan 01 2001";
        String result;
        result = (instance.nextDate(month, day, year));
        assertEquals(expResult, result);
    }
    
    @Test
    public void testNextDateMinMonth() {
        String month = "Jan";
        int day = 5;
        int year = 2000;
        String expResult = "Jan 06 2000";
        String result;
        result = (instance.nextDate(month, day, year));
        assertEquals(expResult, result);
    }
    
    @Test(expected=IllegalArgumentException.class)
    public void testNextDateInvalidMonth() {
        String month = "naJ";
        int day = 5;
        int year = 2000;
        instance.nextDate(month, day, year);
    }

    /**
     * Test of isLeapYear method, of class Content.
     */
    @Test
    public void testIsLeapYear() {

    }

    /**
     * Test of nextMonth method, of class Content.
     */
    @Test
    public void testNextMonth() {

    }
    
}
