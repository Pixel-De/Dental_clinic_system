package DentalClinic.Doctor;

import DentalClinic.DB.DbConnect;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class InformationController implements Initializable {
    @FXML
    TextField idField, nameField, specialityField, qualificationField, contactField;
    @FXML
    TextArea addressArea;
    @FXML
    DatePicker datePicker;
    @FXML
    Button closeButton;
    private String name , speciality, qualification, address;
    private int id, contact;
    private Date date;

    private DbConnect db = new DbConnect();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        idField.setText(String.valueOf(id));
        nameField.setText(name);
        specialityField.setText(speciality);
        qualificationField.setText(qualification);
        addressArea.setText(address);
        contactField.setText(String.valueOf(contact));
        datePicker.setValue(date.toLocalDate());

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
    public void updateDoctor(){
        String n = nameField.getText();
        String spe = specialityField.getText();
        String qu = qualificationField.getText();
        String addr = addressArea.getText();

        int i = Integer.valueOf(idField.getText());
        int con = Integer.valueOf(contactField.getText());

        Date d = Date.valueOf(datePicker.getValue());

        boolean f = db.UpdateDoctor(i, n, spe, qu, addr, con, d);
        System.out.println(f);

    }
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

    public InformationController(){

    }
}
