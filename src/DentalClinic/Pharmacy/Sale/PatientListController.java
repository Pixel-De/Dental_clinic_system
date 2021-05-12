package DentalClinic.Pharmacy.Sale;

import DentalClinic.DB.DbConnect;
import DentalClinic.Patient.Patient;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.util.Date;

public class PatientListController {

    @FXML
    TableView<Patient> patientTable;
    @FXML
    ChoiceBox<String> param;
    @FXML
    TextField criteria;
    @FXML
    Button closeButton;

    private ObservableList<String> params = FXCollections.observableArrayList("PatientID", "PatientName");
    private DbConnect db = new DbConnect();
    private ObservableList<Patient> patients = FXCollections.observableArrayList();
    private ObservableList<Patient> tempPat = FXCollections.observableArrayList();

    @FXML
    public void initialize(){

        patients = db.PatientList();
        param.setItems(params);

        param.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number old, Number new_val)->{
            criteria.setEditable(true);
        });

        criteria.textProperty().addListener(((observableValue, old, new_val) -> {
            if(param.getValue() == params.get(0)){
                if(new_val != ""){
                    patientTable.setItems(filterId(Integer.valueOf(new_val)));
                }
            } else if(param.getValue() == params.get(1)){
                if(new_val != "") {
                    patientTable.setItems(filterName(new_val));
                }
            }
        }));

        TableColumn<Patient, Button> check = new TableColumn<>("");
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


        check.setCellValueFactory(new PropertyValueFactory<Patient, Button>("check"));
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
        patientTable.getColumns().addAll(check, id, name, parent_name, gender, age
                , occupation, address, contact_no, date, reference);

    }

    public ObservableList<Patient> filterId(int id){
        tempPat.clear();
        patients.forEach(patient -> {
            if(Integer.valueOf(patient.getId()) == id){
                if(!tempPat.contains(patient)){
                    tempPat.add(patient);
                }
            }
        });

        return tempPat;

    }
    public ObservableList<Patient> filterName(String name){
        tempPat.clear();
        patients.forEach(product -> {
            if(product.getName().toLowerCase().contains(name)){
                if(!tempPat.contains(product)){
                    tempPat.add(product);
                }
            }
        });
        return tempPat;
    }
    public void refresh(){
        patients = db.PatientList();
        patientTable.setItems(patients);
    }
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
