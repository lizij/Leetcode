class Solution(object):
    def isValid(self, s):
        """
        :type s: str
        :rtype: bool
        """
        tmp = []
        for c in s:
            if c == "(" or c == "[" or c == "{":
                tmp.append(c)
            elif c == ")" and len(tmp) > 0 and tmp[-1] == "(":
                tmp = tmp[:-1]
            elif c == "]" and len(tmp) > 0 and tmp[-1] == "[":
                tmp = tmp[:-1]
            elif c == "}" and len(tmp) > 0 and tmp[-1] == "{":
                tmp = tmp[:-1]
            else:
                return False

        if len(tmp) == 0:
            return True
        else:
            return False

if __name__ == "__main__":
    print(Solution().isValid("[([]])"))
