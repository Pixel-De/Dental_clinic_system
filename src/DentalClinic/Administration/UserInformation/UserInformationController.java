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
import javafx.stage.Stage;

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
    private String fullname,usertype,designation,username;
    private Integer id, contact;
    private Date join_date;

    ObservableList<String> Jobtypes = FXCollections.observableArrayList("Administrator", "Doctor, Receptionist, Cashier, Assistant");

    private DbConnect db = new DbConnect();

    public void initialize(URL url, ResourceBundle resourceBundle) {

        txtUserID.setText(id.toString());
        txtFullname.setText(fullname);
        txtUsername.setText(username);
        txtDesignation.setText(designation);
//        txtRePassword.setText(passwordu);
        txtContact.setText(String.valueOf(contact));
        UserInformationDatepicker.setValue(join_date.toLocalDate());
        comboUserType.setItems(Jobtypes);

    }
    public UserInformationController(User u) {
        fullname = u.getFullname();
        usertype = u.getUsertype();
        designation = u.getDesignation();
        username = u.getUsername();
        id = u.getId();
        contact = u.getContact();
        join_date = u.getJoin_date();

    }
    public void updateUser(){
        String fn = txtFullname.getText();
        String UN = txtUsername.getText();
        String Desig = txtDesignation.getText();
        int i = Integer.valueOf(txtUserID.getText());
        int cont = Integer.valueOf(txtContact.getText());
        String pass = txtPassword.getText();
        LocalDate day = UserInformationDatepicker.getValue();
//        boolean f = db.UpdateUser(i, fn, UN, Desig, pass, cont, day);
//
//        if (f){
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Update");
//            alert.setContentText("Successfully updated.");
//            alert.show();
//        }
    }




    @FXML
    void btnCloseAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    void btnResetAction(ActionEvent event) {
        txtFullname.setText("");
        txtContact.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txtUserID.setText("");
        txtDesignation.setText("");
        UserInformationDatepicker.setValue(null);
    }

    @FXML
    void btnSaveAction(ActionEvent event) {

    }

    @FXML
    void refresh(MouseEvent event) {

    }


}
