package DentalClinic.Prescription;

import DentalClinic.DB.DbConnect;
import DentalClinic.Patient.Patient;
import DentalClinic.Pharmacy.Sale.SaleModel;
import DentalClinic.Pharmacy.productInformation.Product;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

//import java.awt.*;

public class PrescriptionController {
    @FXML
    TextField preIdField, patientNameField, ageField, genderField, dodgeField,durationField,quantityField,remarkField;
    @FXML
    DatePicker datePicker;
    @FXML
    TableView<PrescriptionModel> preTableView;
    @FXML
    ComboBox<String> productBox, patientBox;
    @FXML
    Button closeButton, createButton;


    private DbConnect db = new DbConnect();

    private ObservableList<PrescriptionModel> prescriptionModels = FXCollections.observableArrayList();
    private ObservableList<Patient> patients = FXCollections.observableArrayList();
    private ObservableList<String> patientsNameAndId = FXCollections.observableArrayList();
    private ObservableList<Product> products = FXCollections.observableArrayList();
    private ObservableList<String> productsName = FXCollections.observableArrayList();

    private PresCriptionMain presCriptionMain;
    private int patientId;
    public void initialize(){

        createPresc();

        //productCombo
        products = db.ProductList();
        products.forEach(product -> {
            productsName.add(product.getName());
        });
        productBox.setItems(productsName);
        productBox.getSelectionModel().selectFirst();


        //patientCombo heseg
        patients = db.PatientList();
        patients.forEach(patient -> {
            String s = patient.getId() + patient.getName();
            patientsNameAndId.add(s);
        });
        patientBox.setItems(patientsNameAndId);
        patientBox.getSelectionModel().selectFirst();
        selectPatient(patients.get(0));
        patientBox.getSelectionModel().selectedIndexProperty().addListener(((observableValue, number, t1) -> {
            Patient p = patients.get((Integer) t1);
            selectPatient(p);
        }));

        //Table uusgeh heseg yvjiin

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

        preTableView.setItems(prescriptionModels);
        preTableView.getColumns().addAll(deleteCol, med_nameCol, dodgeCol, durationCol, quantityCol, remarkCol);
    }

    public void selectPatient(Patient p){

        ageField.setText(String.valueOf(p.getAge()));
            patientNameField.setText(p.getName());
            ageField.setText(String.valueOf(p.getAge()));
            genderField.setText(p.getGender());
            patientId = p.getId();
    }
    public void savePresc(){
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
                    prescriptionModels.remove(prescriptionModel);
                }
            });
            prescriptionModels.add(prescriptionModel);

        } catch (Exception e){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.showAndWait();
        }

    }

    public void createPresc(){
        presCriptionMain = db.CreatePrescription();
//        System.out.println(presCriptionMain.id  +  " " + presCriptionMain.date);
        preIdField.setText(presCriptionMain.getId());
        datePicker.setValue(presCriptionMain.getDate().toLocalDate());
        createButton.setDisable(true);
    }
    public void saveChanges(){
        Alert alert ;

        try{

            presCriptionMain.setPatient_id(String.valueOf(patientId));
            boolean f = db.UpdatePrescription(presCriptionMain, prescriptionModels );

            if(f){
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setContentText("Successfully Updated");
                createButton.setDisable(false);
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
    public void reset(){
        patientBox.getSelectionModel().selectFirst();
        patientNameField.setText("");
        ageField.setText("");
        genderField.setText("");
        productBox.getSelectionModel().selectFirst();
        dodgeField.setText("");
        durationField.setText("");
        quantityField.setText("");
        remarkField.setText("");
        prescriptionModels.clear();
    }

    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
}
