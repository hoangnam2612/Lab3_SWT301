/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test_stringreverse;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoang
 */
public class StringReverseTest {

    @Test
    public void testReverseStringForNonEmptyString() {
        assertEquals("olleH", stringreverse.StringReverse.reverseString("Hello"));
        assertEquals("dlrow", stringreverse.StringReverse.reverseString("world"));
    }

    @Test
    public void testReverseStringForEmptyString() {
        assertEquals("", stringreverse.StringReverse.reverseString(""));
    }

    @Test
    public void testReverseStringForNullInput() {
        assertNull(stringreverse.StringReverse.reverseString(null));
    }

}
