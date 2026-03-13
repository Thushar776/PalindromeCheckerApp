// File: PalindromeApp.java
// Compile: javac PalindromeApp.java
// Run: java PalindromeApp

import java.util.*;

public class PalindromeApp {

    // UC1: Application Entry & Welcome Message
    public static void main(String[] args) {
        System.out.println("======================================");
        System.out.println("Palindrome Checker App");
        System.out.println("Version: 1.0");
        System.out.println("======================================");
        System.out.println("This app validates whether a given string is a palindrome under different conditions.");
        System.out.println();

        // UC2: Hardcoded Palindrome Result
        String hardcoded = "madam";
        System.out.println("UC2: Hardcoded check for \"" + hardcoded + "\"");
        if (isPalindromeHardcoded(hardcoded)) {
            System.out.println("Result: \"" + hardcoded + "\" is a palindrome.");
        } else {
            System.out.println("Result: \"" + hardcoded + "\" is NOT a palindrome.");
        }
        System.out.println();

        // UC3: Palindrome Check Using String Reverse
        String test1 = "racecar";
        System.out.println("UC3: Reverse string check for \"" + test1 + "\"");
        System.out.println(isPalindromeByReverse(test1) ? "Palindrome" : "Not Palindrome");
        System.out.println();

        // UC4: Character Array Based Palindrome Check
        String test2 = "level";
        System.out.println("UC4: Char array two-pointer check for \"" + test2 + "\"");
        System.out.println(isPalindromeCharArray(test2) ? "Palindrome" : "Not Palindrome");
        System.out.println();

        // UC5: Stack-Based Palindrome Checker
        String test3 = "noon";
        System.out.println("UC5: Stack-based check for \"" + test3 + "\"");
        System.out.println(isPalindromeStack(test3) ? "Palindrome" : "Not Palindrome");
        System.out.println();

        // UC6: Queue + Stack Based Palindrome Check
        String test4 = "radar";
        System.out.println("UC6: Queue + Stack check for \"" + test4 + "\"");
        System.out.println(isPalindromeQueueStack(test4) ? "Palindrome" : "Not Palindrome");
        System.out.println();

        // UC7: Deque-Based Optimized Palindrome Checker
        String test5 = "civic";
        System.out.println("UC7: Deque-based optimized check for \"" + test5 + "\"");
        System.out.println(isPalindromeDeque(test5) ? "Palindrome" : "Not Palindrome");
        System.out.println();

        System.out.println("=== End of Demonstration ===");
    }

    // UC2: Hardcoded check
    public static boolean isPalindromeHardcoded(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }

    // UC3: Reverse string manually
    public static boolean isPalindromeByReverse(String str) {
        String reversed = "";
        for (int i = str.length() - 1; i >= 0; i--) {
            reversed += str.charAt(i);
        }
        return str.equals(reversed);
    }

    // UC4: Char array two-pointer
    public static boolean isPalindromeCharArray(String str) {
        char[] arr = str.toCharArray();
        int left = 0, right = arr.length - 1;
        while (left < right) {
            if (arr[left] != arr[right]) return false;
            left++;
            right--;
        }
        return true;
    }

    // UC5: Stack-based
    public static boolean isPalindromeStack(String str) {
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            stack.push(c);
        }
        String reversed = "";
        while (!stack.isEmpty()) {
            reversed += stack.pop();
        }
        return str.equals(reversed);
    }

    // UC6: Queue + Stack
    public static boolean isPalindromeQueueStack(String str) {
        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            queue.add(c);
            stack.push(c);
        }
        while (!queue.isEmpty()) {
            if (queue.remove() != stack.pop()) return false;
        }
        return true;
    }

    // UC7: Deque-based optimized
    public static boolean isPalindromeDeque(String str) {
        Deque<Character> deque = new LinkedList<>();
        for (char c : str.toCharArray()) {
            deque.addLast(c);
        }
        while (deque.size() > 1) {
            if (deque.removeFirst() != deque.removeLast()) return false;
        }
        return true;
    }
}
