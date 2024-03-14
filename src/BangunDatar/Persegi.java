package BangunDatar;

/**
 *
 * @author rafli
 */

// Class Persegi mengimplementasikan interface OperasiBangunDatar.
// Interface dalam PBO berfungsi sebagai definisi perilaku yang harus dimiliki oleh suatu kelas.
// Di dalam interface OperasiBangunDatar terdapat 2 method, yaitu Luas() dan Keliling().
// Itu artinya, class Persegi wajib memiliki Luas dan Keliling
// Dengan demikian. kedua method tersebut harus di-override, 
// karena suatu method pada interface masih bersifat abstract.
public class Persegi implements OperasiBangunDatar{

    private double panjang, lebar;
    
    public Persegi(double panjang, double lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public double getPanjang() {
        return panjang;
    }

    public void setPanjang(double panjang) {
        this.panjang = panjang;
    }

    public double getLebar() {
        return lebar;
    }

    public void setLebar(double lebar) {
        this.lebar = lebar;
    }
    
    // Membuat sebuah method Luas untuk mengimplementasikan interface OperasiBangunDatar
    @Override
    public double Luas() {
        return panjang * lebar;
    }
    
    // Membuat sebuah method Keliling untuk mengimplementasikan interface OperasiBangunDatar
    @Override
    public double Keliling() {
        return 2 * (panjang + lebar);
    }    
}
