package RSA;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class encrypt {
        List <BigInteger> messages = new ArrayList<>();

        messages.add(new BigInteger("78"));
        messages.add(new BigInteger("105"));
        messages.add(new BigInteger("99"));
        messages.add(new BigInteger("108"));
        messages.add(new BigInteger("97"));
        messages.add(new BigInteger("115"));

        BigInteger e = new BigInteger("65537");
        BigInteger N = new BigInteger("117349");

        for (BigInteger m : messages) {
            BigInteger c = m.modPow(e, N);
            System.out.println("Das entschlüsselte  Zeichen ist: " + c);
        }

}