import java.util.Scanner;
import java.util.Stack;

/** STUDENT FILE: Complete evaluate. Leave all other project files unchanged. */
public class PostfixEvaluator {
    /**
     * Evaluates a space-separated postfix expression using integer arithmetic.
     * Supported operators: +, -, *, / (integer division).
     *
     * @throws PostFixException for blank, malformed, or invalid expressions
     * @throws ArithmeticException for division by zero
     */
    public static int evaluate(String expression) throws ArithmeticException {
        Stack<Integer> stack = new Stack<>();
        Scanner tokens = new Scanner(expression);

        while(tokens.hasNext()) {
            if (expression == null || expression.isBlank()) {
                throw new PostFixException("Expression cannot be blank");
            }
            
            String s = tokens.next();
            if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
                if (stack.size() < 2) {
                    throw new PostFixException("Not enough operands");
                }
                else {
                    int int1 = stack.pop();
                    int int2 = stack.pop();
                }

                if(s.equals("+")) {
                    stack.push(int2 + int1);
                }
                else if(s.equals("-")) {
                    stack.push(int2 - int1);
                }
                else if(s.equals("*")) {
                    stack.push(int2 * int1);
                }
                else if(s.equals("/")) {
                    if (int1 == 0) {
                        throw new ArithmeticException("You cannot divide by 0");
                    }
                    else {
                        stack.push(int2 / int1)
                    }
                }
            }
            else {
                try {
                    stack.push(Integer.parseInt(s));
                }
                catch (NumberFormatException e) {
                    throw new PostFixException("That is not a real number");
                }
            }

        }

        // TODO 1: Process tokens one at a time.
        // TODO 2: If a token is an integer, push it onto the stack.
        // TODO 3: If it is +, -, *, or /, pop two operands.
        //         IMPORTANT: the first popped number is the RIGHT operand.
        // TODO 4: Calculate and push the result.
        // TODO 5: Reject unknown tokens and expressions with too few operands.
        // TODO 6: After processing, require EXACTLY one result on the stack.
        //         Catch stack underflow/overflow or check before operations.
        // Close the Scanner when you are finished.

        tokens.close();
        if (stack.size() == 1) {
            return numToReturn;
        } else {
            throw new PostFixException("Ill form");
        }
    }
}
