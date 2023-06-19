package RSA.Soufiane;
import java.io.*;
import java.math.BigInteger;

public class key_generator {
    public static void main(String[] args)throws Exception {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        BigInteger e = new BigInteger("65537");

        System.out.println("Geben Sie eine Primzahl ein: (Wert p)");
        String ersteZahl = br.readLine();
        System.out.println("Geben Sie eine Primzahl ein: (Wert q)");
        String zweiteZahl = br.readLine();

        BigInteger p = new BigInteger(ersteZahl);
        BigInteger q = new BigInteger(zweiteZahl);

        BigInteger N = p.multiply(q);
        // System.out.println(N);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        System.out.println(phi);

        System.out.println("Public Key: " + e + " " + N);

        BigInteger d = e.modInverse(phi);
        System.out.println("Private Key: " + d + " " + N);
    }
}