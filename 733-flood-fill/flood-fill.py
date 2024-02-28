class Solution:
    def floodFill(self, image: List[List[int]], sr: int, sc: int, color: int) -> List[List[int]]:
        match_color = image[sr][sc]
        def flood(r, c, visited):
            if r < 0 or r >= len(image) or c < 0 or c >= len(image[0]):
                return
            if (r,c) in visited:
                return
            visited.add((r, c))
            current_color = image[r][c]
            if current_color == match_color:
                image[r][c] = color
            else:
                return
            flood(r, c + 1, visited)
            flood(r+1, c, visited)
            flood(r, c - 1, visited)
            flood(r - 1, c, visited)
        flood(sr, sc, set())
        return image
