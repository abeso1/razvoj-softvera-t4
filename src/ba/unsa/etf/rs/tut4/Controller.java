package ba.unsa.etf.rs.tut4;

import javafx.event.ActionEvent;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class Controller {

    public TextArea unEditAble;
    public TextArea areaZaArtikle;
    public ChoiceBox choiceBocArtikli;
    public Spinner spinKol;
    public TextArea aktuelniRacun;
    private ArrayList<Artikal> lista = new ArrayList<>();
    private static ArrayList<String> listaispisivanja = new ArrayList<>();
    private static Double ukupno= Double.valueOf(0);

    public void dodajArtikle(ActionEvent actionEvent) {
        String artikli = areaZaArtikle.getText();
        String[] listArtikla = artikli.split("\n");
        for(int i=0; i<listArtikla.length; i++){
            String[] artikl = listArtikla[i].split(",");
            String sifra=artikl[0];
            String naziv=artikl[1];
            double cijena=Double.parseDouble(artikl[2]);
            lista.add(new Artikal(sifra,naziv,cijena));
        }
        Artikal.izbaciDuplikate(lista);
        String ispisivanje="";
        for(int i=0; i<lista.size(); i++){
            ispisivanje+=Artikal.toString(lista.get(i));
            ispisivanje+="\n";
        }
        unEditAble.setText(ispisivanje);

        for (int i=0; i<lista.size(); i++){
            choiceBocArtikli.getItems().add(lista.get(i).getSifra());
        }

    }

    public void dodajUKorpu(ActionEvent actionEvent) {
        int value = (Integer)spinKol.getValue();
        String artikl= String.valueOf(choiceBocArtikli.getValue());
        Artikal praviatrikl= new Artikal();
        for(int i=0; i<lista.size(); i++){
            if(artikl.equals(lista.get(i).getSifra())){
                praviatrikl=lista.get(i);
            }
        }
        ukupno+=praviatrikl.getCijena()*value;
        listaispisivanja.add(String.format("%10s%7d%9.2f",artikl, value, praviatrikl.getCijena()*value));
        StringBuilder ispisivanje= new StringBuilder();
        for(int i=0; i<listaispisivanja.size(); i++){
            ispisivanje.append(listaispisivanja.get(i));
            ispisivanje.append("\n");
        }
        ispisivanje.append(String.format("UKUPNO%17.2f", ukupno));
        aktuelniRacun.setText(ispisivanje.toString());
    }


}
