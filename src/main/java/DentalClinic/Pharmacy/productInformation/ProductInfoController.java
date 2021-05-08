package main.java.DentalClinic.Pharmacy.productInformation;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.time.LocalDate;

public class ProductInfoController {

    @FXML
    TextField pID, pName, gName, barCode, UOM , quantity, pPrice, sPrice;
   @FXML
    ComboBox<String> category;
   @FXML
   DatePicker manuDate, eDate;


    ObservableList<String> catListTest = FXCollections.observableArrayList("category1", "category2", "category3");

    @FXML
    public void initialize(){
        category.setItems(catListTest);
    }
    public void saveProduct(){
        String id, p_name, g_name, barcode, uom, quant, p_price, s_price, cate;
        LocalDate m_date, e_date;
        id = pID.getText();
        p_name = pName.getText();
        g_name = gName.getText();
        barcode = barCode.getText();
        uom = UOM.getText();
        quant = quantity.getText();
        p_price = pPrice.getText();
        s_price = sPrice.getText();
        cate = category.getValue();
        m_date = manuDate.getValue();
        e_date = eDate.getValue();
        Product p = new Product(id, p_name, g_name, cate, m_date, e_date, barcode, uom,quant, p_price, s_price);
        System.out.println(p.getCategory()+" "+ p.getgName());
    }

    public void showCategory() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("./ProductCategory.fxml"));
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
