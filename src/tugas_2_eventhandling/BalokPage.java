package tugas_2_eventhandling;

import BangunDatar.Persegi;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 *
 * @author rafli
 */
public class BalokPage extends JFrame implements ActionListener {
    JLabel header = new JLabel();
    JLabel subheader = new JLabel("Tentukan panjang, lebar, dan tinggi untuk menghitung Balok");
    JLabel labelPanjang = new JLabel("Panjang");
    JLabel labelLebar = new JLabel("Lebar");
    JLabel labelTinggi = new JLabel("Tinggi");

    JLabel labelHasil = new JLabel("Hasil");
    JLabel labelLuas = new JLabel("Luas Persegi");
    JLabel labelKeliling = new JLabel("Keliling Persegi");
    JLabel labelVolume = new JLabel("Volume Balok");
    JLabel labelLuasPermukaan = new JLabel("Luas Permukaan Balok");

    JLabel labelHasilLuas = new JLabel("[Hasil berupa angka]");
    JLabel labelHasilKeliling = new JLabel("[Hasil berupa angka]");
    JLabel labelHasilVolume = new JLabel("[Hasil berupa angka]");
    JLabel labelHasilLuasPermukaan = new JLabel("[Hasil berupa angka]");

    JTextField inputPanjang = new JTextField();
    JTextField inputLebar = new JTextField();
    JTextField inputTinggi = new JTextField();

    JButton tombolHasil = new JButton("Hitung");
    JButton tombolReset = new JButton("Reset");

    BalokPage(String username, String jenisKelamin) {
        String panggilan = (jenisKelamin == "l") ? "Mr. " : "Mrs. ";

        setVisible(true);
        setSize(480, 480);
        setTitle("Halaman Utama");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocationRelativeTo(null);

        add(header);
        add(subheader);

        add(labelPanjang);
        add(labelLebar);
        add(labelTinggi);
        add(inputPanjang);
        add(inputLebar);
        add(inputTinggi);

        add(tombolHasil);
        add(tombolReset);

        add(labelHasil);
        add(labelLuas);
        add(labelKeliling);
        add(labelVolume);
        add(labelLuasPermukaan);

        add(labelHasilLuas);
        add(labelHasilKeliling);
        add(labelHasilVolume);
        add(labelHasilLuasPermukaan);
        
        // Memberikan tulisan pada label header
        header.setText("Welcome, " + panggilan + username);
        header.setFont(header.getFont().deriveFont(20.0f));
        header.setBounds(20, 20, 440, 24);
        subheader.setBounds(20, 50, 440, 16);

        labelPanjang.setBounds(20, 84, 84, 32);
        inputPanjang.setBounds(150, 84, 310, 32);

        labelLebar.setBounds(20, 120, 84, 32);
        inputLebar.setBounds(150, 120, 310, 32);

        labelTinggi.setBounds(20, 156, 84, 32);
        inputTinggi.setBounds(150, 156, 310, 32);

        tombolHasil.setBounds(14, 200, 452, 36);
        tombolReset.setBounds(14, 240, 452, 36);

        labelHasil.setHorizontalAlignment(SwingConstants.CENTER);
        labelHasil.setBounds(20, 290, 440, 16);
        labelLuas.setBounds(20, 320, 150, 16);
        labelKeliling.setBounds(20, 350, 150, 16);
        labelVolume.setBounds(20, 380, 150, 16);
        labelLuasPermukaan.setBounds(20, 410, 150, 16);

        labelHasilLuas.setBounds(200, 320, 280, 16);
        labelHasilKeliling.setBounds(200, 350, 280, 16);
        labelHasilVolume.setBounds(200, 380, 280, 16);
        labelHasilLuasPermukaan.setBounds(200, 410, 280, 16);

        tombolHasil.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tombolHasil) {
            double panjang = Double.parseDouble(inputPanjang.getText());
            double lebar = Double.parseDouble(inputLebar.getText());
            double tinggi = Double.parseDouble(inputTinggi.getText());

            Persegi bangun1 = new Persegi(panjang, lebar);

            String hasilLuas = String.valueOf(bangun1.Luas());
            String hasilKeliling = String.valueOf(bangun1.Keliling());

            labelHasilLuas.setText(hasilLuas);
            labelHasilKeliling.setText(hasilKeliling);
        } else if (e.getSource() == tombolReset) {
            // Berikan aksi jika tombol reset diklik
        }
    }
}
