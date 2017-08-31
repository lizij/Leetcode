package Sum_of_Two_Integers;

public class Solution {
    public int getSum(int a, int b) {
        return (b == 0) ? a : getSum(a ^ b, (a & b) << 1);
    }

    public static void main(String[] args) {
    }
}
