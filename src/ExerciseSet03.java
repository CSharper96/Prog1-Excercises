import javafx.util.Pair;

import javax.print.DocFlavor;
import java.util.*;

public class ExerciseSet03
{
    public static void main(String[] args)
    {
        //writeName();
        //planProject();
        aufgabeDrei();
    }
    private static void planProject()
    {
        int hoursOfWork;
        String strLoan;
        int numberOfWorkers;

        hoursOfWork = Terminal.readInt("Provide the hours of Work necessary");
        System.out.println(hoursOfWork);
        strLoan = Terminal.readString("Provide the loan for each hour");
        System.out.println(strLoan);
        numberOfWorkers = Terminal.readInt("Provide the numbers of workers");
        System.out.println(numberOfWorkers);
        float loan = Float.parseFloat(strLoan);
        System.out.println("Loan per 8 hour: " + (loan = loan * 8));
        calculateSummaSummarum(hoursOfWork, loan, numberOfWorkers);
    }
    private static void calculateSummaSummarum(int hoursOfWork, float loan, int numberOfWorkers)
    {
        float daysNecessary;
        float costs;

        daysNecessary = hoursOfWork/(numberOfWorkers*8);
        float costsPerWorker = numberOfWorkers * loan;
        costs = daysNecessary * costsPerWorker;
        System.out.println("Days necessary for the project: " + daysNecessary);
        System.out.println("Money needed: " + costs);
    }
    public static void aufgabeDrei()
    {
        String[] strMonths = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        int year = Terminal.readInt("Select the year ");
        int month = Terminal.readInt("Select the month (1 is january) ");
        if(month > 12 || month < 0) return;
        int days = getDaysOfMonth(month,year);
        String strMonth = strMonths[month-1];
        System.out.println(strMonth + " int the year " + year + " got " + days + " days!");
        int day = Terminal.readInt("Select the day");
        System.out.println(FuncStrInput(day, month, year));
        int specialDay = complicatedWayToVerifyDay(day, month, year);
        int[] changedMonthYear = FuncIntArrayMonthChange(month, year);
        month = changedMonthYear[0];
        year = changedMonthYear[1];
        String dayOfTheWeek = getDayOfTheWeek(day, month, year);
        String strSpecialDay = "";
        switch (specialDay)
        {
            case 0:
                break;
            case 1:
                strSpecialDay = "(Mauerfall)";
            case 2:
                strSpecialDay = "(9/11)";
            case 666:
                strSpecialDay = "(Ma Birthdae!)"; //Possessed by the devil, because it is always true!
            default:
                break;
        }
        System.out.println("It is a " + dayOfTheWeek + ".");
        if(specialDay != 0)
            System.out.println("Special Event: " + strSpecialDay);
    }
    public static int getDaysOfMonth(int month, int year)
    {
        int[] months = {31, 28, 31, 30 ,31 ,30, 31, 31, 30, 31, 30, 31};
        int[] monthsLeapYear = {31, 29, 31, 30 ,31 ,30, 31, 31, 30, 31, 30, 31};
        if(isLeapYear(year))
            return monthsLeapYear[month-1];
        else
            return months[month-1];
    }
    private static boolean isLeapYear (int year)
    {
        if(year % 4 == 0 && year % 100 != 0)
            return true;
        else if(year % 100 == 0 && year % 400 != 0)
            return false;
        else if(year % 400 == 0)
            return true;
        else
            return false;
    }
    public static String getDayOfTheWeek(int day, int month, int year)
    {
        int zellerResult;
        int j = year / 100;
        int k;
        if(month == 1 || month == 2)
            k = (year - 1) % 100;
        else
            k = year % 100;
        zellerResult = (day + (((month + 1) * 13) / 5) + k + FuncIntGauscheKlammer(k / 4) + FuncIntGauscheKlammer(j / 4) + (5 * j)) % 7;
        return FuncStrWeekdayString(zellerResult);
    }
    public static int complicatedWayToVerifyDay(int day, int month, int year)
    {
        switch (year)
        {
            case 1989:
            {
                switch (month)
                {
                    case 11:
                    {
                        switch (day)
                        {
                            case 9:
                                return 1;
                            default:
                                return 0;
                        }
                    }
                    default:
                        return 0;
                }
            }
            case 2001:
            {
                switch (month)
                {
                    case 9:
                    {
                        switch (day)
                        {
                            case 11:
                                return 2;
                            default:
                                return 0;
                        }
                    }
                    default:
                        return 0;
                }
            }
            default:
            {
                switch (month)
                {
                    case 1:
                    {
                        switch (day)
                        {
                            case 8:
                                return 666;
                            default:
                                return 0;
                        }
                    }
                    default:
                        return 0;
                }
            }
        }
    }
    private static void writeName()
    {
        int counter = 0;
        while(counter != 3)
        {
            System.out.println("Thomas Horny");
            counter++;
        }
    }
    public static String FuncStrInput(int day, int month, int year)
    {
        if((""+month).length() == 1)
            if((""+day).length() == 1)
                return ("0" + day +  ".0" + month + "." + year);
            else
                return (      day +  ".0" + month + "." + year);
        else
        if((""+day).length() == 1)
            return ("0" + day +  "." + month + "." + year);
        else
            return (      day +  "." + month + "." + year);
    } // Ende FuncStrEingabe(Tag, Monat, Jahr);
    public static int[] FuncIntArrayMonthChange(int month, int year)
    {
        switch (month)
        {
            case 1:
                month = 11;
                year--;
                break;
            case 2:
                month = 12;
                year--;
                break;
            case 3:
                month = 1;
                break;
            case 4:
                month = 2;
                break;
            case 5:
                month = 3;
                break;
            case 6:
                month = 4;
                break;
            case 7:
                month = 5;
                break;
            case 8:
                month = 6;
                break;
            case 9:
                month = 7;
                break;
            case 10:
                month = 8;
                break;
            case 11:
                month = 9;
                break;
            case 12:
                month = 10;
                break;
            default:
                System.out.println("Month?");
                break;
        }
        int MyResult[] = new int[2];
        MyResult[0] = month;
        MyResult[1] = year;
        return MyResult;
    }
    public static String FuncStrWeekdayString(int iWeekday)
    {
        iWeekday -= 2;
        if (iWeekday < 0)
            iWeekday += 7;
        String strResult;
        switch(iWeekday)
        {
            case 0:
                strResult = "Sunday";
                break;
            case 1:
                strResult = "Monday";
                break;
            case 2:
                strResult = "Tuesday";
                break;
            case 3:
                strResult = "Wednesday";
                break;
            case 4:
                strResult = "Thursday";
                break;
            case 5:
                strResult = "Friday";
                break;
            case 6:
                strResult = "Saturday";
                break;
            default:
                strResult = "No valid day!";
                break;
        }
        return strResult;
    }
    public static int FuncIntGauscheKlammer(double value) {return ((int) Math.floor(value));}
}
