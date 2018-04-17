package Kth_Smallest_Element_in_a_Sorted_Matrix;



import java.util.*;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        /**
         * use list or array sort
         * 118ms
         */
//        List<Integer> list = new ArrayList<>();
//        for (int[] aMatrix : matrix) {
//            for (int j = 0; j < aMatrix.length; j++) {
//                list.add(aMatrix[j]);
//            }
//        }
//        list.sort(Comparator.comparingInt(i->i));
//        return list.get(k - 1);

        /**
         * use PriorityQueue built in Java
         * 42ms
         */
//        PriorityQueue<Integer> pq = new PriorityQueue<>();
//        for (int[] aMatrix : matrix) {
//            for (int anAMatrix : aMatrix) {
//                pq.offer(anAMatrix);
//            }
//        }
//        for (int i = 0; i < k - 1; i++) {
//            pq.poll();
//        }
//        return pq.poll();

        /**
         * use PriorityQueue
         * 48ms
         */
        int M = matrix.length, N = matrix[0].length;
        MinPQ<Integer> pq = new MinPQ<>(M * N);
        for (int[] aMatrix : matrix) {
            for (int anAMatrix : aMatrix) {
                pq.insert(anAMatrix);
            }
        }
        for (int i = 0; i < k - 1; i++) {
            pq.delMin();
        }
        return pq.delMin();
    }

    private class MinPQ<Key extends Comparable<Key>>{
        private Key[] pq;
        private int N = 0;

        public MinPQ(int capacity){ pq = (Key[]) new Comparable[capacity + 1]; }

        public int size(){ return this.N; }

        public boolean isEmpty(){return size() == 0;}

        public void insert(Key key){
            pq[++N] = key;
            swim(N);
        }

        public Key delMin(){
            Key min = pq[1];
            exch(1, N--);
            pq[N + 1] = null;
            sink(1);
            return min;
        }

        private boolean greater(int i, int j){
            return pq[i].compareTo(pq[j]) > 0;
        }

        private void exch(int i, int j){
            Key swap = pq[i];
            pq[i] = pq[j];
            pq[j] = swap;
        }

        private void swim(int k){
            while (k > 1 && greater(k / 2, k)){
                exch(k / 2, k);
                k = k / 2;
            }
        }

        private void sink(int k){
            while (2 * k <= N){
                int j = 2 * k;
                if (j < N && greater(j, j + 1)) j++;
                if (!greater(k, j)) break;
                exch(k, j);
                k = j;
            }
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		int[][] input = {
		        { 1,  5,  9},
                {10, 11, 13},
                {12, 14, 15}
        };
        System.out.println(s.kthSmallest(input, 8));
	}
}