package ba.unsa.etf.rs.tut4;

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
}
