/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stringreverse;

/**
 *
 * @author hoang
 */
public class StringReverse {

    public static String reverseString(String input) {
        if (input == null) {
            return null;
        }

        char[] charArray = input.toCharArray();
        int start = 0;
        int end = charArray.length - 1;

        while (start < end) {
            // Swap characters at start and end indices
            char temp = charArray[start];
            charArray[start] = charArray[end];
            charArray[end] = temp;

            // Move indices towards each other
            start++;
            end--;
        }

        return new String(charArray);
    }
}
