package RSA.Automated;
import java.util.Random;

class PrimeNumberGenerator {
    private Random random = new Random();

    public int getRandomPrime() {
        int num;
        do {
            num = random.nextInt(100000);
        } while (!isPrime(num));
        return num;
    }

    private boolean isPrime(int num) {
        if (num <= 1) return false;
        if (num <= 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (int i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0)
                return false;
        }
        return true;
    }
}
