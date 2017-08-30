class Solution(object):
    def longestValidParentheses(self, s):
        """
        :type s: str
        :rtype: int
        """
        maxLength = 0
        left = -1
        stack = []
        for i in range(0, len(s)):
            if s[i] == "(":
                stack.append(i)
            else:
                if len(stack) == 0:
                    left = i
                else:
                    stack.pop()
                    if len(stack) == 0:
                        maxLength = max(maxLength, i - left)
                    else:
                        maxLength = max(maxLength, i - stack[-1])
        return maxLength

if __name__ == "__main__":
    # print(Solution().isValid("((()))"))
    print("Input:()(()  Expected:2  " + "Output:" + str(Solution().longestValidParentheses("()(()")))
    print("Input:()     Expected:2  " + "Output:" + str(Solution().longestValidParentheses("()")))
    print("Input:(()    Expected:2  " + "Output:" + str(Solution().longestValidParentheses("(()")))
    print("Input:(())    Expected:4  " + "Output:" + str(Solution().longestValidParentheses("(())")))
    # print("01234567890"[2:6])#print 2345