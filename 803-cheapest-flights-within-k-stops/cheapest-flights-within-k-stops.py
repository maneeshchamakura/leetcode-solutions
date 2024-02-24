from queue import Queue
class Solution:
    def findCheapestPrice(self, n: int, flights: List[List[int]], src: int, dst: int, k: int) -> int:
        graph = defaultdict(list)
        for flight in flights:
            a, b, c = flight[0], flight[1], flight[2]
            graph[a].append((b, c))
        
        dist = [float('inf')]*n
        dist[src] = 0

        q = Queue()
        q.put((src, 0))
        stops = 0

        while not q.empty() and stops <= k:
            sz = q.qsize()
            for _ in range(sz):
                node, distance = q.get()

                if node not in graph: continue

                for neighbor, price in graph[node]:
                    if price + distance >= dist[neighbor]: continue
                    dist[neighbor] = price + distance
                    q.put((neighbor, dist[neighbor]))
            stops += 1
        return  dist[dst] if dist[dst] != float('inf') else -1