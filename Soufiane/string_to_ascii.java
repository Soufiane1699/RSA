package RSA;
import java.io.*;
import java.util.ArrayList;

public class string_to_ascii {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Geben Sie eine Zeichenkette ein: ");
        String eingabe = br.readLine();

        for (int i=0; i< eingabe.length(); i++) {
            char zeichen = eingabe.charAt(i);
            int asciiwert = (int) zeichen;

            System.out.println("Das Zeichen " + zeichen + " hat den ASCII-Wert: " + asciiwert);
        }
    }
}