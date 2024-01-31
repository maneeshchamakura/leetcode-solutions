class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        n = len(temperatures)
        ans = [0]*n
        dq = deque()
        for i in reversed(range(n)):
            if not dq:
                ans[i] = 0                
            else:
                while dq and temperatures[i] >= temperatures[dq[0]]:
                    dq.popleft()
                if not dq:
                    ans[i] = 0
                else:
                    ans[i] = dq[0] - i
            dq.appendleft(i)
        return ans