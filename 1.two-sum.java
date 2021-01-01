/*
 * @lc app=leetcode id=1 lang=java
 *
 * [1] Two Sum
 */

/*
 * My Approach: Brute Force
 * 
 * Complexity Analysis
 * 
 * Time complexity : O(n^2). For each element, we try to find its complement by looping through 
 * the rest of array which takes O(n) time. Therefore, the time complexity is O(n^2).
 * 
 * Space complexity : O(1).
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        outer: for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] == complement) {
                    index[0] = i;
                    index[1] = j;
                    break outer;
                }
            }
        }
        return index;
    }
}
// @lc code=end

/*
 * Best Approach: One-pass Hash Table
 * 
 * Complexity Analysis:
 * 
 * Time complexity : O(n). We traverse the list containing n elements only once.
 * Each look up in the table costs only O(1) time.
 * 
 * Space complexity : O(n). The extra space required depends on the number of
 * items stored in the hash table, which stores at most nn elements.
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
// @lc code=end
