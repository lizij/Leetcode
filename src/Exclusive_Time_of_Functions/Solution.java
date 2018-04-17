package Exclusive_Time_of_Functions;



import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Solution {
    public int[] exclusiveTime(int n, List<String> logs) {
        if (n == 0 || logs == null || logs.size() == 0) return new int[n];
        int[] res = new int[n];
        Stack<Func> stack = new Stack<>();
        for (String log: logs){
            String[] words = log.split(":");
            int id = Integer.parseInt(words[0]);
            String state = words[1];
            int timestamp = Integer.parseInt(words[2]);
            if (state.equals("start")){
                stack.push(new Func(id, timestamp));
            }
            else{
                int inter = 0;
                Func tmp = stack.pop();
                while (tmp.id == -1){
                    inter += tmp.timestamp;
                    tmp = stack.pop();
                }
                if (stack.size() > 0) stack.push(new Func(-1, timestamp - tmp.timestamp + 1));//prevent stack overflow
                res[id] += timestamp - tmp.timestamp + 1 - inter;
            }
        }
        return res;
    }

    private class Func{
        int id;
        int timestamp;
        Func(int id, int timestamp){
            this.id = id;
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            return "{" + id + "," + timestamp + '}';
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//		int[] output1 = s.exclusiveTime(2, Arrays.asList("0:start:0","1:start:2","1:end:5","0:end:6"));
//		int[] output1 = s.exclusiveTime(1, Arrays.asList("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7"));
		int[] output1 = s.exclusiveTime(1, Arrays.asList("0:start:0","0:start:1","0:start:2","0:end:3","0:end:4","0:end:5"));
        for (int i: output1) System.out.print(i + " ");
	}
}