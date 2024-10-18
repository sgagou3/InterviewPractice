import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {
    public static List<String> solveHardVersion(String s, List<String> wordDict) {
        List<String> answer = new ArrayList<String>();
        get(s, "", new HashSet<String>(wordDict), answer);
        return answer;
    }

    private static void get(String s, String current, Set<String> seen, List<String> answer) {
        if (seen.contains(s)) {
            answer.add(current + s);
        }
        for (int i = 0; i < s.length(); i++) {
            if (seen.contains(s.substring(0, i))) {
                get(s.substring(i), current + s.substring(0, i) + " ", seen, answer);
            }
        }
    }
}
