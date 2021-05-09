package DentalClinic.Patient;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.w3c.dom.Text;

//import java.awt.*;
import java.io.IOException;
import java.time.LocalDate;
import java.time.ZoneId;

public class InformationController {

    @FXML
    TextField id, name, parent, address, contact, age, occupation;
//    @FXML
//    ChoiceBox<String> gender;
//    @FXML
//    DatePicker reference, date;

    public InformationController(){

    }
    public InformationController(Patient p){
//        id.setText(p.getId().toString());
//        name.setText(p.getName());
//        parent.setText(p.getParent());
//        address.setText(p.getAddress());
//        contact.setText(p.getContact().toString());
//        age.setText(p.getAge().toString());
//        occupation.setText(p.getOccupation());
//        gender.setValue(p.getGender());
//        LocalDate ref = p.getReference().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        reference.setValue(ref);
//        LocalDate d = p.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        date.setValue(d);
    }
    public void initialize(){
//        gender.getItems().add("Male");
//        gender.getItems().add("Female");
    }
    public void showInformation(){
        FXMLLoader loader = new FXMLLoader(getClass().getResource("./InformationView.fxml"));
        Parent rootDocInfo = null;
        try {
            rootDocInfo = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(rootDocInfo));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
