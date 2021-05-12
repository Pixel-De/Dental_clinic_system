package DentalClinic.Administration.ClinicInformation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class ClinicInfoController {

    @FXML
    private HBox upBox;

    @FXML
    private Label labelBright;

    @FXML
    private TextField txtFieldClinicName;

    @FXML
    private TextField txtFieldClinicPhone;

    @FXML
    private TextField txtFieldClinicAddress;

    @FXML
    private TextField txtFieldClinicReportHeader;

    @FXML
    private TextField txtFieldClinicReportFooter;

    @FXML
    private ImageView ClinicInfoPicture;

    @FXML
    private Hyperlink ClinicInfoHyper;

    @FXML
    private Button closeButton;

    @FXML
    private Button btnSave;

    @FXML
    void btnCloseAction(ActionEvent event) {

    }

    @FXML
    void btnSaveAction(ActionEvent event) {

    }

    @FXML
    void saveDoctor(MouseEvent event) {

    }

}
