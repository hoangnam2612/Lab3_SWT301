/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test_findmax;

import findmax.FindMax;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoang
 */
public class FindMaxTest {

    @Test
    public void testFindMaxWithPositiveIntegers() {
        assertEquals(15,  FindMax.findMax(10, 5, 15));
        assertEquals(20, FindMax.findMax(20, 10, 15));
        assertEquals(25, FindMax.findMax(15, 25, 20));
    }

    @Test
    public void testFindMaxWithNegativeIntegers() {
        assertEquals(-5, FindMax.findMax(-10, -5, -15));
        assertEquals(-2, FindMax.findMax(-2, -8, -10));
    }

    @Test
    public void testFindMaxWithEqualIntegers() {
        assertEquals(7, FindMax.findMax(7, 7, 7));
        assertEquals(-3, FindMax.findMax(-3, -3, -3));
    }

    @Test
    public void testFindMaxWithMixedIntegers() {
        assertEquals(10, FindMax.findMax(10, -5, 0));
        assertEquals(15, FindMax.findMax(-20, 15, -30));
    }

    @Test
    public void testFindMaxWithInvalidInput() {
        assertThrows(NumberFormatException.class, () -> {
            FindMax.findMax(10, 5, Integer.parseInt("abc"));
        });
    }

}
