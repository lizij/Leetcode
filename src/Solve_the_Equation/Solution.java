package Solve_the_Equation;



public class Solution {
    public String solveEquation(String equation) {
        /**
         * Format the equation by "ax+b=0", then get every a and b to calculate x value.
         * 9ms
         */
        String formula = getFormula(equation);
        return solve(formula);
    }

    private String getFormula(String equation) {
        String[] formula = equation.split("=");
        char[] rightPart = formula[1].toCharArray();
        for (int i = 0; i < rightPart.length; i++) {
            if (rightPart[i] == '+') rightPart[i] = '-';
            else if (rightPart[i] == '-') rightPart[i] = '+';
        }
        return rightPart[0] == '+' ? formula[0] + new String(rightPart) : formula[0] + '-' + new String(rightPart);
    }

    private String solve(String formula) {
        int x = 0, nums = 0;
        String[] vals = formula.split("(?=[-+])");//this means to match every "" before '-' or '+'. In other words, this will split the formula by '+' or '-'
        for (String val: vals) {
            if (val.contains("x")) {
                if (val.equals("x") || val.equals("+x")) x++;
                else if (val.equals("-x")) x--;
                else x += Integer.parseInt(val.substring(0, val.indexOf("x")));
            } else {
                nums += Integer.parseInt(val);
            }
        }
        if (x == 0 && nums == 0) return "Infinite solutions";
        if (x == 0) return "No solution";
        return "x=" + (-nums / x);
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//        System.out.println(s.solveEquation("x+5-3+x=6+x-2"));//x=2
//        System.out.println(s.solveEquation("x=x"));//Infinite solutions
//        System.out.println(s.solveEquation("2x=x"));//x=0
        System.out.println(s.solveEquation("2x+3x-6x=x+2"));//x=-1
//        System.out.println(s.solveEquation("x=x+2"));//No solution
//        System.out.println(s.solveEquation("-x=-1"));//x=1
	}
}