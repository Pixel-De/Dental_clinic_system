package DentalClinic.Income;

import DentalClinic.DB.DbConnect;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.print.attribute.standard.JobStateReason;
import java.net.URL;
import java.sql.Date;
import java.util.ResourceBundle;

public class EditVoucherController implements Initializable {
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

    private AccountModel selectedAcc ;
    DbConnect db = new DbConnect();

    VoucherModel voucherModel;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        revenueRadioButton.setToggleGroup(toggleGroup);
        expenseRadioButton.setToggleGroup(toggleGroup);


        paymentMethodBox.setItems(paymentMethods);
        accountBox.setItems(accountModelStr);
        accountBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number t1) {
                System.out.println(t1);
                selectedAcc = accountModels.get((Integer) t1);
            }
        });


        voucherIdField.setText(voucherModel.getId());
        refNumberField.setText(voucherModel.getReference());

        if(voucherModel.getType().equals("Revenue")){
            revenueRadioButton.setSelected(true);
        } else {
            expenseRadioButton.setSelected(true);
        }

        amountField.setText(voucherModel.getAmount());
        accountBox.setValue(voucherModel.getAccount_name());
        paymentMethodBox.setValue(voucherModel.getPayment_method());
        datePicker.setValue(voucherModel.getDate().toLocalDate());
        remarkField.setText(voucherModel.getRemark());

        accountModels = db.GetAllAccount();
        accountModels.forEach(accountModel -> {
            accountModelStr.add(accountModel.getName());

        });




    }

    public EditVoucherController(VoucherModel voucherModel){
        this.voucherModel = voucherModel;
    }


    public void update(){
        Alert alert ;
        try{
            RadioButton selectedRadio =(RadioButton) toggleGroup.getSelectedToggle();
            String val = selectedRadio.getText();

            String refNum = refNumberField.getText();
            String amount = amountField.getText();
            String method = paymentMethodBox.getValue();
            Date d = Date.valueOf(datePicker.getValue());
            String rema = remarkField.getText();

            String accID = selectedAcc.getId();

            boolean f = db.UpdateVoucher(voucherModel.getId(), accID, val, d, refNum, amount, method, rema);
            if(f){
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Successfully Updated");
                alert.showAndWait();
            } else {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.showAndWait();
            }
        }catch(Exception e){

        }


    }
    public void reset(){

        accountBox.getSelectionModel().selectFirst();
        datePicker.setValue(null);
        refNumberField.setText("");
        amountField.setText("");
        paymentMethodBox.getSelectionModel().selectFirst();
        remarkField.setText("");

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
