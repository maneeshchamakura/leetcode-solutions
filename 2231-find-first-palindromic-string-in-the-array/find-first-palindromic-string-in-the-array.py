class Solution:
    def firstPalindrome(self, words: List[str]) -> str:
        def is_palindrom(string):
            i, j = 0, len(string) - 1
            while i < j:
                if string[i] != string[j]:
                    return False
                i += 1
                j -= 1
            return True
        for word in words:
            if is_palindrom(word):
                return word
        return ""