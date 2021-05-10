package DentalClinic.Doctor;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

public class InformationController implements Initializable {
    @FXML
    TextField idField, nameField, specialityField, qualificationField, contactField;
    @FXML
    TextArea addressArea;
    @FXML
    DatePicker datePicker;
    private String name , speciality, qualification, address;
    private int id, contact;
    private Date date;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        idField.setText(String.valueOf(id));
        nameField.setText(name);
        specialityField.setText(speciality);
        qualificationField.setText(qualification);
        addressArea.setText(address);
        contactField.setText(String.valueOf(contact));
        //date set hiigeegui bainaa.

    }
    public InformationController(Doctor doctor){
        name  = doctor.getName();
        speciality = doctor.getSpeciality();
        qualification = doctor.getQualification();
        address = doctor.getAddress();
        id = doctor.getId() ;
        contact = doctor. getContact();
        date = doctor.getDate();
    }
    public InformationController(){

    }
}
