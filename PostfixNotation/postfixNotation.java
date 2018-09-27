import java.util.*;

public class postfixNotation
{
    public static void main(String[] args)
    {
        if (args.length < 2 )
        {
            System.out.println("Uncompleted Postfix Notation");
            System.exit(0);
        }
        LinkedStack<String> operands = new LinkedStack<>();
        int numOperands = 0;
        int numOperators = 0;
        for (int i = 0; i < args.length; i++)
        {
            String newData = args[i];
            if (isOperator(newData))
            {
                System.out.println(newData);
                if(numOperands >= 2) calculation(operands, newData);
                numOperands--;
            }
            else
            {
                numOperands++;
                operands.push(newData);
            }
            System.out.println("The top is " + operands.peek());
        }

        if (!operands.isEmpty())
            System.out.println("The answer is " + operands.peek());
        else
        {
            System.out.println("Wrong Operations!!");
            System.exit(0);
        }
    }

    private static boolean isOperator(String newData)
    {
        if (newData.equals("+") || newData.equals("-") || newData.equals("*") || newData.equals("/"))
            return true;
        return false;
    }

    private static void calculation(LinkedStack<String> operands, String operator)
    {
        String num1 = operands.pop();
        String num2 = operands.pop();
        operands.push(getResult (num1, num2, operator));
    }

    private static String getResult(String num1, String num2, String OP)
    {
        String answer = "";
        int operand1 = Integer.parseInt(num1);
        int operand2 = Integer.parseInt(num2);
        System.out.println("Operand1 is " + operand1 + " and Operand2 is " + operand2);
        if (OP.equals("+")) return  (operand1 + operand2) + "" ;
        else if (OP.equals("-")) return  (operand2 - operand1) + "" ;
        else if (OP.equals("*")) return  (operand1 * operand2) + "" ;
        else return (operand2 / operand1) + "";
    }
}
