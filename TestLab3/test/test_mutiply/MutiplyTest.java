/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test_mutiply;

import multiply.Multiply;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoang
 */
public class MutiplyTest {

    @Test
    public void testMultiplyPositiveNumbers() {
        assertEquals(15, Multiply.multiply(3, 5));
    }

    @Test
    public void testMultiplyNegativeNumbers() {
        assertEquals(15, Multiply.multiply(-3, -5));
    }

    @Test
    public void testMultiplyWithZero() {
        assertEquals(0, Multiply.multiply(8, 0));
    }

    @Test
    public void testMultiplyLargeNumbers() {
        assertEquals(2000000000, Multiply.multiply(1000000, 2000));
    }

    @Test
    public void testMultiplyPositiveAndNegative() {
        assertEquals(-15, Multiply.multiply(3, -5));
    }

    @Test
    public void testMultiplyEqualNumbers() {
        assertEquals(25, Multiply.multiply(5, 5));
    }

    @Test
    public void testMultiplyZeroAndZero() {
        assertEquals(0, Multiply.multiply(0, 0));
    }
    
    @Test
    public void testSubtractLetterAndNumber(){
        assertThrows(NumberFormatException.class, () -> {
            Multiply.multiply(Integer.parseInt("a"), 5);
        });
    }
}
