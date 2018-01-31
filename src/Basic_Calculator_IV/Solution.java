package Basic_Calculator_IV;

import java.util.*;

public class Solution {
    public List<String> basicCalculatorIV(String expression, String[] evalvars, int[] evalints) {
        if (expression == null || expression.length() == 0 || evalvars == null || evalints == null || evalvars.length != evalints.length) {
            return null;
        }

        /**
         * Polynomial solution: copied from Solution part, straight forward but very long
         * 130ms
         */

        Map<String, Integer> vars = new HashMap<>();
        for (int i = 0; i < evalvars.length; i++) {
            vars.put(evalvars[i], evalints[i]);
        }
        return parse(expression).evaluate(vars).toList();
    }

    private Poly make(String expr) {
        Poly res = new Poly();
        List<String> list = new ArrayList<>();
        if (Character.isDigit(expr.charAt(0))) {
            res.update(list, Integer.valueOf(expr));
        } else {
            list.add(expr);
            res.update(list, 1);
        }
        return res;
    }

    private Poly combine(Poly left, Poly right, char symbol) {
        if (symbol == '+') return left.add(right);
        if (symbol == '-') return left.sub(right);
        if (symbol == '*') return left.mul(right);
        throw null;
    }

    private Poly parse(String expr) {
        List<Poly> polies = new ArrayList<>();
        List<Character> symbols = new ArrayList<>();
        int i = 0;
        while (i < expr.length()) {
            if (expr.charAt(i) == '(') {
                // find poly with "(" and ")"
                int bal = 0, j = i;
                for (; j < expr.length(); ++j) {
                    if (expr.charAt(j) == '(') bal++;
                    if (expr.charAt(j) == ')') bal--;
                    if (bal == 0) break;
                }
                polies.add(parse(expr.substring(i+1, j)));
                i = j;
            } else if (Character.isLetterOrDigit(expr.charAt(i))) {
                // find poly without "(" or ")"
                int j = i;
                search : {
                    for (; j < expr.length(); ++j)
                        if (expr.charAt(j) == ' ') {
                            polies.add(make(expr.substring(i, j)));
                            break search;
                        }
                    polies.add(make(expr.substring(i)));
                }
                i = j;
            } else if (expr.charAt(i) != ' ') {
                // symbol
                symbols.add(expr.charAt(i));
            }
            i++;
        }

        for (int j = symbols.size() - 1; j >= 0; --j) {
            if (symbols.get(j) == '*') {
                polies.set(j, combine(polies.get(j), polies.remove(j + 1), symbols.remove(j)));
            }
        }

        if (polies.isEmpty()) return new Poly();
        Poly res = polies.get(0);
        for (int j = 0; j < symbols.size(); ++j)
            res = combine(res, polies.get(j+1), symbols.get(j));

        return res;
    }

    class Poly {
        Map<List<String>, Integer> count;
        Poly() {
            count = new HashMap<>();
        }

        void update(List<String> key, int val) {
            // (k, v) -> (k, v + val)
            count.put(key, count.getOrDefault(key, 0) + val);
        }

        Poly add(Poly that) {
            // (k, v1) + (k, v2) -> (k, v1 + v2)
            Poly res = new Poly();
            for (List<String> k: this.count.keySet()) {
                res.update(k, this.count.get(k));
            }
            for (List<String> k: that.count.keySet()) {
                res.update(k, that.count.get(k));
            }
            return res;
        }

        Poly sub(Poly that) {
            // (k, v1) - (k, v2) -> (k, v1 - v2)
            Poly res = new Poly();
            for (List<String> k: this.count.keySet()) {
                res.update(k, this.count.get(k));
            }
            for (List<String> k: that.count.keySet()) {
                res.update(k, -that.count.get(k));
            }
            return res;
        }

        Poly mul(Poly that) {
            // (k1, v1) * (k2, v2) -> (k1 | k2, v1 * v2)
            Poly ans = new Poly();
            for (List<String> k1: this.count.keySet())
                for (List<String> k2: that.count.keySet()) {
                    List<String> kNew = new ArrayList<>();
                    kNew.addAll(k1);
                    kNew.addAll(k2);
                    kNew.sort((o1, o2) -> o1.compareTo(o2));
                    ans.update(kNew, this.count.get(k1) * that.count.get(k2));
                }
            return ans;
        }

        Poly evaluate(Map<String, Integer> evalMap) {

            Poly res = new Poly();
            for (List<String> k: this.count.keySet()) {
                int count = this.count.get(k);
                List<String> free = new ArrayList<>();
                for (String token: k) {
                    if (evalMap.containsKey(token))
                        count *= evalMap.get(token);
                    else
                        free.add(token);
                }
                res.update(free, count);
            }
            return res;
        }

        int compareList(List<String> A, List<String> B) {
            int i = 0, j = 0;
            while (i < A.size() && j < B.size()) {
                int cmp = A.get(i).compareTo(B.get(j));
                if (cmp != 0) {
                    return cmp;
                }
                i++;
                j++;
            }
            return 0;
        }

        List<String> toList() {
            List<String> res = new ArrayList<>();
            List<List<String>> keys = new ArrayList<>(this.count.keySet());
            keys.sort((a, b) ->
                    a.size() != b.size() ? b.size() - a.size() : compareList(a, b));

            for (List<String> key: keys) {
                int v = this.count.get(key);
                if (v == 0) continue;
                StringBuilder word = new StringBuilder();
                word.append("").append(v);
                for (String token: key) {
                    word.append('*').append(token);
                }
                res.add(word.toString());
            }
            return res;
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.basicCalculatorIV("e + 8 - a + 5", new String[]{"e"}, new int[]{1})); // ["-1*a","14"]
		System.out.println(s.basicCalculatorIV("e - 8 + temperature - pressure", new String[]{"e", "temperature"}, new int[]{1, 12})); // ["-1*pressure","5"]
		System.out.println(s.basicCalculatorIV("(e + 8) * (e - 8)", new String[]{}, new int[]{})); // ["1*e*e","-64"]
		System.out.println(s.basicCalculatorIV("7 - 7", new String[]{}, new int[]{})); // []
		System.out.println(s.basicCalculatorIV("a * b * c + b * a * c * 4", new String[]{}, new int[]{})); // ["5*a*b*c"]
		System.out.println(s.basicCalculatorIV("((a - b) * (b - c) + (c - a)) * ((a - b) + (b - c) * (c - a))", new String[]{}, new int[]{})); // ["-1*a*a*b*b","2*a*a*b*c","-1*a*a*c*c","1*a*b*b*b","-1*a*b*b*c","-1*a*b*c*c","1*a*c*c*c","-1*b*b*b*c","2*b*b*c*c","-1*b*c*c*c","2*a*a*b","-2*a*a*c","-2*a*b*b","2*a*c*c","1*b*b*b","-1*b*b*c","1*b*c*c","-1*c*c*c","-1*a*a","1*a*b","1*a*c","-1*b*c"]
	}
}