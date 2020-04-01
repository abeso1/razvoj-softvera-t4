package ba.unsa.etf.rs.tut4;

import static javafx.scene.layout.Region.USE_COMPUTED_SIZE;
import static org.junit.jupiter.api.Assertions.*;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.testfx.api.FxRobot;
import org.testfx.framework.junit5.ApplicationExtension;
import org.testfx.framework.junit5.Start;

import javax.print.DocFlavor;

@ExtendWith(ApplicationExtension.class)
class ControllerTest {
    @Start
    public void start (Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/tutorijal3.fxml"));
        stage.setTitle("Kasa");
        stage.setScene(new Scene(root, USE_COMPUTED_SIZE, USE_COMPUTED_SIZE));
        stage.show();
        stage.toFront();
    }

    @Test
    void TestArtikalTab(FxRobot robot){
        Button dodajArt = robot.lookup("#dodajAtrikleBtn").queryAs(Button.class);
        TextArea textArea1 = robot.lookup("#unEditAble").queryAs(TextArea.class);
        TextArea textArea2 = robot.lookup("#areaZaArtikle").queryAs(TextArea.class);
        assertNotNull(dodajArt);
        assertNotNull(textArea1);
        assertNotNull(textArea2);
    }

    @Test
    void TestRacunTab(FxRobot robot){
        robot.clickOn("#racunTab");
        Button dodajArt = robot.lookup("#dodajAtrikleBtn").queryAs(Button.class);
        TextArea artikli = robot.lookup("#aktuelniRacun").queryAs(TextArea.class);
        Spinner spin = robot.lookup("#spinKol").queryAs(Spinner.class);
        ChoiceBox choices = robot.lookup("#choiceBocArtikli").queryAs(ChoiceBox.class);
        assertNotNull(dodajArt);
        assertNotNull(artikli);
        assertNotNull(spin);
        assertNotNull(choices);
    }

    @Test
    void dodavanjeArtikala1(FxRobot robot){
        TextArea area2 = robot.lookup("#unEditAble").queryAs(TextArea.class);
        TextArea area1 = robot.lookup("#areaZaArtikle").queryAs(TextArea.class);
        Button dodajArt = robot.lookup("#dodajAtrikleBtn").queryAs(Button.class);
        robot.clickOn("#areaZaArtikle");
        robot.write("ABC,Proizvod,1");
        robot.clickOn(dodajArt);
        String inArea = area2.getText();
        assertEquals("ABC, Proizvod, 1.0\n", inArea);
    }

    @Test
    void dodavanjeArtikala2(FxRobot robot){
        TextArea area2 = robot.lookup("#unEditAble").queryAs(TextArea.class);
        TextArea area1 = robot.lookup("#areaZaArtikle").queryAs(TextArea.class);
        Button dodajArt = robot.lookup("#dodajAtrikleBtn").queryAs(Button.class);
        robot.clickOn("#areaZaArtikle");
        robot.write("ABC,Proizvod,1\nABC,Proizvod,2\nABC,Proizvod,4");
        robot.clickOn(dodajArt);
        String inArea = area2.getText();
        assertEquals("ABC, Proizvod, 1.0\nABC, Proizvod, 2.0\nABC, Proizvod, 4.0\n", inArea);
    }

    @Test
    void dodavanjeIstihArtikala(FxRobot robot){
        TextArea area2 = robot.lookup("#unEditAble").queryAs(TextArea.class);
        TextArea area1 = robot.lookup("#areaZaArtikle").queryAs(TextArea.class);
        Button dodajArt = robot.lookup("#dodajAtrikleBtn").queryAs(Button.class);
        robot.clickOn("#areaZaArtikle");
        robot.write("ABC,Proizvod,1\nABC,Proizvod,1\nABC,Proizvod,4");
        robot.clickOn(dodajArt);
        String inArea = area2.getText();
        assertEquals("ABC, Proizvod, 1.0\nABC, Proizvod, 4.0\n", inArea);
    }

    @Test
    void nedodavanjeArtikala(FxRobot robot){
        TextArea area2 = robot.lookup("#unEditAble").queryAs(TextArea.class);
        TextArea area1 = robot.lookup("#areaZaArtikle").queryAs(TextArea.class);
        Button dodajArt = robot.lookup("#dodajAtrikleBtn").queryAs(Button.class);
        robot.clickOn("#areaZaArtikle");
        robot.write("");
        robot.clickOn(dodajArt);
        String inArea = area2.getText();
        assertEquals("", inArea);
    }

    @Test
    void JedanArtikalPaDrugi(FxRobot robot){
        TextArea area2 = robot.lookup("#unEditAble").queryAs(TextArea.class);
        TextArea area1 = robot.lookup("#areaZaArtikle").queryAs(TextArea.class);
        Button dodajArt = robot.lookup("#dodajAtrikleBtn").queryAs(Button.class);
        robot.clickOn(area1);
        robot.write("ABC,Proizvod,1");
        robot.clickOn(dodajArt);
        String inArea = area2.getText();
        assertEquals("ABC, Proizvod, 1.0\n", inArea);
        robot.clickOn(area1);
        robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.write("ABC,Proizvod,2");
        robot.clickOn(dodajArt);
        String inArea2 = area2.getText();
        assertEquals("ABC, Proizvod, 1.0\nABC, Proizvod, 2.0\n", inArea2);
    }

    @Test
    void JedanArtikalPaDrugiIsti(FxRobot robot){
        TextArea area2 = robot.lookup("#unEditAble").queryAs(TextArea.class);
        TextArea area1 = robot.lookup("#areaZaArtikle").queryAs(TextArea.class);
        Button dodajArt = robot.lookup("#dodajAtrikleBtn").queryAs(Button.class);
        robot.clickOn(area1);
        robot.write("ABC,Proizvod,1");
        robot.clickOn(dodajArt);
        String inArea = area2.getText();
        assertEquals("ABC, Proizvod, 1.0\n", inArea);
        robot.clickOn(area1);
        robot.press(KeyCode.CONTROL).press(KeyCode.A).release(KeyCode.A).release(KeyCode.CONTROL);
        robot.write("ABC,Proizvod,1");
        robot.clickOn(dodajArt);
        String inArea2 = area2.getText();
        assertEquals("ABC, Proizvod, 1.0\n", inArea2);
    }
}