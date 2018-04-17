package Shopping_Offers;



import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    int N;
    List<Integer> price;
    List<List<Integer>> special;
    List<Integer> needs;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.price = price;
        this.special = special;
        this.needs = needs;
        N = price.size();
        int[] need = needs.stream().mapToInt(Integer::intValue).toArray();
        PriorityQueue<Integer> res = new PriorityQueue<>();
        dfs(need, 0, res);
        return res.peek();
    }

    private void dfs(int[] need, int cost,  PriorityQueue<Integer> res){
//        boolean notUseSpecial = true;
        for (int i = 0; i < special.size(); i++) {
            List<Integer> tmpSpecial = special.get(i);
            if (isSpecialAvailable(need, tmpSpecial)){
//                notUseSpecial = false;
                useSpecial(need, tmpSpecial);
                dfs(need, cost + tmpSpecial.get(N), res);
                reset(need, tmpSpecial);
            }
        }
//        if (notUseSpecial){
            for (int i = 0; i < N; i++) {
                cost += need[i] * price.get(i);
            }
            res.add(cost);
//        }
    }

    private boolean isSpecialAvailable(int[] need, List<Integer> special){
        for (int i = 0; i < N; i++) {
            if (need[i] < special.get(i)) return false;
        }
        return true;
    }

    private int[] useSpecial(int[] need, List<Integer> special){
        for (int i = 0; i < N; i++) {
            need[i] -= special.get(i);
        }
        return need;
    }

    private int[] reset(int[] need, List<Integer> special){
        for (int i = 0; i < N; i++) {
            need[i] += special.get(i);
        }
        return need;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.shoppingOffers(Arrays.asList(2, 5), Arrays.asList(Arrays.asList(3, 0, 5), Arrays.asList(1, 2, 10)), Arrays.asList(3, 2)));
        System.out.println(s.shoppingOffers(Arrays.asList(2, 3, 4), Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9)), Arrays.asList(1, 2, 1)));
        System.out.println(s.shoppingOffers(Arrays.asList(0, 0, 0), Arrays.asList(Arrays.asList(1, 1, 0, 4), Arrays.asList(2, 2, 1, 9)), Arrays.asList(1, 1, 1)));
	}
}