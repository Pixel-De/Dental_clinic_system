package DentalClinic.Administration.UserInformation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

public class UserInformationController {

    @FXML
    private HBox upBox;

    @FXML
    private Label lblBright;

    @FXML
    private AnchorPane AnchorBord;

    @FXML
    private TextField txtUserID;

    @FXML
    private TextField txtFullname;

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private TextField txtRePassword;

    @FXML
    private TextField txtDesignation;

    @FXML
    private TextField txtContact;

    @FXML
    private ComboBox<?> comboUserType;

    @FXML
    private DatePicker UserInformationDatepicker;

    @FXML
    private Button btnReset;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnClose;

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
