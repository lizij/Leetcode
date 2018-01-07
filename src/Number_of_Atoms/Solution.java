package Number_of_Atoms;

import java.util.Map;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public String countOfAtoms(String formula) {
        /**
         * Get atoms' number in the formula. Use recursion to deal with subformula and regular expression to count atoms' number
         * Then concatenate the result as a string
         * 31ms
         */
        Map<String, Integer> countOfAtoms = count(formula);
        StringBuilder builder = new StringBuilder();
        for (Map.Entry<String, Integer> entry: countOfAtoms.entrySet()) {
            builder.append(entry.getKey());
            if (entry.getValue() > 1) {
                builder.append(entry.getValue());
            }
        }

        return builder.toString();
    }

    private Map<String, Integer> count(String formula) {
        if (formula == null || formula.length() == 0) {
            // invalid formula
            return null;
        }
        // get index of '('
        int left = formula.indexOf('(');
        Map<String, Integer> res = new TreeMap<>();
        if (left == -1) {
            // no subformula
            Pattern p = Pattern.compile("([A-Z][a-z]*)([0-9]*)");
            Matcher m = p.matcher(formula);
            while (m.find()) {
                String atom = m.group(1);
                Integer number = m.group(2).equals("") ? 1 : Integer.valueOf(m.group(2));
                res.put(atom, res.getOrDefault(atom, 0) + number);
            }
        } else {
            // have subformula
            // get right index of ')'
            int right = findRightParenthesisIndex(formula, left);
            // get result of subformula
            Map<String, Integer> midRes = count(formula.substring(left + 1, right));
            // get coefficient of subformula
            int coefficient = 0;
            for (int i = right + 1; i < formula.length(); i++) {
                if (Character.isDigit(formula.charAt(i))) {
                    coefficient = coefficient * 10 + formula.charAt(i) - '0';
                    if (i == formula.length() - 1) {
                        right = i;
                    }
                } else {
                    // get start of right part
                    right = i;
                    break;
                }
            }

            // multiply coefficient
            for (Map.Entry<String, Integer> entry: midRes.entrySet()) {
                midRes.put(entry.getKey(), entry.getValue() * coefficient);
            }

            // get result from left part before '(' and right part after ')'&coefficient
            Map<String, Integer> leftRes = count(formula.substring(0, left));
            Map<String, Integer> rightRes = count(formula.substring(right));

            // merge result
            merge(res, leftRes);
            merge(res, midRes);
            merge(res, rightRes);
        }
        return res;
    }

    private int findRightParenthesisIndex(String formula, int startIndex) {
        // find the corresponding ')' to '(' at startIndex in the formula string
        int count = 0;
        for (int i = startIndex; i < formula.length(); i++) {
            if (formula.charAt(i) == '(') {
                count++;
            } else if (formula.charAt(i) == ')') {
                count--;
                if (count == 0) {
                    return i;
                }
            }
        }
        return formula.length() - 1;
    }

    private void merge(Map<String, Integer> res, Map<String, Integer> subRes) {
        // merge subRes to res
        if (res == null || subRes == null) {
            return;
        }
        if (res.size() == 0) {
            res.putAll(subRes);
        } else {
            for (Map.Entry<String, Integer> entry: subRes.entrySet()) {
                res.put(entry.getKey(), entry.getValue() + res.getOrDefault(entry.getKey(), 0));
            }
        }
    }

	public static void main(String[] args) {
		Solution s = new Solution();
//		System.out.println(s.countOfAtoms("H2O")); // "H2O"
//		System.out.println(s.countOfAtoms("Mg(OH)2")); // "H2MgO2"
//		System.out.println(s.countOfAtoms("K4(ON(SO3)2)2")); // "K4N2O14S4"
		System.out.println(s.countOfAtoms("H11He49NO35B7N46Li20")); // "B7H11He49Li20N47O35"
		System.out.println(s.countOfAtoms("((N42)24(OB40Li30CHe3O48LiNN26)33(C12Li48N30H13HBe31)21(BHN30Li26BCBe47N40)15(H5)16)14")); // "B18900Be18984C4200H5446He1386Li33894N50106O22638"
	}
}