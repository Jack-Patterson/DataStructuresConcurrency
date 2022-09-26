package Lab3;

public class Recursion
{
    public static void main(String[] args)
    {
        System.out.println(sum(new int[]{2, 3, 4, 5}));
    }

    public static int sum(int[] values)
    {
        return (sumRecur(values.length, values));
    }

    private static int sumRecur(int index, int[] values)
    {
        if (index <= 0)
        {
            return 0;
        }
        return (sumRecur(index - 1, values) + values[index - 1]);
    }

    public static int binarySearch(int[] values)
    {
        return 0;
    }

    private static int binarySearchRecur(int[] values, int index){
        return 0;
    }
}
