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
    private TextField txtFieldClinicName, txtFieldClinicPhone, txtFieldClinicAddress, txtFieldClinicReportHeader, txtFieldClinicReportFooter;
    @FXML
    private ImageView ClinicInfoPicture;
    @FXML
    private Hyperlink ClinicInfoHyper;
    @FXML
    private Button closeButton;
    @FXML
    private Button btnSave;

    public void initialize(){


        txtFieldClinicPhone.setText("Phone :443-323-4245");
        txtFieldClinicReportHeader.setText("A smile is a curve that sets everything straight");
        txtFieldClinicName.setText("OraMed Dental Care");
        txtFieldClinicReportFooter.setText("Because you should want to go to your dentist");
        txtFieldClinicAddress.setText("Address:3506  Calvin Street, Salisbury, MD 21875");

    }
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
