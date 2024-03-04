/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gcd;

/**
 *
 * @author hoang
 */
public class GCD {

    public static int calculateGCD(int a, int b) {
        try {
            if (a == 0) {
                return b;
            } else if (b == 0) {
                return a;
            } else {
                while (b != 0) {
                    int temp = b;
                    b = a % b;
                    a = temp;
                }

                return a;
            }
        } catch (Exception e) {
            throw new NumberFormatException("Invalid input: Not a valid integer");
        }
    }
}
