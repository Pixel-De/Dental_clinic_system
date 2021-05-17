package DentalClinic.Prescription;

import DentalClinic.DB.DbConnect;
import DentalClinic.Pharmacy.productInformation.Category;
import DentalClinic.Pharmacy.productInformation.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class PrescriptionEditController implements Initializable {

    @FXML
    TextField preIdField,patientNameField, ageField, genderField,  dodgeField,durationField,quantityField,remarkField;
    @FXML
    DatePicker datePicker;
    @FXML
    ComboBox<String> patientBox;
    @FXML
    TableView<PrescriptionModel> preTableView;
    @FXML
    Button closeButton;
    @FXML
    ComboBox<String> productBox;

    PrescriptionFull prescriptionFull;

    ObservableList<PrescriptionModel> prescriptionModelList = FXCollections.observableArrayList();
    ObservableList<String> productList = FXCollections.observableArrayList();
    DbConnect  db = new DbConnect();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<Product> categories = db.ProductList();
        categories.forEach(product->{
            productList.add(product.getName());
        });
        productBox.setItems(productList);
        if(productList.size()!=0){
            productBox.getSelectionModel().selectFirst();
        }

        preIdField.setText(prescriptionFull.getId());
        preIdField.setEditable(false);
        patientNameField.setText(prescriptionFull.getName());
        patientNameField.setEditable(false);
        ageField.setText(prescriptionFull.getAge());
        ageField.setEditable(false);
        genderField.setText(prescriptionFull.getGender());
        genderField.setEditable(false);
        datePicker.setValue(prescriptionFull.getDate().toLocalDate());
        datePicker.setEditable(false);

        prescriptionModelList = db.getPrescriptionItem(prescriptionFull.getId());

        prescriptionModelList.forEach(prescriptionModel -> {
            Button delete = prescriptionModel.getDelete();
            delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    prescriptionModelList.remove(prescriptionModel);
                }
            });
        });

        TableColumn<PrescriptionModel, Button> deleteCol = new TableColumn<>("");
        TableColumn<PrescriptionModel, String> med_nameCol = new TableColumn<>("MEDICINE NAME");
        TableColumn<PrescriptionModel, String> dodgeCol = new TableColumn<>("DODGE");
        TableColumn<PrescriptionModel, String> durationCol = new TableColumn<>("DURATION");
        TableColumn<PrescriptionModel, Integer > quantityCol = new TableColumn<>("QTY");
        TableColumn<PrescriptionModel, String>  remarkCol = new TableColumn<>("REMARK");

        deleteCol.setCellValueFactory(new PropertyValueFactory<PrescriptionModel, Button>("delete"));
        med_nameCol.setCellValueFactory(new PropertyValueFactory<PrescriptionModel, String>("name"));
        dodgeCol.setCellValueFactory(new PropertyValueFactory<PrescriptionModel, String>("dodge"));
        durationCol.setCellValueFactory(new PropertyValueFactory<PrescriptionModel, String>("duration"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<PrescriptionModel, Integer>("quantity"));
        remarkCol.setCellValueFactory(new PropertyValueFactory<PrescriptionModel, String>("remark"));

        preTableView.setItems(prescriptionModelList);
        preTableView.getColumns().addAll(deleteCol, med_nameCol, dodgeCol, durationCol, quantityCol, remarkCol);

    }


    public void saveChanges(){

        Alert alert ;

        try{
            PresCriptionMain main = new PresCriptionMain(prescriptionFull.getId(), prescriptionFull.getPatient_id(),prescriptionFull.getDate());
            boolean f = db.UpdatePrescription(main, prescriptionModelList );

            if(f){
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Successfully Updated");
                alert.showAndWait();
            } else{
                alert = new Alert(Alert.AlertType.ERROR);
                alert.showAndWait();
            }

        } catch(Exception e){
            alert = new Alert(Alert.AlertType.ERROR);
            alert.showAndWait();

        }

    }



    public void addPresc(){
        try{
            String med = productBox.getValue();
            String dod = dodgeField.getText();
            String dura = durationField.getText();
            String qty = quantityField.getText();
            String rm = remarkField.getText();
            PrescriptionModel prescriptionModel = new PrescriptionModel(Integer.valueOf(qty), med,dod, dura,rm);
            Button delete = prescriptionModel.getDelete();
            delete.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent mouseEvent) {
                    prescriptionModelList.remove(prescriptionModel);
                }
            });
            prescriptionModelList.add(prescriptionModel);

        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.showAndWait();
        }

    }

    public PrescriptionEditController(PrescriptionFull prescriptionFull){
        this.prescriptionFull = prescriptionFull;
    }

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public PrescriptionEditController(){

    }


}
