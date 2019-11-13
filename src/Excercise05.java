public class Excercise05
{
    public static void main(String[] args)
    {
        int iMenu = -1;
        while (iMenu != 0)
        {
            if(iMenu > -2 && iMenu < 5)
            {
                System.out.println("1 : Zinsberechnung");
                System.out.println("2 : Durchschnittsberechnung");
                System.out.println("3 : Vektor-Test");
                System.out.println("4 : Maulwurfssimulation");
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
                    calculation();
                    iMenu = -1;
                    break;
                }
                case 2:
                {
                    averageCalculation();
                    iMenu = -1;
                    break;
                }
                case 3:
                {
                    vectorTest();
                    iMenu = -1;
                    break;
                }
                case 4:
                {
                    moleSimulation();
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
    private static void calculation()
    {
        System.out.println("**\t\tZinsberechnung\t\t**\n\n");
        double iFund = Terminal.readDouble("Geben Sie das Anfangskapital ein [in EURO]");
        double dInterest = Terminal.readDouble("Geben Sie den Zinssatz ein [in %]");
        int dDuration = Terminal.readInt("Geben Sie die Anlagedauer an [in Jahren]");

        for(int i = 0; i != dDuration; i++)
        {
            System.out.println("Kapital nach " + (i+1) + " Jahren: " + (iFund = iFund + (iFund*(dInterest/100))));
        }
        System.out.println("\n\n");
    }
    private static void averageCalculation()
    {
        System.out.println("**\t\tDurchschnittsberechnung\t\t**\n\n");
        int iCounter = Terminal.readInt("Wie viele Zahlen sollen analysiert werden");
        double[] dNotes;
        dNotes = new double[iCounter];
        for(int i = 0; iCounter != i; i++)
        {
            dNotes[i] = Terminal.readDouble("nächste Zahl");
        }
        double dMin = 100;
        double dMax = 0;
        double dAverage = 0;
        System.out.print("OK. Die Zahlen lauten: ");
        for (double dNumber : dNotes)
        {
            System.out.print(dNumber + "  ");
            if(dNumber > dMax) dMax = dNumber;
            if(dNumber < dMin) dMin = dNumber;
            dAverage += dNumber;
        }
        dAverage /= iCounter;
        System.out.println("\nMin: " + dMin + "\tMax: " + dMax + "\tDurchschn.: " + dAverage);
        System.out.println("\n\n");
    }
    private static void vectorTest()
    {
        double[] vec1 = new double[2];
        double[] vec2 = new double[2];
        vec1[0] = Terminal.readDouble("Bitte geben sie die x1-Koordinate ein");
        vec1[1] = Terminal.readDouble("Bitte geben Sie die y1-Koordinate ein");
        vec2[0] = Terminal.readDouble("Bitte geben sie die x2-Koordinate ein");
        vec2[1] = Terminal.readDouble("Bitte geben Sie die y2-Koordinate ein");

        int iVectorSwitch = Terminal.readInt("Welchen Vektor möchten Sie multiplizieren? Vektor 1 (1) oder Vektor 2 (2)");
        switch (iVectorSwitch)
        {
            case 1:
            {
                double iFactor = Terminal.readDouble("Geben Sie den Faktor an");
                double[] dResult = mult(vec1, iFactor);
                System.out.println("Das Ergebnis ist: ");
                System.out.println("x1: " + dResult[0] + "\n" + "y1: " + dResult[1]);
                break;
            }
            case 2:
            {
                double iFactor = Terminal.readDouble("Geben Sie den Faktor an");
                double[] dResult = mult(vec2, iFactor);
                System.out.println("Das Ergebnis ist: ");
                System.out.println("x2: " + dResult[0] + "\n" + "y2: " + dResult[1]);
                break;
            }
            default:
            {
                System.out.println("Keine gültige Eingabe! Multiplikation übersprungen.");
                break;
            }
        }

        System.out.println("\nVektor 1 + Vektor 2:");
        double[] result = plus(vec1, vec2);
        System.out.println("x: " + result[0] + "\ny: " + result[1]);

        System.out.println("\nVektor 1 - Vektor 2:");
        result = minus(vec1, vec2);
        System.out.println("x: " + result[0] + "\ny: " + result[1]);

        iVectorSwitch = Terminal.readInt("Welchen Vektor möchten Sie rotieren? 1 oder 2");
        switch (iVectorSwitch)
        {
            case 1:
            {
                int deg = Terminal.readInt("Um wie viel Grad möchten Sie Vektor 1 rotieren");
                double[] dResult = rotate2d(vec1, deg);
                System.out.println("Das Ergebnis ist: ");
                System.out.println("x1: " + dResult[0] + "\n" + "y1: " + dResult[1]);
                break;
            }
            case 2:
            {
                int deg = Terminal.readInt("Um wie viel Grad möchten Sie Vektor 2 rotieren");
                double[] dResult = rotate2d(vec2, deg);
                System.out.println("Das Ergebnis ist: ");
                System.out.println("x2: " + dResult[0] + "\n" + "y2: " + dResult[1]);
                break;
            }
            default:
            {
                System.out.println("Ungültige Eingabe! Rotation übersprungen.");
                break;
            }
        }

        iVectorSwitch = Terminal.readInt("Von welchem Vektor möchten Sie den Betrag? 1 oder 2");
        switch (iVectorSwitch)
        {
            case 1:
            {
                double dResult = vlength(vec1);
                System.out.println("Das Ergebnis ist: " + dResult);
                break;
            }
            case 2:
            {
                double dResult = vlength(vec2);
                System.out.println("Das Ergebnis ist: " + dResult);
                break;
            }
            default:
            {
                System.out.println("Ungültige Eingabe! Rotation übersprungen.");
                break;
            }
        }

        System.out.println("\n\n");
    }
    /**
     * Multiplies the elements of <code>vec</code>with scalar
     * factor and returns the result. <code>vec</code> is not
     * changed by this operation!
     */
    public static double[] mult(double[] vec, double factor)
    {
        double[] result = new double[2];
        result[0] = vec[0] * factor;
        result[1] = vec[1] * factor;
        return result;
    }
    /**
     * Adds the vectors <code>vec1</code>and <code>vec2</code>
     * and returns the result. Input vectors are not changed.
     */
    public static double[] plus(double[] vec1, double[] vec2)
    {
        double[] result = new double[2];
        result[0] = vec1[0] + vec2[0];
        result[1] = vec1[1] + vec2[1];
        return result;
    }
    /**
     * Subtracts <code>vec2</code>from <code>vec1</code>and
     * returns the result. Input vectors are not changed.
     */
    public static double[] minus(double[] vec1, double[] vec2)
    {
        double[] result = new double[2];
        result[0] = vec1[0] - vec2[0];
        result[1] = vec1[1] - vec2[1];
        return result;
    }
    /**
     * Rotates the two dimensional vector <code>vec</code>by
     * <code>deg</code>degrees and returns the result.
     */
    public static double[] rotate2d(double vec[], int deg)
    {
        double grad = ((2*Math.PI)/360) * (-deg);
        double[] result = new double[2];
        result[0] = Math.round((vec[0] * Math.cos(grad)) - (vec[1] * (-Math.sin(grad))));
        result[1] = Math.round((vec[0] * (-Math.sin(grad))) + (vec[1] * Math.cos(grad)));
        return result;
    }
    /**value = Math.round(100.0 * value)
     * Returns the Euclidean norm of the vector
     * <code>vec</code>.
     */
    public static double vlength(double[] vec)
    {
        double x = vec[0];
        double y = vec[1];
        double result = Math.sqrt(x*x + y*y);
        return result;
    }
    public static void moleSimulation()
    {
        double[] previousHole = new double[]{0,0};
        double[] nextHole = new double[]{1,0};
        System.out.println("Hole 1: (0,0)");
        System.out.println("Hole 2: (1,0)");
        for(int i = 0; i < 100; i++)
        {
            double[] memory = nextHole;
            nextHole = nextHole(nextHole, previousHole);
            previousHole = memory;
            System.out.println("Hole " + (i + 3) + ": (" + nextHole[0] + " , " + nextHole[1] + ")");
        }
    }
    public static double[] nextHole(double[] nPos, double[] pPos)
    {
        double[] vec = minus(nPos, pPos);
        vec = mult(vec, 0.99);
        vec = rotate(vec, 5);
        double[] nVec = new double[]{vec[0] + nPos[0], vec[1] + nPos[1]};

        return nVec;
    }
    public static double[] rotate(double vec[], int deg)
    {
        double grad = ((2*Math.PI)/360) * (-deg);
        double[] result = new double[2];
        result[0] = (vec[0] * Math.cos(grad)) - (vec[1] * (-Math.sin(grad)));
        result[1] = (vec[0] * (-Math.sin(grad))) + (vec[1] * Math.cos(grad));
        return result;
    }
}
