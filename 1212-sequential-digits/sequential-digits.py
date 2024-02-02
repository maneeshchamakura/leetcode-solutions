import bisect
class Solution:
    def sequentialDigits(self, low: int, high: int) -> List[int]:
        prev = [12, 23, 34, 45, 56, 67, 78, 89]
        ans = []
        ans.extend(prev)
        for i in range(7):
            temp = []
            for num in prev:
                mod = num % 10
                if mod == 9:
                    continue
                new_ans = num*10 + (mod + 1)
                temp.append(new_ans)
            ans.extend(temp)
            prev = temp
        # left and right
        left = low - 1
        right = high + 1
        right_index = bisect.bisect_left(ans, right)
        left_index = bisect.bisect_right(ans, left)
        return ans[left_index:right_index]