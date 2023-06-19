package RSA.Soufiane;

import java.math.BigInteger;

public class PrimeNumber {

    public static void checkIsPrime(BigInteger num) {
        if (isPrime(num)) {
            System.out.println(num + " ist eine Primzahl.");
        } else {
            System.out.println(num + " ist keine Primzahl.");
        }
    }

    public static boolean isPrime(BigInteger num) {
        if (num.compareTo(BigInteger.ONE) <= 0) {
            return false;
        }
        BigInteger i;
        for (i = new BigInteger("2"); i.multiply(i).compareTo(num) <= 0; i=i.add(BigInteger.ONE)) {
            if (num.mod(i).equals(BigInteger.ZERO)) {
                return false;
            }
        }
        return true;
    }
}