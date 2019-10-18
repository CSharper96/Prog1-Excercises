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
        Map<Integer, Pair<String,Integer>> monthsDic = null;
        monthsDic = initMap(monthsDic);
        int year = Terminal.readInt("Select the year: ");
        int month = Terminal.readInt("Select the month (1 is january): ");
        if(month > 12 || month < 0) return;
        int days = getDaysOfMonth(month,year);
        String strMonth = "SomeMonth";
        System.out.println(strMonth + " int the year " + year + " got " + days + " days!");
    }
    private static Map<Integer, Pair<String,Integer>> initMap(Map<Integer,Pair<String,Integer>> monthsDic)
    {
        int[] iMonths = {31, 28, 31, 30 ,31 ,30, 31, 31, 30, 31, 30, 31};
        String[] strMonths = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        for(int i = 1; i < 13; i++)
        {
            Pair<String,Integer> monthsPair = new Pair<>(strMonths[i],iMonths[i]);
            monthsDic.put(i,monthsPair);
        }
        return monthsDic;
    }
    public static int getDaysOfMonth(int month, int year)
    {
        int[] months = {31, 28, 31, 30 ,31 ,30, 31, 31, 30, 31, 30, 31};
        return months[month-1];
    }
    private static void writeName()
    {
        int counter = 0;
        while(counter != 3)
        {
            System.out.println("Mein Name");
            counter++;
        }
    }
}
