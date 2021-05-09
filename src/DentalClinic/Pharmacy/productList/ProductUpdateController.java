package DentalClinic.Pharmacy.productList;

import DentalClinic.DB.DbConnect;
import DentalClinic.Pharmacy.productInformation.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import DentalClinic.Pharmacy.productInformation.Category;

import java.awt.*;

public class ProductUpdateController {
    @FXML
    ComboBox<String> category;
    ObservableList<String> categories = FXCollections.observableArrayList();
    public void initialize(){
        DbConnect db = new DbConnect();
        ObservableList<Category> tmp = db.CategoryList();
        tmp.forEach(category ->{
            categories.add(category.getCategory());
        });

        category.setItems(categories);
        category.getSelectionModel().selectFirst();
    }
    public  ProductUpdateController(Product p){

    }
    public ProductUpdateController(){

    }
    public void showProductUpdate(){
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("./ProductUpdateView.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle("Product Update");
            stage.setScene(scene);
            stage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
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
