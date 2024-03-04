/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package palindromechecker;

/**
 *
 * @author hoang
 */
public class PalindromeChecker {

    public static boolean checkPalindrome(String input) {
        if (input == null) {
            throw new IllegalArgumentException("Input must not be null");
        }

        String cleanedInput = input.replaceAll("\\s", "").toLowerCase();
        int length = cleanedInput.length();

        for (int i = 0; i < length / 2; i++) {
            if (cleanedInput.charAt(i) != cleanedInput.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        PalindromeChecker.checkPalindrome("level"); // In ra: true
        PalindromeChecker.checkPalindrome("hello"); // In ra: false
        PalindromeChecker.checkPalindrome(null);
        PalindromeChecker.checkPalindrome("");

    }
}
