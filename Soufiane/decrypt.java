package RSA_Github.Soufiane;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class decrypt {
    public static void main(String[] args) {
        List <BigInteger> messages = new ArrayList<>();

        messages.add(new BigInteger("14206"));
        messages.add(new BigInteger("98538"));
        messages.add(new BigInteger("28159"));
        messages.add(new BigInteger("68228"));
        messages.add(new BigInteger("6883"));
        messages.add(new BigInteger("41872"));

        BigInteger d = new BigInteger("113433");
        BigInteger N = new BigInteger("117349");

        for (BigInteger c : messages) {
            BigInteger m = c.modPow(d, N);
            System.out.println("Das verschlüsselte Zeichen ist: " + m);
        }
    }
}