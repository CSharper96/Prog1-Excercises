public class MainClass
{
    public static void main(String[] args)
    {
        ExerciseSet02 setTwo = new ExerciseSet02();
        int num = Terminal.readInt("Provide a number");
        System.out.println(setTwo.computeSum(num));
        setTwo.printSequence1(num);
        setTwo.printSequence2(num);
        setTwo.printSequence3(num);
        setTwo.printTriangle(num);
    }
}
