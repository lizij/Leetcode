package Pascals_Triangle_II;



import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> lastLine = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            lastLine.add(0, 1);
            for (int j = 1; j < lastLine.size() - 1; j++) {
                lastLine.set(j, lastLine.get(j) + lastLine.get(j + 1));
            }
        }
        return lastLine;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.getRow(3));
	}
}