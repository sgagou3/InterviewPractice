import java.util.ArrayList;
import java.util.List;

public class Subsets {
    public static List<List<Integer>> solve(int[] nums) {
        List<List<Integer>> answer = new ArrayList<List<Integer>>();
        dfs(nums, 0, new ArrayList<Integer>(), answer);
        return answer;
    }

    private static void dfs(int[] nums, int index, List<Integer> current, List<List<Integer>> answer) {
        answer.add(new ArrayList<Integer>(current));
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            dfs(nums, i + 1, current, answer);
            current.remove(current.size() - 1);
        }
    }
}
