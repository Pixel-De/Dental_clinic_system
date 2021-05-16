package DentalClinic.Prescription;

import DentalClinic.DB.DbConnect;
import DentalClinic.Doctor.Doctor;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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
    TableView<PrescriptionFull> preTable; // turluu bicig ugnu

    private ObservableList<String> params = FXCollections.observableArrayList("Prescription ID", "Patient Name");
    private ObservableList<PrescriptionFull> prescriptionFulls = FXCollections.observableArrayList();

    DbConnect db = new DbConnect();
    public void initialize(){

        ObservableList<PresCriptionMain> presCriptionMains = FXCollections.observableArrayList();
        prescriptionFulls = db.PrescriptionList();


        prescriptionFulls.forEach(prescriptionFull -> {
            Button edit = prescriptionFull.getEdit();
            edit.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    PrescriptionEditController pEditCont = new PrescriptionEditController(prescriptionFull);
                    try{

                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("./PrescriptionEdit.fxml"));
                        loader.setController(pEditCont);
                        Scene scene = new Scene(loader.load());
                        Stage stage = new Stage();
                        stage.setTitle("Prescription Edit");
                        stage.setScene(scene);
                        stage.showAndWait();

                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            });
        });

        TableColumn<PrescriptionFull, Button> edit = new TableColumn<>("");
        TableColumn<PrescriptionFull, Button> delete = new TableColumn<>("");
        TableColumn<PrescriptionFull,String> id = new TableColumn<>("PRESCRIPTION ID");
        TableColumn<PrescriptionFull, String> p_id = new TableColumn<>("PATIENT NAME");
        TableColumn<PrescriptionFull, String> p_name = new TableColumn<>("PATIENT NAME");
        TableColumn<PrescriptionFull, String > age = new TableColumn<>("AGE");


        delete.setCellValueFactory(new PropertyValueFactory<PrescriptionFull, Button>("delete"));
        edit.setCellValueFactory(new PropertyValueFactory<PrescriptionFull, Button>("edit"));
        id.setCellValueFactory(new PropertyValueFactory<PrescriptionFull, String>("id"));
        p_id.setCellValueFactory(new PropertyValueFactory<PrescriptionFull, String>("patient_id"));
        p_name.setCellValueFactory(new PropertyValueFactory<PrescriptionFull, String >("name"));
        age.setCellValueFactory(new PropertyValueFactory<PrescriptionFull, String>("age"));

        preTable.setItems(prescriptionFulls);
        preTable.getColumns().addAll(edit, delete, id, p_id, p_name, age);


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
