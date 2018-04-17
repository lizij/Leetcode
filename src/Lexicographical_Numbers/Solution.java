package Lexicographical_Numbers;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            dfs(i, n, res);
        }
        return res;
    }

    private void dfs(int cur, int n, List<Integer> res){
        if (cur > n) return;
        res.add(cur);
        for (int i = 0; i < 10; i++) {
            dfs(cur * 10 + i, n, res);
        }
    }

	public static void main(String[] args) {
        Solution s = new Solution();
        List<Integer> output1 = s.lexicalOrder(13);
        for (Integer i : output1) System.out.print(i + " ");
    }
}