package DentalClinic.Pharmacy.Sale;

import DentalClinic.DB.DbConnect;
import DentalClinic.Patient.Patient;
import DentalClinic.Pharmacy.productInformation.Product;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class SaleController {

    @FXML
    Label idLabel, nameLabel, avQuantityLabel, priceLabel, totalLabel, changeDueLabel;
    @FXML
    TextField quantityField , paidField;
    @FXML
    ComboBox<String> productNameBox, methodBox;
    @FXML
    TableView<SaleModel> salesTable; ;

    private ObservableList<Product> products = FXCollections.observableArrayList();
    private ObservableList<Patient> patients = FXCollections.observableArrayList();
    private ObservableList<String> pBox = FXCollections.observableArrayList();
    private ObservableList<SaleModel> saleModels = FXCollections.observableArrayList();
    private DbConnect db = new DbConnect();


    @FXML
    public void initialize(){
        products = db.ProductList();
        patients = db.PatientList();

        products.forEach(product -> {
            pBox.add(product.getName());
        });

        productNameBox.setItems(pBox);

        productNameBox.getSelectionModel().selectedIndexProperty().addListener(((observableValue, old, new_val) -> {
            String s = pBox.get((Integer) new_val);
            setInformation(s);
        }));

        saleModels.addListener(new ListChangeListener<SaleModel>() {
            @Override
            public void onChanged(Change<? extends SaleModel> change) {

            }
        });
        TableColumn<SaleModel, Integer> id = new TableColumn<>("PRODUCT ID");
        TableColumn<SaleModel, String> name = new TableColumn<>("PRODUCT NAME");
        TableColumn<SaleModel, Integer> quant = new TableColumn<>("QUANTITY");
        TableColumn<SaleModel, Float > unit = new TableColumn<>("UNIT");
        TableColumn<SaleModel, Float> total = new TableColumn<>("TOTAL");

        id.setCellValueFactory(new PropertyValueFactory<SaleModel, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<SaleModel, String>("name"));
        quant.setCellValueFactory(new PropertyValueFactory<SaleModel, Integer>("quantity"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));

        salesTable.setItems(saleModels);
        salesTable.getColumns().addAll(id, name, quant, unit, total);
    }

    public void addToCart(){
        if(!quantityField.getText().equals("")){
            try{
                Float ttl = Integer.valueOf(quantityField.getText()) * Float.valueOf(priceLabel.getText());

                SaleModel saleModel = new SaleModel(Integer.valueOf(idLabel.getText()), Integer.valueOf(quantityField.getText()),nameLabel.getText(),Float.valueOf(priceLabel.getText()),ttl);

                saleModels.add(saleModel);
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void setInformation(String s){

        products.forEach(product -> {
            if(s.equals(product.getName())) {
                idLabel.setText(product.getId());
                nameLabel.setText(product.getName());
                avQuantityLabel.setText(product.getQuantity());
                priceLabel.setText(product.getSPrice());
                quantityField.setText("0");
            }
        });

    }
    public void seePatientList() throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("./PatientList.fxml"));
        Parent rootDocInfo = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rootDocInfo));
        stage.show();
    }

}
