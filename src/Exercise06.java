import java.util.Arrays;
import java.util.Random;

public class Exercise06
{
    public static void main(String[] args)
    {
        guessGame();
        generateRandomArray();
    }
    private static void generateRandomArray()
    {
        int iAmountOfNumbers = Terminal.readInt("size");
        int iMinNumber = Terminal.readInt("min");
        int iMaxNumber = Terminal.readInt("max");
        double[] aNumberArray = new double[iAmountOfNumbers];
        for (int i = 0; i != iAmountOfNumbers; i++)
        {

            aNumberArray[i] = getRandomNumber(iMinNumber, iMaxNumber);
            System.out.println(aNumberArray[i]);
        }
        System.out.println("Nun sortiert:");
        Arrays.sort(aNumberArray);
        for (double number : aNumberArray)
        {
            System.out.println(number);
        }
    }
    //Beste Strategie? Sukzessive Approximation
    private static void guessGame()
    {
        System.out.println("I got a number between 1 and 20. Guess what? You'll never guess it!");
        int randomNumber = getRandomNumber(0,20);
        while(true)
        {
            int guessedNumber = Terminal.readInt("Your number");

            if(randomNumber > guessedNumber)
                System.out.println("My number is larger!");
            else if (randomNumber < guessedNumber)
                System.out.println("My number is smaller!");
            else
                break;
        }
        System.out.println("Nice1!");
    }
    private static int getRandomNumber(int minNumber, int maxNumber) {
        return (int) (Math.random() * ((maxNumber - minNumber) + 1)) + minNumber;
    }
}
