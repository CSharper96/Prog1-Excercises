package horny.prog1.exercises.set09;

public class SortingAlgorithm
{
    public int[] bubbelsort(int[] data, int length)
    {
        for (int i = length-1; i > 0; i--)
        {
            for (int k = 0; k < i; k++)
            {
                if (data[k] > data[k+1])
                {
                    int tmp = data[k];
                    data[k] = data[k+1];
                    data[k+1] = tmp;
                    updateArray(data);
                }
            }
        }
        return data;
    }
    public int[] selectionsort(int[] data, int length)
    {
        for(int i = 0; i < length - 1; i++)
        {
            int minPos = i;
            for(int j = i + 1; j < length; j++)
                if(data[j] < data[minPos])
                    minPos = j;
            int tmp = data[i];
            data[i] = data[minPos];
            data[minPos] = tmp;
            updateArray(data);
        }
        return data;
    }
    public int[] insertionsort(int[] data, int length)
    {
        updateArray(data);
        for(int i = 1; i < length; i++)
        {
            int insertVal = data[i];
            int insertPos = i;
            while(insertPos > 0 && data[insertPos - 1] > insertVal)
            {
                data[insertPos] = data[insertPos - 1];
                insertPos--;
                updateArray(data);
            }
            data[insertPos] = insertVal;
            //updateArray(data);
        }
        return data;
    }
    private void updateArray(int[] data)
    {
        System.out.println();
        for(int value : data)
        {
            System.out.print(value + "\t");
        }
    }
}
