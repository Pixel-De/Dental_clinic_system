package DentalClinic.Income;

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

    private ToggleGroup toggleGroup = new ToggleGroup();

    private ObservableList<AccountModel> accountModels = FXCollections.observableArrayList();
    private ObservableList<String> paymentMethods = FXCollections.observableArrayList("CARD, CASH");

    public void initialize(){

        revenueRadioButton.setToggleGroup(toggleGroup);
        expenseRadioButton.setToggleGroup(toggleGroup);

        paymentMethodBox.setItems(paymentMethods);
        paymentMethodBox.getSelectionModel().selectFirst();

    }

    public void showAccount(){

        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("./ChartOfAccounts.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle("Chart of Account");
            stage.setScene(scene);
            stage.showAndWait();

        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
