package DentalClinic.Prescription;

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


    public PrescriptionEditController(PrescriptionFull prescriptionFull){

        preIdField.setText(prescriptionFull.getId());
        preIdField.setEditable(false);
        patientNameField.setText(prescriptionFull.getName());
        ageField.setText(prescriptionFull.getAge());



    }

}
