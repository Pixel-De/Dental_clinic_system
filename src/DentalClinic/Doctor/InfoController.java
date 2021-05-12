package DentalClinic.Doctor;

import DentalClinic.DB.DbConnect;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.time.ZoneId;
import java.sql.Date;

public class InfoController {

    @FXML
    TextField idField, nameField, specialityField, qualificationField, contactField;
    @FXML
    TextArea addressArea;
    @FXML
    DatePicker datePicker;
    @FXML
    Button closeButton;
    DbConnect db = new DbConnect();
    public void saveDoctor(){
        String name = nameField.getText();
        String speciality = specialityField.getText();
        String qualification = qualificationField.getText();
        String address = addressArea.getText();

        int id = Integer.valueOf(idField.getText());
        int contact = Integer.valueOf(contactField.getText());

        Date date = Date.valueOf(datePicker.getValue());

        boolean f = db.AddDoctor(id, name, speciality, qualification, address, contact, date);
        if(f){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Saved");
            alert.setContentText("Successfully saved.");
            alert.show();
        }
    }

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public void reset(){
        nameField.setText("");
        specialityField.setText("");
        qualificationField.setText("");
        addressArea.setText("");
        idField.setText("");
        contactField.setText("");
        datePicker.setValue(null);
    }
}
