class Solution:
    def sortedSquares(self, nums: List[int]) -> List[int]:
        low, high = 0, len(nums) - 1
        result = []
        while low < high:
            left_ans = nums[low]**2
            right_ans = nums[high]**2
            if right_ans > left_ans:
                result.append(right_ans)
                high -= 1
            else:
                result.append(left_ans)
                low += 1
        result.append(nums[low]**2)
        result.reverse()
        return result