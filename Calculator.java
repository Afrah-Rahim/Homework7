import java.util.Stack;
/**
 * A class that uses Stacks to do operations
 * 
 * @author Akash J and Fabliha H
 * @version May 2, 2017
 */
public class Calculator
{
    public static void main(String[] args)
    {
        //Test Case 1:
        String exp = "8-(4+2*3)/2";
        String output = Calculator.evaluateInfix(exp);
        System.out.println("exp = " + output);

        int result = Calculator.evaluatePostfix("8423*+2/-");
        System.out.println("result = " + result);

        //Test Case 2:
        String exp2 = "2*(3+4)";
        String output2 = Calculator.evaluateInfix(exp2);
        System.out.println("exp = " + output2);

        int result2 = Calculator.evaluatePostfix(output2);
        System.out.println("result = " + result2);
    }

    /**
     * evaluateInfix: A method that converts an expression that is in infix form to postfix form
     * 
     * Precondition: A string expression in infix form is entered
     * Postcondition: The expression is converted to postfix and returned as a string
     */
    public static String evaluateInfix(String exp)
    {
        String output = "";
        Stack s1 = new Stack <Character>();
        int len = exp.length();
        int i = 1;
        int b1 = 0; 

        //Adding the chars in a stack
        while(i < len)
        {
            if(exp.charAt(i) == '(') 
            {
                int x = exp.indexOf(')');

                if(! (x == len-1))
                {
                    if(isOperator(exp, (x+1)))
                    {
                        Character c = exp.charAt(x+1);
                        s1.push(c);
                        Character c2 = exp.charAt(x+2);
                        s1.push(c2);
                    }
                }
                i++;
            }
            else if(exp.charAt(i) == ')')
            {
                b1 = i;
                i = len;
            }
            else if(isOperator(exp, (i+1)))
            {
                int j = exp.indexOf('(');
                int j1 = j;
                int k = exp.indexOf(')');
                int k1 = k-1;
                while(j<k)
                {
                    if(isOperator(exp, j))
                    {
                        Character c = exp.charAt(j);
                        s1.push(c);
                    }
                    j++;
                }

                while(k1 > j1)
                {
                    if(!(isOperator(exp, k1)))
                    {
                        Character c = exp.charAt(k1);
                        s1.push(c);
                    }
                    k1--;
                }
                i = len;
            }
            else
            {
                Character c = exp.charAt(i);
                s1.push(c);
                i++;
            }
        }
        Character firstC = exp.charAt(0);
        s1.push(firstC);

        while(!(s1.isEmpty()))
        {
            output += (Character)s1.pop();
        }

        return output;
    }

    /**
     * isOperator: A method that checks if the index given is an operator or not
     * 
     * @param: A string expression and int index
     * @returns: A boolean
     */
    public static boolean isOperator(String str, int index)
    {
        return (str.charAt(index) == '+') || (str.charAt(index) == '*') || (str.charAt(index) == '-') || (str.charAt(index) == '/');
    }
    
    /**
     * evaluatePostfix: A method that calculates an expression by using Stacks 
     * 
     * Precondition: A string is entered that is in postFix form
     * Postcondition: An int is returned that is the result of the operations
     */
    public static int evaluatePostfix(String expression)
    {
        int output = 0;
        Stack s1 = new Stack<Integer>();

        int x = Integer.parseInt(expression.substring(0,1));
        s1.push(x);

        int n = 1;

        while(!(n >= expression.length()))
        {

            if(expression.charAt(n) == '+')
            {
                int operand1 = (int)s1.pop();
                int operand2 = (int)s1.pop();

                output = operand1 + operand2;

                s1.push(output);
                n++;
            }
            else if(expression.charAt(n) == '*')
            {
                int operand1 = (int)s1.pop();
                int operand2 = (int)s1.pop();

                output = operand1 * operand2;

                s1.push(output);
                n++;
            }
            else if(expression.charAt(n) == '-')
            {
                int operand1 = (int)s1.pop();
                int operand2 = (int)s1.pop();

                output = operand2 - operand1;

                s1.push(output);
                n++;
            }
            else if(expression.charAt(n) == '/')
            {
                int operand1 = (int)s1.pop();
                int operand2 = (int)s1.pop();

                output = operand2 / operand1;

                s1.push(output);
                n++;
            }
            else
            {
                int y = Integer.parseInt(expression.substring(n,(n+1)));
                s1.push(y);
                n++;
            }
        }
        return output;
    }
}
