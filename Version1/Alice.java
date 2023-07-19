package RSA.RSA.Version1;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;

public class Alice {
    static protected BigInteger e = BigInteger.valueOf(65537);
    static private BigInteger phi, d;
    static HashMap <BigInteger, BigInteger> alice_public_key = new HashMap<>();
    static HashMap <BigInteger, BigInteger> alice_private_key = new HashMap<>();
    static SecureRandom random = new SecureRandom();
    private static int bitlaenge = 16;
    public static BigInteger alice_p(){
        BigInteger p = BigInteger.probablePrime(bitlaenge, random);
        return p;
    }
    public static BigInteger alice_q(){
        BigInteger q = BigInteger.probablePrime(bitlaenge, random);
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
        phi = (alice_p().subtract(BigInteger.ONE)).multiply(alice_q().subtract(BigInteger.ONE));
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
