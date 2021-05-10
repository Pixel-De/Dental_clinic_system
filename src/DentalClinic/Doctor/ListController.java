package DentalClinic.Doctor;

import DentalClinic.DB.DbConnect;
import DentalClinic.Patient.Patient;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import javax.print.Doc;
import java.util.Date;

public class ListController {
    @FXML
    TableView<Doctor> doctorTable;

    public void initialize(){
        System.out.println("sucks java");
        DbConnect data = new DbConnect();
        if(data.getStatus()!=null){
            System.out.println("db got here");
            ObservableList<Doctor> doctors = data.DoctorList();
            doctors.forEach(doctor -> {
                Button btn = doctor.getEdit();
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
}
