package DentalClinic.Income;

import DentalClinic.DB.DbConnect;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.sql.Date;

public class ListOfVoucherController {

    @FXML
    TableView<VoucherModel> voucherTable;
    @FXML
    Button closeButton;

    ObservableList<VoucherModel> voucherModels = FXCollections.observableArrayList();
    DbConnect db = new DbConnect();

    public void initialize(){


        voucherModels = db.GetAllVoucher();
        voucherModels.forEach(voucherModel -> {
            Button edit = voucherModel.getEdit();
            Button delete = voucherModel.getDelete();

            delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    boolean f = db.DeleteVoucher(voucherModel.getId());
                    if(f){
                        voucherModels.remove(voucherModel);
                    }
                }
            });
            edit.setOnMouseClicked(new EventHandler<MouseEvent>() {
                EditVoucherController editVoucherController = new EditVoucherController(voucherModel);
                @Override
                public void handle(MouseEvent mouseEvent) {

                    try{
                        FXMLLoader loader = new FXMLLoader();
                        loader.setLocation(getClass().getResource("./EditVoucher.fxml"));
                        loader.setController(editVoucherController);
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
            });

        });


        TableColumn<VoucherModel, Button> delete = new TableColumn<>("");
        TableColumn<VoucherModel, Button> edit = new TableColumn<>("");

        TableColumn<VoucherModel,String> v_id = new TableColumn<>("VOUCHER ID");
        TableColumn<VoucherModel, Date>  date = new TableColumn<>( "DATE");
        TableColumn<VoucherModel, String> p_method = new TableColumn<>("PAYMENT METHOD");
        TableColumn<VoucherModel, String > accName = new TableColumn<>("ACCOUNT NAME");
        TableColumn<VoucherModel, String > ref = new TableColumn<>("REFERENCE");
        TableColumn<VoucherModel, String > remark = new TableColumn<>("REMARK");
        TableColumn<VoucherModel, String > accType = new TableColumn<>("ACCOUNT TYPE");
        TableColumn<VoucherModel, String > amount = new TableColumn<>("AMOUNT");



        delete.setCellValueFactory(new PropertyValueFactory<VoucherModel, Button>("delete"));
        edit.setCellValueFactory(new PropertyValueFactory<VoucherModel, Button>("edit"));
        v_id.setCellValueFactory(new PropertyValueFactory<VoucherModel, String>("id"));
        accType.setCellValueFactory(new PropertyValueFactory<VoucherModel, String>("type"));
        date.setCellValueFactory(new PropertyValueFactory<VoucherModel, Date>("date"));
        p_method.setCellValueFactory(new PropertyValueFactory<VoucherModel, String >("payment_method"));
        accName.setCellValueFactory(new PropertyValueFactory<VoucherModel, String>("account_name"));
        ref.setCellValueFactory(new PropertyValueFactory<VoucherModel, String>("reference"));
        remark.setCellValueFactory(new PropertyValueFactory<VoucherModel, String>("remark"));
        amount.setCellValueFactory(new PropertyValueFactory<VoucherModel, String>("amount"));

        voucherTable.setItems(voucherModels);
        voucherTable.getColumns().addAll(edit, delete, v_id, date, p_method, accName, accType,ref, remark, amount);

    }

    public void refresh(){
        voucherModels = db.GetAllVoucher();
        voucherTable.setItems(voucherModels);
    }

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


}
