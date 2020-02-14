/*
* First Unique Character in a String
Given a string, find the first non-repeating character in it and
* return it's index. If it doesn't exist, return -1.
Examples:
s = "leetcode"
return 0.
s = "loveleetcode",
return 2.
Note: You may assume the string contain only lowercase letters.
* */
package ArraysAndString;

import java.util.HashMap;

public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        String s = "loveleetcode";
        System.out.println(firstUniqChar(s));//2
    }
    public static int firstUniqChar(String s) {
            HashMap<Character, Integer> count = new HashMap<Character, Integer>();
            int n = s.length();
            // build hash map : character and how often it appears
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                count.put(c, count.getOrDefault(c, 0) + 1);
            }

            // find the index
            for (int i = 0; i < n; i++) {
                if (count.get(s.charAt(i)) == 1)
                    return i;
            }
            return -1;
        }
}
