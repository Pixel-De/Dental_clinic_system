package DentalClinic.Administration.UserInformation;

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

import java.sql.Date;
import java.time.LocalDate;

public class UserInfoController {
    @FXML
    HBox upBox;
    @FXML
    Label lblBright;
    @FXML
    AnchorPane Anchor1;
    @FXML
    TextField txtUserID ,txtFullname,txtUsername,txtPassword,txtRePassword,txtDesignation,txtContact;
    @FXML
    ComboBox<String> comboUserType;
    @FXML
    DatePicker UserInformationDatepicker;
    @FXML
    AnchorPane Anchor2;
    @FXML
    AnchorPane Anchor3;
    @FXML
    Button btnReset;
    @FXML
    Button btnClose;
    ObservableList<String> JobTypes= FXCollections.observableArrayList("Administrator", "Doctor", "Receptionist", "Cashier", "Assistant");
    private DbConnect db = new DbConnect();
    public void initialize(){
        comboUserType.setItems(JobTypes);
        comboUserType.getSelectionModel().selectFirst();
    }

    public void saveUser(){
        String fn = txtFullname.getText();
        String UN = txtUsername.getText();
        String Desig = txtDesignation.getText();
        int i = Integer.valueOf(txtUserID.getText());
        String cont = txtContact.getText();
        String pass = txtPassword.getText();
        LocalDate day = UserInformationDatepicker.getValue() ;
        Date d = Date.valueOf(day);
        String type = comboUserType.getValue();
        boolean Lee = db.AddUser(fn, Desig, UN ,cont, type,pass, Date.valueOf(day));

        if(Lee){
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
        UserInformationDatepicker.setValue(null);
    }
    @FXML
    void btnCloseAction(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }


}

