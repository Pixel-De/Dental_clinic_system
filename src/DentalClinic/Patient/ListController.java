package DentalClinic.Patient;

import DentalClinic.DB.DbConnect;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListController {

    @FXML
    TableView<Patient> patientTable;

    public void initialize(){
        System.out.println("sucks java");
        DbConnect data = new DbConnect();
        if(data.getStatus()!=null){
            System.out.println("db got here");
            ObservableList<Patient> patients = data.PatientList();
            patients.forEach(patient -> {
                System.out.println(patient.getId()+" "+patient.getName());
            });





        }
    }
}
