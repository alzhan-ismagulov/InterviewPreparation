/*
* Valid Parentheses
Given a string containing just the characters '(', ')', '{', '}', '[' and ']',
* determine if the input string is valid.
An input string is valid if:
    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
Note that an empty string is also considered valid.
Example 1:
Input: "()"
Output: true
Example 2:
Input: "()[]{}"
Output: true
Example 3:
Input: "(]"
Output: false
Example 4:
Input: "([)]"
Output: false
Example 5:
Input: "{[]}"
Output: true
* */
package ArraysAndString;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "()";
        System.out.println(ValidParentheses(s));//true
    }
    public static boolean ValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return false;
        }
        Stack<Character> stack = new Stack<Character>();
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == '(' || arr[i] == '[' || arr[i] == '{') {
                stack.push(arr[i]);
            } else if (arr[i] == ')' || arr[i] == ']' || arr[i] == '}') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char c = stack.pop();
                    if ((c == '(' && arr[i] == ')') ||
                            (c == '[' && arr[i] == ']') ||
                            (c == '{' && arr[i] == '}')) {
                        continue;
                    }
                    return false;
                }
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
