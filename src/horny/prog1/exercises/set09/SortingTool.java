package horny.prog1.exercises.set09;

import horny.prog1.exercises.set09.SortingAlgorithm.*;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class SortingTool extends SortingAlgorithm
{
    protected int ArrayLenght;
    protected boolean IsSorted;
    protected boolean IsEqual;
    protected int[] Array;
    private SortingAlgorithm algorithm = new SortingAlgorithm();
    public void setInitData() throws Exception {
        Scanner scan = new Scanner(System.in);
        System.out.print("Please insert the array-lenght: ");
        ArrayLenght = scan.nextInt();
        System.out.print("Should the array be sorted? (y/n): n");
        char chVerify = 'n';//scan.next().charAt(0);
        switch (chVerify)
        {
            case 'y':
                IsSorted = true;
                break;
            case 'n':
                IsSorted = false;
                break;
            default:
                System.out.println("Invalid input!");
                throw new Exception();
        }
        System.out.print("Should all arrays be the same? (y/n): y");
        chVerify = 'y';//scan.next().charAt(0);
        switch (chVerify)
        {
            case 'y':
                IsEqual = true;
                break;
            case 'n':
                IsEqual = false;
                break;
            default:
                System.out.println("Invalid input!");
                throw new Exception();
        }
        createSingleArray();
    }
    public void createSingleArray()
    {
        Array = new int[ArrayLenght];
        for(int i = 0; i < ArrayLenght; i++)
            Array[i] = getRandomNumb();
    }
    public int getRandomNumb()
    {
        return ThreadLocalRandom.current().nextInt(0, 100 + 1);
    }
    public void performExperiment(SortingAlgorithm algorithm)
    {

    }
    public void performExperiment_Bubbelsort()
    {
        algorithm.insertionsort(Array, ArrayLenght);
    }
}
