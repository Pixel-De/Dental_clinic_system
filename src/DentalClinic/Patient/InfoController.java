package DentalClinic.Patient;

import DentalClinic.DB.DbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;

public class InfoController {

    @FXML
    TextField id, name, parent, contact, age, occupation;
    @FXML
    ChoiceBox<String> gender;
    @FXML
    DatePicker reference, date;
    @FXML
    TextArea address;

    private ObservableList<String> genders = FXCollections.observableArrayList("Female", "Male");
    DbConnect db = new DbConnect();
    @FXML
    public void initialize(){
        gender.setItems(genders);
        gender.getSelectionModel().selectFirst();
    }
    public void savePatient(){
        String n  = name.getText();
        String par = parent.getText();
        String gen = gender.getValue();
        String occup = occupation.getText();
        String addr = address.getText();
        int i = Integer.valueOf(id.getText());
        int ag = Integer.valueOf(age.getText());
        int cont = Integer.valueOf(contact.getText());
        LocalDate refLoc = reference.getValue();
        Date ref = Date.valueOf(refLoc);
        LocalDate dLoc = date.getValue() ;
        Date d = Date.valueOf(dLoc);
        boolean flag = db.AddPatient(i, n, par, gen,ag, occup, addr, cont, ref, d );
        System.out.println(flag);
    }
}
