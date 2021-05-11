package DentalClinic.Pharmacy.productList;

import DentalClinic.DB.DbConnect;
import DentalClinic.Pharmacy.productInformation.Product;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.InnerShadow;
import javafx.stage.Stage;
import DentalClinic.Pharmacy.productInformation.Category;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;
import java.util.ResourceBundle;

public class ProductUpdateController implements Initializable {
    @FXML
    ComboBox<String> categoryBox;
    @FXML
    TextField idField, nameField, genericField, barcodeField ,uomField, quantityField, purchaseField, salesField ;
    @FXML
    DatePicker manuPicker, expirePicker;
    @FXML
    Button closeButton;


    private ObservableList<String> categories = FXCollections.observableArrayList();
    private String id, name, gName, cate,barcode, uom, quantity,p_price, s_price;
    Date m_date, e_date ;

    DbConnect db;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        db = new DbConnect();
        ObservableList<Category> tmp = db.CategoryList();
        tmp.forEach(category ->{
            categories.add(category.getCategory());
        });

        categoryBox.setItems(categories);
        categoryBox.getSelectionModel().selectFirst();

        idField.setText(id);
        nameField.setText(name);
        genericField.setText(gName);
        barcodeField.setText(barcode);
        uomField.setText(uom);
        quantityField.setText(quantity);
        purchaseField.setText(p_price);
        salesField.setText(s_price);
        categoryBox.setValue(cate);
        manuPicker.setValue(m_date.toLocalDate());
        expirePicker.setValue(e_date.toLocalDate());

    }
    public void updateProduct(){
        id = idField.getText();
        name = nameField.getText();
        gName = genericField.getText();
        cate = categoryBox.getValue();
        barcode = barcodeField.getText();
        uom = uomField.getText();
        quantity = quantityField.getText();
        p_price = purchaseField.getText();
        s_price = salesField.getText();
        m_date = Date.valueOf(manuPicker.getValue());
        e_date = Date.valueOf(expirePicker.getValue());

        boolean f = db.UpdateProduct(Integer.valueOf(id), name, gName, cate, m_date, e_date, Integer.valueOf(barcode), uom,Integer.valueOf(quantity), Integer.valueOf( p_price), Integer.valueOf(s_price));
        if(f){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Updated");
            alert.setContentText("Successfully updated");
            alert.show();
        }
    }

    public void reset(){
        idField.setText("");
        nameField.setText("");
        genericField.setText("");
        categoryBox.getSelectionModel().selectFirst();
        barcodeField.setText("");
        uomField.setText("");
        quantityField.setText("");
        purchaseField.setText("");
        salesField.setText("");
        manuPicker.setValue(null);
        expirePicker.setValue(null);
    }
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public  ProductUpdateController(Product p){
        id = p.getId();
        name = p.getName();
        gName = p.getGName();
        cate = p.getCategory();
        barcode = p.getBarCode();
        uom = p.getUOM();
        quantity = p.getQuantity();
        p_price = p.getPPrice();
        s_price = p.getSPrice();
        m_date = p.getManuDate();
        e_date = p.getExpireDate();
    }
    public ProductUpdateController(){

    }
    public void showCategory() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("../productInformation/ProductCategory.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle("Product Category");
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
