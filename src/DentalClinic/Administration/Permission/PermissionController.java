package DentalClinic.Administration.Permission;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

public class PermissionController {

    @FXML
    private HBox upBox;

    @FXML
    private Label lblBright;

    @FXML
    private ChoiceBox<?> param;

    @FXML
    private TextField criteria;

    @FXML
    private TableView<?> PermissionTable;

    @FXML
    private Button btnSave;

    @FXML
    private Button btnClose;

    @FXML
    void btnCloseAction(ActionEvent event) {

    }

    @FXML
    void btnSaveAction(ActionEvent event) {

    }

    @FXML
    void refresh(MouseEvent event) {

    }

}
