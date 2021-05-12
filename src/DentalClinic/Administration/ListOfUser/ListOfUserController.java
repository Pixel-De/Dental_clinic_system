package DentalClinic.Administration.ListOfUser;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ListOfUserController {

    @FXML
    private ChoiceBox<?> param;

    @FXML
    private TextField criteria;

    @FXML
    private TableView<?> ListOfUserTable;

    @FXML
    private Button btnRefresh;

    @FXML
    private Button closeButton;

    @FXML
    void btnRefreshAction(ActionEvent event) {

    }

    @FXML
    void closeButtonAction(ActionEvent event) {

    }

    @FXML
    void refresh(MouseEvent event) {

    }

}
