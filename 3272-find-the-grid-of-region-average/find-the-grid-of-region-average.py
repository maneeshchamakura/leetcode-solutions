from statistics import mean
class Solution:
    def resultGrid(self, image: List[List[int]], threshold: int) -> List[List[int]]:
        rows = len(image)
        cols = len(image[0])
        result = []
        for i in range(rows):
            result.append([])
            for j in range(cols):
                result[i].append([])
        start_row = 0
        end_row = 2
        while end_row < rows:
            top_left_row, top_left_col = start_row, 0
            bottom_right_row, bottom_right_col = end_row, 2
            while bottom_right_col < cols:
                is_valid = True
                sum_so_far = 0
                for i in range(top_left_row, bottom_right_row + 1):
                    for j in range(top_left_col, bottom_right_col + 1):
                        delta_x = [0, 1]
                        delta_y = [1, 0]
                        current_val = image[i][j]
                        sum_so_far += current_val
                        for k in range(2):
                            new_i = i + delta_x[k]
                            new_j = j + delta_y[k]
                            if new_i >=0 and new_i < rows and new_j >=0 and new_j < cols and new_i <= bottom_right_row and new_j <= bottom_right_col:
                                if abs(current_val - image[new_i][new_j]) > threshold:
                                    is_valid = False
                                    break
                        if not is_valid:
                            break
                    if not is_valid:
                        break
                # print(result)
                if is_valid:
                    # print ("valid once", top_left_row, top_left_col, bottom_right_row, bottom_right_col)
                    ans = sum_so_far // 9
                    for k in range(top_left_row, bottom_right_row + 1):
                        for l in range(top_left_col, bottom_right_col + 1):
                            # print((k, l))
                            result[k][l].append(ans)
                    # print (result)
                bottom_right_col += 1
                top_left_col += 1
            start_row += 1
            end_row += 1
        final_ans = [[0]*cols for i in range(rows)]
        # for sub_arr in result:
        #     print(sub_arr)
        for i in range(rows):
            for j in range(cols):
                if len(result[i][j]) == 0:
                    final_ans[i][j] = image[i][j]
                else:
                    final_ans[i][j] = int(mean(result[i][j]))
        return final_ans
            