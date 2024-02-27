class Solution:
    def monkeyMove(self, n: int) -> int:
        # find the answer 2**n - 2
        base = 2
        mod = (10**9) + 7
        res = 1
        while n > 0:
            if n % 2 == 1:
                res = (res%mod * base%mod)%mod
            base = (base%mod * base%mod)%mod
            n //= 2
        res += (mod - 2)
        res %= mod
        return res