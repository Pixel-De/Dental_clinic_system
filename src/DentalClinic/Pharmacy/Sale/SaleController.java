package DentalClinic.Pharmacy.Sale;

import DentalClinic.DB.DbConnect;
import DentalClinic.Patient.Patient;
import DentalClinic.Pharmacy.productInformation.Product;
import javafx.beans.property.FloatProperty;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
    ComboBox<String> productNameBox, methodBox, patientBox;
    @FXML
    TableView<SaleModel> salesTable;


    private ObservableList<Product> products = FXCollections.observableArrayList();
    private ObservableList<Patient> patients = FXCollections.observableArrayList();
    private ObservableList<String> pBox = FXCollections.observableArrayList();
    private ObservableList<SaleModel> saleModels = FXCollections.observableArrayList();
    private ObservableList<String> paidMethod = FXCollections.observableArrayList("Card", "Cash");

    private DbConnect db = new DbConnect();


    private StringProperty totalProperty = new SimpleStringProperty();
    private StringProperty changeD = new SimpleStringProperty();

    private float ttl=0 ;

    @FXML
    public void initialize(){

        totalLabel.textProperty().bindBidirectional(totalProperty);
        changeDueLabel.textProperty().bindBidirectional(changeD);



        saleModels.addListener(new ListChangeListener<SaleModel>() {
            @Override
            public void onChanged(Change<? extends SaleModel> change) {
                SaleModel s = saleModels.get(saleModels.size()-1);
                ttl = ttl + s.getTotal();
                System.out.println(ttl);
                totalProperty.set(String.valueOf(ttl));
            }
        });

        paidField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                try{

                    float changeDue = Float.valueOf(t1) - ttl;
                    changeD.set(String.valueOf(changeDue));
//                    System.out.println(changeDue);



                }catch (Exception e){
                    System.out.println("err");
                }
            }
        });



        products = db.ProductList();
        patients = db.PatientList();

        products.forEach(product -> {
            pBox.add(product.getName());
        });

        productNameBox.setItems(pBox);
        methodBox.setItems(paidMethod);
        patientBox.setItems(getPatientNameAndId());

        productNameBox.getSelectionModel().selectedIndexProperty().addListener(((observableValue, old, new_val) -> {
            String s = pBox.get((Integer) new_val);
            setInformation(s);
        }));

        methodBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, t1) -> {
            String s = paidMethod.get((Integer) t1);
        });

        patientBox.getSelectionModel().selectedIndexProperty().addListener(((observableValue, number, t1) -> {
//            String s = patients.get((Integer) t1);
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
    public ObservableList<String> getPatientNameAndId(){
        ObservableList<String> p= FXCollections.observableArrayList();
        patients.forEach(patient -> {
            String s = patient.getId() +" "+ patient.getName();
            p.add(s);
        });

        return p;
    }
}
