class Solution:
    def canTraverseAllPairs(self, nums: List[int]) -> bool:
        primes = defaultdict(list)
        def prime_factors(num, index):
            for i in range(2, int(math.sqrt(num)) + 1):
                if num % i == 0:
                    primes[i].append(index)
                    while num % i == 0 and num > 1:
                        num //= i
            if num >= 2:
                primes[num].append(index)
        for i, num in enumerate(nums):
            prime_factors(num, i)
        # print (primes)
        adj = defaultdict(list)
        # create graph
        for key, vals in primes.items():
            for i in range(len(vals) - 1):
                adj[vals[i]].append(vals[i+1])
                adj[vals[i+1]].append(vals[i])
        def dfs(node, visited):
            visited.add(node)
            for neighbor in adj[node]:
                if neighbor in visited:
                    continue
                dfs(neighbor, visited)
        visited = set()
        dfs(0, visited)
        return len(visited) == len(nums)