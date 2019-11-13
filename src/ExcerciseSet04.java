import java.util.Stack;

public class ExcerciseSet04
{
    //public static void main(String[] args)
    //{
        //startByteOverflowDemo();
        //demonstrateArithmeticOperations();
        //convertToBinary();
        //convertHexToDec0();
    //}
    /*  30 == 0001 1110
    *   60 == 0011 1100
    *   90 == 0101 1010
    *   120 == 0111 1000
    *   now the "error" occours:
    *   -106 == 1001 0110
    *   -76 == 1011 0100
    *   -46 == 1101 0010
    *   -16 == 1111 0000
    *   14 == 0000 1110
    *   Byte == 2^8 = 256 without negative numbers
    *   Signed Byte == 2^7 => min -128 <-> max 127
    * */
    private static void startByteOverflowDemo()
    {
        byte num = 0;
        int i = 0;
        while (i < 10)
        {
            System.out.print(num + " ");
            num += 30;
            i++;
        }
        System.out.println();
    }
    private static void demonstrateArithmeticOperations()
    {
        int iFirstNum = Terminal.readInt("Please provide a number for the first operand");
        int iSecondNum = Terminal.readInt("Please provide a number for the second operand");
        System.out.println(iFirstNum + " + " + iSecondNum + " = " + (iFirstNum + iSecondNum));
        System.out.println(iFirstNum + " - " + iSecondNum + " = " + (iFirstNum - iSecondNum));
        System.out.println(iFirstNum + " * " + iSecondNum + " = " + (iFirstNum * iSecondNum));
        System.out.println(iFirstNum + " / " + iSecondNum + " = " + (iFirstNum / iSecondNum));
        System.out.println(iFirstNum + " % " + iSecondNum + " = " + (iFirstNum % iSecondNum) + "\t\t%");
        System.out.println(iFirstNum + " % " + iSecondNum + " = " + Math.floorMod(iFirstNum , iSecondNum) + "\t\tMath.floorMod");
        System.out.println("Java nutzt beide!\n% => gleiches Vorzeichen wie Dividend\nMath.floorMod => gleiches Vorzeichen wie Divisor");
    }
    private static void convertToBinary()
    {
        int num = Terminal.readInt("Please provide a positive number");
        Stack<String> binaryConverterStack = new Stack<>();
        do
        {
            if (num % 2 == 0) binaryConverterStack.push("0 ");
            else binaryConverterStack.push("1 ");
            num /= 2;
        } while(num != 0);
        while (binaryConverterStack.size() < 8)
            binaryConverterStack.push("0 ");
        String strOut = "";
        while (binaryConverterStack.size() > 0) strOut += binaryConverterStack.pop();
        System.out.println("From right (LSB) to left (MSB)\nMSB <- LSB");
        System.out.println(strOut);
    }
    private static void convertHexToDec0()
    {
        //Code 13 => CR ^M
        //Bedeutung: Carriage Return, Zeilenumbruch.
        System.out.print("Please provide a hexadecimal number (e.g. 1f): ");
        int resultStr = 0;
        int resultHex = 0;
        char ch = Terminal.readChar();
        String str = "";
        while(ch != '\n')
        {
            str += ch;
            int code = ch;
            System.out.println(ch + " -> "+ code);
            int d = convertToNumberChar(ch);
            resultHex = 16*resultHex + d;
            ch = Terminal.readChar();
        }
        resultStr = convertToNumberStr(str);
        System.out.println("Corresponding decimal number (via String): " + resultStr);
        System.out.println("Corresponding decimal number (via char): " + resultHex);
    }
    private static int convertToNumberStr(String str) //Aufwand mit String wesentlich geringer als mit char
    {                                             //mit String wäre auch Integer.ParseInt als Einzeiler gegangen
        String digits = "0123456789ABCDEF";
        str = str.toUpperCase();
        int val = 0;
        for (int i = 0; i < str.length(); i++)
        {
            char c = str.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }
    private static int convertToNumberChar(char hex)
    {
        String digits = "0123456789abcdef";
        int d = digits.indexOf(hex);
        return d;
    }
}
