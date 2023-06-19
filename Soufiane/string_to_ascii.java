package RSA.Soufiane;
import java.util.Scanner;

public class string_to_ascii {
    public static String convert() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Geben Sie eine Zeichenkette ein: ");
        String eingabe = sc.nextLine();

        int[] asciiArray = zeichenZuAsciiArray(eingabe);
        System.out.println("ASCII-Werte der eingegebenen Werte: ");

        for (int i = 0; i < asciiArray.length; i++) {
            System.out.println(eingabe.charAt(i) + " -> " + asciiArray[i]);
        }
        return eingabe;
    }

    public static int[] zeichenZuAsciiArray(String eingabe) {
        int[] asciiArray = new int[eingabe.length()];

        for (int i = 0; i < eingabe.length(); i++) {
            asciiArray[i] = (int) eingabe.charAt(i);
        }
        return asciiArray;
    }
}