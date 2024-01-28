class Solution:
    def flowerGame(self, n: int, m: int) -> int:
        # n and m
        even_nums_n = n // 2
        odd_nums_n = n - even_nums_n
        
        even_nums_m = m // 2
        odd_nums_m = m - even_nums_m
        
        return (even_nums_n * odd_nums_m) + (odd_nums_n * even_nums_m)