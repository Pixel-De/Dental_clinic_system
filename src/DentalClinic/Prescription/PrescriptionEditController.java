package DentalClinic.Prescription;

import DentalClinic.DB.DbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class PrescriptionEditController {

    @FXML
    TextField preIdField,patientNameField, ageField, genderField;
    @FXML
    DatePicker datePicker;
    @FXML
    ComboBox<String> patientBox;
    @FXML
    TableView<PrescriptionFull> preTableView;

    ObservableList<PrescriptionFull> prescriptionFullList = FXCollections.observableArrayList();
    DbConnect  db = new DbConnect();


    public PrescriptionEditController(PrescriptionFull prescriptionFull){

        preIdField.setText(prescriptionFull.getId());
        preIdField.setEditable(false);
        patientNameField.setText(prescriptionFull.getName());
        patientNameField.setEditable(false);
        ageField.setText(prescriptionFull.getAge());
        ageField.setEditable(false);
        genderField.setText(prescriptionFull.getGender());
        genderField.setEditable(false);

//        prescriptionFullList = db.G





    }

}
