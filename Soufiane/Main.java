package RSA.Soufiane;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Geben Sie die erste Primzahl (p) ein: ");
        BigInteger p = sc.nextBigInteger();

        System.out.println("Geben Sie die zweite Primzahl (q) ein: ");
        BigInteger q = sc.nextBigInteger();

        PrimeNumber.isPrime(p);
        PrimeNumber.isPrime(q);

        BigInteger N = (p.multiply(q));
        BigInteger phi = ((p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1)))));

        System.out.println("Soll für e der Standardwert berechnet werden. (true/false)");
        boolean eingabe = sc.nextBoolean();

        BigInteger e;
        if (eingabe) {
            e = new BigInteger("65537");
        } else {
            System.out.println("Geben Sie einen Wert für e ein: ");
            e = sc.nextBigInteger();
        }

        BigInteger d = e.modInverse(phi);

        BigInteger[] public_Key = {e, N};
        BigInteger[] private_Key = {d, N};
        System.out.println("Public Key: " + Arrays.toString(public_Key));
        System.out.println("Private Key: " + Arrays.toString(private_Key));

        String ascii_message = string_to_ascii.convert();
        BigInteger[] encrypted_message = encrypt.encryption(ascii_message);


    }
}