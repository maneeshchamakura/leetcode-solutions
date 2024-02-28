class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        state = [0]*numCourses
        graph = defaultdict(list)
        for pre_req in prerequisites:
            c1, c2 = pre_req[0], pre_req[1]
            graph[c2].append(c1)
        # while in visiting state = -1
        # after visiting set to 1
        stack = []
        visited = set()
        def hascycle(node):
            if node in visited:
                if node in stack:
                    return True
                return False
            visited.add(node)
            stack.append(node)
            for neighbor in graph[node]:
                if hascycle(neighbor):
                    return True
            stack.pop()
            return False
        for i in range(numCourses):
            if hascycle(i):
                return False
        return True