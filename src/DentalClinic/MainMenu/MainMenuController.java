package DentalClinic.MainMenu;

import DentalClinic.Administration.ListOfUser.ListOfUserController;
import DentalClinic.Administration.UserInformation.UserInfoController;
import DentalClinic.Administration.UserInformation.UserInformationController;
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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Administration/ClinicInformation/ClinicInformationView.fxml"));
        Parent clinic = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(clinic));
        stage.show();
    }

    @FXML
    void setDentalScreen(ActionEvent event) throws IOException {

    }

    @FXML
    void setDoctorInformation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Doctor/InfoView.fxml"));
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
    void setListOfUsers(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Administration/ListOfUser/ListOfUserView.fxml"));
        Parent listofuser = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(listofuser));
        stage.show();
    }

    @FXML
    void setListOfVoucher(ActionEvent event) throws  IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Income/ListOfVoucher.fxml"));
        Parent patientsInfo = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(patientsInfo));
        stage.show();
    }

    @FXML
    void setPatientInformation(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Patient/InfoView.fxml"));
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
    void setPermission(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Administration/Permission/PermissionView.fxml"));
        Parent permissione = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(permissione));
        stage.show();
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
    void setPrescription(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Prescription/Presicription.fxml"));
        Parent rootPharmaSales = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rootPharmaSales));
        stage.show();
    }

    @FXML
    void setPrescriptionList(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Prescription/PreList.fxml"));
        Parent rootPharmaSaled = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(rootPharmaSaled));
        stage.show();

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
    void setUserInformation(ActionEvent event) throws IOException {
        UserInfoController userinfocont = new UserInfoController();
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Administration/UserInformation/UserInfoView.fxml"));
        loader.setController(userinfocont);
        Parent clinics = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(clinics));
        stage.show();
    }

    @FXML
    void setVoucher(ActionEvent event)  throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../Income/VoucherView.fxml"));
        Parent clinicd = loader.load();
        Stage stage = new Stage();
        stage.setScene(new Scene(clinicd));
        stage.show();

    }

}
