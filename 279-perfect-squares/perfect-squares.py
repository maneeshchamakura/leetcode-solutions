class Solution:
    def numSquares(self, n: int) -> int:
        ''' 
           0 1 2 3 4 5 6 7 8 9 10
        0  0 0 0 0 0 0 0 0 0 0 0
        1  0 1 2 3 4 5 6 7 8 9 10
        4  0 1 2 3 1 2 3 4 2 3 4
        9
        16
        25
        36
        '''
        i = 1
        squares = []
        while True:
            square = i*i
            i += 1
            if square > 10**4:
                break
            squares.append(square)
        count = len(squares)
        # print (squares)
        dp = list()
        for i in range(count + 1):
            dp.append([0]*(n + 1))
        # for i in range(len(dp)):
        #     # set first column to zero
        #     dp[i][0] = n
        # for i in range(len(dp[0])):
        #     dp[0][i] = n
        # minimum
        # set first row and column to max value
        for i in range(1, count + 1):
            for j in range(1, n+1):
                current = squares[i-1]
                # print(current)
                if j < current:
                    dp[i][j] = dp[i-1][j]
                else:
                    # print("here")
                    dp[i][j] = 1 + dp[i][j-current]
                    # check with above
                    if i > 1:
                        dp[i][j] = min(dp[i][j], dp[i-1][j])
        # print (dp)
        return dp[count][n]