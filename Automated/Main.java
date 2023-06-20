package RSA.Automated;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static int p, q, n, phi, exponent;

    public static void main(String[] args) {
        JFrame frame = new JFrame("RSA Key Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.GREEN);
        frame.setSize(500, 500);
        frame.setLayout(new FlowLayout());

        PrimeNumberGenerator primeGenerator = new PrimeNumberGenerator();

        JButton primeButton = new JButton("Primzahlen generieren");
        JButton yesNoButton = new JButton("E auf Default setzen (65537)");
        JButton phiButton = new JButton("Berechnen von phi(p * q) ");
        JTextField pField = new JTextField(10);
        JTextField qField = new JTextField(10);
        JTextField nField = new JTextField(10);
        JTextField phiField = new JTextField(10);
        JTextField eField = new JTextField(10);
        JTextField publicKey = new JTextField(20);
        JTextField privateKey = new JTextField(20);
        // Bestimmt ob der Text in diesem Textfeld geändert werden darf oder nicht
        pField.setEditable(false);
        qField.setEditable(false);
        nField.setEditable(false);
        phiField.setEditable(false);
        eField.setEditable(false);

        primeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                p = primeGenerator.getRandomPrime();
                q = primeGenerator.getRandomPrime();
                n = p * q;
                pField.setText(String.valueOf(p));
                qField.setText(String.valueOf(q));
                nField.setText(String.valueOf(n));
            }
        });

        phiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int phi = (p -1) * (q - 1);
                phiField.setText(String.valueOf(phi));
            }
        });

        yesNoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int diaglogResult = JOptionPane.showConfirmDialog(null, "Möchten Sie E auf 65537 setzen?", "Bestätigung", JOptionPane.YES_NO_OPTION);
                if (diaglogResult == JOptionPane.YES_OPTION) {
                    int exponent = 65537;
                    eField.setText(String.valueOf(exponent));
                    publicKey.setText("Public Key lautet: " + n + ", E: " + exponent);
                }
            }
        });


        frame.add(new JLabel("Primzahl p: "));
        frame.add(pField);

        frame.add(new JLabel("Primzahl q: "));
        frame.add(qField);

        frame.add(primeButton);
        frame.add(new JLabel("N = p * q:"));
        frame.add(nField);

        frame.add(phiButton);
        frame.add(new JLabel("phi(p * q) : "));
        frame.add(phiField);

        frame.add(yesNoButton);
        frame.add(new JLabel("Wert von E: "));
        frame.add(eField);

        frame.add(new JLabel("Public Key lautet: "));
        frame.add(publicKey);

        frame.setVisible(true);

    }
}
