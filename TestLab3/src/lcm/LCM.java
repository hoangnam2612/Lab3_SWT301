/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lcm;

import gcd.GCD;

/**
 *
 * @author hoang
 */
public class LCM {

    public static int calculateLCM(int a, int b) {
        try {
            if (a <= 0 || b <= 0) {
                throw new IllegalArgumentException("Đầu vào phải là số nguyên dương");
            }

            return (a * b) / GCD.calculateGCD(a, b);
        } catch (Exception e) {
            throw new NumberFormatException("Invalid input: Not a valid integer");
        }
    }
}
