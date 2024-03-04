/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package factorial;

/**
 *
 * @author hoang
 */
public class Factorial {

    public static long getFactorial(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("Invalid argument. N must be between 0...20");
        }

        if (n == 0 || n == 1) {
            return 1; //ket thuc cuoc choi som neu nhan nhung dau vao dac biet
        }

        long product = 1; //tich nha don, thuan toan con heo dat
        for (int i = 2; i <= n; i++) {
            product *= i;
        }
        return product;
    }
}
