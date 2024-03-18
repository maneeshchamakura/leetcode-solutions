class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort()
        arrows = 0
        i = 0
        n = len(points)
        while i < n:
            current_point = points[i]
            end = current_point[1]
            i += 1
            while i < n and points[i][0] <= end:
                # check where the second balloon ends
                second_end = points[i][1]
                if second_end >= end:
                    pass
                else:
                    end = second_end
                i += 1
            arrows += 1
        return arrows