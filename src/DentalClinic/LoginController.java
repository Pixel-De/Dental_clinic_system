package DentalClinic;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.FileInputStream;

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

    @FXML
    void closeWindow(ActionEvent event) {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    void submitData(ActionEvent event) {
        String username = txtUsername.getText(), password = txtPassword.getText();

        if(username.length() > 0 && password.length() > 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success!");
            alert.setHeaderText(null);
            alert.setContentText("Successfully logged in!");

            alert.showAndWait();
        }
        else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error!");
            alert.setHeaderText(null);
            alert.setContentText("Please fill the all fields!");

            alert.showAndWait();
        }

    }

    public void initialize() throws  Exception{
//        FileInputStream input = new FileInputStream("assets/check.png");
//        Image image = new Image(input);
//        ImageView view = new ImageView(image);
//
//        btnSubmit.setGraphic(view);
    }

}

