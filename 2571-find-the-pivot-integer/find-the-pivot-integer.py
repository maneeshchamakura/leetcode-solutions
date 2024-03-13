class Solution:
    def pivotInteger(self, n: int) -> int:
        result = -1
        low, high = 1, n
        while low <= high:
            mid = (low + high) // 2
            # sum till 1..mid
            left_sum = (mid*(mid + 1)) // 2
            # sum from mid..high
            right_count = n - mid
            right_sum = (right_count*(right_count + 1)) // 2
            right_sum += (right_count+1)*mid
            if left_sum == right_sum:
                return mid
            elif left_sum < right_sum:
                low = mid + 1
            else:
                high = mid - 1
        return -1