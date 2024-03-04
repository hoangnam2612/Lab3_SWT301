/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package primechecker;

/**
 *
 * @author hoang
 */
public class PrimeChecker {

    public static String isPrime(int number) {
        boolean result = true;

        if (number <= 1) {
            result = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    result = false;
                    break;
                }
            }
        }

        return "Is " + number + " a prime number? " + result;
    }
}
