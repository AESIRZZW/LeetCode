/*
 * @lc app=leetcode id=34 lang=java
 *
 * [34] Find First and Last Position of Element in Sorted Array
 */

// @lc code=start

/*
 * My Approach: Optimize Linear Scan
 * 
 * Complexity Analysis:
 * 
 * Time Complexity: O(n). This brute-force approach examines each of the n elements, so the overall runtime is linear.
 * 
 * Space Complexity: O(1). The linear scan method allocates a fixed-size array, so it has a constant-size memory footprint.
 * 
 * Advantages: Calculate all positions in one scan, and save additional integers storage space.
 */

class MySolution {
    public int[] searchRange(int[] nums, int target) {
        int[] range = new int[] { -1, -1 };
        for (int i = 0; i < nums.length; i++) {
            if (range[0] == -1 && nums[i] == target)
                range[0] = i;
            if (range[1] == -1 && nums[nums.length - 1 - i] == target)
                range[1] = nums.length - 1 - i;
        }
        return range;
    }
}
// @lc code=end
