package DentalClinic.Income;

import DentalClinic.DB.DbConnect;
import DentalClinic.Prescription.PrescriptionFull;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class ChartOfAccountsController {
    @FXML
    ComboBox<String> accountBox, statusBox;
    @FXML
    TextField accID, accName;
    @FXML
    TableView<AccountModel> accountTable;
    @FXML
            Button closeButton;


    ObservableList<String> accountType = FXCollections.observableArrayList("Expense", "Revenue");
    ObservableList<String> statusType = FXCollections.observableArrayList("Active", "Deactive");
    ObservableList<AccountModel> accountModels = FXCollections.observableArrayList();

    DbConnect db = new DbConnect();


    public void initialize(){

        accountBox.setItems(accountType);
        accountBox.getSelectionModel().selectFirst();
        statusBox.setItems(statusType);
        statusBox.getSelectionModel().selectFirst();

        accountModels = db.GetAllAccount();

        TableColumn<AccountModel, Button> delete = new TableColumn<>("");
        TableColumn<AccountModel,String> id = new TableColumn<>("ACCOUNT ID");
        TableColumn<AccountModel, String> name = new TableColumn<>( "ACCOUNTS NAME");
        TableColumn<AccountModel, String> type = new TableColumn<>("ACCOUNT TYPE");
        TableColumn<AccountModel, String > status = new TableColumn<>("STATUS");


        delete.setCellValueFactory(new PropertyValueFactory<AccountModel, Button>("delete"));
        id.setCellValueFactory(new PropertyValueFactory<AccountModel, String>("id"));
        name.setCellValueFactory(new PropertyValueFactory<AccountModel, String>("name"));
        type.setCellValueFactory(new PropertyValueFactory<AccountModel, String >("type"));
        status.setCellValueFactory(new PropertyValueFactory<AccountModel, String>("status"));

        accountTable.setItems(accountModels);
        accountTable.getColumns().addAll(delete, id, name, type, status);


    }

    public void saveAccount(){

        String n = accName.getText();
        String t = accountBox.getValue();
        String s = statusBox.getValue();

        boolean f = db.AddAccount(n,t, s);

        Alert alert;
        if(f){
//            accountModels.add()
        }

    }
    public void reset(){

        accName.setText("");
        accountBox.getSelectionModel().selectFirst();
        statusBox.getSelectionModel().selectFirst();

    }
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }

}
