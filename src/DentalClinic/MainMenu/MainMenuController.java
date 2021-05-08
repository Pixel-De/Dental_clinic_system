package DentalClinic.MainMenu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;

public class MainMenuController {

    @FXML
    private AnchorPane mainMenu;

    @FXML
    private MenuItem menuLogOff;

    @FXML
    private MenuItem menuChangePassword;

    @FXML
    private MenuItem menuExit;

    @FXML
    private MenuItem menuCloseAll;

    @FXML
    private MenuItem menuAbout;

    @FXML
    private HBox mainLogo;

    @FXML
    private Label bright;

    @FXML
    private VBox MenuItems;

    @FXML
    private ImageView ImageAvatar;

    @FXML
    private Label UserName;

    @FXML
    private Label UserRank;

    @FXML
    void setClinicInformation(ActionEvent event) throws IOException {
//        FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu/MainMenu.fxml"));
//        Parent clinic = loader.load();
//        Stage stage = new Stage();
//        stage.setScene(new Scene(clinic));
//        stage.show();
    }

    @FXML
    void setDentalScreen(ActionEvent event) throws IOException {

    }

    @FXML
    void setDoctorInformation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Doctor/InformationView.fxml"));
        Parent rootDocInfo = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rootDocInfo));
        stage.show();
    }

    @FXML
    void setIncomeReports(ActionEvent event) throws IOException {

    }

    @FXML
    void setListOfDoctors(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Doctor/ListView.fxml"));
        Parent rootDocList = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rootDocList));
        stage.show();
    }

    @FXML
    void setListOfPatient(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Patient/ListView.fxml"));
        Parent rootDocList = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rootDocList));
        stage.show();
    }

    @FXML
    void setListOfUsers(ActionEvent event) {

    }

    @FXML
    void setListOfVoucher(ActionEvent event) {

    }

    @FXML
    void setPatientInformation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Patient/InformationView.fxml"));
        Parent patientsInfo = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(patientsInfo));
        stage.show();
    }

    @FXML
    void setPatientVisitList(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Treatment/PatientVisitView.fxml"));
        Parent rootTreatVis = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rootTreatVis));
        stage.show();
    }

    @FXML
    void setPermission(ActionEvent event) {

    }

    @FXML
    void setPharmacyReport(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Pharmacy/Report.fxml"));
        Parent rootPharma = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rootPharma));
        stage.show();
    }

    @FXML
    void setPharmacySales(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Pharmacy/Sale/SaleView.fxml"));
        Parent rootPharmaSale = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rootPharmaSale));
        stage.show();
    }

    @FXML
    void setPrescription(ActionEvent event) {

    }

    @FXML
    void setPrescriptionList(ActionEvent event) {

    }

    @FXML
    void setProductInformation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Pharmacy/productInformation/ProductInfoView.fxml"));
        Parent rootPharmaProductInfo = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rootPharmaProductInfo));
        stage.show();
    }

    @FXML
    void setProductList(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Pharmacy/productList/ProductList.fxml"));
        Parent rootPharmaProductCat = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rootPharmaProductCat));
        stage.show();
    }

    @FXML
    void setTreatmentReports(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Treatment/Report.fxml"));
        Parent rootTreatList = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rootTreatList));
        stage.show();
    }

    @FXML
    void setUserInformation(ActionEvent event) {

    }

    @FXML
    void setVoucher(ActionEvent event) {

    }

}
