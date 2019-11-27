package horny.prog1.exercises.set07;

import java.util.ArrayList;

public class Polygon
{
    private ArrayList<Point> Points;
    public Polygon()
    {
        Points = new ArrayList<>();
    }
    public void addPoint(double x, double y)
    {
        Points.add(new Point(x, y));
    }
    public Point getFirstPoint()
    {
        if(Points.isEmpty())
            return null;
        else
            return Points.get(0);
    }
    public Point getLastPoint()
    {
        if(Points.isEmpty())
            return null;
        else
            return Points.get((Points.size() - 1));
    }
    public ArrayList<Point> getPoints()
    {
        return Points;
    }
    public int getSize()
    {
        return Points.size();
    }
    public String toString()
    {
        String pointsToString = "{";
        for(Point point : Points)
        {
            pointsToString += "(" + point.GetX() + " , " + point.GetY() + ")";
        }
        pointsToString += "}";
        return pointsToString;
    }
    public double calculateArea1()
    {
        int size = getSize();
        if (size < 3) return 0.0;
        double a = 0.0;
        double y[] = getCoordinates(size, false);
        double x[] = getCoordinates(size, true);
        for (int i = 0; i < size; i++)
        {
            a += (y[i] + y[(i + 1) % size]) * (x[i] - x[(i + 1) % size]);
        }
        return Math.abs(a / 2.0);
    }
    public double calculateArea2()
    {
        int size = getSize();
        if (size < 3) return 0.0;
        double a = 0.0;
        double y[] = getCoordinates(size, false);
        double x[] = getCoordinates(size, true);
        for (int i = 1; i < size; i++)
        {
            a += x[i] * (y[(i + 1) % size] - y[(i - 1) % size]);
        }
        return Math.abs(a / 2.0);
    }
    public double[] getCoordinates(int size, boolean isX)
    {
        double coordinates[] = new double[size];
        for(int i = 0; i < size; i++)
        {
            if(isX)
                coordinates[i] = (Points.get(i)).GetX();
            else
                coordinates[i] = (Points.get(i)).GetY();
        }
        return coordinates;
    }
}
