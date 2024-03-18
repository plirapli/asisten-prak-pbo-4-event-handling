package tugas_2_eventhandling;

import BangunRuang.Balok;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

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

    JLabel labelHasilLuas = new JLabel();
    JLabel labelHasilKeliling = new JLabel();
    JLabel labelHasilVolume = new JLabel();
    JLabel labelHasilLuasPermukaan = new JLabel();

    JTextField inputPanjang = new JTextField();
    JTextField inputLebar = new JTextField();
    JTextField inputTinggi = new JTextField();

    JButton tombolHasil = new JButton("Hitung");
    JButton tombolReset = new JButton("Reset");

    BalokPage(String username, String jenisKelamin) {
        // Melakukan operasi ternary untuk menentukan apakah user dipanggil "Mr." atau "Mrs."
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
        tombolReset.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tombolHasil) {
            // Kode diapit dalam try catch untuk memberikan error handling
            try {
                // Mengambil inputan panjang, lebar, dan tinggi yang diketik oleh user
                // sekaligus mengkonversinya menjadi bertipe data Double
                Double panjang = Double.valueOf(inputPanjang.getText());
                Double lebar = Double.valueOf(inputLebar.getText());
                Double tinggi = Double.valueOf(inputTinggi.getText());

                /* 
                  Membuat objek bernama bangun dengan class Balok
                  Mengapa yang dibuat hanya class Balok saja dan class Persegi tidak?
                  Karena class Balok merupakan parent class dari class persegi.
                  Sehingga, class balok telah mewarisi sifat-sifat yang dimiliki oleh class Persegi.
                  Dengan demikian, selain dapat mengakses method-method yang dimilikinya,
                  class Balok juga dapat mengakses method-method 
                  yang dimiliki class Persegi, yaitu Luas() dan Keliling().
                */
                Balok bangun = new Balok(panjang, lebar, tinggi);
                
                // Mengakses method Luas() dan Keliling() untuk menghitung persegi
                Double keliling = bangun.Keliling();
                Double luas = bangun.Luas();
                
                // Mengakses method Volume() dan LuasPermukaan() untuk menghitung balok
                Double volume = bangun.Volume();
                Double luasPermukaan = bangun.LuasPermukaan();
                
                // Hasil keliling, luas, volume, dan luas permukaan 
                // yang bertipe data double dikonversi menjadi String agar dapat ditampilkan di layar.
                String hasilKeliling = String.valueOf(keliling);
                String hasilLuas = String.valueOf(luas);
                String hasilVolume = String.valueOf(volume);
                String hasilLuasPermukaan = String.valueOf(luasPermukaan);
                
                // Menampilkan hasil ke frame
                labelHasilKeliling.setText(hasilKeliling);
                labelHasilLuas.setText(hasilLuas);
                labelHasilVolume.setText(hasilVolume);
                labelHasilLuasPermukaan.setText(hasilLuasPermukaan);
            } catch (Exception error) {
                // Menampilkan pesan error dalam bentuk pop-up
                JOptionPane.showMessageDialog(this, error.getMessage());
            }
        } else if (e.getSource() == tombolReset) {
            // Berikan aksi jika tombol reset diklik
            // input menjadi kosong
            inputPanjang.setText("");
            inputLebar.setText("");
            inputTinggi.setText("");

            // label menjadi kosong
            labelHasilLuas.setText("");
            labelHasilKeliling.setText("");
            labelHasilVolume.setText("");
            labelHasilLuasPermukaan.setText("");
        }
    }
}
