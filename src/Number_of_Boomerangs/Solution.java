package Number_of_Boomerangs;



import java.util.HashMap;

public class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int N = points.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        int res = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                int dis = getDistance(points[i], points[j]);
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }

            for (int val: map.values()){
                res += val * (val - 1);
            }
            map.clear();
        }
        return res;
    }

    private int getDistance(int[] a, int[] b){
        return (a[0] - b[0]) * (a[0] - b[0]) + (a[1] - b[1]) * (a[1] - b[1]);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] input1 = {
                {2, 0},
                {0, 0},
                {1, 0}
        };
        System.out.println(s.numberOfBoomerangs(input1));
	}
}