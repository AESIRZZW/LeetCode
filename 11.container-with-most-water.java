/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
/*
 * My Approach: Brute Force
 * 
 * Complexity Analysis:
 * 
 * Time complexity: O(n^2). Calculating area for all n(n-1)/2 height pairs.
 * 
 * Space complexity: O(1). Constant extra space is used.
 */
class MySolution {
    public int maxArea(int[] height) {
        int maxArea = 0, currentHeight = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = height.length - 1; j > i; j--) {
                currentHeight = height[i] >= height[j] ? height[j] : height[i];
                maxArea = currentHeight * (j - i) > maxArea ? currentHeight * (j - i) : maxArea;
            }
        }
        return maxArea;
    }
}
// @lc code=end

/*
 * Best Approach: Two Pointer Approach
 * 
 * Algorithm: https://leetcode.com/problems/container-with-most-water/solution/
 * 
 * Complexity Analysis:
 * 
 * Time complexity: O(n). Single pass.
 * 
 * Space complexity: O(1). Constant space is used.
 */

// @lc code=start
class BestSolution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1, maxArea = 0;
        while (l < r) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r])
                l++;
            else
                r--;
        }
        return maxArea;
    }
}
// @lc code=end