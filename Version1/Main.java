package RSA.RSA.Version1;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Version 1.0
 * @Info Aktuell geht es nur von Alice nach Bob.
 */

public class Main {
    public static String message;
    private static BigInteger e = BigInteger.valueOf(65537);
    public static BigInteger getE(){
        return e;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Herzlich Willkommen im RSA-Tool. ");
        System.out.println("--------------------------------");
        System.out.println("Bobs Public Key: " + Bob.getBob_public_key());
        System.out.println("Alice Public Key: " + Alice.getAlice_public_key());
        System.out.println("Alice:           Message:            Bob:");
        System.out.println();
        System.out.println("   /\\            _____                 /\\");
        System.out.println("  /  \\          <     >               /  \\");
        System.out.println(" (    )         |  M  |              (    )");
        System.out.println("  \\__/          |_____|               \\__/");
        System.out.println(" /    \\            |                  /    \\");
        System.out.println("< ---- >     ------+------>         < ---- >");
        System.out.println(" \\____/            |                  \\____/");
        System.out.println("-----------------------------------------------");
        System.out.println("Enter a message.");
        message = sc.next();
        StringtoAscii.processMessage();
        Decrypt.decrypt();
    }
}
//
