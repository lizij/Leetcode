
def findLongestWord(s, d):
    def isSubsequence(x):
        iterator_of_s = iter(s)#all chars of s
        return all(c in iterator_of_s for c in x)
    return max(sorted(filter(isSubsequence, d)) + [''], key=len)

if __name__ == "__main__":
    s = "abpcplea"
    d = ["ale","apple","monkey","plea"]
    print(findLongestWord(s, d))
    x = "ale"
    iterator_of_s = iter(s)
    print(iterator_of_s)
    chars_of_x = [c for c in x]
    print(chars_of_x)
    chars_of_x_in_s = [c in iterator_of_s for c in x]
    print(chars_of_x_in_s)
    print(all(c in iterator_of_s for c in x))
    print(all(chars_of_x_in_s))