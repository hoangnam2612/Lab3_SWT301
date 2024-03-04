/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package multiply;

/**
 *
 * @author hoang
 */
public class Multiply {

    public static int multiply(int a, int b) {
        try {
            long result = (long) a * b;
            if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                throw new ArithmeticException("Integer overflow: Mutiply exceeds the range of int");
            }
            return (int) result;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid input: Not a valid integer");
        }
    }
}
