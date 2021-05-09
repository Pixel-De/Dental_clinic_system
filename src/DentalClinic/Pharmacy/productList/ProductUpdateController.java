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
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import DentalClinic.Pharmacy.productInformation.Category;

import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;

public class ProductUpdateController implements Initializable {
    @FXML
    ComboBox<String> categoryBox;
    @FXML
    TextField idField, nameField, genericField, barcodeField ,uomField, quantityField, purchaseField, salesField ;
    @FXML
    DatePicker manuPicker, expirePicker;


    private ObservableList<String> categories = FXCollections.observableArrayList();
    private String id, name, gName, cate,barcode, uom, quantity,p_price, s_price;
    Date m_date, e_date ;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DbConnect db = new DbConnect();
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
//        LocalDate l1 = m_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
//        manuPicker.setValue(m_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
//        expirePicker.setValue(e_date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());

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
