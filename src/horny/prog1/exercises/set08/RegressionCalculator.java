package horny.prog1.exercises.set08;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;


public class RegressionCalculator
{
    private ArrayList<Point> GivenValues;
    private ArrayList<Point> NewValues;
    private int neededMonths;
    public Pair<ArrayList<Point>, ArrayList<Point>> startProg()
    {
        NewValues = new ArrayList<>();
        getValues();
        for(int i = GivenValues.size(); i < 12; i++) {
            double result = calculateRegression(false, i + 1);
            writeNewValues(i + 1, result);
            NewValues.add(new Point(i + 1, result));
        }
        Pair<ArrayList<Point>, ArrayList<Point>>  pair = new Pair(GivenValues, NewValues);
        return pair;
    }
    private void getValues() {
        Scanner scan = new Scanner(System.in);
        int months = -1;
        boolean firstTime = true;
        while (months < 1 || months > 12)
        {
            if((months < 1 || months > 12) && !firstTime)
                System.out.println("Invalid input!");
            System.out.println("Please set a number of months, where you can provide sales.");
            System.out.println("(1 = only January , 2 = January, February , ...");
            System.out.print("Months:");
            months = scan.nextInt();
            firstTime = false;
        }
        GivenValues = new ArrayList<>();
        System.out.println("Please provide your sales of the last " + months + " months.");
        neededMonths = 12 - months;
        for(int i = 0; i < months; i++)
        {
            int amount = 0;
            System.out.print("Month " + (i + 1) + ": ");
            amount = scan.nextInt();
            Point point = new Point(i + 1, amount);
            GivenValues.add(point);
        }
    }
    private double calculateRegression(boolean getExactValue, int nextMonth)
    {
        double arithX = getArithmetic(true);
        double arithY = getArithmetic(false);
        double SSxx = getSSxx(arithX);
        double SSxy = getSSxy(arithX, arithY);
        double m = SSxy/SSxx;
        double b = arithY - (m * arithX);
        double result = (m * nextMonth) + b;
        if(getExactValue)
            return result;
        else
            return (int) result;
    }
    private double getArithmetic(boolean isX)
    {
        ArrayList<Double> allValues = new ArrayList<Double>();
        if(isX)
        {
            for(Point point : GivenValues)
                allValues.add(point.GetX() + 1);
            return calculateArithmetic(allValues);
        }
        else
        {
            for(Point point : GivenValues)
                allValues.add(point.GetY());
            return calculateArithmetic(allValues);
        }
    }
    private double calculateArithmetic(ArrayList<Double> allValues)
    {
        int size = allValues.size();
        double arithmetic = 0;
        for(int i = 0; i < size; i++)
            arithmetic += allValues.get(i);
        arithmetic /= size;
        return arithmetic;
    }
    private double getSSxx(double arithX)
    {
        int n = GivenValues.size();
        double SSxx = 0;
        for(int i = 1; i <= n; i++)
        {
            double xi = GivenValues.get(i - 1).GetX() + 1;
            SSxx += Math.pow((xi - arithX), 2);
        }
        return SSxx;
    }
    private double getSSxy(double arithX, double arithY)
    {
        int n = GivenValues.size();
        double SSxy = 0;
        for(int i = 1; i <= n; i++)
        {
            double yi = GivenValues.get(i - 1).GetY();
            double xi = GivenValues.get(i - 1).GetX() + 1;
            SSxy += (xi - arithX) * (yi - arithY);
        }
        return SSxy;
    }
    private void writeNewValues(int start, double result)
    {
        System.out.println("Geschätzte Verkäufe in Monat " + start + ": " + result);
    }
}
