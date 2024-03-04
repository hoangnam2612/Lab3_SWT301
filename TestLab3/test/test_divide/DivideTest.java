/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test_divide;

import divide.Divide;
import multiply.Multiply;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
import test_mutiply.MutiplyTest;

/**
 *
 * @author hoang
 */
public class DivideTest {

    @Test
    public void testDividePositiveNumbers() {
        assertEquals(2, Divide.divide(6, 3));
    }

    @Test
    public void testDivideNegativeNumbers() {
        assertEquals(2, Divide.divide(-6, -3));
    }

    @Test
    public void testDividePositiveAndNegative() {
        assertEquals(-2, Divide.divide(6, -3));
    }

    @Test
    public void testDivideZeroByNumber() {
        assertEquals(0, Divide.divide(0, 5));
    }

    @Test
    public void testDivideNumberByZero() {
        Throwable exception = assertThrows(ArithmeticException.class, () -> {
            Divide.divide(5, 0);
        });

        assertEquals("Cannot divide by zero", exception.getMessage());
    }

    @Test
    public void testDivideLargeNumbers() {
        assertEquals(500, Divide.divide(1000000, 2000));
    }
    
    @Test
    public void testMultilyLetterAndNumber(){
        assertThrows(NumberFormatException.class, () -> {
            Multiply.multiply(Integer.parseInt("a"), 5);
        });
    }

}
