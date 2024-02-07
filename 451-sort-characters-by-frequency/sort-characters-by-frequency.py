class Solution:
    def frequencySort(self, s: str) -> str:
        s_counter = Counter(s)
        char_list = []
        for char, count in s_counter.items():
            char_list.append((count, char))
        heapify(char_list)
        result = []
        while len(char_list) > 0:
            ans, char = heappop(char_list)
            result.extend([char]*ans)
        return ''.join(reversed(result))