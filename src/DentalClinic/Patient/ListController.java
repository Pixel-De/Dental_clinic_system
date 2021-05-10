package DentalClinic.Patient;

import DentalClinic.DB.DbConnect;
import DentalClinic.Pharmacy.productList.ProductUpdateController;
import com.mysql.cj.xdevapi.Table;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

public class ListController {

    @FXML
    TableView<Patient> patientTable;
    @FXML
    Button closeButton;

    DbConnect db = new DbConnect();

    ObservableList<Patient> patients = FXCollections.observableArrayList();
    public void initialize(){
        Alert alert  = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Patient");
        alert.setContentText("Are you sure you want to delete this record?");

        System.out.println("sucks java");
        DbConnect data = new DbConnect();
        if(data.getStatus()!=null){
            System.out.println("db got here");
            patients = data.PatientList();
            patients.forEach(patient -> {
                Button b = patient.getEdit();
                Button dell = patient.getDelete();
                b.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {

                        InformationController lc = new InformationController(patient);
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("./InformationView.fxml"));
                            loader.setController(lc);
                            Scene scene = new Scene(loader.load());
                            Stage stage = new Stage();
                            stage.setTitle("Patient Update");
                            stage.setScene(scene);
                            stage.showAndWait();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                //delete

                dell.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {

                        Optional<ButtonType> result = alert.showAndWait();
                        if(result.get()==ButtonType.OK){
                            int delID = patient.getId();
                            boolean f = db.DeletePatient(delID);
                            System.out.println(delID);
                            patients.remove(patient);
                        }
                    }
                });
                System.out.println(patient.getId()+" "+patient.getName());
            });

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

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public void refresh(){
        patients = db.PatientList();
        patientTable.setItems(patients);
    }
}
