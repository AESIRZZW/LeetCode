import java.util.Arrays;

/*
 * @lc app=leetcode id=16 lang=java
 *
 * [16] 3Sum Closest
 */

/*
 * My Approach: Two Pointers
 * 
 * Algorithm: https://leetcode.com/problems/3sum-closest/solution/
 * 
 * Complexity Analysis:
 * 
 * Time complexity: O(n^2). We have outer and inner loops, each going through n elements.
 * Sorting the array takes O(nlogn), so overall complexity is (nlog{n} + n^2). 
 * This is asymptotically equivalent to O(n^2).
 * 
 * Space complexity: from O(logn) to O(n), depending on the implementation of the sorting algorithm.
 */

// @lc code=start
class MySolution {
    public int threeSumClosest(int[] nums, int target) {
        int diff = Integer.MAX_VALUE;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length && diff != 0; i++) {
            int lo = i + 1, hi = nums.length - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(target - sum) < Math.abs(diff))
                    diff = target - sum;
                if (sum < target)
                    lo++;
                else
                    hi--;
            }
        }
        return target - diff;
    }
}
// @lc code=end