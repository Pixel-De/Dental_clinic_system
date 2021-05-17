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
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.swing.JRViewer;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class SaleController {

    @FXML
    Label idLabel, nameLabel, avQuantityLabel, priceLabel, totalLabel, changeDueLabel, inVoiceIdLabel;
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
    private ObservableList<Invoice_item> invoice_items = FXCollections.observableArrayList();

    private DbConnect db = new DbConnect();

    private int  invoiceId = 0 ;


    private StringProperty totalProperty = new SimpleStringProperty();
    private StringProperty changeD = new SimpleStringProperty();

    private float total = 0 ;
    private Patient selectedPatient;
    private Double paid;
    private String method="";
    private Double cd = 0.0;

    @FXML
    public void initialize(){
        invoiceId = db.getIdInvoice();


        totalLabel.textProperty().bindBidirectional(totalProperty);
        changeDueLabel.textProperty().bindBidirectional(changeD);
        inVoiceIdLabel.setText(String.valueOf(invoiceId));
        totalLabel.setText(String.valueOf(total));
        changeDueLabel.setText(String.valueOf(cd));
        paidField.setText("0");

        saleModels.addListener(new ListChangeListener<SaleModel>() {
            @Override
            public void onChanged(Change<? extends SaleModel> change) {

                total = 0;
                saleModels.forEach(saleModel -> {
                    total = total + saleModel.getTotal();

                    totalProperty.set(String.valueOf(total));

                });
            }
        });

        paidField.textProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String s, String t1) {
                try{

                    float changeDue = Float.valueOf(t1) - total;
                    cd = Double.valueOf(changeDue) ;
                    changeD.set(String.valueOf(changeDue));

                    try{

                        paid = Double.valueOf(t1);

                    }catch (Exception e){
                        paid = 0.0;
                    }

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


        methodBox.getSelectionModel().selectFirst();
        productNameBox.getSelectionModel().selectFirst();
        patientBox.getSelectionModel().selectFirst();

        method = paidMethod.get(0);
        if(products.size() != 0){
            setInformation(products.get(0).getName());
            paid = 0.0;
        }
        if(patients.size() != 0){
            selectedPatient = patients.get(0);
        }


        productNameBox.getSelectionModel().selectedIndexProperty().addListener(((observableValue, old, new_val) -> {
            String s = pBox.get((Integer) new_val);
            setInformation(s);
        }));

        methodBox.getSelectionModel().selectedIndexProperty().addListener((observableValue, number, t1) -> {
            method = paidMethod.get((Integer) t1);
        });

        patientBox.getSelectionModel().selectedIndexProperty().addListener(((observableValue, number, t1) -> {
            selectedPatient = patients.get((Integer) t1);
        }));

        saleModels.addListener(new ListChangeListener<SaleModel>() {
            @Override
            public void onChanged(Change<? extends SaleModel> change) {

            }
        });
        TableColumn<SaleModel, Button> delete = new TableColumn<>("");
        TableColumn<SaleModel, Integer> id = new TableColumn<>("PRODUCT ID");
        TableColumn<SaleModel, String> name = new TableColumn<>("PRODUCT NAME");
        TableColumn<SaleModel, Integer> quant = new TableColumn<>("QUANTITY");
        TableColumn<SaleModel, Float > unit = new TableColumn<>("UNIT");
        TableColumn<SaleModel, Float> total = new TableColumn<>("TOTAL");


        delete.setCellValueFactory(new PropertyValueFactory<SaleModel, Button>("delete"));
        id.setCellValueFactory(new PropertyValueFactory<SaleModel, Integer>("id"));
        name.setCellValueFactory(new PropertyValueFactory<SaleModel, String>("name"));
        quant.setCellValueFactory(new PropertyValueFactory<SaleModel, Integer>("quantity"));
        unit.setCellValueFactory(new PropertyValueFactory<>("unit"));
        total.setCellValueFactory(new PropertyValueFactory<>("total"));

        salesTable.setItems(saleModels);
        salesTable.getColumns().addAll(delete, id, name, quant, unit, total);


    }





    public void addToCart(){
        if(!quantityField.getText().equals("")){
            try{
                Float ttl = Integer.valueOf(quantityField.getText()) * Float.valueOf(priceLabel.getText());

                SaleModel saleModel = new SaleModel(Integer.valueOf(idLabel.getText()), Integer.valueOf(quantityField.getText()),nameLabel.getText(),Float.valueOf(priceLabel.getText()),ttl);
                Button del = saleModel.getDelete();
                del.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        saleModels.remove(saleModel);
                    }
                });
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

    public void saveInvoice(){

        try{

            int i = this.invoiceId;
            int user_id = selectedPatient.getId();
            double ttl = total;
            double p = paid;
            String m = method;
            Double c = cd;

            if(saleModels.size() != 0){
                saleModels.forEach(saleModel -> {
                    invoice_items.add(new Invoice_item(String.valueOf(invoiceId),String.valueOf(saleModel.getId())  , saleModel.getQuantity(), Double.valueOf(saleModel.getTotal())));
                });
                boolean f = db.CreateInvoice(i,user_id, ttl, p, m, c, invoice_items);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Invoice Saved.");
                if(f){
                    alert.setContentText("Invoice Successfully saved.");
                    alert.showAndWait();

                    JasperReport jasperReport = JasperCompileManager.compileReport("../../Reports/Invoice_report.jrxml");

                    Map<String, SaleModel> parameters = new HashMap<String, SaleModel>();

                    JRDataSource dataSource = (JRDataSource) new JREmptyDataSource();

                    JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
                    JRViewer viewer = new JRViewer(jasperPrint);

                    viewer.setOpaque(true);
                    viewer.setVisible(true);


                }else {
                    alert.setContentText("Invoice did not saved.");
                    alert.showAndWait();
                }
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.showAndWait();
            }



        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.showAndWait();
        }

    }
}
