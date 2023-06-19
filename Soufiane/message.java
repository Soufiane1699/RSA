package RSA.Soufiane;

import java.math.BigInteger;
import java.util.Scanner;

public class message {
    public static BigInteger encrypt(BigInteger m, BigInteger e, BigInteger N) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Geben Sie die Anzahl der Elemente ein: ");
        int n = sc.nextInt();

        BigInteger[] messages = new BigInteger[n];

        for (int i = 0; i < n; i++) {
            System.out.println("Geben Sie das Element ein: " + (i + 1) + " ein");
            messages[i] = sc.nextBigInteger();
        }

        for (BigInteger element : messages) {
            BigInteger c = m.modPow(e, N);
        }
        sc.close();
        return m;
    }
}
