class Solution:
    def maxSumAfterPartitioning(self, arr: List[int], k: int) -> int:
        def traverse(arr, index, memo):
            if index >= len(arr):
                return 0
            if index in memo:
                return memo[index]
            max_val = 0
            max_ans = 0
            for i in range(index, min(index + k, len(arr))):
                # subarray from arr[index] till arr[i]
                max_val = max(max_val, arr[i])
                current_ans = traverse(arr, i + 1, memo)
                current_ans += max_val*(i - index + 1)
                max_ans = max(max_ans, current_ans)
            memo[index] = max_ans
            return max_ans
        return traverse(arr, 0, {})