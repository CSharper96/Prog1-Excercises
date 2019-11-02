import javafx.util.Pair;

import javax.print.DocFlavor;
import java.util.*;

public class ExerciseSet03
{
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
        String strYear = Terminal.readString("Please enter a year");
        int iYear = (int)(Integer.valueOf(strYear)).intValue();
        int iMonth = Terminal.readInt("Please enter the month (1 = January)");
        int iDay = Terminal.readInt("Please enter the day");
        int iDecade = (int) (Integer.valueOf(strYear.substring(2   ))).intValue();
        int iMillenial = (int) (Integer.valueOf(strYear.substring(0, 2))).intValue();
        int iAmountOfDays = getDaysOfMonth(iMonth, strYear);
        System.out.println("Day: "+ iDay +" Month: " + iMonth + " Year: " + strYear + " Got " + iAmountOfDays + " days. " + " Decade: " + iDecade + " Millenial: " + iMillenial + " Leap year?: " + isLeapYear(strYear));
        String strStartingWeekday = getWeekdayAsString(iDay, iMonth, iMillenial, iDecade);
        System.out.println("The " + iDay + ". of the month is a " + strStartingWeekday);
        int iDayVerification = complicatedWayToVerifyDay(iDay, iMonth, iYear);
        if(iDayVerification != 0)
        {
            switch (iDayVerification)
            {
                case 1:
                {
                    System.out.println("Special day: Mauerfall");
                    break;
                }
                case 2:
                {
                    System.out.println("Special day: 9/11");
                    break;
                }
                case 666:
                {
                    if(iYear < 1996)
                        System.out.println("Ma Birthdae (well, not now... but in " + (1996-iYear) + " years)");
                    else
                        System.out.println("Ma Birthdae!");
                    break;
                }
                default:
                    System.out.println("Default not implemented!");
            }
        }
        System.out.println("\nNow it's about to create the calendar!");
        strStartingWeekday = getWeekdayAsString(1, iMonth, iMillenial, iDecade);
        printCalendar(strStartingWeekday, iAmountOfDays);
    }
    private static  void printCalendar(String strStartingWeekday, int iAmountOfDays)
    {
        String arrCalendarPositions[][] = new String[7][7];
        int iFirstWeekdayPosition = validateStartingWeekday(strStartingWeekday);
        int iDayCounter = 1;
        for(int rows = 0; rows <= 6; rows++)
        {
            for(int coloumns = 0; coloumns <= 6; coloumns++)
            {
                if(rows == 0)
                {
                    arrCalendarPositions[rows][coloumns] = setWeekdayForCalendar(coloumns) + "\t";
                }
                else if (rows == 1 && coloumns == iFirstWeekdayPosition && iDayCounter <= iAmountOfDays)
                {
                    if(iDayCounter < 9) arrCalendarPositions[rows][coloumns] = iDayCounter + "\t" + " ";
                    else arrCalendarPositions[rows][coloumns] = iDayCounter + "\t";
                    iDayCounter++;
                }
                else if (rows != 0 && rows == 1 && coloumns > iFirstWeekdayPosition && iDayCounter <= iAmountOfDays)
                {
                    if(iDayCounter < 9) arrCalendarPositions[rows][coloumns] = iDayCounter + "\t" + " ";
                    else arrCalendarPositions[rows][coloumns] = iDayCounter + "\t";
                    iDayCounter++;
                }
                else if (rows != 0 && rows != 1 && iDayCounter <= iAmountOfDays)
                {
                    if(iDayCounter < 9) arrCalendarPositions[rows][coloumns] = iDayCounter + "\t" + " ";
                    else arrCalendarPositions[rows][coloumns] = iDayCounter + "\t";
                    iDayCounter++;
                }
                else if(rows != 0)
                {
                    if(iDayCounter < 9) arrCalendarPositions[rows][coloumns] = "\t" + "  ";
                    else arrCalendarPositions[rows][coloumns] = "\t";
                }
            }
        }
        for(int rows = 0; rows <= 6; rows++)
        {
            for(int coloumns = 0; coloumns <= 6; coloumns++)
            {
                System.out.print(arrCalendarPositions[rows][coloumns]);
                System.out.print("  ");
            }
            System.out.print("\n");
        }
    }
    private static int validateStartingWeekday(String strSTartingWeekday)
    {
        if(strSTartingWeekday == "Monday")
            return 0;
        else if(strSTartingWeekday == "Tuesday")
            return 1;
        else if(strSTartingWeekday == "Wednesday")
            return 2;
        else if(strSTartingWeekday == "Thursday")
            return 3;
        else if(strSTartingWeekday == "Friday")
            return 4;
        else if(strSTartingWeekday == "Saturday")
            return 5;
        else
            return 6;
    }
    private static String setWeekdayForCalendar(int coloumn)
    {
        switch (coloumn)
        {
            case 0:
                return "Mon";
            case 1:
                return "Tue";
            case 2:
                return "Wed";
            case 3:
                return "Thu";
            case 4:
                return "Fri";
            case 5:
                return "Sat";
            case 6:
                return "Sun";
            default:
                return "---";
        }
    }
    private static String getWeekdayAsString(int iDay, int iMonth, int iMillenial, int iDecade)
    {
        if (iMonth < 3) iDecade = iDecade - 1;
        int iWeekday;
        iWeekday = (int) (((iDay + Math.floor (2.6 * ((iMonth + 9) % 12 + 1) - 0.2) + iDecade + Math.floor(iDecade / 4) + Math.floor(iMillenial / 4) - 2 * iMillenial - 1) % 7 + 7) % 7 + 1);
        return selectWeekday(iWeekday);
    }
    private static String selectWeekday(int iWeekday)
    {
        switch (iWeekday)
        {
            case 1:
                return "Monday";
            case 2:
                return "Tuesday";
            case 3:
                return "Wednesday";
            case 4:
                return "Thursday";
            case 5:
                return "Friday";
            case 6:
                return "Saturday";
            case 7:
                return "Sunday";
            default:
                return "No valid day!";
        }
    }
    private static int getDaysOfMonth(int iMonth, String strYear)
    {
        int[] months = {31, 28, 31, 30 ,31 ,30, 31, 31, 30, 31, 30, 31};
        int[] monthsLeapYear = {31, 29, 31, 30 ,31 ,30, 31, 31, 30, 31, 30, 31};
        if(isLeapYear(strYear))
            return monthsLeapYear[iMonth-1];
        else
            return months[iMonth-1];
    }
    private static boolean isLeapYear (String strYear)
    {
        int year = Integer.valueOf(strYear).intValue();
        if (year % 4 == 0 && year % 100 != 0)
            return true;
        else if (year % 100 == 0 && year % 400 != 0)
            return false;
        else if (year % 400 == 0)
            return true;
        else
            return false;
    }
    private static int FuncIntGauscheKlammer(double value) {return ((int) Math.floor(value));}
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
}
