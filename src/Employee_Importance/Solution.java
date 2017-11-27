package Employee_Importance;

import Others.Employee;
import edu.princeton.cs.algs4.StdOut;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public int getImportance(List<Employee> employees, int id) {
    	if (employees == null || employees.size() == 0) return 0;
        Map<Integer, Employee> map = new HashMap<>();
        for (Employee e: employees) {
        	map.put(e.id, e);
		}
		return helper(map, id);
    }

    private int helper(Map<Integer, Employee> employees, int target) {
    	int res = employees.get(target).importance;
		for (int sub: employees.get(target).subordinates) {
			res += helper(employees, sub);
		}
		return res;
	}

	public static void main(String[] args) {
		Solution s = new Solution();
		StdOut.println(s.getImportance(
				Arrays.asList(
						new Employee(1, 5, 2, 3),
						new Employee(2,3),
						new Employee(3, 3)),
				1)
		);
		StdOut.println(s.getImportance(
				Arrays.asList(
						new Employee(1, 15, 2),
						new Employee(2,10, 3),
						new Employee(3, 5)),
				1)
		);
		StdOut.println(s.getImportance(
				Arrays.asList(
						new Employee(2, 5)),
				2)
		);
	}
}