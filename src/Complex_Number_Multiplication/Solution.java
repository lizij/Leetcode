package Complex_Number_Multiplication;



import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public String complexNumberMultiply(String a, String b){
        Pattern p = Pattern.compile("([^\\+]*)\\+([^\\+]*)i");
        Matcher ma = p.matcher(a);
        Matcher mb = p.matcher(b);
        int a1, a2, b1, b2;
        if (ma.matches() && mb.matches()){
            a1 = Integer.parseInt(ma.group(1));
            a2 = Integer.parseInt(ma.group(2));
            b1 = Integer.parseInt(mb.group(1));
            b2 = Integer.parseInt(mb.group(2));
            return a1 * b1 - a2 * b2 + "+" + (a1 * b2 + a2 * b1) + "i";
        }
        return null;
    }

    public static void main(String[] args) {
        String a = "1+1i";
        String b = "1+-1i";

        Solution s = new Solution();
        System.out.println(s.complexNumberMultiply(a, a));
        System.out.println(s.complexNumberMultiply(b, b));
    }
}
