package DentalClinic.Administration.Permission;

import DentalClinic.Administration.ListOfUser.User;
import DentalClinic.DB.DbConnect;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;


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
    private Button btnSave, btnClose;
    private  CheckBox checkBox1;

    private DbConnect db = new DbConnect();
    private ObservableList<String> checkBoxList = FXCollections.observableArrayList();
    public void initialize(URL url, ResourceBundle resourceBundle){
        TableColumn<User, String> action = new TableColumn<>("ACTION NAME");
        action.setCellValueFactory(new PropertyValueFactory<User, String>("ACTION NAMES"));
        checkBox1 = new CheckBox();
        checkBox1.setOnAction(e ->{
            checkBoxList.add(checkBox1.getText());
        });
    }

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
