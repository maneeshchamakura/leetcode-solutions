class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        in_degrees = [0]*numCourses
        graph = defaultdict(list)
        for pre_req in prerequisites:
            c1, c2 = pre_req[0], pre_req[1]
            in_degrees[c1] += 1
            graph[c2].append(c1)
            # c1 -> c2
        q = deque()
        for i in range(numCourses):
            if in_degrees[i] == 0:
                q.append(i)
        count = 0
        while q:
            node = q.popleft()
            count += 1
            for neighbor in graph[node]:
                in_degrees[neighbor] -= 1
                if in_degrees[neighbor] == 0:
                    q.append(neighbor)
        return count == numCourses