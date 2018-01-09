package Parse_Lisp_Expression;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int evaluate(String expression) {
        if (expression == null || expression.length() == 0) {
            return 0;
        }

        /**
         * Use recursion to divide expression into subexpressions, then evaluate each of them
         * 35ms
         */

        Map<String, Integer> vars = new HashMap<>();
        return evaluate(expression, vars);
    }

    public int evaluate(String expression, Map<String, Integer> vars) {
        if (expression == null || expression.length() == 0) {
            return 0;
        }
        vars = new HashMap<>(vars); // clone vars and not to affect outside vars

        // () expression
        if (expression.startsWith("(")) {
            List<String> elements = split(expression);
            String op = elements.get(0);
            if (op.equals("add")) {
                // add expressions
                return evaluate(elements.get(1), vars) + evaluate(elements.get(2), vars);
            } else if (op.equals("mult")) {
                // multiply expressions
                return evaluate(elements.get(1), vars) * evaluate(elements.get(2), vars);
            } else if (op.equals("let")) {
                // assign variables with values
                for (int i = 1; i < elements.size() - 1; i += 2) {
                    String var = elements.get(i);
                    int value = evaluate(elements.get(i + 1), vars);
                    vars.put(var, value);
                }
                // evaluate the last expression
                return evaluate(elements.get(elements.size() - 1), vars);
            }
        } else {

            if (vars.containsKey(expression)) { // variables
                return vars.get(expression);
            } else { // pure number
                return Integer.valueOf(expression);
            }
        }
        return 0;
    }

    private List<String> split(String expression) {
        // split expression into operation symbol, variables, numbers and subexpressions
        List<String> elements = new ArrayList<>();
        StringBuilder builder = new StringBuilder();
        int parenthesis = 0;
        char[] chs = expression.toCharArray();
        for (int i = 1; i < chs.length - 1; i++) {
            if (chs[i] == '(') {
                parenthesis++;
            } else if (chs[i] == ')') {
                parenthesis--;
            } else if (chs[i] == ' ' && parenthesis == 0) {
                elements.add(builder.toString());
                builder.setLength(0);
                continue;
            }
            builder.append(chs[i]);
        }
        elements.add(builder.toString());
        return elements;
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.evaluate("(add 1 2)")); // 3
		System.out.println(s.evaluate("(mult 3 (add 2 3))")); // 15
		System.out.println(s.evaluate("(let x 2 (mult x 5))")); // 10
		System.out.println(s.evaluate("(let x 2 (mult x (let x 3 y 4 (add x y))))")); // 14
		System.out.println(s.evaluate("(let x 3 x 2 x)")); // 2
		System.out.println(s.evaluate("(let x 1 y 2 x (add x y) (add x y))")); // 5
		System.out.println(s.evaluate("(let x 2 (add (let x 3 (let x 4 x)) x))")); // 6
		System.out.println(s.evaluate("(let a1 3 b2 (add a1 1) b2)")); // 4

	}
}