/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package test_primechecker;

import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hoang
 */
public class PrimeCheckerTest {

    @Test
    public void testIsPrimeWithPrimeNumber() {
        assertEquals("Is 2 a prime number? true", primechecker.PrimeChecker.isPrime(2));
        assertEquals("Is 3 a prime number? true", primechecker.PrimeChecker.isPrime(3));
        assertEquals("Is 17 a prime number? true", primechecker.PrimeChecker.isPrime(17));
        assertEquals("Is 29 a prime number? true", primechecker.PrimeChecker.isPrime(29));
    }

    @Test
    public void testIsPrimeWithNonPrimeNumber() {
        assertEquals("Is 0 a prime number? false", primechecker.PrimeChecker.isPrime(0));
        assertEquals("Is 1 a prime number? false", primechecker.PrimeChecker.isPrime(1));
        assertEquals("Is 4 a prime number? false", primechecker.PrimeChecker.isPrime(4));
        assertEquals("Is 15 a prime number? false", primechecker.PrimeChecker.isPrime(15));
    }

    @Test
    public void testIsPrimeWithNegativeNumber() {
        assertEquals("Is -5 a prime number? false", primechecker.PrimeChecker.isPrime(-5));
    }

}
