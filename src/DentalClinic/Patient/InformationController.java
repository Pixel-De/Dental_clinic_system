package DentalClinic.Patient;

import DentalClinic.DB.DbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import org.w3c.dom.Text;

//import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;
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
    @FXML
    Button closeButton;

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
        reference.setValue(referDate.toLocalDate());
        date.setValue(dateDate.toLocalDate());
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
        Date ref = Date.valueOf(refLoc);
        LocalDate dLoc = date.getValue() ;
        Date d = Date.valueOf(dLoc);

        boolean f = db.UpdatePatient(i, n, par, gen, ag, occup, addr, cont, ref, d);

        if(f){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Update");
            alert.setContentText("Successfully updated.");
            alert.show();
        }


    }

    public void reset(){
        name.setText("");
        parent.setText("");
        gender.getSelectionModel().selectFirst();
        occupation.setText("");
        address.setText("");
        id.setText("");
        age.setText("");
        contact.setText("");
        reference.setValue(null);
        date.setValue(null);
    }

    @FXML
    private void closeButtonAction(){
        // get a handle to the stage
        Stage stage = (Stage) closeButton.getScene().getWindow();
        // do what you have to do
        stage.close();
    }


    public InformationController(){}


}
