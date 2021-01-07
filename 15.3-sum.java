import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

/*
 * My Approach: Brute Force (Time Limit Exceeded)
 * 
 * Complexity Analysis:
 * 
 * Time Complexity: O(n^4).
 * 
 * Space Complexity: O(n).
 */

// @lc code=start
class MySolution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> triplets = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                thirdLevel: for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        List<Integer> triplet = new ArrayList<>();
                        triplet.add(nums[i]);
                        triplet.add(nums[j]);
                        triplet.add(nums[k]);
                        for (List<Integer> list : triplets) {
                            List<Integer> tempList = new ArrayList<>(list);
                            if (tempList.contains(nums[i])) {
                                tempList.remove(tempList.indexOf(nums[i]));
                                if (tempList.contains(nums[j])) {
                                    tempList.remove(tempList.indexOf(nums[j]));
                                    if (tempList.contains(nums[k])) {
                                        break thirdLevel;
                                    }
                                }
                            }
                        }
                        triplets.add(triplet);
                    }
                }
            }
        }
        return triplets;
    }
}
// @lc code=end

/*
 * Best Approach1: Two Pointers
 * 
 * Complexity Analysis:
 * 
 * Time Complexity: O(n^2). Two Pointers pattern is O(n), and we call it n
 * times. Sorting the array takes O(nlog⁡n), so overall complexity is
 * O(nlog⁡n+n2). This is asymptotically equivalent to O(n2).
 * 
 * Space Complexity: From O(log⁡n) to O(n), depending on the implementation of
 * the sorting algorithm. For the purpose of complexity analysis, we ignore the
 * memory required for the output.
 */

// @lc code=start
class BestSolution1 {
    public List<List<Integer>> threeSum(int[] nums) {
        // Two Pointers pattern requires the array to be sorted.
        Arrays.sort(nums);
        List<List<Integer>> triplets = new ArrayList<>();
        // If the current value is greater than zero, break from the loop. Remaining
        // values cannot sum to zero.
        for (int i = 0; i < nums.length || nums[i] <= 0; i++) {
            // If the current value is the same as the one before, skip it.
            if (i == 0 || nums[i - 1] != nums[i]) {
                // Otherwise, call twoSumII for the current position i.
                twoSumII(nums, i, triplets);
            }
        }
        return triplets;
    }

    private void twoSumII(int[] nums, int i, List<List<Integer>> triplets) {
        // Set the low pointer lo to i + 1, and high pointer hi to the last index.
        int lo = i + 1, hi = nums.length - 1;
        // While low pointer is smaller than high:
        while (lo < hi) {
            int sum = nums[i] + nums[lo] + nums[hi];
            // If sum of nums[i] + nums[lo] + nums[hi] is less than zero, increment lo.
            if (sum < 0)
                lo++;
            // If sum is greater than zero, decrement hi.
            else if (sum > 0)
                hi--;
            else {
                triplets.add(Arrays.asList(nums[i], nums[lo++], nums[hi--]));
                // Increment lo while the next value is the same as before to avoid duplicates
                // in the result.
                while (lo < hi && nums[lo] == nums[lo - 1])
                    lo++;
            }
        }
    }
}
// @lc code=end