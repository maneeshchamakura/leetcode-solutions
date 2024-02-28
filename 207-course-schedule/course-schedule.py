class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        state = [0]*numCourses
        graph = defaultdict(list)
        for pre_req in prerequisites:
            c1, c2 = pre_req[0], pre_req[1]
            graph[c2].append(c1)
        # while in visiting state = -1
        # after visiting set to 1
        def hascycle(node):
            if state[node] == 1:
                return False
            if state[node] == -1:
                return True
            state[node] = -1
            for neighbor in graph[node]:
                if hascycle(neighbor):
                    return True
            state[node] = 1
            return False
        for i in range(numCourses):
            if hascycle(i):
                return False
        return True