public class FirstMissingPositive {
    public static int solve(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            while (0 < nums[i] && nums[i] <= nums.length && nums[nums[i] - 1] != nums[i] && nums[i] != i + 1) {
                int t = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = t;
            }
            i++;
        }
        i = 0;
        for (; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }
}
