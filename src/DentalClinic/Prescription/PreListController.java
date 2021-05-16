package DentalClinic.Prescription;

import DentalClinic.DB.DbConnect;
import DentalClinic.Doctor.Doctor;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.sql.Date;

public class PreListController {

    @FXML
    ChoiceBox<String> param ;
    @FXML
    TextField criteria;
    @FXML
    DatePicker fromPicker, toPicker;
    @FXML
    Button closeButton;
    @FXML
    TableView patientTable; // turluu bicig ugnu

    private ObservableList<String> params = FXCollections.observableArrayList("Prescription ID", "Patient Name");
//    private ObservableList<>

    DbConnect db = new DbConnect();
    public void initialize(){

        ObservableList<PresCriptionMain> presCriptionMains = FXCollections.observableArrayList();

//        TableColumn<Doctor, Button> edit = new TableColumn<>("");
//        TableColumn<Doctor, Button> delete = new TableColumn<>("");
//        TableColumn<Doctor,Integer> id = new TableColumn<>("PRESCRIPTION ID");
//        TableColumn<Doctor, String> p_id = new TableColumn<>("PATIENT NAME");
//        TableColumn<Doctor, String> p_name = new TableColumn<>("PATIENT NAME");
//        TableColumn<Doctor, String > age = new TableColumn<>("AGE");
//
//
//        delete.setCellValueFactory(new PropertyValueFactory<Doctor, Button>("delete"));
//        edit.setCellValueFactory(new PropertyValueFactory<Doctor, Button>("edit"));
//        id.setCellValueFactory(new PropertyValueFactory<Doctor, Integer>("id"));
//        p_id.setCellValueFactory(new PropertyValueFactory<Doctor, String>("name"));
//        p_name.setCellValueFactory(new PropertyValueFactory<Doctor, String >("speciality"));
//        age.setCellValueFactory(new PropertyValueFactory<Doctor, String>("qualification"));
//
//        doctorTable.setItems(doctors);
//        doctorTable.getColumns().addAll(edit, delete, id, name, speciality, qualification, address, contact_no, date);





        param.setItems(params);
        param.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number old, Number new_val)->{
            criteria.setEditable(true);
        });

        criteria.textProperty().addListener(
                ((observableValue, old, new_val) -> {
                    if(param.getValue() == params.get(0)){
                        if(new_val != ""){
//                            doctorTable.setItems(filterId(Integer.valueOf(new_val)));
                        }
                    } else if(param.getValue() == params.get(1)){
                        if(new_val != "") {
//                            doctorTable.setItems(filterName(new_val));
                        }
                    }
                })
        );

    }

    public void searchPres(){

        Date f = Date.valueOf(fromPicker.getValue());
        Date t = Date.valueOf(toPicker.getValue());

        //hebed ugnu

    }
    public void refresh(){

    }
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
            stage.close();
    }

//    public ObservableList<Doctor> filterId(int id){
//        tempPat.clear();
//        doctors.forEach(patient -> {
//            if(patient.getId() == id){
//                if(!tempPat.contains(patient)){
//                    tempPat.add(patient);
//                }
//            }
//        });
//
//        return tempPat;
//    }
//    public  ObservableList<Doctor> filterName(String name){
//        tempPat.clear();
//        doctors.forEach(patient -> {
//            if(patient.getName().toLowerCase().contains(name)){
//                if(!tempPat.contains(patient)){
//                    tempPat.add(patient);
//                }
//            }
//        });
//        return tempPat;
//    }

}
