package DentalClinic;

import DentalClinic.Administration.ListOfUser.User;
import DentalClinic.Administration.Permission.PermissionModel;
import DentalClinic.DB.DbConnect;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import DentalClinic.LoginModel;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController {

    @FXML
    private TextField txtUsername;

    @FXML
    private TextField txtPassword;

    @FXML
    private Button btnSubmit;

    @FXML
    private Button btnClose;

    @FXML
    private ImageView imageView;

    private DbConnect db = new DbConnect();

    @FXML

    void submitData(ActionEvent event) throws IOException {
        String username = txtUsername.getText(), password = txtPassword.getText();
        System.out.println(username + password);

        if (username.length() > 0 && password.length() > 0) {

            PermissionModel permissionmodel = db.Login(username, password);
            if (permissionmodel != null) {
                System.out.println(permissionmodel.getAdmin().toString());
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Success!");
                alert.setHeaderText(null);
                alert.setContentText("Successfully logged in!");
                FXMLLoader loader = new FXMLLoader(getClass().getResource("MainMenu/MainMenu.fxml"));
                Parent patientsInfo = loader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(patientsInfo));
                stage.show();
                Stage haah = (Stage) btnSubmit.getScene().getWindow();

                haah.close();
            }
            else {
                System.out.println("iim hereglegch baihgui");
            }

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(null);
            alert.setContentText("Please fill the all fields!");

            alert.showAndWait();
            }
        }



    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    public void initialize() throws  Exception{
//        FileInputStream input = new FileInputStream("assets/check.png");
//        Image image = new Image(input);
//        ImageView view = new ImageView(image);
//
//        btnSubmit.setGraphic(view);
    }

}

