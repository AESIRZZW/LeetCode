/*
 * @lc app=leetcode id=167 lang=java
 *
 * [167] Two Sum II - Input array is sorted
 */

/*
 * My Approach 1: Brute Force
 * 
 * Complexity Analysis:
 * 
 * Time complexity: O(n^2). For each element, we try to find its complement by looping through 
 * the rest of array which takes O(n) time. Therefore, the time complexity is O(n^2).
 * 
 * Space complexity: O(1).
 */

// @lc code=start
class MySolution1 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > target)
                break;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target)
                    return new int[] { i + 1, j + 1 };
                if (numbers[i] + numbers[j] > target)
                    break;
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
// @lc code=end

/*
 * My Approach 2: Binary Search
 * 
 * Complexity Analysis:
 * 
 * Time complexity: O(nlogn). For each element, we try to find its complement by
 * binary search the rest of array which takes O(logn) time. Therefore, the time
 * complexity is O(nlogn)).
 * 
 * Space complexity: O(1).
 */

// @lc code=start
class MySolution2 {
    public int[] twoSum(int[] numbers, int target) {
        for (int i = 0; i < numbers.length; i++) {
            int j = binarySearch(numbers, i + 1, target - numbers[i]);
            if (j != -1)
                return new int[] { i + 1, j + 1 };
        }
        throw new IllegalArgumentException("No two sum solution");
    }

    private static int binarySearch(int[] numbers, int start, int target) {
        int left = start, right = numbers.length - 1, mid = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (numbers[mid] > target)
                right = mid - 1;
            else if (numbers[mid] < target)
                left = mid + 1;
            else
                break;
        }
        return mid;
    }
}
// @lc code=end

/*
 * Best Approach: Two Pointers
 * 
 * Complexity Analysis:
 * 
 * Time Complexity: O(n). Each of the n elements is visited at most once, thus
 * the time complexity is O(n).
 * 
 * Space Complexity: O(1). We only use two indexes, the space complexity is
 * O(1).
 */

// @lc code=start
class BestSolution {
    public int[] twoSum(int[] numbers, int target) {
        int low = 0, high = numbers.length - 1;
        while (low < high) {
            if (numbers[low] + numbers[high] == target)
                return new int[] { low + 1, high + 1 };
            else if (numbers[low] + numbers[high] > target)
                low++;
            else
                high--;
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
// @lc code=end