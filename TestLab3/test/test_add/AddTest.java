/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test_add;

import add.Add;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoang
 */
public class AddTest {

    @Test
    public void testAddPositiveNumbers() {
        assertEquals(5, Add.add(2, 3));
    }

    @Test
    public void testAddNegativeNumbers() {
        assertEquals(-2, Add.add(-5, 3));
    }

    @Test
    public void testAddZero() {
        assertEquals(7, Add.add(7, 0));
    }

    @Test
    public void testAddLargeNumbers() {
        assertEquals(2000000000, Add.add(1000000000, 1000000000));
    }

    @Test
    public void testAddEqualNumbers() {
        assertEquals(10, Add.add(5, 5));
    }
    
    @Test
    public void testAddByLetter(){
        assertThrows(NumberFormatException.class, () -> {
            Add.add(Integer.parseInt("a"), 5);
        });
    }

}
