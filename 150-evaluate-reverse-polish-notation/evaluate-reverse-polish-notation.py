class Solution:
    def evalRPN(self, tokens: List[str]) -> int:
        # reverse polish notation
        stack = []
        for n in tokens:
            if n == '+':
                stack.append(stack.pop() + stack.pop())
            elif n == '-':
                x, y = stack.pop(), stack.pop()
                stack.append(y - x)
            elif n == '*':
                stack.append(stack.pop() * stack.pop())
            elif n == '/':
                x, y = stack.pop(), stack.pop()
                stack.append(int(y/x))
            else:
                stack.append(int(n))
        return stack.pop()

    # class Solution:
    # def evalRPN(self, tokens: List[str]) -> int:
    #     # Initialize an empty stack to store operands
    #     stack = []
        
    #     # Iterate through each token in the input list
    #     for n in tokens:
    #         # If the token is an operator, perform the corresponding operation
    #         if n == '+':
    #             stack.append(stack.pop() + stack.pop())
    #         elif n == '-':
    #             x, y = stack.pop(), stack.pop()
    #             stack.append(y - x)
    #         elif n == '*':
    #             stack.append(stack.pop() * stack.pop())
    #         elif n == '/':
    #             x, y = stack.pop(), stack.pop()
    #             # Perform integer division and append the result to the stack
    #             stack.append(int(y / x))
    #         else:
    #             # If the token is an operand, convert it to an integer and append to the stack
    #             stack.append(int(n))
        
    #     # The final result is the only element left in the stack
    #     return stack[-1]