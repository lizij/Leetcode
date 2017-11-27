package Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Employee {
    // It's the unique id of each node;
    // unique id of this employee
    public int id;
    // the importance value of this employee
    public int importance;
    // the id of direct subordinates
    public List<Integer> subordinates;

    public Employee(int id, int importance, int... subordinates) {
        this.id = id;
        this.importance = importance;
        this.subordinates = Arrays.stream(subordinates).boxed().collect(Collectors.toList());
    }

    public Employee(int id, int importance) {
        this.id = id;
        this.importance = importance;
        this.subordinates = new ArrayList<>();
    }
}
