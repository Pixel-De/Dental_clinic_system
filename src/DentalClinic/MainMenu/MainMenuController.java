package DentalClinic.MainMenu;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

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
    private MenuItem btnPatientInfo;

    @FXML
    private MenuItem btnListPatient;

    @FXML
    private MenuItem DoctorInfo;

    @FXML
    private MenuItem btnListDoctors;

    @FXML
    private MenuItem btnProductInfo;

    @FXML
    private MenuItem btnProductList;

    @FXML
    private MenuItem btnSales;

    @FXML
    private MenuItem btnReports;

}
