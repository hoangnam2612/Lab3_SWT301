/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test_subtract;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import subtract.Subtract;

/**
 *
 * @author hoang
 */
public class SubtractTest {

    @Test
    public void testSubtractPositiveNumbers() {
        assertEquals(2, Subtract.subtract(5, 3));
    }

    @Test
    public void testSubtractNegativeNumbers() {
        assertEquals(-2, Subtract.subtract(-5, -3));
    }

    @Test
    public void testSubtractWithZero() {
        assertEquals(8, Subtract.subtract(8, 0));
    }

    @Test
    public void testSubtractLargeNumbers() {
        assertEquals(100000000, Subtract.subtract(300000000, 200000000));
    }

    @Test
    public void testSubtractPositiveAndNegative() {
        assertEquals(8, Subtract.subtract(5, -3));
    }

    @Test
    public void testSubtractEqualNumbers() {
        assertEquals(0, Subtract.subtract(5, 5));
    }

    @Test
    public void testSubtractZeroAndZero() {
        assertEquals(0, Subtract.subtract(0, 0));
    }
    
    @Test
    public void testSubtractLetterAndNumber(){
        assertThrows(NumberFormatException.class, () -> {
            Subtract.subtract(Integer.parseInt("a"), 5);
        });
    }

}
