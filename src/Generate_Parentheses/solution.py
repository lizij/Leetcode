from itertools import combinations
class Solution(object):
    def generateParenthesis(self, n):
        """
        :type n: int:
        :rtype: List[str]
        """
        """
            1
        1 
            2
        """
        ans = []

        if n == 0:
            return ans

        if n == 1:
            return ["()"]

        for i in range(0, n):
            tmp1 = self.generateParenthesis(i)
            tmp2 = self.generateParenthesis(n - 1 - i)
            if len(tmp1) > 0 and len(tmp2) > 0:
                for j in tmp1:
                    for k in tmp2:
                        ans.append("(%s)%s" % (j, k))
            elif len(tmp1) == 0 and len(tmp2) > 0:
                for k in tmp2:
                    ans.append("()%s" % k)
            elif len(tmp1) > 0 and len(tmp2) == 0:
                for j in tmp1:
                    ans.append("(%s)" % j)

        return ans

    def generateParenthesis2(self, n):
        ans = []
        def generate(tmp, left, right):
            if right == 0:
                ans.append(tmp)
            if left > 0:
                generate(tmp + "(", left - 1, right)
            if right > left:
                generate(tmp + ")", left, right - 1)
        generate("", n, n)
        return ans

    def generateParenthesis3(self, n):
        answer_list = []

        def backtracking(num_left, num_right, answer):
            if len(answer) == 2 * n:
                answer_list.append(answer)
                return
            elif num_left < n and num_left >= num_right:
                num_left += 1
                answer += "("
                backtracking(num_left, num_right, answer)

                if num_right + 1 <= num_left:
                    if num_left == n:
                        num_left -= 1
                        answer = answer[:-1]
                    num_right += 1
                    answer += ")"
                    backtracking(num_left, num_right, answer)
            elif num_left == n:
                answer += (n - num_right) * ")"
                answer_list.append(answer)

        backtracking(0, 0, "")
        return set(answer_list)


if __name__ == "__main__":
    print(Solution().generateParenthesis3(3))