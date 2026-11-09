class Solution {
    public int firstMissingPositive(int[] nums) {

        int i = 0;

        // Place each positive number at its correct index
        while (i < nums.length) {

            int correct = nums[i] - 1;

            if (nums[i] > 0 &&
                nums[i] <= nums.length &&
                nums[i] != nums[correct]) {

                int temp = nums[i];
                nums[i] = nums[correct];
                nums[correct] = temp;

            } else {
                i++;
            }
        }

        // Find the first incorrect position
        for (int j = 0; j < nums.length; j++) {

            if (nums[j] != j + 1) {
                return j + 1;
            }
        }

        return nums.length + 1;
    }
}
