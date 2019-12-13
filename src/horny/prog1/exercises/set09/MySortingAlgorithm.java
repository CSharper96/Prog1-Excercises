package horny.prog1.exercises.set09;

public class MySortingAlgorithm {
    public static void main(String[] args)
    {
        int[] data = new int[]{8,1,6,4,7,3,2,5,9};
        for (int i = data.length-1; i > 0; i--)
        {
            for (int k = 0; k < i; k++)
            {
                if (data[k] > data[k+1])
                {
                    int tmp = data[k];
                    data[k] = data[k+1];
                    data[k+1] = tmp;
                }
            }
        }
    }
}
