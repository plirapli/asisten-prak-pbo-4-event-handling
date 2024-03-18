package BangunRuang;

import BangunDatar.Persegi;

/**
 *
 * @author rafli
 */
public class Balok extends Persegi implements OperasiBangunRuang {
    final double tinggi;

    public Balok(double panjang, double lebar, double tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    public double getTinggi() {
        return tinggi;
    }

    @Override
    public double Volume() {
        return this.Luas() * this.tinggi;
    }

    @Override
    public double LuasPermukaan() {
        double p = getPanjang();
        double l = getLebar();
        double t = getTinggi();
        
        return 2 * ((p * l) + (p * t) + (l * t));
    }   
}
