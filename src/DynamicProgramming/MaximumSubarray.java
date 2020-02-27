/*
Maximum Subarray

Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

Example:

Input: [-2,1,-3,4,-1,2,1,-5,4],
Output: 6
Explanation: [4,-1,2,1] has the largest sum = 6.

Follow up:

If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.

 */
package DynamicProgramming;

public class MaximumSubarray {
    //Approach 1: Divide and Conquer
    public int crossSum(int[] nums, int left, int right, int p) {
        if (left == right) return nums[left];

        int leftSubsum = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i = p; i > left - 1; --i) {
            currSum += nums[i];
            leftSubsum = Math.max(leftSubsum, currSum);
        }

        int rightSubsum = Integer.MIN_VALUE;
        currSum = 0;
        for(int i = p + 1; i < right + 1; ++i) {
            currSum += nums[i];
            rightSubsum = Math.max(rightSubsum, currSum);
        }

        return leftSubsum + rightSubsum;
    }

    public int helper(int[] nums, int left, int right) {
        if (left == right) return nums[left];

        int p = (left + right) / 2;

        int leftSum = helper(nums, left, p);
        int rightSum = helper(nums, p + 1, right);
        int crossSum = crossSum(nums, left, right, p);

        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }

    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }
    //Approach 2: Greedy
    class Solution2 {
        public int maxSubArray(int[] nums) {
            int n = nums.length;
            int currSum = nums[0], maxSum = nums[0];

            for(int i = 1; i < n; ++i) {
                currSum = Math.max(nums[i], currSum + nums[i]);
                maxSum = Math.max(maxSum, currSum);
            }
            return maxSum;
        }
    }
    //Approach 3: Dynamic Programming (Kadane's algorithm)
    class Solution3 {
        public int maxSubArray(int[] nums) {
            int n = nums.length, maxSum = nums[0];
            for(int i = 1; i < n; ++i) {
                if (nums[i - 1] > 0) nums[i] += nums[i - 1];
                maxSum = Math.max(nums[i], maxSum);
            }
            return maxSum;
        }
    }
}
