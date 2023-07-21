package RSA.RSA.Version1;

import java.math.BigInteger;

public class CheckOperation {
    private static BigInteger berechneDecryptMessage(BigInteger m, BigInteger e, BigInteger N){
        BigInteger ergebnis = m.modPow(e, N);
        return ergebnis;
    }

    public static void main(String[] args) {
        BigInteger result = berechneDecryptMessage(BigInteger.valueOf(72), BigInteger.valueOf(65537),
                BigInteger.valueOf(2232732373L));
        System.out.println(result);
    }
}
