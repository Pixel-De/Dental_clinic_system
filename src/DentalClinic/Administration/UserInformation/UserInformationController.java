package DentalClinic.Administration.UserInformation;

import DentalClinic.Administration.ListOfUser.User;
import DentalClinic.DB.DbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class UserInformationController implements Initializable {

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
    private String fullname,usertype,designation,username,password;
    private Integer id, contact;
    private Date join_date;

    ObservableList<String> JobTypes= FXCollections.observableArrayList("Administrator", "Doctor", "Receptionist", "Cashier", "Assistant");

    private DbConnect db = new DbConnect();

    public void initialize(URL url, ResourceBundle resourceBundle) {
        txtUserID.setText(id.toString());
        txtFullname.setText(fullname);
        txtUsername.setText(username);
        txtDesignation.setText(designation);
        txtPassword.setText(password);
        txtContact.setText(String.valueOf(contact));
        UserInformationDatepicker.setValue(join_date.toLocalDate());
        comboUserType.setItems(JobTypes);
    }
    public UserInformationController(User u) {
        fullname = u.getFullname();
        usertype = u.getUsertype();
        designation = u.getDesignation();
        username = u.getUsername();
        id = u.getId();
        contact = u.getContact();
        join_date = u.getJoin_date();
        System.out.println(u.getUsername());
    }

    public void UpdateUser(){
        String fn = txtFullname.getText();
        String UN = txtUsername.getText();
        String Desig = txtDesignation.getText();
        int i = Integer.valueOf(txtUserID.getText());
        String cont = txtContact.getText();
        String pass = txtPassword.getText();
        LocalDate day = UserInformationDatepicker.getValue() ;
        Date d = Date.valueOf(day);
        String type = comboUserType.getValue();
        boolean k = db.UpdateUser(i,fn,Desig,cont,type);

        if(k){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Saved");
            alert.setContentText("Successfully saved.");
            alert.show();
        }
    }


    @FXML
    public void reset() {
        txtFullname.setText("");
        txtContact.setText("");
        txtUsername.setText("");
        txtPassword.setText("");
        txtUserID.setText("");
        txtDesignation.setText("");
        txtRePassword.setText("");
        UserInformationDatepicker.setValue(null);
    }

    @FXML
    void btnCloseAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
    public UserInformationController(){ }
}
