import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    private final Map<Integer, String> keyPad = Map.of(
            2, "abc",
            3, "def",
            4, "ghi",
            5, "jkl",
            6, "mno",
            7, "pqrs",
            8, "tuv",
            9, "wxyz");

    public List<String> solve(String digits) {
        List<String> answer = new ArrayList<String>();
        if (!digits.isEmpty()) {
            dfs(digits, new StringBuilder(), 0, answer);
        }
        return answer;
    }

    private void dfs(String digits, StringBuilder current, int index, List<String> answer) {
        if (index == digits.length()) {
            answer.add(current.toString());
        } else {
            int key = Integer.parseInt(String.valueOf(digits.charAt(index)));
            for (int i = 0; i < keyPad.get(key).length(); i++) {
                current.append(keyPad.get(key).charAt(i));
                dfs(digits, current, index + 1, answer);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}
