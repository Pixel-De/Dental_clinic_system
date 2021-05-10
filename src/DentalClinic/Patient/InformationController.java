package DentalClinic.Patient;

import DentalClinic.DB.DbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

//import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class InformationController implements Initializable {

    @FXML
    TextField id, name, parent, contact, age, occupation;
    @FXML
    ChoiceBox<String> gender;
    @FXML
    DatePicker reference, date;
    @FXML
    TextArea address;

    private String nameText, parentText, genderText, occupationText, addressText;
    private Integer idInt, ageInt, contactInt;
    private Date referDate, dateDate;

    ObservableList<String> genders = FXCollections.observableArrayList("Female", "Male");

    DbConnect db = new DbConnect();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        gender.setItems(genders);
        id.setText(idInt.toString());
        name.setText(nameText);
        parent.setText(parentText);
        address.setText(addressText);
        contact.setText(contactInt.toString());
        age.setText(ageInt.toString());
        occupation.setText(occupationText);
        gender.getSelectionModel().select(genderText);
        // reference date bolon date dutuu baigaa aldaa zaaj baigaa ucir
    }
    public InformationController(Patient p){
        nameText = p.getName();
        parentText = p.getParent();
        genderText = p.getGender();
        occupationText = p.getOccupation();
        addressText = p.getAddress();
        idInt = p.getId();
        ageInt = p.getAge();
        contactInt = p.getAge();
        referDate = p.getReference();
        dateDate = p.getDate();
    }


    public void updatePatient(){
        String n  = name.getText();
        String par = parent.getText();
        String gen = gender.getValue();
        String occup = occupation.getText();
        String addr = address.getText();
        int i = Integer.valueOf(id.getText());
        int ag = Integer.valueOf(age.getText());
        int cont = Integer.valueOf(contact.getText());
        LocalDate refLoc = reference.getValue();
        Date ref = Date.from(refLoc.atStartOfDay(ZoneId.systemDefault()).toInstant());
        LocalDate dLoc = date.getValue() ;
        Date d = Date.from(dLoc.atStartOfDay(ZoneId.systemDefault()).toInstant());

    }
    public InformationController(){


    }


}
