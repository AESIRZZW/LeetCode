import java.util.Set;
import java.util.HashSet;

/*
 * @lc app=leetcode id=169 lang=java
 *
 * [169] Majority Element
 */

/*
 * My Approach: Optimized Brute Force
 * 
 * Complexity Analysis:
 * 
 * Time Complexity: O(n^2). In the worst case.
 * 
 * Space Complexity: O(1).
 */

// @lc code=start
class MySolution {
    public int majorityElement(int[] nums) {
        Set<Integer> checkedSet = new HashSet<>();
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (checkedSet.contains(nums[i]))
                continue;
            count = 1;
            checkedSet.add(nums[i]);
            // if nums.length = 1
            if (count >= nums.length / 2 + 1)
                return nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j])
                    count++;
                if (count >= nums.length / 2 + 1)
                    return nums[i];
            }
        }
        throw new IllegalArgumentException("No majority element");
    }
}
// @lc code=end
