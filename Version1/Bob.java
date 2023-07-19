package RSA.RSA.Version1;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.HashMap;

public class Bob {
    static private BigInteger phi, d;
    static protected BigInteger e = BigInteger.valueOf(65537);
    static HashMap <BigInteger, BigInteger> bob_public_key = new HashMap<>();
    static HashMap <BigInteger, BigInteger> bob_private_key = new HashMap<>();
    static SecureRandom random = new SecureRandom();
    private static int bitlaenge = 16;

    private static BigInteger bob_p(){
        BigInteger p = BigInteger.probablePrime(bitlaenge, random);
        return p;
    }
    private static BigInteger bob_q(){
        BigInteger q = BigInteger.probablePrime(bitlaenge, random);
        return q;
    }
    public static BigInteger bob_N(){
        BigInteger N = bob_p().multiply(bob_q());
        return N;
    }
    public static BigInteger bob_d(){
        d = e.modInverse(phi);
        return d;
    }
    private static BigInteger bob_phi(){
        phi = (bob_p().subtract(BigInteger.ONE).multiply(bob_q().subtract(BigInteger.ONE)));
        return phi;
    }
    public static String getBob_private_key(){
        bob_private_key.put(d, bob_N());
        return bob_private_key.keySet() + " " + bob_private_key.values();
    }
    public static String getBob_public_key() {
        bob_public_key.put(e, bob_N());
        return bob_public_key.keySet() + " " +  bob_public_key.values();
    }
}
