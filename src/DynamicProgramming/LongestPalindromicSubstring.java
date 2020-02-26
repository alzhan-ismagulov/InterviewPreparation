/*
Longest Palindromic Substring

Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

Example 1:

Input: "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:

Input: "cbbd"
Output: "bb"

   Hide Hint #1
How can we reuse a previously computed palindrome to compute a larger palindrome?
   Hide Hint #2
If “aba” is a palindrome, is “xabax” and palindrome? Similarly is “xabay” a palindrome?
   Hide Hint #3
Complexity based hint:
If we use brute-force and check whether for every start and end position a substring is a palindrome we have O(n^2)
start - end pairs and O(n) palindromic checks. Can we reduce the time for palindromic checks to O(1) by reusing some
previous computation.
 */
package DynamicProgramming;

public class LongestPalindromicSubstring {
    //Approach 4: Expand Around Center
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }
}
