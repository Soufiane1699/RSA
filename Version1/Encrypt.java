package RSA.RSA.Version1;
/*
Encrypt is: m = c^(d) mod N
 */

import java.math.BigInteger;

public class Encrypt {
    private BigInteger N;
    private BigInteger c;
    static char[] chars;

    public static void encrypt(){
        for (char ch : chars){
            // BigInteger m = Decrypt.decrypt();
            //BigInteger m = c.modPow(d, N);
            //System.out.println("Der Wert für m ist: " + m);
        }
    }
}
