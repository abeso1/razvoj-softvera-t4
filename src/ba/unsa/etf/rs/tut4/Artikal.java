package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;
import java.util.Objects;

public class Artikal {
    private String sifra;
    private String naziv;
    private double cijena;
    public Artikal(){}

    public Artikal(String art_sifra, String art_naziv, double art_cijena){
        setSifra(art_sifra);
        setNaziv(art_naziv);
        setCijena(art_cijena);
    }

    public static void izbaciDuplikate(ArrayList<Artikal> lista) {
        for(int i=0; i<lista.size()-1; i++){
            Artikal a1= lista.get(i);
            for(int j=i+1; j<lista.size(); j++){
                Artikal a2= lista.get(j);
                if(a1.equals(a2)) {
                    lista.remove(j);
                    j--;
                }
            }
        }
    }

    public double getCijena() {
        return cijena;
    }

    public void setCijena(double cijena) {
        if(cijena<0) throw new IllegalArgumentException("Cijena je negativna");
        this.cijena = cijena;
    }

    public String getNaziv() {
        return naziv;
    }

    public void setNaziv(String naziv) {
        if(naziv.isEmpty()) throw new IllegalArgumentException("Naziv je prazan");
        this.naziv = naziv;
    }

    public String getSifra() {
        return sifra;
    }

    public void setSifra(String sifra) {
        if(sifra.isEmpty()) throw new IllegalArgumentException("Šifra je prazna");
        this.sifra = sifra;
    }



    @Override
    public boolean equals(Object o) {
        if(!(o instanceof Artikal)) return false;
        Artikal artikal = (Artikal) o;
        return (artikal.sifra == this.sifra && artikal.naziv == this.naziv && artikal.cijena == this.cijena);
    }

    public static String toString(Artikal artikal) {
        return artikal.sifra+", "+artikal.naziv+", "+artikal.cijena;
    }
}
