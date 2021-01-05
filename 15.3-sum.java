import java.util.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode id=15 lang=java
 *
 * [15] 3Sum
 */

// @lc code=start
class Solution {
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
