import java.util.HashMap;
import java.util.Map;

public class LongestSubarrayKFrequency {
    public static int solve(int[] nums, int k) {
        int answer = 0;
        int start = 0;
        Map<Integer, Integer> seen = new HashMap<Integer, Integer>();
        for (int end = 0; end < nums.length; end++) {
            seen.put(nums[end], seen.getOrDefault(nums[end], 0) + 1);
            while (start <= end && seen.get(nums[end]) > k) {
                seen.put(nums[start], seen.get(nums[start]) - 1);
                start++;
            }
            answer = Math.max(answer, end - start + 1);
        }
        return answer;
    }
}
