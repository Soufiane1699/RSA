package RSA.RSA.Version1;

public class StringtoAscii extends Main {
    static String message = Main.message;
    static char[] ascii = message.toCharArray();

    public static void processMessage(){
        for (char m: ascii) {
            System.out.println((int) m + " ");
        }
    }

    public static char[] getAscii(){
        return ascii;
    }
}
