package DentalClinic.Pharmacy.productInformation;

import DentalClinic.DB.DbConnect;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.time.LocalDate;
import java.time.ZoneId;
import java.sql.Date;

public class ProductInfoController {
    @FXML
    TextField pID, pName, gName, barCode, UOM , quantity, pPrice, sPrice;
    @FXML
    ComboBox<String> category;
    @FXML
    DatePicker manuDate, eDate;
    @FXML
    Button closeButton;

    ObservableList<String> allCategory = FXCollections.observableArrayList();

    private DbConnect db = new DbConnect();

    @FXML
    public void initialize(){

        ObservableList<Category> tmp = db.CategoryList();
        tmp.forEach(category ->{
            allCategory.add(category.getCategory());
        });

        category.setItems(allCategory);
        category.getSelectionModel().selectFirst();

    }
    public void saveProduct(){
//        ZoneId defaultZoneId = ZoneId.systemDefault();
        String id, p_name, g_name, barcode, uom, quant, p_price, s_price, cate;
        Date m_date, e_date;
        id = pID.getText();
        p_name = pName.getText();
        g_name = gName.getText();
        barcode = barCode.getText();
        uom = UOM.getText();
        quant = quantity.getText();
        p_price = pPrice.getText();
        s_price = sPrice.getText();
        cate = category.getValue() == null ? "": category.getValue();
        m_date = Date.valueOf(manuDate.getValue());
        e_date = Date.valueOf(eDate.getValue());

        boolean f = db.AddProduct(Integer.valueOf(id), p_name, g_name, cate, m_date, e_date, Integer.valueOf(barcode),uom, Integer.valueOf(quant), Integer.valueOf(p_price), Integer.valueOf(s_price));

        if(f){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Saved");
            alert.setContentText("Successfully saved.");
            alert.showAndWait();
        }
    }

    public void reset(){
        pID.setText("");
        pName.setText("");
        gName.setText("");
        barCode.setText("");
        UOM.setText("");
        quantity.setText("");
        pPrice.setText("");
        sPrice.setText("");
        category.getSelectionModel().selectFirst();
        manuDate.setValue(null);
        eDate.setValue(null);
    }
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public void showCategory() {
        try {

            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("./ProductCategory.fxml"));
            Scene scene = new Scene(loader.load());
            Stage stage = new Stage();
            stage.setTitle("Product Category");
            stage.setScene(scene);
            this.closeButtonAction();
            stage.showAndWait();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
