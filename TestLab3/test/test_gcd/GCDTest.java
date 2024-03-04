/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test_gcd;

import gcd.GCD;
import org.junit.Assert;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoang
 */
public class GCDTest {

    @Test
    public void testCalculateGCDWithPositiveIntegers() {
        assertEquals(3, GCD.calculateGCD(9, 6));
        assertEquals(5, GCD.calculateGCD(25, 15));
        assertEquals(1, GCD.calculateGCD(17, 8));
    }

    @Test
    public void testCalculateGCDWithOneZero() {
        assertEquals(7, GCD.calculateGCD(7, 0));
        assertEquals(5, GCD.calculateGCD(0, 5));
    }

    @Test
    public void testCalculateGCDWithBothZeros() {
        assertEquals(0, GCD.calculateGCD(0, 0));
    }
    
    @Test
    public void testGCDByLetter(){
        assertThrows(NumberFormatException.class, () -> {
            GCD.calculateGCD(Integer.parseInt("a"), 5);
        });
    }
}
