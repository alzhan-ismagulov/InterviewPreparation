/*
* Missing Number
Given an array containing n distinct numbers taken from 0, 1, 2, ..., n,
* find the one that is missing from the array.
Example 1:
Input: [3,0,1]
Output: 2
Example 2:
Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity.
* Could you implement it using only constant extra space complexity?
* */
package ArraysAndString;

import java.util.HashSet;
import java.util.Set;

public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {9,6,4,2,3,5,7,0,1};
        System.out.println(missingNumber(nums));//8
    }
        public static int missingNumber(int[] nums) {
            Set<Integer> numSet = new HashSet<Integer>();
            for (int num : nums) numSet.add(num);

            int expectedNumCount = nums.length + 1;
            for (int number = 0; number < expectedNumCount; number++) {
                if (!numSet.contains(number)) {
                    return number;
                }
            }
            return -1;
        }
}
