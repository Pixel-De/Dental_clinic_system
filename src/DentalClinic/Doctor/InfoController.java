package DentalClinic.Doctor;

import DentalClinic.DB.DbConnect;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.ZoneId;
import java.sql.Date;

public class InfoController {

    @FXML
    TextField idField, nameField, specialityField, qualificationField, contactField;
    @FXML
    TextArea addressArea;
    @FXML
    DatePicker datePicker;
    DbConnect db = new DbConnect();
    public void saveDoctor(){
        String name = nameField.getText();
        String speciality = specialityField.getText();
        String qualification = qualificationField.getText();
        String address = addressArea.getText();

        int id = Integer.valueOf(idField.getText());
        int contact = Integer.valueOf(contactField.getText());

        Date date = Date.valueOf(datePicker.getValue());

        // db ruu save hiih uildel.
    }
}
