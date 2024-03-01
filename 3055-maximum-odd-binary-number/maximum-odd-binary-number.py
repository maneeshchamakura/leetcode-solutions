class Solution:
    def maximumOddBinaryNumber(self, s: str) -> str:
        zero_count, one_count = 0, 0
        for char in s:
            if char == '0':
                zero_count += 1
            else:
                one_count += 1
        result = [0]*len(s)
        result[len(s) - 1] = 1
        index = 0
        one_count -= 1
        while one_count > 0:
            result[index] = 1
            index += 1
            one_count -= 1
        return ''.join([str(x) for x in result])
            