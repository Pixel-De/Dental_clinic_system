package DentalClinic.Patient;

import DentalClinic.DB.DbConnect;
import com.mysql.cj.xdevapi.Table;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.util.Date;

public class ListController {

    @FXML
    TableView<Patient> patientTable;

    public void initialize(){
        System.out.println("sucks java");
        DbConnect data = new DbConnect();
        if(data.getStatus()!=null){
            System.out.println("db got here");
            ObservableList<Patient> patients = data.PatientList();

            TableColumn<Patient, Button> edit = new TableColumn<>("");
            TableColumn<Patient, Button> delete = new TableColumn<>("");
            TableColumn<Patient,Integer> id = new TableColumn<>("PATIENT ID");
            TableColumn<Patient, String> name = new TableColumn<>("PATIENT NAME");
            TableColumn<Patient, String> parent_name = new TableColumn<>("PARENT NAME");
            TableColumn<Patient, String > gender = new TableColumn<>("GENDER");
            TableColumn<Patient, Integer> age = new TableColumn<>("AGE");
            TableColumn<Patient, String> occupation = new TableColumn<>("OCCUPATION");
            TableColumn<Patient, String> address = new TableColumn<>("ADDRESS");
            TableColumn<Patient, Integer> contact_no = new TableColumn<>("CONTACT NO");
            TableColumn<Patient, Date>  date = new TableColumn<>("DATE");
            TableColumn<Patient, Date> reference = new TableColumn<>("REFERENCE");


            delete.setCellValueFactory(new PropertyValueFactory<Patient, Button>("delete"));
            edit.setCellValueFactory(new PropertyValueFactory<Patient, Button>("edit"));
            id.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("id"));
            name.setCellValueFactory(new PropertyValueFactory<Patient, String>("name"));
            parent_name.setCellValueFactory(new PropertyValueFactory<Patient, String >("parent"));
            gender.setCellValueFactory(new PropertyValueFactory<Patient, String>("gender"));
            age.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("age"));
            occupation.setCellValueFactory(new PropertyValueFactory<Patient, String>("occupation"));
            address.setCellValueFactory(new PropertyValueFactory<Patient, String>("address"));
            contact_no.setCellValueFactory(new PropertyValueFactory<Patient, Integer>("contact"));
            date.setCellValueFactory(new PropertyValueFactory<Patient, Date>("date"));
            reference.setCellValueFactory(new PropertyValueFactory<Patient, Date>("reference"));

            patientTable.setItems(patients);
            patientTable.getColumns().addAll(edit, delete, id, name, parent_name, gender, age
            , occupation, address, contact_no, date, reference);




        }
    }
}
