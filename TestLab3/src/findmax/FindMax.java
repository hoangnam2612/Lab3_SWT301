/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package findmax;

/**
 *
 * @author hoang
 */
public class FindMax {

    public static int findMax(int a, int b, int c) {
        try {
            int max = a;

            if (b > max) {
                max = b;
            }

            if (c > max) {
                max = c;
            }

            return max;
        } catch (NumberFormatException e) {
            throw new NumberFormatException("Invalid input: Not a valid integer");
        }
    }
}
