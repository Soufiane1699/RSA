package RSA.RSA.Version1;
/*
Verschlüsselung c = m^(e) mod N
 */

import java.math.BigInteger;

public class Decrypt {
    private BigInteger N;
    private BigInteger m;
    static char[] chars = StringtoAscii.getAscii();

    public static void decrypt(){
        for(char ch : chars){
            BigInteger m = BigInteger.valueOf((int) ch);
            BigInteger c = m.modPow(Main.getE(), Bob.bob_N());
            System.out.println("Der Wert für c ist: " + c);
        }
    }

}
