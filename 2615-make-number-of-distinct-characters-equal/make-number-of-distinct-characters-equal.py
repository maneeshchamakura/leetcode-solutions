class Solution:
    def isItPossible(self, word1: str, word2: str) -> bool:
        word1_count = Counter(word1)
        word2_count = Counter(word2)
        temp1 = Counter(word1)
        temp2 = Counter(word2)
        count1 = len(word1_count.keys())
        count2 = len(word2_count.keys())
        # temp1 = map(word1_count)
        # temp2 = map(word2_count)
        for char2 in temp2.keys():
            for char1 in temp1.keys():
                # remove char1 from word1
                # update new_count1
                word1_count[char1] -= 1
                new_count1 = count1 if word1_count[char1] > 0 else count1 - 1
                # remove char2 from word2
                # update new_count2
                word2_count[char2] -= 1
                new_count2 = count2 if word2_count[char2] > 0 else count2 - 1
                # add char2 to word1_count
                word1_count[char2] += 1
                # add char1 to word2_count
                word2_count[char1] += 1
                if word1_count[char2] == 1:
                    new_count1 += 1
                if word2_count[char1] == 1:
                    new_count2 += 1
                if new_count1 == new_count2:
                    return True
                # set the values back
                word1_count[char1] += 1
                word2_count[char2] += 1
                word1_count[char2] -= 1
                word2_count[char1] -= 1
        return False
                
        