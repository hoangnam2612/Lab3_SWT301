/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package divide;

/**
 *
 * @author hoang
 */
public class Divide {

    public static int divide(int a, int b) {
        if (b == 0) {
            throw new ArithmeticException("Cannot divide by zero");
        } else {
            try {
                long result = (long) a / b;
                if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
                    throw new ArithmeticException("Integer overflow: Divide exceeds the range of int");
                }
                return (int) result;
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Invalid input: Not a valid integer");
            }
        }
    }
}
