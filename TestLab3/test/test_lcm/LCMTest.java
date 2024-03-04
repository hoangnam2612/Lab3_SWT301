/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test_lcm;

import lcm.LCM;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoang
 */
public class LCMTest {

    @Test
    public void testCalculateLCM() {
        assertEquals(12, LCM.calculateLCM(4, 6));
        assertEquals(20, LCM.calculateLCM(5, 4));
        assertEquals(24, LCM.calculateLCM(8, 6));
    }

    @Test
    public void testCalculateLCMWithIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> {
            LCM.calculateLCM(-5, 10);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            LCM.calculateLCM(15, 0);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            LCM.calculateLCM(0, -7);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            LCM.calculateLCM(-3, -4);
        });
    }
    
    @Test
    public void testGCDByLetter(){
        assertThrows(NumberFormatException.class, () -> {
            LCM.calculateLCM(Integer.parseInt("a"), 4);
        });
    }
}
