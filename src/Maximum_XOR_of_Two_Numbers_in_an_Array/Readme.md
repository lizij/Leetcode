## Problem Description

Given a non-empty array of numbers, a0, a1, a2, … , an-1, where 0 ≤ ai < 231.

Find the maximum result of ai XOR aj, where 0 ≤ i, j < n.

Could you do this in O(n) runtime?

Example:

```
Input: [3, 10, 5, 25, 2, 8]
Output: 28
Explanation: The maximum result is 5 ^ 25 = 28.
```

## Solution Explanation

This solution use this fact:$a \oplus b = c <=> a = b \oplus c$

### In every loop:

1. $mask = mask \lor (1 << i) = 1...10...0 $ (1 of 32 - i and 0 of i).

2. If $A[i] = X...X$ (X represent for 0 or 1), $A[i] \land mask = X...X0...0$, which is $A[i]$'s prefix ($X$ of 32 - i and 0 of i).

3. Store all prefixes of $A[i] (0 <= i < n)$ in Set.

4. If $max = X...X0...0$ ($X$ of 31 - i and 0 of i + 1), $tmp = max  \lor(1 << i) = X...X10...0$ (31 - i of $X$, 1 of 1 and 0 of i), which means setting No. 32 - i of $max$'s bit to 1. 

5. If $prefix1$ is one prefix in Set $tmp \oplus prefix1$ exists in Set, that means there must be another prefix (like prefix2) satisfying that $tmp \oplus prefix1  = prefix2$.

   In terms of the fact we talked about, we have some equations:

   $tmp \oplus prefix1 = prefix2$ 

   $<=> tmp = prefix1 \oplus prefix2$

   $<=> tmp = (A[k] \land mask) \oplus (A[j] \land mask)$

   $<=> X_{32}^{tmp}..X_{31-i}^{tmp}10...0 = X_{32}^{k}...X_{32-i}^{k}0...0 \oplus X_{32}^{j}...X_{32-i}^{j}0...0$

   $=> 1 = X_{32 - i}^{k} \oplus X_{32 - i}^{j}$

   In this reasoning, $k != j$ (because if k = j, the bit of 32 - i should be 0), which means there are two nums$, A[k]$ and $A[j]$. The their bits of 32 - i are different and all bits before 32 - i are the same as max.  Therefore, $A[k] \oplus A[j] = max + (1 << i) > max$. A new $max$ is gotten.





