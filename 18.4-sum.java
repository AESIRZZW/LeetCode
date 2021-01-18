import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 * @lc app=leetcode id=18 lang=java
 *
 * [18] 4Sum
 */

/*
 * Best General Approach: Two Pointers
 * 
 * Algorithm: https://leetcode.com/problems/4sum/solution/
 * 
 * Complexity Analysis:
 * 
 * Time Complexity: O(n^(k−1)), or (n^3) for 4Sum. We have k-2 loops, and twoSum is O(n).
 * Note that for k>2, sorting the array does not change the overall time complexity.
 * 
 * Space Complexity: O(n). We need O(k) space for the recursion. k can be the same as nn in the worst case for the generalized algorithm.
 * Note that, for the purpose of complexity analysis, we ignore the memory required for the output.
 */

// @lc code=start
class Solution {
    public static List<List<Integer>> fourSum(int[] nums, int target) {
        // Any Two Pointers approach needs to ensure that the array is in order.
        Arrays.sort(nums);
        return kSum(nums, target, 0, 4);
    }

    // A general kSum recursive solution
    public static List<List<Integer>> kSum(int[] nums, int target, int start, int k) {
        List<List<Integer>> result = new ArrayList<>();
        // The number of remaining elements is less than k,
        // which will not be able to find the kSum solution.
        if (start + k > nums.length)
            return result;
        // Must be initialized to 0 instead of Integer.MIN_VAULE or Integer.MAX_VAULE.
        int minSum = 0, maxSum = 0;
        for (int i = 0; i < k; i++) {
            minSum += nums[i + start];
            maxSum += nums[nums.length - 1 - i];
        }
        // Check if the sum of k smallest values is greater than target,
        // or the sum of k largest values is smaller than target.
        // If so, no need to continue - there are no k elements that sum to target.
        if (minSum > target || maxSum < target)
            return result;
        // If k equals 2, call twoSum (which using Two Pointers Pattern) and then return
        // the result.
        if (k == 2)
            return twoSum(nums, target, start);
        // Iterate i through the array from start:
        for (int i = start; i < nums.length; i++) {
            // If the current value is the same as the one before, skip it.
            if (i == start || nums[i - 1] != nums[i]) {
                // Recursively call kSum with start = i + 1, k = k - 1, and target - nums[i].
                for (List<Integer> list : kSum(nums, target - nums[i], i + 1, k - 1)) {
                    // For each returned List<Integer> list of values:
                    // Include the current value nums[i] into the list.
                    // And add this list to the List<List<Integer>> result.
                    result.add(new ArrayList<>(Arrays.asList(nums[i])));
                    result.get(result.size() - 1).addAll(list);
                }
            }
        }
        // Return the result.
        return result;
    }

    public static List<List<Integer>> twoSum(int[] nums, int target, int start) {
        List<List<Integer>> result = new ArrayList<>();
        // Set the low pointer lo to start, and high pointer hi to the last index.
        int lo = start, hi = nums.length - 1;
        // While low pointer is smaller than high:
        while (lo < hi) {
            int sum = nums[lo] + nums[hi];
            // If the sum of nums[lo] and nums[hi] is less than target, increment lo.
            // Also increment lo if the value is the same as for lo - 1.
            if (sum < target || (lo > start && nums[lo] == nums[lo - 1]))
                lo++;
            // If the sum is greater than target, decrement hi.
            // Also decrement hi + 1 if the value is the same as for hi.
            else if (sum > target || (hi < nums.length - 1 && nums[hi + 1] == nums[hi]))
                hi--;
            // Otherwise, we found a pair:
            // Add it to the result.
            // Then decrement hi and increment lo. (Don't miss this step.)
            else
                result.add(Arrays.asList(nums[lo++], nums[hi--]));
        }
        // Return the result.
        return result;
    }
}
// @lc code=end
