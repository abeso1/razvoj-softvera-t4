package ba.unsa.etf.rs.tut4;

import javafx.event.ActionEvent;
import javafx.scene.control.TextArea;

import java.util.ArrayList;

public class Controller {

    public TextArea unEditAble;
    public TextArea areaZaArtikle;

    public void dodajArtikle(ActionEvent actionEvent) {
        String artikli = areaZaArtikle.getText();
        String[] listArtikla = artikli.split("\n");
        ArrayList<Artikal> lista = new ArrayList<>();
        for(int i=0; i<listArtikla.length; i++){
            String[] artikl = listArtikla[i].split(",");
            lista.add(new Artikal(artikl[0],artikl[1],Double.parseDouble(artikl[2])));
        }
        System.out.println(lista.size());
        Artikal.izbaciDuplikate(lista);
        String ispisivanje="";
        for(int i=0; i<lista.size(); i++){
            ispisivanje+=Artikal.toString(lista.get(i));
            ispisivanje+="\n";
        }
        unEditAble.setText(ispisivanje);

    }
}
