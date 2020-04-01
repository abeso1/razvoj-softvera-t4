package ba.unsa.etf.rs.tut4;

import java.util.ArrayList;

public class Racun {
    private  ArrayList<Artikal> artikli=new ArrayList<>();
    private  ArrayList<Integer> kolicine=new ArrayList<>();

    public Racun(){}

    public void dodajStavku(Artikal artikal, int i) {
        setArtikal(artikal);
        setKolicina(i);
    }

    public double ukupanIznos() {
        double suma=0;
        for(int i=0; i<artikli.size(); i++) suma+=artikli.get(i).getCijena()*kolicine.get(i);
        return suma;
    }

    private  void setArtikal(Artikal artikal)  {
        artikli.add(artikal);
    }

    private void setKolicina(Integer kolicina) {
        kolicine.add(kolicina);
    }
}
