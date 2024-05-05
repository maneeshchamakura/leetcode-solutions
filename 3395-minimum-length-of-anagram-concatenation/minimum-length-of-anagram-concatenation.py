class Solution:
    def minAnagramLength(self, s: str) -> int:
        n = len(s)
        counter = Counter(s)
        vals = list(counter.values())
        gcd = math.gcd(*vals)
        return sum([val//gcd for val in vals])
            