package DentalClinic.Administration.UserInformation;

import DentalClinic.Administration.ListOfUser.User;
import DentalClinic.DB.DbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UserInformationController {

    @FXML
    HBox upBox;
    @FXML
    Label lblBright;
    @FXML
    AnchorPane AnchorBord;
    @FXML
    TextField txtUserID ,txtFullname, txtUsername, txtDesignation, txtPassword, txtRePassword, txtContact;
    @FXML
    ComboBox<String> comboUserType;
    @FXML
    DatePicker UserInformationDatepicker;
    @FXML
    Button btnReset, btnSave, btnClose ;
//    private String full_name,user_job,fieldOfArea,user_name;
//    private Integer id, contact_no;
//    private Date joining_date;
//    private DbConnect db = new DbConnect();

//    public void initialize(URL url, ResourceBundle resourceBundle) {
//
//        txtUserID.setText(String.valueOf(id));
//        txtFullname.setText(full_name);
//        txtUsername.setText(user_name);
//        txtDesignation.setText(fieldOfArea);
////        txtRePassword.setText(passwordu);
//        txtContact.setText(String.valueOf(contact_no));
//        UserInformationDatepicker.setValue(joining_date.toLocalDate());
//
//    }
    public UserInformationController(User user) {

    }

//    private  ObservableList<String> comboUserType = FXCollections.observableArrayList("Administrator", "Doctor, Receptionist, Cashier, Assistant");
//
//    public void initializable(){
//        comboUserType.setItems(comboUserType);
//        comboUserType.getSelectionModel().selectFirst();
//    }


    @FXML
    void btnCloseAction(ActionEvent event) {

    }

    @FXML
    void btnResetAction(ActionEvent event) {

    }

    @FXML
    void btnSaveAction(ActionEvent event) {

    }

    @FXML
    void refresh(MouseEvent event) {

    }

}
