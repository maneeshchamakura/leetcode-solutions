from heapq import heapify, heappush, heappop
class Solution:
    def maxPoints(self, grid: List[List[int]], queries: List[int]) -> List[int]:
        heap = []
        heapify(heap)
        ans = {}
        rows, cols = len(grid), len(grid[0])
        heappush(heap, (grid[0][0], 0, 0))
        visited = set()
        visited.add((0, 0))
        temp_ans = 0
        original = list(queries)
        m = len(queries)
        queries.sort()
        print (heap[0])
        for i in range(m):
            current_val = queries[i]
            # print (current_val, heap[0][0])
            while len(heap) > 0 and current_val > heap[0][0]:
                temp_ans += 1
                delta_x = [0, 0, -1, 1]
                delta_y = [1, -1, 0, 0]
                blah, curr_x, curr_y = heappop(heap)
                for j in range(4):
                    new_x = curr_x + delta_x[j]
                    new_y = curr_y + delta_y[j]
                    if (new_x, new_y) not in visited and new_x >= 0 and new_x < rows and new_y >=0 and new_y < cols:
                        visited.add((new_x, new_y))
                        heappush(heap, (grid[new_x][new_y], new_x, new_y))
            ans[current_val] = temp_ans
        print (ans)
        return [ans[x] for x in original]


