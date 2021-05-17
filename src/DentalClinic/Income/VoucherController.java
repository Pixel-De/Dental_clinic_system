package DentalClinic.Income;

import DentalClinic.DB.DbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.print.attribute.standard.JobStateReason;

public class VoucherController {

    @FXML
    TextField voucherIdField, refNumberField, amountField, remarkField;
    @FXML
    ComboBox<String> accountBox, paymentMethodBox;
    @FXML
    DatePicker datePicker;
    @FXML
    RadioButton revenueRadioButton, expenseRadioButton;
    @FXML
    Button closeButton;

    private ToggleGroup toggleGroup = new ToggleGroup();

    private ObservableList<AccountModel> accountModels = FXCollections.observableArrayList();
    private ObservableList<String> paymentMethods = FXCollections.observableArrayList("CARD", "CASH");
    private ObservableList<String> accountModelStr = FXCollections.observableArrayList();

    DbConnect db = new DbConnect();

    public void initialize(){

        accountModels = db.GetAllAccount();
        accountModels.forEach(accountModel -> {
            accountModelStr.add(accountModel.getName());

        });
        accountBox.setItems(accountModelStr);
        if(accountModelStr.size() != 0){
            accountBox.getSelectionModel().selectFirst();
        }

        revenueRadioButton.setToggleGroup(toggleGroup);
        expenseRadioButton.setToggleGroup(toggleGroup);

        paymentMethodBox.setItems(paymentMethods);
        paymentMethodBox.getSelectionModel().selectFirst();

    }

    public void save(){
        Alert alert ;
        try{
//            String v_type = toggleGroup.getSelectedToggle();

//            System.out.println(v_type);


        }catch(Exception e){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.showAndWait();
        }


    }
    public void reset(){

    }
    public void showAccount(){

        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("./ChartOfAccounts.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle("Chart of Account");
            stage.setScene(scene);
            closeButtonAction();
            stage.showAndWait();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
