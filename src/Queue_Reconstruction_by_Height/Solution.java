package Queue_Reconstruction_by_Height;



import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int[][] reconstructQueue(int[][] people) {//(h, k)
        int N = people.length;
        int[][] aux = people.clone();
        Arrays.sort(aux, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o2[0] == o1[0]) return o1[1] - o2[1];
                else return o2[0] - o1[0];
            }
        });
        for (int i = 1; i < N; i++) {
            int h = aux[i][0], k = aux[i][1];
            for (int j = i; j > k; j--){
                aux[j] = aux[j - 1];
            }
            aux[k] = new int[]{h, k};
        }
        return aux;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] input = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}};
        int[][] output = s.reconstructQueue(input);
//        int[][] output = input;
        for (int i = 0; i < output.length; i++) {
            for (int j = 0; j < output[i].length; j++) {
                System.out.print(output[i][j] + " ");
            }
            System.out.println();
        }
    }
}
