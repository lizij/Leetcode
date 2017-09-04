
## Problem Description
Given a singly linked list, return a random node's value from the linked list. Each node must have the same probability of being chosen.
Follow up:
What if the linked list is extremely large and its length is unknown to you? Could you solve this efficiently without using extra space?
Example:
```
// Init a singly linked list [1,2,3].
ListNode head = new ListNode(1);
head.next = new ListNode(2);
head.next.next = new ListNode(3);
Solution solution = new Solution(head);

// getRandom() should return either 1, 2, or 3 randomly. Each element should have equal probability of returning.
solution.getRandom();
```
## Solution Explanation
This problem comes from https://gregable.com/2007/10/reservoir-sampling.html and some other related articles.
We need to make sure that every element in list has the same probability to be selected without knowing the list length.

​We assume the length of list is $N$. For every element $i^{th}$, $P_i$ needs to be $\frac{1}{n}$. By using **randomInt(n)**(Here we mark it as **rand()**) in java, we can get k which satisfying 0 <= k < n. Then there is $P_{rand(k) = 0} = \frac{1}{k}$

At first, we choose the head value as result(result = head.value). 

N = 1:$P_{1^{st}} = P_{rand(1) = 0} = 1$

Then for every element, while traversing the list ascendingly, if rand(i) = 0, we set result = $i^{th}$.value. 

N = 2: 

$P_{1^{st}} = P_{rand(2) != 0} = \frac{1}{2}$

$P_{2^{nd}} = P_{rand(2) = 0} =  \frac{1}{2}$

N = 3:

$P_{1^{st}} = P_{rand(2) != 0} * P_{rand(3) != 0} = \frac{1}{2} * \frac{2}{3} = \frac{1}{3}$

$P_{2^{nd}} = P_{rand(2) = 0} * P_{rand(3) != 0} = \frac{1}{2} * \frac{2}{3} = \frac{1}{3}$

$P_{3^{nd}} = P_{rand(3) = 0} = \frac{1}{3}$

N = 4:

$P_{1^{st}} = P_{rand(2) != 0} * P_{rand(3) != 0} * P_{rand(4) != 0} = \frac{1}{2} * \frac{2}{3} * \frac{3}{4} = \frac{1}{4}$

$P_{2^{nd}} = P_{rand(2) = 0} * P_{rand(3) != 0} * P_{rand(4) != 0} = \frac{1}{2} * \frac{2}{3} * \frac{3}{4} = \frac{1}{4}$

$P_{3^{nd}} = P_{rand(3) = 0} * P_{rand(4) != 0} = \frac{1}{3} * \frac{3}{4} = \frac{1}{4}$

$P_{4^{th}} = P_{rand(4) = 0} = \frac{1}{4}$

Therefore if N = n, for $i^{th}$ element in list:

$P_{i^{th}} = P_{rand(i = 0)} * P_{rand(i + 1) != 0} * ... * P_{rand(n) != 0} = \frac{1}{i} * \frac{i}{i + 1} * ... * \frac{n - 1}{n} = \frac{1}{n}$

In the code:

```
for (int i = 1;node != null;i++, node = node.next){
            if (random.nextInt(i) == 0) res = node;
}
```

In the first loop, randomInt(1) == 0 will always be true. It will actually initialize **res** in a obscure way.

In other loops, for every i, calculate $P_i$ to decide whether node can be the possible result. Because we traver the list ascendingly, the previous result will be unuseful to decide $P_{i^{th}}$ 