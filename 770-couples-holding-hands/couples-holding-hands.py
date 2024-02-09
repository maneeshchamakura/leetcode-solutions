class Solution:
    def minSwapsCouples(self, row: List[int]) -> int:
        val_dict = {x:i for i, x in enumerate(row)}
        count = 0
        n = len(row)
        for i in range(0, n, 2):
            num = row[i]
            # check if num is divisible by 1
            if num % 2 == 0:
                if row[i+1] != num + 1:
                    next_index = val_dict[num + 1]
                    # swap next_index and i+1
                    row[i+1], row[next_index] = row[next_index], row[i+1]
                    val_dict[row[next_index]] = next_index
                    count += 1
            else:
                if row[i+1] != num - 1:
                    next_index = val_dict[num - 1]
                    # swap next_index and i + 1
                    row[i+1], row[next_index] = row[next_index], row[i+1]
                    val_dict[row[next_index]] = next_index
                    count += 1
        return count