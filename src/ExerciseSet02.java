public class ExerciseSet02
{
    public int computeSum(int number)
    {
        int result = 0;
        int i = 1;
        while (i <= number)
        {
            result = result + i;
            i = i + 1;
        }
        return result;
    }

    public void printSequence1(int num)
    {
        int outNumb = 0;
        int ctrNumb = 1;
        System.out.print("Sequence 1: ");
        for(;num>0;num--)
        {
            System.out.print(outNumb + " ");
            outNumb += ctrNumb;
            ctrNumb += 2;
        }
        System.out.println("...");
    }
    public void printSequence2(int num)
    {
        int outNumb = 1;
        System.out.print("Sequence 2: ");
        for(;num>0;num--)
        {
            double isUneven;
            isUneven = outNumb % 2;
            if(isUneven == 0)
                System.out.print(-outNumb + " ");
            else
                System.out.print(outNumb + " ");
            outNumb += 1;
        }
        System.out.println("...");
    }
    public void printSequence3(int num)
    {
        int outNumb = 1;
        int ctrNumb = 2;
        System.out.print("Sequence 3: ");
        for(;num>0;num--)
        {
            System.out.print(outNumb + " ");
            outNumb += ctrNumb;
            ctrNumb += 1;
        }
        System.out.println("...");
    }
    public void printTriangle(int num)
    {
        System.out.println("Visualizes the " + num + "-th triangular number:");
        int counter = 1;
        for(int i = num;i>0;i--)
        {
            int column = num - counter;
            int dots = num - column;
            for(;column>0;column--)
            {
                System.out.print(" ");
                System.out.print(" ");
            }
            for(;dots>0;dots--)
            {
                System.out.print(".");
                System.out.print(" ");
            }
            System.out.println();
            counter++;
        }
    }
}
