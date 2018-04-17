package Fraction_Addition_and_Subtraction;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public String fractionAddition(String expression) {
        Fraction result = null;
        Pattern pattern = Pattern.compile("[-]*[0-9]+/[0-9]+");
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()){
            if (result == null) result = new Fraction(matcher.group(0));
            else result.add(new Fraction(matcher.group(0)));
        }
        return result == null ? "" : result.toString();
    }

    class Fraction{
        int numerator;
        int denominator;
        public Fraction(int numerator, int denominator){
            this.numerator = numerator;
            this.denominator = denominator;
        }

        public Fraction(String str){
            String[] nums = str.split("/");
            this.numerator = Integer.valueOf(nums[0]);
            this.denominator = Integer.valueOf(nums[1]);
        }

        private int hcf(int a, int b){
            if (a == 0 || b == 0) return 1;
            if (a < b){
                int c = a;
                a = b;
                b = c;
            }

            int r = a % b;
            while (r != 0){
                a = b;
                b = r;
                r = a % b;
            }
            return b;
        }

        public void add(Fraction f){
            int a = f.numerator;
            int b = f.denominator;
            int n = this.numerator * b + a * this.denominator;
            int d = this.denominator * b;
            int hcf = Math.abs(hcf(n, d));
            this.numerator = n / hcf;
            this.denominator = n != 0 ? d / hcf : 1;
        }

        @Override
        public String toString() {
            return numerator + "/" + denominator;
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
        System.out.println(s.fractionAddition("-1/2+1/2"));
        System.out.println(s.fractionAddition("-1/2+1/2+1/3"));
        System.out.println(s.fractionAddition("1/3-1/2"));
        System.out.println(s.fractionAddition("5/3+1/3"));
	}
}