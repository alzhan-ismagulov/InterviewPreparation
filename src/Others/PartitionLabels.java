/*
Partition Labels

A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each
letter appears in at most one part, and return a list of integers representing the size of these parts.

Example 1:

Input: S = "ababcbacadefegdehijhklij"
Output: [9,7,8]
Explanation:
The partition is "ababcbaca", "defegde", "hijhklij".
This is a partition so that each letter appears in at most one part.
A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.

Note:

    S will have length in range [1, 500].
    S will consist of lowercase letters ('a' to 'z') only.

   Hide Hint #1
Try to greedily choose the smallest partition that includes the first letter. If you have something like "abaccbdeffed",
then you might need to add b. You can use an map like "last['b'] = 5" to help you expand the width of your partition.
 */
package Others;

import java.util.ArrayList;
import java.util.List;

public class PartitionLabels {
    //Approach #1: Greedy [Accepted]
    class Solution {
        public List<Integer> partitionLabels(String S) {
            int[] last = new int[26];
            for (int i = 0; i < S.length(); ++i)
                last[S.charAt(i) - 'a'] = i;

            int j = 0, anchor = 0;
            List<Integer> ans = new ArrayList();
            for (int i = 0; i < S.length(); ++i) {
                j = Math.max(j, last[S.charAt(i) - 'a']);
                if (i == j) {
                    ans.add(i - anchor + 1);
                    anchor = i + 1;
                }
            }
            return ans;
        }
    }
}
