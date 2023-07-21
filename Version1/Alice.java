package RSA.RSA.Version1;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;
/*
Wichtig P und Q müssen als Klassenvariablen gespeichert werden,
dadurch wird P und Q nur dann generiert wenn diese noch nicht initalisiert wurden
Dadurch wird sichergestellt, dass dieselben Werte von P und Q verwendet werden, wenn N
und phi berechnet werden.
 */

public class Alice {
    static protected BigInteger e = BigInteger.valueOf(65537);
    static private BigInteger phi, d;
    static private BigInteger p, q;
    static HashMap <BigInteger, BigInteger> alice_public_key = new HashMap<>();
    static HashMap <BigInteger, BigInteger> alice_private_key = new HashMap<>();
    static SecureRandom random = new SecureRandom();
    private static int bitlaenge = 16;
    private static BigInteger alice_p(){
        if (p == null){
            p = BigInteger.probablePrime(bitlaenge, random);
        }
        return p;
    }
    private static BigInteger alice_q(){
        if (q == null){
            q = BigInteger.probablePrime(bitlaenge, random);
        }
        return q;
    }
    public static BigInteger alice_N(){
        BigInteger N = alice_p().multiply(alice_q());
        return N;
    }
    private static BigInteger alice_d(){
        d = e.modInverse(phi);
        return d;
    }
    private static BigInteger alice_phi(){
        if (phi == null){
            phi = (alice_p().subtract(BigInteger.ONE)).multiply(alice_q().subtract(BigInteger.ONE));

        }
        return phi;
    }
    public static String getAlice_private_key(){
        alice_private_key.put(d, alice_N());
        return alice_public_key.keySet() + " " + alice_public_key.values();
    }
    public static String getAlice_public_key(){
        alice_public_key.put(e, alice_N());
        return alice_public_key.keySet() + " " + alice_public_key.values();
    }
}
