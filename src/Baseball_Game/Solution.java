package Baseball_Game;



import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int calPoints(String[] ops) {
        List<Integer> scores = new ArrayList<>();
        for (String op: ops){
            if (op.matches("-*\\d+")){
                scores.add(Integer.parseInt(op));
            }
            else {
                int n = scores.size();
                if (op.equals("+")) {
                    scores.add(scores.get(n- 1) + scores.get(n - 2));
                }
                else if (op.equals("D")) {
                    scores.add(2 * scores.get(n - 1));
                }
                else if (op.equals("C")) {
                    scores.remove(n - 1);
                }
            }
        }
        int res = 0;
        for (int i: scores) res += i;
        return res;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.calPoints(new String[]{"5","2","C","D","+"}));
        System.out.println(s.calPoints(new String[]{"5","-2","4","C","D","9","+","+"}));
	}
}