/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test_palindromechecker;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoang
 */
public class PalindromeCheckerTest {

    @Test
    public void testValidPalindrome() {
        assertTrue(palindromechecker.PalindromeChecker.checkPalindrome("A man a plan a canal Panama"));
    }

    @Test
    public void testValidPalindromeDifferentCases() {
        assertTrue(palindromechecker.PalindromeChecker.checkPalindrome("Able was I ere I saw Elba"));
    }

    @Test
    public void testNonPalindrome() {
        assertFalse(palindromechecker.PalindromeChecker.checkPalindrome("Hello, World!"));
    }

    @Test
    public void testEmptyString() {
        assertTrue(palindromechecker.PalindromeChecker.checkPalindrome(""));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullInput() {
        palindromechecker.PalindromeChecker.checkPalindrome(null);
    }

}
