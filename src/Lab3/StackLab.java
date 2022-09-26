package Lab3;

import java.util.*;

public class StackLab
{
    public static boolean isBalanced(String expression)
    {
        Deque<Character> stack = new LinkedList<>();
        boolean balanced = true;
        int index = 0;

        while (balanced && index < expression.length())
        {
            char ch = expression.charAt(index);
            if (isOpen(ch))
            {
                stack.push(ch);
            }
            else if (isClose(ch))
            {
                if (stack.isEmpty())
                {
                    balanced = false;
                }
                else
                {
                    char topChar = stack.pop();
                    if (!isMatching(topChar, ch))
                    {
                        balanced = false;
                    }
                }
            }
            index++;
        }


        return balanced && stack.isEmpty();
    }

    private static boolean isOpen(char ch)
    {
        switch (ch)
        {
            case '(':
            case '[':
            case '{':
            case '<':
                return true;
            default:
                return false;
        }
    }

    private static boolean isClose(char ch)
    {
        switch (ch)
        {
            case ')':
            case ']':
            case '}':
            case '>':
                return true;
            default:
                return false;
        }
    }

    private static boolean isMatching(char ch1, char ch2)
    {
        if (ch1 == '(' && ch2 == ')')
        {
            return true;
        }
        else if (ch1 == '[' && ch2 == ']')
        {
            return true;
        }
        else if (ch1 == '{' && ch2 == '}')
        {
            return true;
        }
        else if (ch1 == '<' && ch2 == '>')
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}