package RSA.Soufiane;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class encrypt {
        public static BigInteger e;
        public static BigInteger N;
        public static BigInteger[] encryption(String ascii_message) {
                Scanner sc = new Scanner(System.in);

                System.out.println("Geben Sie die Anzahl der Elemente ein: ");
                int n = sc.nextInt();

                BigInteger[] messages = new BigInteger[n];

                for (int i = 0; i < n; i++) {
                        System.out.println("Geben Sie das Element ein: " + (i + 1) + " ein");
                        messages[i] = sc.nextBigInteger();
                }

                // druckt das Array aus
                for (int i = 0; i < n; i++) {
                        System.out.println("Element " + (i + 1) + " : " + messages[i]);
                }

                System.out.println("Soll für e der Standardwert genommen werden: (true/false)");

                BigInteger e;
                if (eingabe) {

                }
                System.out.println("Geben Sie den Wert für E ein: ");
                e = sc.nextBigInteger();

                System.out.println("Geben Sie den Wert für N ein: ");
                N = sc.nextBigInteger();

                sc.close();

                for (BigInteger m : messages) {
                        BigInteger c = m.modPow(e, N);
                        System.out.println("Das verschlüsselte Zeichen ist: " + c);
                }
        return messages;
        }
}