package Beautiful_Arrangement;


import java.util.ArrayList;
import java.util.HashMap;

public class Solution {
    int count;
    public int countArrangement(int N) {
        HashMap<Integer, ArrayList<Integer>> divisible = new HashMap<>();
        count = 0;
        for (int i = 0; i < N; i++){
            ArrayList<Integer> tmp = new ArrayList<>();
            for (int j = 1; j <= N; j++) {
                if (j % (i + 1) == 0 || (i + 1) % j == 0) tmp.add(j);
            }
            divisible.put(i + 1, tmp);
        }
        boolean[] marked = new boolean[N + 1];
        count(marked, N, divisible);
        return count;
    }

    private void count(boolean[] marked, int pos, HashMap<Integer, ArrayList<Integer>> divisible){
        if (pos == 0){
            count++;
            return;
        }
        ArrayList<Integer> di = divisible.get(pos);
        for (Integer i: di){
            if (!marked[i]){
                marked[i] = true;
                count(marked, pos - 1, divisible);
                marked[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.countArrangement(3));
    }
}
