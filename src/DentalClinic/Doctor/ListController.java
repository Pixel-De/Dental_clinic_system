package DentalClinic.Doctor;

import DentalClinic.DB.DbConnect;
import DentalClinic.Patient.Patient;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.print.Doc;
import java.util.Date;
import java.util.Optional;

public class ListController {
    @FXML
    TableView<Doctor> doctorTable;
    @FXML
    Button closeButton;
    @FXML
    TextField criteria;
    @FXML
    ChoiceBox<String> param;

    private ObservableList<String> params = FXCollections.observableArrayList("DoctorID", "DoctorName");
    private ObservableList<Doctor> doctors = FXCollections.observableArrayList();
    private ObservableList<Doctor> tempPat = FXCollections.observableArrayList();

    private DbConnect db = new DbConnect();

    public void initialize(){
        Alert alert  = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Patient");
        alert.setContentText("Are you sure you want to delete this record?");

        param.setItems(params);

        param.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number old, Number new_val)->{
            criteria.setEditable(true);
        });

        criteria.textProperty().addListener(((observableValue, old, new_val) -> {
            if(param.getValue() == params.get(0)){
                if(new_val != ""){
                    doctorTable.setItems(filterId(Integer.valueOf(new_val)));
                }
            } else if(param.getValue() == params.get(1)){
                if(new_val != "") {
                    doctorTable.setItems(filterName(new_val));
                }
            }
        }));

        if(db.getStatus()!=null){
            System.out.println("db got here");
            doctors = db.DoctorList();
            doctors.forEach(doctor -> {
                Button btn = doctor.getEdit();
                Button delBtn = doctor.getDelete();
                btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        DentalClinic.Doctor.InformationController lc = new InformationController(doctor);
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("./InformationView.fxml"));
                            loader.setController(lc);
                            Scene scene = new Scene(loader.load());
                            Stage stage = new Stage();
                            stage.setTitle("Doctor Update");
                            stage.setScene(scene);
                            stage.showAndWait();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                delBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Optional<ButtonType> result = alert.showAndWait();
                        if(result.get()==ButtonType.OK){
                            int delID = doctor.getId();
                            boolean f = db.DeleteDoctor(delID);
                            System.out.println(delID);
                            doctors.remove(doctor);
                        }
                    }
                });
            });
            TableColumn<Doctor, Button> edit = new TableColumn<>("");
            TableColumn<Doctor, Button> delete = new TableColumn<>("");
            TableColumn<Doctor,Integer> id = new TableColumn<>("DOCTOR ID");
            TableColumn<Doctor, String> name = new TableColumn<>("DOCTOR NAME");
            TableColumn<Doctor, String> speciality = new TableColumn<>("SPECIALITY");
            TableColumn<Doctor, String > qualification = new TableColumn<>("QUALIFICATION");
            TableColumn<Doctor, String> address = new TableColumn<>("ADDRESS");
            TableColumn<Doctor, Integer> contact_no = new TableColumn<>("CONTACT NO");
            TableColumn<Doctor, Date> date = new TableColumn<>("date");


            delete.setCellValueFactory(new PropertyValueFactory<Doctor, Button>("delete"));
            edit.setCellValueFactory(new PropertyValueFactory<Doctor, Button>("edit"));
            id.setCellValueFactory(new PropertyValueFactory<Doctor, Integer>("id"));
            name.setCellValueFactory(new PropertyValueFactory<Doctor, String>("name"));
            speciality.setCellValueFactory(new PropertyValueFactory<Doctor, String >("speciality"));
            qualification.setCellValueFactory(new PropertyValueFactory<Doctor, String>("qualification"));
            address.setCellValueFactory(new PropertyValueFactory<Doctor, String>("address"));
            contact_no.setCellValueFactory(new PropertyValueFactory<Doctor, Integer>("contact"));
            date.setCellValueFactory(new PropertyValueFactory<Doctor, Date>("date"));

            doctorTable.setItems(doctors);
            doctorTable.getColumns().addAll(edit, delete, id, name, speciality, qualification, address, contact_no, date);

        }
    }
    public void refresh(){
        doctors = db.DoctorList();
        doctorTable.setItems(doctors);
    }
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public ObservableList<Doctor> filterId(int id){
        tempPat.clear();
        doctors.forEach(patient -> {
            if(patient.getId() == id){
                if(!tempPat.contains(patient)){
                    tempPat.add(patient);
                }
            }
        });

        return tempPat;
    }
    public  ObservableList<Doctor> filterName(String name){
        tempPat.clear();
        doctors.forEach(patient -> {
            if(patient.getName().toLowerCase().contains(name)){
                if(!tempPat.contains(patient)){
                    tempPat.add(patient);
                }
            }
        });
        return tempPat;
    }
}
