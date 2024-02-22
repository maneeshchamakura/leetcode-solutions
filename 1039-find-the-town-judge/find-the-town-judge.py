class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        possible_judges = set(list(range(1, n + 1)))
        in_degree = [0]*(n+1)
        for x in trust:
            trustee, trusted = x[0], x[1]
            if trustee in possible_judges:
                possible_judges.remove(trustee)
            in_degree[trusted] += 1
        for judge in possible_judges:
            if in_degree[judge] == n - 1:
                return judge
        return -1
