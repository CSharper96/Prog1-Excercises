import java.util.*;

public class Exercise06
{
    public static void main(String[] args)
    {
        int iMenu = -1;
        while (iMenu != 0)
        {
            if(iMenu > -2 && iMenu < 5)
            {
                System.out.println("1 : Time for guessing a number");
                System.out.println("2 : Generate a random array");
                System.out.println("3 : Search for a pattern in an string");
                System.out.println("4 : Simulate your hiking duration");
                System.out.println("0 : Beenden");
                System.out.println("-1 : Angaben wiederholen");
            }
            iMenu = Terminal.readInt("Bitte geben Sie Ihre Zahl ein");
            if(iMenu > -2 && iMenu < 5)
                System.out.println("\n\n");
            switch (iMenu)
            {
                case 1:
                {
                    guessGame();
                    iMenu = -1;
                    break;
                }
                case 2:
                {
                    generateRandomArray();
                    iMenu = -1;
                    break;
                }
                case 3:
                {
                    verifyStringArray();
                    iMenu = -1;
                    break;
                }
                case 4:
                {
                    simulateHiking();
                    iMenu = -1;
                    break;
                }
                case 0:
                    break;
                default: {
                    iMenu = -1;
                    break;
                }
            }
        }
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
    private static void verifyString()
    {
        System.out.println("Searches for the first occurrence of pattern in text and returns its");
        System.out.println("position. If no match is found, -1 is returned.");
        String strText = Terminal.readString("Please enter a text:");
        String strPattern = Terminal.readString("Please enter a pattern");
        int iTextLength = strText.length();
        int iPatternLength = strPattern.length();
        int iPatternChar = 0;
        boolean bMoreThanTwoChars = false;
        if(iPatternLength > 1) bMoreThanTwoChars = true;
        int iStartPos = 0;
        int iEndPos = 0;
        String strFilteredText = null;
        for(int i = 0; i != iTextLength; i++)
        {
            char actualTextChar = strText.charAt(i);
            char actualPatternChar = strPattern.charAt(iPatternChar);
            if((iPatternChar + 1) != iPatternLength && actualTextChar == actualPatternChar)
            {
                strFilteredText += actualTextChar;
                iPatternChar++;
                continue;
            }
            else if((iPatternChar + 1) == iPatternLength && actualTextChar == actualPatternChar)
            {
                strFilteredText += actualTextChar;
                iEndPos = i;
                iStartPos = iEndPos - (iPatternLength + 1);
                break;
            }
        }
        if(bMoreThanTwoChars)
        {
            System.out.println("Pattern found at Start-Position " + ++iStartPos + " to " + iEndPos);
        }
        else
        {
            if(strFilteredText.isEmpty())
                System.out.println("No Pattern found ... -1");
            else
                System.out.println("Pattern found at Pos " + iEndPos);
        }
    }
    private static void verifyStringArray()
    {
        System.out.println("Searches for the first occurrence of pattern in text and returns its");
        System.out.println("position. If no match is found, -1 is returned.");
        String strText = Terminal.readString("Please enter a text:");
        String strPattern = Terminal.readString("Please enter a pattern");

        int iTextLength = strText.length();
        int iPatternLength = strPattern.length();
        char[] textArray = new char[iTextLength];
        char[] patternArray = new char[iPatternLength];
        for(int i = 0; i != iTextLength; i++)
            textArray[i] = strText.charAt(i);
        for(int i = 0; i != iPatternLength; i++)
            patternArray[i] = strPattern.charAt(i);

        int patternCounter = 0;
        char prevChar = ' ';
        String patternReplica = "";
        int startPos = 0;
        boolean patternFound = false;
        for(char actualChar : textArray)
        {
            if(patternCounter == strPattern.length()) break;
            if(patternCounter == 0 || patternReplica.length() <= 1) startPos++;
            if(actualChar == patternArray[patternCounter])
            {
                prevChar = actualChar;
            }
            if(prevChar != actualChar)
            {
                patternReplica = "";
                patternCounter = 0;
            }
            else
            {
                patternReplica += patternArray[patternCounter];
                patternCounter++;
            }
            if(patternReplica == strPattern)
            {
                patternFound = true;
                break;
            }
        }
        if(patternFound)
            System.out.println("Pattern found!\nAt Position " + startPos + " to " + (startPos + strPattern.length()));
        else
            System.out.println("No Pattern found!");
    }
    private static void simulateHiking()
    {
        //Init Places
        Place places[] = new Place[5];
        for(int i = 0; i != 5; i++)
        {
            switch (i)
            {
                case 0:
                {
                    Place place = new Place();
                    place.Name = "Angeregg";
                    place.Height = 950;
                    place.Distance = 0;
                    places[i] = place;
                    break;
                }
                case 1:
                {
                    Place place = new Place();
                    place.Name = "Hanslettalm";
                    place.Height = 1616;
                    place.Distance = 3500;
                    places[i] = place;
                    break;
                }
                case 2:
                {
                    Place place = new Place();
                    place.Name = "Wiedersberger Horn";
                    place.Height = 2127;
                    place.Distance = 5000;
                    places[i] = place;
                    break;
                }
                case 3:
                {
                    Place place = new Place();
                    place.Name = "Hanslettalm";
                    place.Height = 1616;
                    place.Distance = 7500;
                    places[i] = place;
                    break;
                }
                case 4:
                {
                    Place place = new Place();
                    place.Name = "Angeregg";
                    place.Height = 950;
                    place.Distance = 10000;
                    places[i] = place;
                    break;
                }
                default:break;
            }
        }
        //In-/Outputs
        int iRoute = Terminal.readInt("Number of places (1 - 5)");
        if(iRoute < 1 || iRoute > 5)
        {
            System.out.println("Invalid route!");
            return;
        }
        for(int i = 0; i != iRoute; i++)
        {
            Place actPlace = places[i];
            System.out.println("1.\tPlace");
            System.out.println("\tName\t\t\t\t: " + actPlace.Name);
            System.out.println("\tHeight\t\t\t[m] : " + actPlace.Height);
            System.out.println("\tDist. from start[m] : " + actPlace.Distance);
            System.out.println();
        }
        int upwardSpeed = Terminal.readInt("Upward speed\t\t[m/h] \t");
        int downwardSpeed = Terminal.readInt("Downward speed\t\t[m/h] \t");
        float horizontalSpeed = (float) Terminal.readDouble("Horizontal speed\t[km/h]\t");
        //
        float timeInHours = 0;
        float tempTime = 0;
        for(int i = 0; i != iRoute; i++)
        {
            if((i + 1) != iRoute)
            {
                float timeForHeight = 0;
                float timeForDist = 0;
                int heightDiff = places[i + 1].Height - places[i].Height;
                int distanceDiff = places[i + 1].Distance - places[i].Distance;
                if(heightDiff < 0)
                {
                    timeForHeight = (float) (-heightDiff) / downwardSpeed;
                    timeForDist = distanceDiff / (horizontalSpeed * 1000);
                }
                else {
                    timeForHeight = (float) heightDiff / upwardSpeed;
                    timeForDist = distanceDiff / (horizontalSpeed * 1000);
                }
                if (timeForHeight > timeForDist)
                    tempTime = (timeForDist / 2) + timeForHeight;
                else
                    tempTime = (timeForHeight / 2) + timeForDist;
            }
            else
            {
                int convertedTime = (int) (timeInHours * 60);
                int hour = convertedTime / 60;
                int minutes = convertedTime % 60;
                System.out.println("\nTotal time :\t" + hour + ":" + minutes);
                break;
            }
            {
                int convertedTime = (int) (tempTime * 60);
                int hour = convertedTime / 60;
                int minutes = convertedTime % 60;
                System.out.println("to " + places[i + 1].Name + " ->\t" + hour + ":" + minutes);
            }
            timeInHours += tempTime;
            tempTime = 0;
        }
    }
}