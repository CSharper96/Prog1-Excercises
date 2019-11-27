package horny.prog1.exercises.set07;

import java.util.Scanner;

public class PolygonTest
{
    private static Polygon polygon;
    public static void main(String[] args)
    {
        createPolygon();
        writePoints();
        System.out.println("Area1 = " + polygon.calculateArea1());
        System.out.println("Area2 = " + polygon.calculateArea2());
    }
    private static void createPolygon()
    {
        polygon = new Polygon();

        Scanner scan = new Scanner(System.in);
        System.out.print("Provide an amount of Points: ");
        int amountOfPoints = scan.nextInt();
        System.out.println();

        for(int i = 0; i != amountOfPoints; i++)
        {
            System.out.print("Enter the x-pos of P" + (i+1) + " :");
            double x = scan.nextDouble();
            System.out.print("Enter the y-pos of P" + (i+1) + " :");
            double y = scan.nextDouble();
            polygon.addPoint(x, y);
        }
    }
    private static void writePoints()
    {
        System.out.println(polygon.toString());
    }
}
