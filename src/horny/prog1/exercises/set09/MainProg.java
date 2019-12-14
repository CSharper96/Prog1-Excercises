package horny.prog1.exercises.set09;

import horny.prog1.exercises.set09.*;

public class MainProg extends SortingTool
{
    public static void main(String[] args)
    {
        SortingTool sTool = new SortingTool();
        try
        {
            sTool.setInitData();
            sTool.performExperiment_Bubbelsort();
        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }

}
