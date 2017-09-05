package Minimum_Index_Sum_of_Two_Lists;

import edu.princeton.cs.algs4.StdOut;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    public String[] findRestaurant(String[] list1, String[] list2) {
        int minSum = Integer.MAX_VALUE;
        List<String> list = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list2.length; i++) {
            map.put(list2[i], i);
        }
        for (int i = 0; i < list1.length; i++) {
            if (map.get(list1[i]) != null){
                int j = map.get(list1[i]);
                if (i + j < minSum) {
                    minSum = i + j;
                    list.clear();
                    list.add(list1[i]);
                }
                else if (i + j == minSum){
                    list.add(list1[i]);
                }
            }
        }
        return list.toArray(new String[list.size()]);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        for (String str: s.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"})) StdOut.println(str);
        for (String str: s.findRestaurant(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"}, new String[]{"KFC", "Shogun", "Burger King"})) StdOut.println(str);
        for (String str: s.findRestaurant(new String[]{"Shogun","Tapioca Express","Burger King","KFC"}, new String[]{"KNN","KFC","Burger King","Tapioca Express","Shogun"})) StdOut.println(str);
	}
}