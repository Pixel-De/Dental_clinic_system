package DentalClinic.Administration.ListOfUser;

import DentalClinic.Administration.UserInformation.UserInformationController;
import DentalClinic.DB.DbConnect;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import DentalClinic.Administration.ListOfUser.User;

import java.util.Date;
import java.util.Optional;

public class ListOfUserController {

    @FXML
    private ChoiceBox<String> param;

    @FXML
    private TextField criteria;

    @FXML
    private TableView<User> ListOfUserTable;

    @FXML
    private Button btnRefresh;

    @FXML
    private Button closeButton;


    private ObservableList<String> parameter = FXCollections.observableArrayList(" ", " ");
    private ObservableList<User> users = FXCollections.observableArrayList();
    private ObservableList<User> tempPatt = FXCollections.observableArrayList();

    private DbConnect db = new DbConnect();


    public void initialize(){
        Alert balert  = new Alert(Alert.AlertType.CONFIRMATION);
        balert.setTitle("Delete User");
        balert.setContentText("Are you sure you want to delete this record?");

        param.setItems(parameter);

        param.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number old, Number new_val)->{
            criteria.setEditable(true);
        });

        criteria.textProperty().addListener(((observableValue, old, new_val) -> {
            if(param.getValue() == parameter.get(0)){
                if(new_val != ""){
                    ListOfUserTable.setItems(FilterId(Integer.valueOf(new_val)));
                }
            } else if(param.getValue() == parameter.get(1)){
                if(new_val != "") {
                    ListOfUserTable.setItems(FilterName(new_val));
                }
            }
        }));

        if(db.getStatus()!=null){
            System.out.println("db got here");
            users = db.GetAllUser();
            users.forEach(user -> {
                Button btn = user.getEdit();
                Button delBtn = user.getDelete();
                btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        UserInformationController lc = new UserInformationController(user);
                        try {
                            FXMLLoader loader = new FXMLLoader();
                            loader.setLocation(getClass().getResource("../UserInformation/UserInformationView.fxml"));
                            loader.setController(lc);
                            Scene scene = new Scene(loader.load());
                            Stage stage = new Stage();
                            stage.setTitle("User Update");
                            stage.setScene(scene);
                            stage.showAndWait();

                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                delBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        Optional<ButtonType> result = balert.showAndWait();
                        if(result.get()==ButtonType.OK){
                            int delID = user.getId();
                            boolean f = db.DeleteUser(delID);
                            System.out.println(delID);
                            users.remove(user);
                        }
                    }
                });
            });
            TableColumn<User, Button> edit = new TableColumn<>("");
            TableColumn<User, Button> delete = new TableColumn<>("");
            TableColumn<User,Integer> id = new TableColumn<>("USER ID");
            TableColumn<User, String> fullname = new TableColumn<>("FULL NAME");
            TableColumn<User, String> username = new TableColumn<>("Username");
            TableColumn<User, String > usertype = new TableColumn<>("USER TYPE");
            TableColumn<User, String> designation = new TableColumn<>("DESIGNATION");
            TableColumn<User, Integer> contact = new TableColumn<>("CONTACT NO");
            TableColumn<User, Date> join_date = new TableColumn<>("JOINING DATE");

            fullname.setCellValueFactory(new PropertyValueFactory<User, String>("FullName"));
            delete.setCellValueFactory(new PropertyValueFactory<User, Button>("delete"));
            edit.setCellValueFactory(new PropertyValueFactory<User, Button>("edit"));
            id.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
            username.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
            usertype.setCellValueFactory(new PropertyValueFactory<User, String >("user type"));
            designation.setCellValueFactory(new PropertyValueFactory<User, String>("Designation"));
            contact.setCellValueFactory(new PropertyValueFactory<User, Integer>("contact_no"));
            join_date.setCellValueFactory(new PropertyValueFactory<User, Date>("date"));

            ListOfUserTable.setItems(users);
            ListOfUserTable.getColumns().addAll(edit, delete, id, username, usertype, designation, contact, join_date);

        }
    }
    public void refresh(){
        users = db.GetAllUser();
        ListOfUserTable.setItems(users);
    }
    @FXML
    private void closeButtonAction(){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }
    public ObservableList<User> FilterId(int id){
        tempPatt.clear();
        users.forEach(user -> {
            if(user.getId() == id){
                if(!tempPatt.contains(user)){
                    tempPatt.add(user);
                }
            }
        });

        return tempPatt;
    }
    public  ObservableList<User> FilterName(String username){
        tempPatt.clear();
        users.forEach(user -> {
            if(user.getUsername().toLowerCase().contains(username)){
                if(!tempPatt.contains(user)){
                    tempPatt.add(user);
                }
            }
        });
        return tempPatt;
    }
    @FXML
    void btnRefreshAction(ActionEvent event) {
        users = db.GetAllUser();
        ListOfUserTable.setItems(users);
    }

    @FXML
    void closeButtonAction(ActionEvent event) {
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
    }


}
