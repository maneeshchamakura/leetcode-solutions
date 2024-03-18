class Solution:
    def insert(self, intervals: List[List[int]], newInterval: List[int]) -> List[List[int]]:
        # add some possibly overlapping intervals to the list of intervals
        # and then sort them
        intervals.append(newInterval)
        intervals.sort()
        new_intervals = []
        n = len(intervals)
        i = 0
        while i < n:
            cur_start, cur_end = intervals[i][0], intervals[i][1]
            i += 1
            while i < n and intervals[i][0] <= cur_end:
                cur_end = max(cur_end, intervals[i][1])
                i += 1
            new_intervals.append([cur_start, cur_end])
        return new_intervals