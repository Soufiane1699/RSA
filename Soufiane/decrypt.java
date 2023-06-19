package RSA.Soufiane;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class decrypt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Wie viele Elemente möchten Sie eingeben?");
        int n = sc.nextInt();

        BigInteger[] messages = new BigInteger[n];

        for (int i = 0; i < n; i++) {
            System.out.printf("Geben Sie das Element " + (i + 1) + " ein:");
            messages[i] = sc.nextBigInteger();
        }

        // druckt das Arrays aus
        for (int i = 0; i < n; i++) {
            System.out.println("Element " + (i + 1) + ": " + messages[i]);
        }

        System.out.println("Geben Sie den Wert für e ein: ");
        BigInteger e = sc.nextBigInteger();

        System.out.println("Geben Sie den Wert für N ein: ");
        BigInteger N = sc.nextBigInteger();

        System.out.println("Geben Sie den Wert für d ein: ");
        BigInteger d = sc.nextBigInteger();

        sc.close();

        for (BigInteger c : messages) {
            BigInteger m = c.modPow(d, N);
            System.out.println("Das verschlüsselte Zeichen ist: " + m);
        }
    }
}