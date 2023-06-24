package RSA.Automated;
import java.math.BigInteger;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    static BigInteger p, q, n, phi, e, d;

    public static void main(String[] args) {
        JFrame frame = new JFrame("RSA Key Generator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBackground(Color.GREEN);
        frame.setSize(700, 500);
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
                p = BigInteger.valueOf(primeGenerator.getRandomPrime());
                q = BigInteger.valueOf(primeGenerator.getRandomPrime());
                n = p.multiply(q);
                pField.setText(String.valueOf(p));
                qField.setText(String.valueOf(q));
                nField.setText(String.valueOf(n));
            }
        });

        phiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BigInteger phi = (p.subtract(BigInteger.valueOf(1)).multiply(q.subtract(BigInteger.valueOf(1))));
                phiField.setText(String.valueOf(phi));
            }
        });

        yesNoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                int diaglogResult = JOptionPane.showConfirmDialog(null, "Möchten Sie E auf 65537 setzen?", "Bestätigung", JOptionPane.YES_NO_OPTION);
                if (diaglogResult == JOptionPane.YES_OPTION) {
                    e =  BigInteger.valueOf(65537);
                    eField.setText(String.valueOf(e));
                    publicKey.setText("Public Key lautet: " + n + ", E: " + e);
                }
            }
        });

        JButton privateKeyButton = new JButton("Berechnen von d (Private Key)");
        privateKeyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                phi = (p.subtract(BigInteger.ONE)).multiply(q.subtract(BigInteger.ONE));
                BigInteger d = e.modInverse(phi);
                privateKey.setText("Der Private Key lautet: " + d + " " + e);
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

        frame.add(privateKeyButton);
        frame.add(new JLabel("Private Key lautet: " ));
        frame.add(privateKey);

        frame.setVisible(true);
    }
}
