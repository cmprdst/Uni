/**************************************

 2) ackermann(1, 10) = 1024
    ackermann(2, 4) = 65536
    ackermann(3, 3) = 65536

 3) Die Anzahl von Rekursionsschritten nimmt bei der Ackermann-Funktion so rapide zu, dass der allokierte Speicher nicht
    ausreicht, um den Algorithmus terminieren zu können, d.h. noch bevor der Wertebereich des BigInteger verlassen wird,
    wird der Algorithmus aufgrund mangelnden Speichers abgebrochen, sodass keine "ArithmeticException" auftritt, sondern
    es zu einem StackOverflowError kommt. Ein Beispiel dafür ist die Zahlenkombination (2, 5)

***********************************************/
import java.math.BigInteger;

public class AckermannFunction {
    public static BigInteger ackermann(BigInteger x, BigInteger y){
        if (y.equals(BigInteger.ZERO)) return BigInteger.ZERO;
        else if (x.equals(BigInteger.ZERO)) return y.multiply(BigInteger.TWO);
        else if (y.equals(BigInteger.ONE)) return BigInteger.TWO;
        else return ackermann(x.subtract(BigInteger.ONE), ackermann(x, y.subtract(BigInteger.ONE)));
    }
   
    public static void main(String[] args) {
        System.out.println(ackermann(BigInteger.ONE, BigInteger.TEN));
        System.out.println(ackermann(BigInteger.TWO, BigInteger.valueOf(4)));
        System.out.println(ackermann(BigInteger.valueOf(3), BigInteger.valueOf(3)));
   }
}