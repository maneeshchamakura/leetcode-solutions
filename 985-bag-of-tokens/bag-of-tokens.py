class Solution:
    def bagOfTokensScore(self, tokens: List[int], power: int) -> int:
        tokens.sort()
        n = len(tokens)
        score = 0
        max_score = 0
        while len(tokens) > 0 and power >= tokens[0]:
            index = 0
            while index < len(tokens) and power >= tokens[index]:
                power -= tokens[index]
                index += 1
                score += 1
                max_score = max(max_score, score)
            if index == len(tokens):
                break
            # try adding more power with the score
            tokens = tokens[index:]
            # try adding elements from the right
            index = len(tokens) - 1
            if score > 0:
                power += tokens[index]
                tokens = tokens[:index]
                score -= 1     
        return max_score