class Solution:
    def divisibilityArray(self, word: str, m: int) -> List[int]:
        num = 0
        result = []
        for i in range(len(word)):
            current_digit = int(word[i])
            num *= 10
            num += current_digit
            num %= m
            if num == 0:
                result.append(1)
            else:
                result.append(0)
        return result
            