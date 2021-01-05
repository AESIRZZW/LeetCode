/*
 * @lc app=leetcode id=66 lang=java
 *
 * [66] Plus One
 */

/*
 * Best Approach: Schoolbook Addition with Carry
 * 
 * Algorithm: 
 * 
 * 1、Move along the input array starting from the end of array.
 * 
 * 2、Set all the nines at the end of array to zero.
 * 
 * 3、If we meet a not-nine digit, we would increase it by one. The job is done - return digits.
 * 
 * 4、We're here because all the digits were equal to nine. Now they have all been set to zero. We then append the digit 1 in front of the other digits and return the result.
 * 
 * Complexity Analysis:
 * 
 * Time complexity: O(n). Since it's not more than one pass along the input list.
 * 
 * Space complexity: O(n). Although we perform the operation in-place (i.e. on the input list itself), 
 * in the worst scenario, we would need to allocate an intermediate space to hold the result, 
 * which contains the N+1 elements. Hence the overall space complexity of the algorithm is O(N).
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        // move along the input array starting from the end
        for (int i = digits.length - 1; i >= 0; i--) {
            // set all the nines at the end of array to zeros
            if (digits[i] == 9) {
                digits[i] = 0;
            }
            // here we have the rightmost not-nine
            else {
                // increase this rightmost not-nine by 1
                digits[i] += 1;
                // and the job is done
                return digits;
            }
        }
        // we're here because all the digits are nines
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
// @lc code=end
