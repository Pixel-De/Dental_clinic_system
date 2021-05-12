package DentalClinic.Pharmacy.productList;

import DentalClinic.DB.DbConnect;
import DentalClinic.Patient.InformationController;
import DentalClinic.Patient.Patient;
import DentalClinic.Pharmacy.productInformation.Category;
import DentalClinic.Pharmacy.productInformation.Product;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.util.Date;
import java.util.Optional;

public class ProductListController {
    @FXML
    TableView<Product> productTable;
    @FXML
    Button closeButton;

    ObservableList<Product> products ;
    DbConnect data;

    Alert alert;

    public void initialize(){
        data = new DbConnect();

        alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Delete Product");
        alert.setContentText("Are you sure you want to delete this product?");

        if(data.getStatus()!=null){
            System.out.println("db got here");
            products = data.ProductList();
            products.forEach(product -> {

                Button e = product.getEdit();
                Button del = product.getDelete();

                e.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {

                        ProductUpdateController pu = new ProductUpdateController(product);
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("./ProductUpdateView.fxml"));
                            loader.setController(pu);
                            Scene scene = new Scene(loader.load());
                            Stage stage = new Stage();
                            stage.setTitle("Product Update");
                            stage.setScene(scene);
                            stage.showAndWait();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }

                    }
                });

                del.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Optional<ButtonType> result = alert.showAndWait();
                        if(result.get()==ButtonType.OK){
                            int delID = Integer.valueOf( product.getId());
                            boolean f = data.DeleteProduct(delID);
                            System.out.println(delID);
                            products.remove(product);
                        }

                    }
                });
            });


            TableColumn<Product, Button> edit = new TableColumn<>("");
            TableColumn<Product, Button> delete = new TableColumn<>("");
            TableColumn<Product,String> id = new TableColumn<>("PRODUCT ID");
            TableColumn<Product, String> name = new TableColumn<>("PRODUCT NAME");
            TableColumn<Product, String> g_name = new TableColumn<>("GENERIC NAME");
            TableColumn<Product, String > category = new TableColumn<>("CATEGORY");
            TableColumn<Product, String> barcode = new TableColumn<>("BARCODE");
            TableColumn<Product, String> uom = new TableColumn<>("UOM");
            TableColumn<Product, String> quantity = new TableColumn<>("QUANTITY");
            TableColumn<Product, String > p_price = new TableColumn<>("PURCHASE PRICE");
            TableColumn<Product, String > s_price = new TableColumn<>("SALES PRICE");

            TableColumn<Product, Date>  m_date = new TableColumn<>("MANUFACTURE DATE");
            TableColumn<Product, Date>  e_date = new TableColumn<>("EXPIRATION DATE");


            delete.setCellValueFactory(new PropertyValueFactory<Product, Button>("delete"));
            edit.setCellValueFactory(new PropertyValueFactory<Product, Button>("edit"));
            id.setCellValueFactory(new PropertyValueFactory<Product, String>("id"));
            name.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
            g_name.setCellValueFactory(new PropertyValueFactory<Product, String >("gName"));
            category.setCellValueFactory(new PropertyValueFactory<Product, String>("category"));
            barcode.setCellValueFactory(new PropertyValueFactory<Product, String>("barCode"));
            uom.setCellValueFactory(new PropertyValueFactory<Product, String>("UOM"));
            quantity.setCellValueFactory(new PropertyValueFactory<Product, String>("quantity"));
            p_price.setCellValueFactory(new PropertyValueFactory<Product, String>("pPrice"));
            s_price.setCellValueFactory(new PropertyValueFactory<Product, String>("sPrice"));
            m_date.setCellValueFactory(new PropertyValueFactory<Product, Date>("manuDate"));
            e_date.setCellValueFactory(new PropertyValueFactory<Product, Date>("expireDate"));

            productTable.setItems(products);
            productTable.getColumns().addAll(edit, delete, id, name, g_name, category, barcode
                    , uom, quantity, p_price, s_price, m_date, e_date);
        }
    }

    public void refresh(){
        products = data.ProductList();
        productTable.setItems(products);
    }
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
