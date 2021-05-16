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


//    private ObservableList<String> parameter = FXCollections.observableArrayList("DoctorID", "DoctorName");
//    private ObservableList<User> users = FXCollections.observableArrayList();
//    private ObservableList<User> tempPatt = FXCollections.observableArrayList();
//
//    private DbConnect db = new DbConnect();
//
//
//    public void initialize(){
//        Alert balert  = new Alert(Alert.AlertType.CONFIRMATION);
//        balert.setTitle("Delete Patient");
//        balert.setContentText("Are you sure you want to delete this record?");
//
//        param.setItems(parameter);
//
//        param.getSelectionModel().selectedIndexProperty().addListener((ObservableValue<? extends Number> ov, Number old, Number new_val)->{
//            criteria.setEditable(true);
//        });
//
//        criteria.textProperty().addListener(((observableValue, old, new_val) -> {
//            if(param.getValue() == parameter.get(0)){
//                if(new_val != ""){
//                    ListOfUserTable.setItems(FilterId(Integer.valueOf(new_val)));
//                }
//            } else if(param.getValue() == parameter.get(1)){
//                if(new_val != "") {
//                    ListOfUserTable.setItems(FilterName(new_val));
//                }
//            }
//        }));
//
//        if(db.getStatus()!=null){
//            System.out.println("db got here");
//            users = db.UserList();
//            users.forEach(user -> {
//                Button btn = user.getEdit();
//                Button delBtn = user.getDelete();
//                btn.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                    @Override
//                    public void handle(MouseEvent mouseEvent) {
//                        UserInformationController lc = new UserInformationController(user);
//                        try {
//                            FXMLLoader loader = new FXMLLoader();
//                            loader.setLocation(getClass().getResource("../UserInformation/UserInformationView.fxml"));
//                            loader.setController(lc);
//                            Scene scene = new Scene(loader.load());
//                            Stage stage = new Stage();
//                            stage.setTitle("Doctor Update");
//                            stage.setScene(scene);
//                            stage.showAndWait();
//
//                        } catch (Exception e) {
//                            e.printStackTrace();
//                        }
//                    }
//                });
//                delBtn.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                    @Override
//                    public void handle(MouseEvent mouseEvent) {
//                        Optional<ButtonType> result = balert.showAndWait();
//                        if(result.get()==ButtonType.OK){
//                            int delID = user.getId();
//                            boolean f = db.DeleteDoctor(delID);
//                            System.out.println(delID);
//                            users.remove(user);
//                        }
//                    }
//                });
//            });
//            TableColumn<User, Button> edit = new TableColumn<>("");
//            TableColumn<User, Button> delete = new TableColumn<>("");
//            TableColumn<User,Integer> id = new TableColumn<>("USER ID");
//            TableColumn<User, String> full_name = new TableColumn<>("FULL NAME");
//            TableColumn<User, String> user_name = new TableColumn<>("Username");
//            TableColumn<User, String > user_job = new TableColumn<>("USER TYPE");
//            TableColumn<User, String> fieldOfArea = new TableColumn<>("DESIGNATION");
//            TableColumn<User, Integer> contact_no = new TableColumn<>("CONTACT NO");
//            TableColumn<User, Date> joining_date = new TableColumn<>("JOINING DATE");
//
//
//            delete.setCellValueFactory(new PropertyValueFactory<User, Button>("delete"));
//            edit.setCellValueFactory(new PropertyValueFactory<User, Button>("edit"));
//            id.setCellValueFactory(new PropertyValueFactory<User, Integer>("id"));
//            user_name.setCellValueFactory(new PropertyValueFactory<User, String>("username"));
//            user_job.setCellValueFactory(new PropertyValueFactory<User, String >("user type"));
//            fieldOfArea.setCellValueFactory(new PropertyValueFactory<User, String>("Designation"));
//            contact_no.setCellValueFactory(new PropertyValueFactory<User, Integer>("contact_no"));
//            joining_date.setCellValueFactory(new PropertyValueFactory<User, Date>("date"));
//
//            ListOfUserTable.setItems(users);
//            ListOfUserTable.getColumns().addAll(edit, delete, id, user_name, user_job, fieldOfArea, contact_no, joining_date);
//
//        }
//    }
//    public void refresh(){
//        users = db.UserList();
//        ListOfUserTable.setItems(users);
//    }
//    @FXML
//    private void closeButtonAction(){
//        Stage stage = (Stage) closeButton.getScene().getWindow();
//        stage.close();
//    }
//    public ObservableList<User> FilterId(int id){
//        tempPatt.clear();
//        users.forEach(user -> {
//            if(user.getId() == id){
//                if(!tempPatt.contains(user)){
//                    tempPatt.add(user);
//                }
//            }
//        });
//
//        return tempPatt;
//    }
//    public  ObservableList<User> FilterName(String user_name){
//        tempPatt.clear();
//        users.forEach(patient -> {
//            if(patient.getName().toLowerCase().contains(user_name)){
//                if(!tempPatt.contains(patient)){
//                    tempPatt.add(patient);
//                }
//            }
//        });
//        return tempPatt;
//    }
//    @FXML
//    void btnRefreshAction(ActionEvent event) {
//        users = db.UserList();
//        ListOfUserTable.setItems(users);
//    }
//
//    @FXML
//    void closeButtonAction(ActionEvent event) {
//        Stage stage = (Stage) closeButton.getScene().getWindow();
//        stage.close();
//    }


}
